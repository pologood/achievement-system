
package com.achievement.publisher;


import com.achievement.event.AchievementEvent;

/**
 * IEventClient
 *
 * @author caisl
 * @since 2017-06-22
 */
public interface IEventClient {

    /**
     * 发布事件
     *
     * @param event
     * @return
     */
    Boolean publish(AchievementEvent event);
}
