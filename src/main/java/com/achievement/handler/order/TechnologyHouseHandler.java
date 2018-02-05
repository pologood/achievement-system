/*
 * Copyright (C) 2009-2017 Hangzhou  Technology Co., Ltd.All rights reserved
 */
package com.achievement.handler.order;

import com.achievement.constant.AchievementConstant;
import com.achievement.constant.AchievementEnum;
import com.achievement.event.AchievementEvent;
import com.achievement.event.OrderEvent;
import com.achievement.handler.AbstractAchieveHandler;
import org.springframework.stereotype.Component;

/**
 * TechnologyHouseAchieveHandler
 *
 * @author caisl
 * @desc 技术宅
 * @since 2017-06-13
 */
@Component
public class TechnologyHouseHandler extends AbstractAchieveHandler {

    private static String achievementId = "c5a968a3372c474794ef670fe9ad7134";

    @Override
    protected boolean checkEvent(AchievementEvent event) {
        //1.事件类型检验
        if (event instanceof OrderEvent) {
            OrderEvent orderEvent = (OrderEvent) event;
            if (orderEvent.getAction() == AchievementEnum.OrderActionEnum.SUBMIT.getCode() &&
                    AchievementConstant.OrderType.ORDER_TAKEOUT.equals(orderEvent.getOrderType())) {
                event.setAchievementId(achievementId);
                return true;
            }
        }
        return false;
    }
}
