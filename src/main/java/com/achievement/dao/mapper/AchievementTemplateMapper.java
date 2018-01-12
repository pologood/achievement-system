package com.achievement.dao.mapper;


import com.achievement.dataobject.AchievementTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AchievementTemplateMapper {

    /**
     * 根据主键查询成就配置
     *
     * @param achievementTemplateId
     * @return
     */
    AchievementTemplate selectByPrimaryKey(String achievementTemplateId);

    /**
     * 查询某成就包下面的所有成就
     *
     * @param achievementPackageId
     * @return
     */
    List<AchievementTemplate> selectByPackageId(@Param("achievementPackageId") String achievementPackageId);

    /**
     * 根据成就ID列表，查询成就配置表
     *
     * @param templateIdList 成就ID列表
     * @return 成就配置列表
     */
    List<AchievementTemplate> selectByTemplateIdList(List<String> templateIdList);
}