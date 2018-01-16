/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.handler.common;

import com.achievement.constant.AchievementEnum;
import com.achievement.event.AchievementEvent;
import com.achievement.event.CommonEvent;
import com.achievement.handler.AbstractAchieveHandler;
import org.springframework.stereotype.Component;

/**
 * FiftyQuarterOneHandler
 *
 * @author caisl
 * @desc 五十四分之一
 * @since 2017-06-13
 */
@Component
public class FiftyQuarterOneHandler extends AbstractAchieveHandler {
    private static String achievementId = "c5a968a3372c474794ef670fe9ad7136";

    @Override
    protected boolean checkEvent(AchievementEvent event) {
        if (event instanceof CommonEvent) {
            CommonEvent commonEvent = (CommonEvent) event;
            if (commonEvent.getType() == AchievementEnum.EventTypeEnum.RECEIVE_EVENT.getType()) {
                event.setAchievementId(achievementId);
                return true;
            }
        }
        return false;
    }
}
