/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.event;

import java.io.Serializable;
import java.util.List;

/**
 * CommonEvent
 *
 * @author caisl
 * @desc 公共事件（公共模块）
 * @since 2017-06-13
 */
public class CommonEvent extends AchievementEvent implements Serializable {

    public CommonEvent(){

    }

    public CommonEvent(String entityId, List<String> customerRegisterIds, int source, int type) {
        super(entityId, customerRegisterIds, source, type);
    }

}
