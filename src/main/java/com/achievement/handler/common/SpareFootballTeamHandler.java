/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.handler.common;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.dfire.soa.consumer.fm.achievement.handler.AbstractAchieveHandler;
import com.dfire.soa.consumer.fm.constant.AchievementConstant;
import com.dfire.soa.consumer.fm.constant.AchievementEnum;
import com.dfire.soa.consumer.fm.constant.Constants;
import com.dfire.soa.consumer.fm.domain.achievement.AchievementDTO;
import com.dfire.soa.consumer.fm.domain.achievement.Condition;
import com.dfire.soa.consumer.fm.domain.event.AchievementEvent;
import com.dfire.soa.consumer.fm.domain.event.CommonEvent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * SpareFootballTeamHandler
 *
 * @author caisl
 * @desc 备胎足球队
 * @since 2017-06-13
 */
@Component
public class SpareFootballTeamHandler extends AbstractAchieveHandler {
    private static String achievementId = "c5a968a3372c474794ef670fe9ad7137";

    @Override
    protected boolean checkEvent(AchievementEvent event) {
        if (event instanceof CommonEvent) {
            CommonEvent commonEvent = (CommonEvent) event;
            if (commonEvent.getType() == AchievementEnum.EventTypeEnum.ATTENTION_EVENT.getType()) {
                event.setAchievementId(achievementId);
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean doCondition(AchievementDTO achievementDTO) {
        if (CollectionUtils.isNotEmpty(achievementDTO.getConditions())) {
            for (Condition condition : achievementDTO.getConditions()) {
                if (Constants.Achievement.SPARE_FOOTBALL_TEAM_CONDITION_KEY.equals(condition.getKey())) {
                    List<String> entityIds = new ArrayList<>();
                    if (StringUtils.isNotBlank(condition.getProcessValue())) {
                        entityIds = JSON.parseArray(condition.getProcessValue(), String.class);
                    }
                    //关注不同的店铺
                    if (!condition.getProcessValue().contains(achievementDTO.getEntityId())) {
                        entityIds.add(achievementDTO.getEntityId());
                        condition.setProcessValue(JSON.toJSONString(entityIds));
                        condition.setProcess((short) (condition.getProcess() + 1));
                        if (condition.getValue().equals(Objects.toString(condition.getProcess()))) {
                            achievementDTO.setStatus(AchievementConstant.RecordStatus.STATUS_COMPLETED);
                        } else {
                            achievementDTO.setStatus(AchievementConstant.RecordStatus.STATUS_PROCESSING);
                        }
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
