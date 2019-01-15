
package com.achievement.dao;

import com.achievement.constant.Constants;
import com.achievement.dao.mapper.AchievementPackageMapper;
import com.achievement.dataobject.AchievementPackage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

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
    RedisTemplate redisTemplate;
    @Resource
    AchievementPackageMapper achievementPackageMapper;
    /**
     * 查询所有成就包
     *
     * @return
     */
    public List<AchievementPackage> queryAll() {
        List<AchievementPackage> achievementPackages = (List<AchievementPackage>) redisTemplate.opsForValue().get(Constants.CacheKey.ACHIEVEMENT_PACKAGE_ALL);
        if (CollectionUtils.isEmpty(achievementPackages)) {
            achievementPackages = achievementPackageMapper.queryAll();
            redisTemplate.opsForValue().set(Constants.CacheKey.ACHIEVEMENT_PACKAGE_ALL, achievementPackages, Constants.CacheExpireTime.EXPIRE_TIME_ONE_DAY);
        }
        return achievementPackages;
    }
}
