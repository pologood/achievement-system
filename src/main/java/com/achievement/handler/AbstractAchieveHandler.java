/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.handler;


import com.achievement.constant.AchievementConstant;
import com.achievement.constant.Constants;
import com.achievement.dao.AchievementRecordDAO;
import com.achievement.dao.AchievementTemplateDAO;
import com.achievement.dao.mapper.AchievementTemplateMapper;
import com.achievement.dataobject.AchievementRecord;
import com.achievement.dataobject.AchievementTemplate;
import com.achievement.domain.AchievementDTO;
import com.achievement.domain.AchievementMsg;
import com.achievement.domain.AchievementReward;
import com.achievement.domain.Condition;
import com.achievement.event.AchievementEvent;
import com.alibaba.fastjson.JSON;
import com.lmax.disruptor.EventHandler;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;

/**
 * AbstractEventPublisher
 *
 * @author caisl
 * @since 2017-06-08
 */
public abstract class AbstractAchieveHandler implements EventHandler<AchievementEvent> {

    @Resource
    protected AchievementRecordDAO achievementRecordDAO;
    @Resource
    protected AchievementTemplateDAO achievementTemplateDAO;
    @Resource
    private ISparkService sparkService;
    @Resource
    private AchievementTemplateMapper achievementTemplateMapper;

    /**
     * 执行事件
     *
     * @param event
     * @param sequence
     * @param endOfBatch
     * @throws Exception
     */
    @Override
    public void onEvent(AchievementEvent event, long sequence, boolean endOfBatch) throws Exception {
        LoggerUtil.warn(FireMemberLoggerFactory.ACHIEVEMENT_LOGGER, LogMarker.ACHIEVEMENT_HANDLER, "{} {}  handle" +
                " event event = {}， 位于队列序号={}", event.getDisruptorName(), this.getClass().getSimpleName(), event.toString(), sequence);
        if (event == null || CollectionUtils.isEmpty(event.getCustomerRegisterIds())) {
            LoggerUtil.error(FireMemberLoggerFactory.ACHIEVEMENT_LOGGER, LogMarker.ACHIEVEMENT_HANDLER,
                    "valid param fail event={}", event != null ? event.toString() : null);
            return;
        }
        if (!checkEvent(event)) {
            return;
        }
        for (String customerRegisterId : event.getCustomerRegisterIds()) {
            AchievementDTO achievementDTO = checkAchievement(customerRegisterId, event);
            if (achievementDTO.getStatus() == AchievementConstant.RecordStatus.STATUS_COMPLETED && reward(achievementDTO)) {
                sendMessage(achievementDTO);
            }
        }
    }

    /**
     * 成就校验
     *
     * @param event
     * @return
     */
    protected AchievementDTO checkAchievement(String customerRegisterId, AchievementEvent event) {
        AchievementDTO achievementDTO = null;
        try {
            achievementDTO = new AchievementDTO(event.getEntityId(), customerRegisterId, event.getAchievementId(),
                    event.getSource());
            AchievementRecord record = achievementRecordDAO.queryRecord(customerRegisterId, event.getAchievementId());
            if (isAchieveCompleted(record)) {
                return achievementDTO;
            }
            AchievementTemplate achievementTemplate = achievementTemplateMapper.selectByPrimaryKey(event.getAchievementId());
            if (achievementTemplate != null) {
                if (isAchieveEffect(achievementTemplate.getStartTime(), achievementTemplate.getEndTime())) {
                    assembleAchievementDTO(achievementDTO, achievementTemplate, record);
                    //进度有更新
                    if (doCondition(achievementDTO) && achievementDTO.getStatus() == AchievementConstant.RecordStatus.STATUS_PROCESSING) {
                        modifyAchievementRecord(achievementDTO);
                    }
                }
            }
        } catch (Throwable e) {
            LoggerUtil.error(FireMemberLoggerFactory.ACHIEVEMENT_LOGGER, LogMarker.ACHIEVEMENT_HANDLER, e);
        }
        return achievementDTO;
    }

    /**
     * 组装成就DTO对象
     *
     * @param achievementDTO
     * @param achievementTemplate
     * @param record
     */
    private void assembleAchievementDTO(AchievementDTO achievementDTO, AchievementTemplate achievementTemplate,
                                        AchievementRecord record) {
        achievementDTO.setAchievementName(achievementTemplate.getNameCode());
        achievementDTO.setContext(achievementTemplate.getContextCode());
        achievementDTO.setReward(JSON.parseObject(achievementTemplate.getReward(), AchievementReward.class));
        achievementDTO.setPicUrl(achievementTemplate.getPicUrl());
        achievementDTO.setAchievementPackageId(achievementTemplate.getAchievementPackageId());
        if (record != null) {
            achievementDTO.setFinishTime(record.getFinishTime());
            achievementDTO.setStatus(record.getStatus());
            achievementDTO.setAchievementRecordId(record.getAchievementRecordId());
            achievementDTO.setVersion(record.getLastVer());
            if (StringUtils.isNotBlank(record.getSchedule())) {
                achievementDTO.setConditions(JSON.parseArray(record.getSchedule(), Condition.class));
            }
        } else {
            if (StringUtils.isNotBlank(achievementTemplate.getConditions())) {
                achievementDTO.setConditions(JSON.parseArray(achievementTemplate.getConditions(), Condition.class));
            }
        }
    }

    /**
     * 更新用户成就记录表
     *
     * @param achievementDTO
     */
    protected void modifyAchievementRecord(AchievementDTO achievementDTO) {
        long now = System.currentTimeMillis();
        AchievementRecord record = new AchievementRecord();
        record.setAchievementPackageId(achievementDTO.getAchievementPackageId());
        record.setAchievementRecordId(achievementDTO.getAchievementRecordId());
        record.setCustomerRegisterId(achievementDTO.getCustomerRegisterId());
        record.setAchievementTemplateId(achievementDTO.getAchievementId());
        record.setStatus(achievementDTO.getStatus());
        record.setOpTime(now);
        record.setFireSeed(achievementDTO.getReward().getFireSeed());
        if (achievementDTO.getStatus() == AchievementConstant.RecordStatus.STATUS_COMPLETED) {
            record.setFinishTime(now);
            achievementDTO.setFinishTime(now);
        }
        if (CollectionUtils.isNotEmpty(achievementDTO.getConditions())) {
            record.setSchedule(JSON.toJSONString(achievementDTO.getConditions()));
        }
        if (StringUtils.isBlank(record.getAchievementRecordId())) {
            record.setAchievementRecordId(UUID.randomUUID().toString());
            record.setCreateTime(now);
            achievementDTO.setAchievementRecordId(record.getAchievementRecordId());
            //Insert
            achievementRecordDAO.insertRecord(record);
        } else {
            //update
            record.setLastVer(achievementDTO.getVersion() + 1);
            achievementRecordDAO.updateRecord(record);
        }
    }

    /**
     * 成就达成 进行奖励
     *
     * @param achievementDTO
     */
    protected boolean reward(AchievementDTO achievementDTO) throws Exception {
        int retry = 3;
        while (retry > 0) {
            SparkVo spark = new SparkVo();
            spark.setChangeValue(achievementDTO.getReward().getFireSeed());
            spark.setTwodfireMemberId(achievementDTO.getCustomerRegisterId());
            spark.setSparkAction(EnumSparkAction.ACHIEVE.getSparkAction());
            Result<Integer> updateSparkResult = sparkService.updateSpark(spark);
            if (ResultUtil.isModelNotNull(updateSparkResult)) {
                achievementDTO.getReward().setFireSeed(updateSparkResult.getModel());
                modifyAchievementRecord(achievementDTO);
                break;
            } else {
                Thread.sleep(100);
                LoggerUtil.error(FireMemberLoggerFactory.ACHIEVEMENT_LOGGER, LogMarker.SPARK_HANDLER, "updateSpark " +
                        "fail request = {}, errMsg = {}, retry = {}", JSON.toJSON(spark), updateSparkResult
                        .getMessage(), retry);
                retry--;
                //重试三次都失败 记录到日志里面
                if (retry == 0) {
                    LoggerUtil.error(FireMemberLoggerFactory.ACHIEVEMENT_LOGGER, LogMarker.SPARK_UPDATE_FAIL, "updateSpark " +
                            "fail request = {}, errMsg = {}", JSON.toJSON(spark), updateSparkResult.getMessage());
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 消息推送 发送弹窗信息
     *
     * @param achievementDTO
     */
    protected void sendMessage(AchievementDTO achievementDTO) {
        try {
            AchievementMsg achievementMsg = new AchievementMsg();
            achievementMsg.setAchievementId(achievementDTO.getAchievementId());
            achievementMsg.setAchievementName(achievementDTO.getAchievementName());
            achievementMsg.setContext(achievementDTO.getContext());
            achievementMsg.setFinishTime(achievementDTO.getFinishTime());
            achievementMsg.setSource(achievementDTO.getSource());
            achievementMsg.setFireSeedValue(achievementDTO.getReward().getFireSeed());
            achievementMsg.setAchievementRecordId(achievementDTO.getAchievementRecordId());
            achievementMsg.setStatus(achievementDTO.getStatus());
            Map<String, String> picUrls = JSON.parseObject(achievementDTO.getPicUrl(), Map.class);
            if (!picUrls.isEmpty()) {
                achievementMsg.setPicUrl(picUrls.get(Constants.Achievement.STATUS_PREFIX_DETAIL));
            }
            //MQ push message
        } catch (Exception e) {
            LoggerUtil.error(FireMemberLoggerFactory.ACHIEVEMENT_LOGGER, LogMarker.ACHIEVEMENT_HANDLER, "sendMessage " +
                    "fail uid= {}, achievementTemplateId = {}", achievementDTO.getAchievementId(), achievementDTO.getCustomerRegisterId());
        }
    }

    /**
     * 入参事件检验
     *
     * @param event
     * @return
     */
    protected abstract boolean checkEvent(AchievementEvent event);

    /**
     * 判断成就条件是否达成
     *
     * @param achievementDTO
     * @return
     */
    protected boolean doCondition(AchievementDTO achievementDTO) {
        if (CollectionUtils.isEmpty(achievementDTO.getConditions())) {
            achievementDTO.setStatus(AchievementConstant.RecordStatus.STATUS_COMPLETED);
            return true;
        }
        return false;
    }

    /**
     * 成就是否达成
     *
     * @param record
     * @return
     */
    protected boolean isAchieveCompleted(AchievementRecord record) {
        return record != null && record.getStatus() == AchievementConstant.RecordStatus.STATUS_COMPLETED;
    }

    /**
     * 成就是否有效
     *
     * @param effectiveTime
     * @param expireTime
     * @return
     */
    protected boolean isAchieveEffect(long effectiveTime, long expireTime) {
        long now = System.currentTimeMillis();
        return now >= effectiveTime && now <= expireTime;
    }

}
