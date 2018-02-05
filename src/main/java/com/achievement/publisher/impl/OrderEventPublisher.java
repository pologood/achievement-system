/*
 * Copyright (C) 2009-2017 Hangzhou  Technology Co., Ltd.All rights reserved
 */
package com.achievement.publisher.impl;

import com.achievement.event.OrderEvent;
import com.achievement.factory.EventHandlerThreadFactory;
import com.achievement.handler.AchieveEventExceptionHandler;
import com.achievement.handler.CookeryGodPassHandler;
import com.achievement.handler.order.LoveProverbsHandler;
import com.achievement.handler.order.TechnologyHouseHandler;
import com.achievement.handler.order.WelcomeHandler;
import com.achievement.publisher.IEventPublisher;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * OrderEventPublisher
 *
 * @author caisl
 * @since 2017-06-08
 */
@Component
public class OrderEventPublisher implements InitializingBean, IEventPublisher<OrderEvent> {

    private static final EventTranslatorOneArg<OrderEvent, OrderEvent> translator = (OrderEvent event, long sequence,
                                                                                     OrderEvent arg0) -> {
        event.setDisruptorName(arg0.getDisruptorName());
        event.setEntityId(arg0.getEntityId());
        event.setCustomerRegisterIds(arg0.getCustomerRegisterIds());
        event.setOrderId(arg0.getOrderId());
        event.setAction(arg0.getAction());
        event.setOrderFee(arg0.getOrderFee());
        event.setType(arg0.getType());
        event.setSource(arg0.getSource());
        event.setOrderType(arg0.getOrderType());
    };
    private static Logger log = LoggerFactory.getLogger(OrderEventPublisher.class);
    private Disruptor<OrderEvent> disruptor;

    @Resource
    private WelcomeHandler welcomeHandler;
    @Resource
    private LoveProverbsHandler loveProverbsHandler;
    @Resource
    private TechnologyHouseHandler technologyHouseHandler;
    @Resource
    private CookeryGodPassHandler cookeryGodPassHandler;

    private int bufferSize;
    private RingBuffer ringBuffer;


    @Override
    public void afterPropertiesSet() throws Exception {
        disruptor = new Disruptor<>(() -> new OrderEvent(),
                4096, new EventHandlerThreadFactory("OrderEvent"), ProducerType.MULTI, new BlockingWaitStrategy());
        disruptor.handleEventsWith(welcomeHandler, loveProverbsHandler, technologyHouseHandler).then(cookeryGodPassHandler);
        disruptor.setDefaultExceptionHandler(new AchieveEventExceptionHandler("OrderEventDisruptor"));
        ringBuffer = disruptor.start();
        bufferSize = ringBuffer.getBufferSize();
    }

    @Override
    public boolean publish(OrderEvent event) {
        event.setDisruptorName("OrderEventDisruptor");
        if (ringBuffer.remainingCapacity() < bufferSize * 0.01) {
            log.warn("OrderEventDisruptor size = " + ringBuffer.remainingCapacity());
        }
        return ringBuffer.tryPublishEvent(translator, event);//发布事件；
    }
}
