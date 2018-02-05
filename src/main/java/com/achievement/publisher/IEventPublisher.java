/*
 * Copyright (C) 2009-2017 Hangzhou  Technology Co., Ltd.All rights reserved
 */
package com.achievement.publisher;


import com.achievement.event.AchievementEvent;

/**
 * IEventPublisher
 *
 * @author caisl
 * @since 2017-06-08
 */
public interface IEventPublisher<T extends AchievementEvent> {
    /**
     * 发布事件
     * @param event
     * @return
     */
    boolean publish(T event);
}
