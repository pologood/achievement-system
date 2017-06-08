/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */

import com.caisl.publisher.EventClient;
import com.caisl.event.OrderEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * UserSignTest
 *
 * @author shinan
 * @since 2017-06-01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserSignTest {
    @Resource
    EventClient eventClient;


    @Test
    public void OrderEventPublishTest(){
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setEntityId("99926498");
        eventClient.publish(orderEvent);
    }
}
