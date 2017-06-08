/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.caisl.publisher;

import com.caisl.event.OrderEvent;
import com.caisl.handler.OrderSubmitEventHandler;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;

/**
 * OrderEventPublisher
 *
 * @author shinan
 * @since 2017-06-08
 */
@Component
public class OrderEventPublisher implements InitializingBean, IEventPublisher<OrderEvent> {

    private static final EventTranslatorOneArg<OrderEvent, OrderEvent> aa = new
            EventTranslatorOneArg<OrderEvent, OrderEvent>() {

                public void translateTo(OrderEvent event, long sequence, OrderEvent arg0) {
                    event.setEntityId(arg0.getEntityId());
                }

            };
    private static Disruptor<OrderEvent> disruptor;

    public void afterPropertiesSet() throws Exception {
        disruptor = new Disruptor<OrderEvent>(new EventFactory<OrderEvent>() {
            public OrderEvent newInstance() {
                return new OrderEvent();
            }
        },
                1024, Executors.newFixedThreadPool(10), ProducerType.MULTI,
                new BlockingWaitStrategy());
        disruptor.handleEventsWith(new OrderSubmitEventHandler());
        disruptor.start();
    }

    public void publish(OrderEvent event) {
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        ringBuffer.tryPublishEvent(aa, event);//发布事件；
    }
}
