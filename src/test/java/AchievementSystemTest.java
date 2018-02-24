/*
 * Copyright (C) 2009-2017 Hangzhou  Technology Co., Ltd.All rights reserved
 */

import com.achievement.constant.AchievementConstant;
import com.achievement.constant.AchievementEnum;
import com.achievement.event.OrderEvent;
import com.achievement.publisher.IEventClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * AchievementSystemTest
 *
 * @author caisl
 * @since 2018-01-18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AchievementSystemTest {
    public static List<String> customerRegisterIds = new ArrayList<>();

    static {
        customerRegisterIds.add("a87337792a9e45dc82e970215d7229b9");
    }

    public String entityId = "99926498";
    @Resource
    IEventClient eventClient;

    @Test
    public void finishWelcomeAchievementTest() throws Exception {
        OrderEvent orderEvent = new OrderEvent(entityId, customerRegisterIds, AchievementConstant.EventSource
                .FROM_H5, AchievementEnum.EventTypeEnum.ORDER_EVENT.getType());
        orderEvent.setAction(AchievementEnum.OrderActionEnum.SUBMIT.getCode());
        orderEvent.setOrderType(AchievementConstant.OrderType.ORDER_SHOP);
        eventClient.publish(orderEvent);
        Thread.sleep(5000);
    }
}
