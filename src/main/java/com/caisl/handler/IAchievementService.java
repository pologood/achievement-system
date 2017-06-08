/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.caisl.handler;

import com.caisl.event.AchievementEvent;
import com.lmax.disruptor.EventHandler;

/**
 * IAchievementService
 *
 * @author shinan
 * @since 2017-06-05
 */
public interface IAchievementService extends EventHandler<AchievementEvent>{
    boolean preBusiness(AchievementEvent event);

    boolean doCondition(AchievementEvent event);

    void reward();
}
