/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.dao.mapper;


import com.achievement.dataobject.AchievementRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * AchievementPackageDAO
 *
 * @author caisl
 * @since 2017-06-14
 */
public interface AchievementRecordMapper {
    /**
     * 根据主键查询记录
     *
     * @param achievementRecordId 主键Id
     * @return
     */
    AchievementRecord selectByPrimaryKey(String achievementRecordId);

    /**
     * 插入一条记录
     *
     * @param record 记录
     * @return
     */
    int insert(AchievementRecord record);

    /**
     * 查询记录
     *
     * @param customerRegisterId 用户Id
     * @param status             状态
     * @return
     */
    List<String> selectAchievementIds(@Param("customerRegisterId") String customerRegisterId, @Param("status") short status);

    /**
     * 根据用户Id 和 成就Id 查询成就记录
     *
     * @param customerRegisterId
     * @param achievementId
     * @return
     */
    AchievementRecord selectById(@Param("customerRegisterId") String customerRegisterId, @Param("achievementTemplateId") String achievementId);

    /**
     * 查询成就记录（多条）
     *
     * @param customerRegisterId
     * @param achievementPackageId
     * @param status
     * @return
     */
    List<AchievementRecord> selectRecords(@Param("customerRegisterId") String customerRegisterId, @Param
            ("achievementPackageId") String achievementPackageId, @Param("status") short status);

    /**
     * 更新记录
     *
     * @param record
     * @return
     */
    int updateRecord(AchievementRecord record);

    /**
     * 根据用户ID查询和成就状态，查询用户成就记录
     *
     * @param customerRegisterId 用户ID
     * @param status             成就状态
     * @return
     */
    List<AchievementRecord> selectRecordByStatus(@Param("customerRegisterId") String customerRegisterId, @Param("status") short status);

    /**
     * 查询完成成就获得的火种数
     *
     * @param customerRegisterId
     * @return
     */
    List<Integer> selectReward(String customerRegisterId);
}