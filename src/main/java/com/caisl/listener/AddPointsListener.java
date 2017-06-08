/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.caisl.listener;

import com.caisl.event.SignEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * AddPointsListener
 *
 * @author shinan
 * @since 2017-05-08
 */
@Component
public class AddPointsListener implements ApplicationListener<SignEvent> {
    public void onApplicationEvent(SignEvent signEvent) {
        System.out.println(signEvent.getSource() + " sign success" + " addPoint");
    }
}
