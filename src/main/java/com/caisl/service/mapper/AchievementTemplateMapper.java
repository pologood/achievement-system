package com.caisl.service.mapper;

import com.caisl.domain.AchievementTemplate;

public interface AchievementTemplateMapper {
    int deleteByPrimaryKey(String achievementTemplateId);

    int insert(AchievementTemplate record);

    int insertSelective(AchievementTemplate record);

    AchievementTemplate selectByPrimaryKey(String achievementTemplateId);

    int updateByPrimaryKeySelective(AchievementTemplate record);

    int updateByPrimaryKeyWithBLOBs(AchievementTemplate record);

    int updateByPrimaryKey(AchievementTemplate record);
}