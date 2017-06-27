/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.event;

import java.io.Serializable;

/**
 * OrderEvent
 *
 * @author shinan
 * @since 2017-06-05
 */
public class OrderEvent extends AchievementEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 订单类型（堂食 外卖）
     */
    private String orderType;
    /**
     * 订单金额（分）
     */
    private double orderFee;
    /**
     * 订单Id
     */
    private String orderId;
    /**
     * 事件类型 1-评价订单 2-提交订单
     */
    private int action;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public double getOrderFee() {
        return orderFee;
    }

    public void setOrderFee(double orderFee) {
        this.orderFee = orderFee;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
}
