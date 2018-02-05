/*
 * Copyright (C) 2009-2017 Hangzhou  Technology Co., Ltd.All rights reserved
 */
package com.achievement.factory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * EventHandlerThreadFactory
 *
 * @author caisl
 * @since 2017-06-13
 */
public class EventHandlerThreadFactory implements ThreadFactory {

    private final AtomicInteger seq = new AtomicInteger(0);

    /**
     * 线程名
     */
    private String threadName;

    public EventHandlerThreadFactory(String threadName){
        this.threadName = threadName;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r,"AchievementEvent-Consumer-Thread-" + this.threadName + seq.getAndIncrement());
        thread.setDaemon(true);
        return thread;
    }
}
