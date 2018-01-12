/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.handler.consumer;

import com.dfire.soa.consumer.fm.achievement.handler.AbstractAchieveHandler;
import com.dfire.soa.consumer.fm.domain.event.AchievementEvent;
import com.dfire.soa.consumer.fm.domain.event.ConsumerEvent;
import org.springframework.stereotype.Component;

/**
 * SmallHousewifeHandler
 *
 * @author caisl
 * @desc 优惠小主妇
 * @since 2017-06-13
 */
@Component
public class SmallHousewifeHandler extends AbstractAchieveHandler {
    private static String achievementId = "c5a968a3372c474794ef670fe9ad7138";

    @Override
    protected boolean checkEvent(AchievementEvent event) {
        if (event instanceof ConsumerEvent) {
            ConsumerEvent consumerEvent = (ConsumerEvent) event;
            if (consumerEvent.getOfferCount() > 0) {
                event.setAchievementId(achievementId);
                return true;
            }
        }
        return false;
    }
}