
package com.achievement.publisher;
import com.achievement.event.AchievementEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * EventClient
 *
 * @author caisl
 * @since 2017-06-05
 */
@Component
public class EventClient implements IEventClient, ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * 获得上下文
     *
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 发布事件
     *
     * @param event
     * @return
     */
    public Boolean publish(AchievementEvent event) {
        String eventName = StringUtils.uncapitalize(event.getClass().getSimpleName());
        IEventPublisher publisher = (IEventPublisher) applicationContext.getBean(eventName + "Publisher");
        if (publisher != null) {
            return publisher.publish(event);
        }
        return false;
    }
}
