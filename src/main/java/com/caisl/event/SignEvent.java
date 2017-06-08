/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.caisl.event;

import org.springframework.context.ApplicationEvent;

/**
 * SignEvent
 *
 * @author shinan
 * @since 2017-05-08
 */
public class SignEvent extends ApplicationEvent {

    public SignEvent(final String name){
        super(name);
    }
}
