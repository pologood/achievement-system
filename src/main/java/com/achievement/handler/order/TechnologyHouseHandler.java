/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.handler.order;

import com.dfire.soa.consumer.fm.achievement.handler.AbstractAchieveHandler;
import com.dfire.soa.consumer.fm.constant.AchievementConstant;
import com.dfire.soa.consumer.fm.constant.AchievementEnum;
import com.dfire.soa.consumer.fm.domain.event.AchievementEvent;
import com.dfire.soa.consumer.fm.domain.event.OrderEvent;
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
