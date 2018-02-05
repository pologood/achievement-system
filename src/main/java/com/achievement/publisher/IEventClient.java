/*
 * Copyright (C) 2009-2017 Hangzhou  Technology Co., Ltd.All rights reserved
 */
package com.achievement.publisher;


import com.achievement.event.AchievementEvent;

/**
 * IEventClient
 *
 * @author shinan
 * @since 2017-06-22
 */
public interface IEventClient {

    /**
     * 发布事件
     *
     * @param event
     * @return
     */
    Boolean publish(AchievementEvent event);
}
