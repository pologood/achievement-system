/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.caisl.handler;

import com.caisl.event.UserRegisterEvent;
import com.lmax.disruptor.EventHandler;
import org.springframework.stereotype.Component;

/**
 * UserRegisterEventHandler
 *
 * @author shinan
 * @since 2017-05-10
 */
@Component
public class UserRegisterEventHandler implements EventHandler<UserRegisterEvent> {
    public void onEvent(UserRegisterEvent userRegisterEvent, long l, boolean b) throws Exception {
        System.out.println(Thread.currentThread() + " UserRegisterEvent = " + userRegisterEvent.getName() + " l = " + l
                + " b = " + b);
    }
}
