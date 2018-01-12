/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.publisher.impl;

import com.achievement.event.ConsumerEvent;
import com.achievement.factory.EventHandlerThreadFactory;
import com.achievement.handler.AchieveEventExceptionHandler;
import com.achievement.handler.CookeryGodPassHandler;
import com.achievement.handler.consumer.HelloRicherHandler;
import com.achievement.handler.consumer.SmallHousewifeHandler;
import com.achievement.publisher.IEventPublisher;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * OrderEventPublisher
 *
 * @author caisl
 * @since 2017-06-19
 */
@Component
public class ConsumerEventPublisher implements InitializingBean, IEventPublisher<ConsumerEvent> {

    private static final EventTranslatorOneArg<ConsumerEvent, ConsumerEvent> translator = (ConsumerEvent event, long sequence,
                                                                                           ConsumerEvent arg0) -> {
        event.setDisruptorName(arg0.getDisruptorName());
        event.setEntityId(arg0.getEntityId());
        event.setCustomerRegisterIds(arg0.getCustomerRegisterIds());
        event.setType(arg0.getType());
        event.setSource(arg0.getSource());
        event.setGoods(arg0.getGoods());
        event.setOfferCount(arg0.getOfferCount());
    };
    private Disruptor<ConsumerEvent> disruptor;

    @Resource
    private HelloRicherHandler helloRicherHandler;
    @Resource
    private SmallHousewifeHandler smallHousewifeHandler;
    @Resource
    private CookeryGodPassHandler cookeryGodPassHandler;

    private int bufferSize;
    private RingBuffer ringBuffer;

    @Override
    public void afterPropertiesSet() throws Exception {
        disruptor = new Disruptor<>(() -> new ConsumerEvent(),
                4096, new EventHandlerThreadFactory("ConsumerEvent"), ProducerType.MULTI, new BlockingWaitStrategy());
        disruptor.handleEventsWith(helloRicherHandler, smallHousewifeHandler).then(cookeryGodPassHandler);
        disruptor.setDefaultExceptionHandler(new AchieveEventExceptionHandler("ConsumerEventDisruptor"));
        ringBuffer = disruptor.start();
        bufferSize = ringBuffer.getBufferSize();
    }

    @Override
    public boolean publish(ConsumerEvent event) {
        event.setDisruptorName("ConsumerEventDisruptor");
        if (ringBuffer.remainingCapacity() < bufferSize * 0.01) {
            LoggerUtil.warn(FireMemberLoggerFactory.ACHIEVEMENT_LOGGER, LogMarker.ACHIEVEMENT_HANDLER,
                    "ConsumerEventDisruptor size = {}", ringBuffer.remainingCapacity());
        }
        return ringBuffer.tryPublishEvent(translator, event);//发布事件；
    }
}
