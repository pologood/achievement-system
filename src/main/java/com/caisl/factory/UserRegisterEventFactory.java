/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.caisl.factory;

import com.caisl.event.BaseEvent;
import com.lmax.disruptor.EventFactory;

/**
 * UserRegisterEventFactory
 *
 * @author shinan
 * @since 2017-05-10
 */
public class UserRegisterEventFactory implements EventFactory<BaseEvent> {
    public BaseEvent newInstance() {
        return new BaseEvent();
    }
}
