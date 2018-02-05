/*
 * Copyright (C) 2009-2017 Hangzhou  Technology Co., Ltd.All rights reserved
 *//*

package com.achievement.quene;

import com.achievement.event.UserRegisterEvent;
import com.achievement.factory.EventThreadFactory;
import com.achievement.factory.UserRegisterEventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

*/
/**
 * EventQueue
 *
 * @author caisl
 * @since 2017-06-03
 *//*

public enum EventQueue {

    INSATNCE;

    Disruptor<UserRegisterEvent> userRegisterEventDisruptor;

    EventQueue(){
         userRegisterEventDisruptor = new Disruptor<UserRegisterEvent>(new UserRegisterEventFactory(), 1024 *1024,
                new EventThreadFactory());
    }

    public void publishEvent(UserRegisterEvent event){

    }
}
*/
