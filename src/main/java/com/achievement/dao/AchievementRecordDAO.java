/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.dao;

import com.achievement.dao.mapper.AchievementRecordMapper;
import com.achievement.dataobject.AchievementRecord;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * AchievementRecordDAO
 *
 * @author caisl
 * @since 2017-06-14
 */
@Repository
public class AchievementRecordDAO {
    @Resource
    AchievementRecordMapper achievementRecordMapper;

    /**
     * 查询记录
     *
     * @param customerRegisterId 用户Id
     * @param achievementId      成就Id
     * @return
     */
    public AchievementRecord queryRecord(String customerRegisterId, String achievementId) {
        return achievementRecordMapper.selectById(customerRegisterId, achievementId);
    }

    /**
     * 查询记录
     *
     * @param achievementRecordId 主键Id
     * @return
     */
    public AchievementRecord queryRecordByPrimaryKey(String achievementRecordId) {
        return achievementRecordMapper.selectByPrimaryKey(achievementRecordId);
    }

    /**
     * 查询记录（多条）
     *
     * @param customerRegisterId   用户Id
     * @param achievementPackageId 成就包Id
     * @param status               状态
     * @return
     */
    public List<AchievementRecord> queryRecords(String customerRegisterId, String achievementPackageId,
                                                short status) {
        return achievementRecordMapper.selectRecords(customerRegisterId, achievementPackageId, status);
    }

    /**
     * 查询成就Id集合
     *
     * @param customerRegisterId 用户Id
     * @param status             状态
     * @return
     */
    public List<String> queryAchievementIds(String customerRegisterId, short status) {
        return achievementRecordMapper.selectAchievementIds(customerRegisterId, status);
    }

    /**
     * 插入记录
     *
     * @param achievementRecord 记录对象
     */
    public void insertRecord(AchievementRecord achievementRecord) {
        achievementRecordMapper.insert(achievementRecord);
    }

    /**
     * 更新记录
     *
     * @param achievementRecord 更新记录
     */
    public void updateRecord(AchievementRecord achievementRecord) {
        achievementRecordMapper.updateRecord(achievementRecord);
    }

    /**
     * 根据用户ID查询和成就状态，查询用户成就记录
     *
     * @param customerRegisterId 用户ID
     * @param status             成就状态
     * @return
     */
    public List<AchievementRecord> queryRecordByStatus(String customerRegisterId, short status) {
        List<AchievementRecord> recordList = achievementRecordMapper.selectRecordByStatus(customerRegisterId, status);
        if (recordList == null) {
            return Collections.emptyList();
        }
        return recordList;
    }

    /**
     * 查询完成成就获得的火种数
     *
     * @param customerRegisterId
     * @return
     */
    public List<Integer> queryRewardFireSeed(String customerRegisterId) {
        return achievementRecordMapper.selectReward(customerRegisterId);
    }
}
