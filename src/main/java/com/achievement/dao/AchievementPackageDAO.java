/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.dao;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.dfire.soa.consumer.fm.bo.AchievementPackage;
import com.dfire.soa.consumer.fm.constant.Constants;
import com.dfire.soa.consumer.fm.dao.mapper.AchievementPackageMapper;
import com.twodfire.redis.ICacheService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * AchievementPackageDAO
 *
 * @author caisl
 * @since 2017-06-14
 */
@Repository
public class AchievementPackageDAO {
    @Resource
    ICacheService cacheService;
    @Resource
    AchievementPackageMapper achievementPackageMapper;
    /**
     * 查询所有成就包
     *
     * @return
     */
    public List<AchievementPackage> queryAll() {
        List<AchievementPackage> achievementPackages = (List<AchievementPackage>) cacheService.getObject(Constants.CacheKey.ACHIEVEMENT_PACKAGE_ALL);
        if (CollectionUtils.isEmpty(achievementPackages)) {
            achievementPackages = achievementPackageMapper.queryAll();
            cacheService.setObject(Constants.CacheKey.ACHIEVEMENT_PACKAGE_ALL, achievementPackages, Constants.CacheExpireTime.EXPIRE_TIME_ONE_DAY);
        }
        return achievementPackages;
    }
}
