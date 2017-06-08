/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.caisl.publisher;

import com.caisl.event.AchievementEvent;

/**
 * IEventPublisher
 *
 * @author shinan
 * @since 2017-06-08
 */
public interface IEventPublisher<T extends AchievementEvent> {
    public void publish(T event);
}
