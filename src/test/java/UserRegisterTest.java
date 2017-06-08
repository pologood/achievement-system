/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 *//*


import com.caisl.event.BaseEvent;
import com.caisl.event.UserRegisterEvent;
import com.caisl.factory.UserRegisterEventFactory;
import com.caisl.handler.UserRegisterEventHandler;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

*/
/**
 * UserRegisterTest
 *
 * @author shinan
 * @since 2017-05-10
 *//*

public class UserRegisterTest {
    public static void main(String args[]){
        EventFactory<BaseEvent> eventFactory = new UserRegisterEventFactory();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        int ringBufferSize = 1024*1024;
        Disruptor<BaseEvent> disruptor = new Disruptor<BaseEvent>(eventFactory,
                ringBufferSize, executor, ProducerType.SINGLE,
                new YieldingWaitStrategy());

        EventHandler<UserRegisterEvent> eventHandler = new UserRegisterEventHandler();
        disruptor.handleEventsWith(eventHandler);

        disruptor.start();

        // 发布事件；
        RingBuffer<UserRegisterEvent> ringBuffer = disruptor.getRingBuffer();
        for(int i=0;i<8;i++) {
            long sequence = ringBuffer.next();//请求下一个事件序号；
            ringBuffer.newBarrier();
            try {
                UserRegisterEvent event = ringBuffer.get(sequence);//获取该序号对应的事件对象；
                event.setName("caisl" + i);
            } finally {
                ringBuffer.publish(sequence);//发布事件；
            }
        }
    }
}
*/
