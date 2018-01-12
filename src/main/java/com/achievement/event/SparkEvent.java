/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.event;

import java.io.Serializable;

/**
 * SparkEvent
 *
 * @author caisl
 * @desc 火种更新事件
 * @since 2017-07-03
 */
public class SparkEvent extends AchievementEvent implements Serializable {
    private static final long serialVersionUID = 2834056501809813962L;
    /**
     * 火种增加动作类型
     * {@see com.dfire.soa.member.em.EnumSparkAction}
     */
    private int action;
    /**
     * 金额（分）
     */
    private Integer money;
    /**
     * 火种值
     */
    private Integer changeValue;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 用户ID
     */
    private String customerRegisterId;
    /**
     * 备注
     */
    private String memo;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public Integer getChangeValue() {
        return changeValue;
    }

    public void setChangeValue(Integer changeValue) {
        this.changeValue = changeValue;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCustomerRegisterId() {
        return customerRegisterId;
    }

    public void setCustomerRegisterId(String customerRegisterId) {
        this.customerRegisterId = customerRegisterId;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
