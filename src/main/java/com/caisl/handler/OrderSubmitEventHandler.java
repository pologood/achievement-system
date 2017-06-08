/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.caisl.handler;

import com.caisl.event.AchievementEvent;
import com.caisl.event.OrderEvent;

/**
 * OrderSubmitEventHandler
 *
 * @author shinan
 * @since 2017-06-05
 */
public class OrderSubmitEventHandler extends AbstractEventHandler {

    public boolean preBusiness(AchievementEvent event) {
        System.out.println(event.getEntityId());
        if(event instanceof OrderEvent) {
            return true;
        }
        return false;
    }

    public boolean doCondition(AchievementEvent event) {
        return true;
    }

    public void reward() {
        System.out.println("OrderSubmitEventHandler reward");
    }

}
