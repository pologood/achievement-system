/*
 * Copyright (C) 2009-2017 Hangzhou  Technology Co., Ltd.All rights reserved
 */
package com.achievement.dao.mapper;

import com.achievement.dataobject.AchievementPackage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * AchievementPackageDAO
 *
 * @author caisl
 * @since 2017-06-14
 */
@Mapper
public interface AchievementPackageMapper {
    /**
     * 查询所有成就包信息
     *
     * @return
     */
    List<AchievementPackage> queryAll();
}