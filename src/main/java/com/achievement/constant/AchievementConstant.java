/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.constant;

/**
 * AchievementConstant
 *
 * @author shinan
 * @since 2017-06-13
 */
public class AchievementConstant {

    public interface OrderType {
        String ORDER_TANGSHI = "1";
        String ORDER_TAKEOUT = "2";
    }

    public interface RecordStatus {
        short STATUS_NOT_START = 0;//未开始
        short STATUS_PROCESSING = 1;//进行中
        short STATUS_COMPLETED = 2;//已完成
        short STATUS_PROCESSING_EXPIRE = 3;//进行中已过期
        short STATUS_NOT_STATR_EXPIRE = 4;//未开始已过期
    }
}
