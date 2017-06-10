package com.caisl.service.mapper;

import com.caisl.domain.AchievementPackage;

public interface AchievementPackageMapper {
    AchievementPackage selectByPrimaryKey(String achievementPackageId);
}