package com.achievement.service.mapper;

import com.achievement.domain.AchievementRecord;

public interface AchievementRecordMapper {
    int deleteByPrimaryKey(String achievementRecordId);

    int insert(AchievementRecord record);

    int insertSelective(AchievementRecord record);

    AchievementRecord selectByPrimaryKey(String achievementRecordId);

    int updateByPrimaryKeySelective(AchievementRecord record);

    int updateByPrimaryKey(AchievementRecord record);
}