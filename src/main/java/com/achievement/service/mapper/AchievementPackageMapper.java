package com.achievement.service.mapper;

import com.achievement.domain.AchievementPackage;

public interface AchievementPackageMapper {
    AchievementPackage selectByPrimaryKey(String achievementPackageId);
}