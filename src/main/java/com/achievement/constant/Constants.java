/*
 * Copyright (C) 2009-2017 Hangzhou  Technology Co., Ltd.All rights reserved
 */
package com.achievement.constant;

/**
 * Constants
 *
 * @author caisl
 * @desc 静态常量
 * @since 2017-06-19
 */
public class Constants {

    public static final short IS_VALID = (short) 1; // 有效
    public static final short IS_NOT_VALID = (short) 0; // 无效

    /**
     * 缓存过期时间
     */
    public interface CacheExpireTime {
        int EXPIRE_TIME_ONE_DAY = 24 * 60 * 60;//一天
        int EXPIRE_TIME_HALF_DAY = 12 * 60 * 60;//半天
        int TEN_MINUTES = 10 * 60;//10分钟
    }

    /**
     * 缓存key
     */
    public interface CacheKey {
        String KEY_PREFIX = "fireMember:";
        String ACHIEVEMENT_PACKAGE_ALL = KEY_PREFIX + "achievementPackage:ALL";//成就包缓存Key
        String ACHIEVEMENT_TEMPLATE_PREFIX = KEY_PREFIX + "achievementTemplate:";//成就模板缓存Key
        String ACHIEVEMENT_TEMPLATE_PACKAGE_PREFIX = KEY_PREFIX + "achievementTemplatePackage:";//成就包下包含所有成就模板缓存key
        String SIGN_RECORD = KEY_PREFIX + "signRecord:";//个人签到记录
        String WHOLE_NET_RANKING_FIRESEED = KEY_PREFIX + "whole_net_ranking:fireSeed";// 全网火种排名缓存key
        String WHOLE_NET_RANKING_CONSUMERAMOUNT = KEY_PREFIX + "whole_net_ranking:consumerAmount";// 全网消费额排名缓存key

    }

    /**
     * 成就相关的常量
     */
    public interface Achievement {
        String STATUS_PREFIX_LIST = "list_";//成就图片列表前缀-小图
        String STATUS_PREFIX_DETAIL = "detail";//成就图片详情前缀-大图
        String STATUS_PREFIX_HOME_PAGE = "home_page";//成就图片首页前缀
        String ALL_ACHIEVEMENT_PACKAGE_ID = "8959a151a5e94cd98ef29bde24aa4all";//查询所有成就
        String COOKERY_GOD_PASS_CONDITION_KEY = "finishAchievementIds";//食神通行证条件key
        String SPARE_FOOTBALL_TEAM_CONDITION_KEY = "attention";//备胎足球队条件key
    }

    /**
     * 降级开关
     */
    public interface DowngradeConfig {
        String EVENT_PUBLISH_SWITCH = "event_publish";//事件发送降级开关
        String LOG_PRINT = "log_print";//日志打印
        String HOME_PAGE = "home_page";//火会员首页降级
        String RANKING_LIST = "ranking_list";//排行榜降级
        String FRIENDS_RANKING_ZERO_SHOW = "friends_ranking_zero_show";//1 展示排行数据为0的数据  0不展示排行数据为0的数据
    }

    public interface PageSelection {
        int FoodDiaryPageSize = 5;//我的美食日记：最近去过的5家店
    }

    /**
     * ScanCode 相关的常量
     */
    public interface ScanCodeConstants {
        /** 授权 */
        int AUTHORIZE = 1;
        /** 登录 */
        int LOGIN = 2;
    }

}
