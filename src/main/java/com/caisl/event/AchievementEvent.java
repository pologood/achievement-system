/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.caisl.event;

import java.util.List;

/**
 * AchievementEvent
 *
 * @author shinan
 * @since 2017-06-05
 */
public abstract class AchievementEvent {

    private String entityId;

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public List<String> getCustomerRegisterIds() {
        return customerRegisterIds;
    }

    public void setCustomerRegisterIds(List<String> customerRegisterIds) {
        this.customerRegisterIds = customerRegisterIds;
    }

    private List<String> customerRegisterIds;
}
