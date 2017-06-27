/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.event;

import java.io.Serializable;
import java.util.List;

/**
 * AchievementEvent
 *
 * @author shinan
 * @since 2017-06-05
 */
public abstract class AchievementEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 店铺Id
     */
    private String entityId;
    /**
     * 小二Id集合 完成事件的人
     */
    private List<String> customerRegisterIds;
    /**
     * 事件来源 1-APP 2-H5
     */
    private int source;
    /**
     * 事件类型 see{@link com.dfire.soa.consumer.fm.constant.AchievementEnum}
     */
    private int type;
    /**
     * 成就Id （封装每个handler里面对应的成就Id）
     */
    private String achievementId;
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

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(String achievementId) {
        this.achievementId = achievementId;
    }
}
