/*
 * Copyright (C) 2009-2017 Hangzhou  Technology Co., Ltd.All rights reserved
 */
package com.achievement.factory;

import com.achievement.constant.AchievementEnum;
import com.achievement.domain.AchievementEventMessage;
import com.achievement.event.AchievementEvent;
import com.achievement.event.CommonEvent;
import com.achievement.event.ConsumerEvent;
import com.achievement.event.OrderEvent;
import org.springframework.stereotype.Component;

/**
 * AchievementEventFactory
 *
 * @author caisl
 * @desc 事件工厂
 * @since 2017-06-21
 */
@Component
public class AchievementEventFactory {

    /**
     * 工厂模式创建事件实例
     *
     * @param eventMessage
     * @return
     */
    public AchievementEvent create(AchievementEventMessage eventMessage) {
        if (eventMessage.getType() == AchievementEnum.EventTypeEnum.ORDER_EVENT.getType()) {
            OrderEvent orderEvent = new OrderEvent(eventMessage.getEntityId(), eventMessage.getCustomerRegisterIds(),
                    eventMessage.getSource(), eventMessage.getType());
            orderEvent.setAction(eventMessage.getAction());
            orderEvent.setOrderType(eventMessage.getOrderType());
            return orderEvent;
        } else if (eventMessage.getType() == AchievementEnum.EventTypeEnum.CONSUMER_EVENT.getType()) {
            ConsumerEvent consumerEvent = new ConsumerEvent(eventMessage.getEntityId(), eventMessage.getCustomerRegisterIds(),
                    eventMessage.getSource(), eventMessage.getType());
            consumerEvent.setOfferCount(eventMessage.getOfferCount());
            return consumerEvent;
        } else {
            CommonEvent commonEvent = new CommonEvent(eventMessage.getEntityId(), eventMessage.getCustomerRegisterIds(),
                    eventMessage.getSource(), eventMessage.getType());
            return commonEvent;
        }
    }
}
