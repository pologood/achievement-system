/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.handler;

import com.lmax.disruptor.ExceptionHandler;

/**
 * AchieveEventExceptionHandler
 *
 * @author caisl
 * @since 2017-06-13
 */
public class AchieveEventExceptionHandler implements ExceptionHandler {
    /**
     * 队列名
     */
    private final String disruptorName;

    public AchieveEventExceptionHandler(String disruptorName) {
        this.disruptorName = disruptorName;
    }

    @Override
    public void handleEventException(Throwable ex, long sequence, Object event) {
        LoggerUtil.error(FireMemberLoggerFactory.ACHIEVEMENT_LOGGER, LogMarker.ACHIEVEMENT_HANDLER, ex,"disruptorName " +
                "= {} Exception processing: sequence = {}, event = {}",disruptorName, sequence, event.toString());
    }

    @Override
    public void handleOnStartException(Throwable ex) {
        LoggerUtil.error(FireMemberLoggerFactory.ACHIEVEMENT_LOGGER, LogMarker.ACHIEVEMENT_HANDLER, ex,"disruptorName " +
                "= {} Exception during onStart(): ",disruptorName);
    }

    @Override
    public void handleOnShutdownException(Throwable ex) {
        LoggerUtil.error(FireMemberLoggerFactory.ACHIEVEMENT_LOGGER, LogMarker.ACHIEVEMENT_HANDLER, ex,"disruptorName " +
                "= {} Exception during onShutdown(): ",disruptorName);
    }
}
