/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.caisl.handler;

import com.caisl.event.AchievementEvent;
import com.caisl.handler.IAchievementService;

/**
 * AbstractEventPublisher
 *
 * @author shinan
 * @since 2017-06-08
 */
public abstract class AbstractEventHandler implements IAchievementService {
    public void onEvent(AchievementEvent event, long sequence, boolean endOfBatch) throws Exception {
        if(preBusiness(event) && doCondition(event)) {
            reward();
        }
    }

}
