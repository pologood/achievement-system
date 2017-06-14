/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 *//*


import com.achievement.event.SignEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

*/
/**
 * EventTest
 *
 * @author shinan
 * @since 2017-05-08
 *//*

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class EventTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testPublishEvent(){
        applicationContext.publishEvent(new SignEvent("achievement"));
    }
}
*/
