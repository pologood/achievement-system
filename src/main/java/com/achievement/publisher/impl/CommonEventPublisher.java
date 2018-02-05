/*
 * Copyright (C) 2009-2017 Hangzhou  Technology Co., Ltd.All rights reserved
 */
package com.achievement.publisher.impl;

import com.achievement.event.CommonEvent;
import com.achievement.factory.EventHandlerThreadFactory;
import com.achievement.handler.AchieveEventExceptionHandler;
import com.achievement.handler.CookeryGodPassHandler;
import com.achievement.handler.common.DazzleLifeHandler;
import com.achievement.handler.common.FiftyQuarterOneHandler;
import com.achievement.handler.common.SpareFootballTeamHandler;
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
 * @since 2017-06-19
 */
@Component
public class CommonEventPublisher implements InitializingBean, IEventPublisher<CommonEvent> {

    private static final EventTranslatorOneArg<CommonEvent, CommonEvent> translator = (CommonEvent event, long sequence,
                                                                                       CommonEvent arg0) -> {
        event.setDisruptorName(arg0.getDisruptorName());
        event.setEntityId(arg0.getEntityId());
        event.setCustomerRegisterIds(arg0.getCustomerRegisterIds());
        event.setType(arg0.getType());
        event.setSource(arg0.getSource());
    };
    private static Logger log = LoggerFactory.getLogger(CommonEventPublisher.class);
    private Disruptor<CommonEvent> disruptor;

    @Resource
    private DazzleLifeHandler dazzleLifeHandler;
    @Resource
    private FiftyQuarterOneHandler fiftyQuarterOneHandler;
    @Resource
    private SpareFootballTeamHandler spareFootballTeamHandler;
    @Resource
    private CookeryGodPassHandler cookeryGodPassHandler;

    private int bufferSize;
    private RingBuffer ringBuffer;

    @Override
    public void afterPropertiesSet() throws Exception {
        disruptor = new Disruptor<>(() -> new CommonEvent(),
                2048, new EventHandlerThreadFactory("CommonEvent"), ProducerType.MULTI, new BlockingWaitStrategy());
        disruptor.handleEventsWith(dazzleLifeHandler, fiftyQuarterOneHandler, spareFootballTeamHandler).then(cookeryGodPassHandler);
        disruptor.setDefaultExceptionHandler(new AchieveEventExceptionHandler("CommonEventDisruptor"));
        ringBuffer = disruptor.start();
        bufferSize = ringBuffer.getBufferSize();
    }

    @Override
    public boolean publish(CommonEvent event) {
        event.setDisruptorName("CommonEventDisruptor");
        if (ringBuffer.remainingCapacity() < bufferSize * 0.01) {
            log.warn("CommonEventDisruptor size = " + ringBuffer.remainingCapacity());
        }
        return ringBuffer.tryPublishEvent(translator, event);//发布事件；
    }
}
