/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.caisl.publisher;

import com.caisl.event.AchievementEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * EventClient
 *
 * @author shinan
 * @since 2017-06-05
 */
@Component
public class EventClient implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void publish(AchievementEvent event) {
        String eventName = StringUtils.uncapitalize(event.getClass().getSimpleName());
        IEventPublisher publisher = (IEventPublisher) applicationContext.getBean(eventName + "Publisher");
        if (publisher != null) {
            publisher.publish(event);
        }
    }
}
