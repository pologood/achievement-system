/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.caisl.event;

/**
 * BaseEvent
 *
 * @author shinan
 * @since 2017-06-05
 */
public class BaseEvent {
    private Object event;

    public BaseEvent(){

    }
    public BaseEvent(Object event){
        this.event = event;
    }
}
