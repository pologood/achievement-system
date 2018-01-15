/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.handler.order;

import com.achievement.constant.AchievementEnum;
import com.achievement.event.AchievementEvent;
import com.achievement.event.OrderEvent;
import com.achievement.handler.AbstractAchieveHandler;
import org.springframework.stereotype.Component;

/**
 * LoveProverbsAchieveHandler
 *
 * @author caisl
 * @desc 爱的箴言
 * @since 2017-06-13
 */
@Component
public class LoveProverbsHandler extends AbstractAchieveHandler {
    private static String achievementId = "c5a968a3372c474794ef670fe9ad7133";

    @Override
    protected boolean checkEvent(AchievementEvent event) {
        if (event instanceof OrderEvent) {
            OrderEvent orderEvent = (OrderEvent) event;
            if (orderEvent.getAction() == AchievementEnum.OrderActionEnum.EVALUATION.getCode()) {
                event.setAchievementId(achievementId);
                return true;
            }
        }
        return false;
    }
}
