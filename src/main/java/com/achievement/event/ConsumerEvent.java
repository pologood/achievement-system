/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.event;

import java.io.Serializable;

/**
 * ConsumerEvent
 *
 * @author shinan
 * @since 2017-06-13
 */
public class ConsumerEvent extends AchievementEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 支付类型
     */
    private String payType;
    /**
     * 消费去向 1-充值火会员 2-
     */
    private int goods;
    /**
     * 消费金额
     */
    private double fee;
    /**
     * 优惠类型 （使用哪种优惠）
     */
    private String offerType;

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public int getGoods() {
        return goods;
    }

    public void setGoods(int goods) {
        this.goods = goods;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }
}
