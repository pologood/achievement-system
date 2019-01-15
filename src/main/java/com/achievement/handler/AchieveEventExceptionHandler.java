
package com.achievement.handler;

import com.lmax.disruptor.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AchieveEventExceptionHandler
 *
 * @author caisl
 * @since 2017-06-13
 */
public class AchieveEventExceptionHandler implements ExceptionHandler {

    private static Logger log = LoggerFactory.getLogger(AchieveEventExceptionHandler.class);

    /**
     * 队列名
     */
    private final String disruptorName;

    public AchieveEventExceptionHandler(String disruptorName) {
        this.disruptorName = disruptorName;
    }

    @Override
    public void handleEventException(Throwable ex, long sequence, Object event) {
        log.error("disruptorName = " + disruptorName + " Exception processing: sequence = " + sequence + ", event = " +
                event.toString() + ex);
    }

    @Override
    public void handleOnStartException(Throwable ex) {
        log.error("disruptorName= " + disruptorName + " Exception during onStart(): ", ex);
    }

    @Override
    public void handleOnShutdownException(Throwable ex) {
        log.error("disruptorName = " + disruptorName + " Exception during onShutdown(): ", ex);
    }
}
