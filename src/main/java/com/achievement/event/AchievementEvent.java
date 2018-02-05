/*
 * Copyright (C) 2009-2017 Hangzhou  Technology Co., Ltd.All rights reserved
 */
package com.achievement.event;

import com.achievement.constant.AchievementConstant;
import com.achievement.constant.AchievementEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 * AchievementEvent
 *
 * @author caisl
 * @desc 成就事件基类
 * @since 2017-06-05
 */
public abstract class AchievementEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 店铺Id
     */
    private String entityId;
    /**
     * 用户Id集合 完成事件的人
     */
    private List<String> customerRegisterIds;
    /**
     * 事件来源 1-APP 2-H5 {@link AchievementConstant.EventSource}
     */
    private int source;
    /**
     * 事件类型 see{@link AchievementEnum}
     */
    private int type;
    /**
     * 成就Id （封装每个handler里面对应的成就Id）
     */
    private String achievementId;
    /**
     * 队列名
     */
    private String disruptorName;

    public AchievementEvent(){

    }
    public AchievementEvent(String entityId, List<String> customerRegisterIds, int source, int type) {
        this.entityId = entityId;
        this.customerRegisterIds = customerRegisterIds;
        this.source = source;
        this.type = type;
    }

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

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public String getDisruptorName() {
        return disruptorName;
    }

    public void setDisruptorName(String disruptorName) {
        this.disruptorName = disruptorName;
    }
}
