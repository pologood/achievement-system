/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.dao;

import com.dfire.soa.consumer.fm.bo.AchievementTemplate;
import com.dfire.soa.consumer.fm.constant.Constants;
import com.dfire.soa.consumer.fm.dao.mapper.AchievementTemplateMapper;
import com.twodfire.redis.ICacheService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * AchievementTemplateDAO
 *
 * @author caisl
 * @since 2017-06-14
 */
@Repository
public class AchievementTemplateDAO {
    @Resource
    ICacheService cacheService;
    @Resource
    AchievementTemplateMapper achievementTemplateMapper;

    /**
     * 根据成就Id查询成就配置
     *
     * @param achievementTemplateId
     * @return
     */
    public AchievementTemplate queryByTemplateId(String achievementTemplateId) {
        AchievementTemplate achievementTemplate = (AchievementTemplate) cacheService.getObject(Constants.CacheKey
                .ACHIEVEMENT_TEMPLATE_PREFIX + achievementTemplateId);
        if (achievementTemplate == null) {
            achievementTemplate = achievementTemplateMapper.selectByPrimaryKey(achievementTemplateId);
            cacheService.setObject(Constants.CacheKey.ACHIEVEMENT_TEMPLATE_PREFIX + achievementTemplateId,
                    achievementTemplate, Constants.CacheExpireTime.EXPIRE_TIME_ONE_DAY);
        }
        return achievementTemplate;
    }

    /**
     * 查询成就包包含的成就配置
     * @param achievementPackageId
     * @return
     */
    public List<AchievementTemplate> queryByPackageId(String achievementPackageId) {
        List<AchievementTemplate> achievementTemplates = (List<AchievementTemplate>) cacheService.getObject(Constants
                .CacheKey.ACHIEVEMENT_TEMPLATE_PACKAGE_PREFIX + achievementPackageId);
        if (achievementTemplates == null) {
            achievementTemplates = achievementTemplateMapper.selectByPackageId(achievementPackageId);
            cacheService.setObject(Constants.CacheKey.ACHIEVEMENT_TEMPLATE_PACKAGE_PREFIX + achievementPackageId,
                    achievementTemplates, Constants.CacheExpireTime.EXPIRE_TIME_ONE_DAY);
        }
        return achievementTemplates;
    }

    /**
     * 根据成就ID列表，查询成就配置
     *
     * @param templateIdList 成就ID列表
     * @return 成就配置列表
     */
    public List<AchievementTemplate> queryByTemplateIdList(List<String> templateIdList){
        List<AchievementTemplate> templateList = achievementTemplateMapper.selectByTemplateIdList(templateIdList);
        if(templateList == null){
            return Collections.emptyList();
        }
        return templateList;
    }

}
