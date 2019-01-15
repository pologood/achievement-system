
package com.achievement.event;

import java.io.Serializable;
import java.util.List;

/**
 * ConsumerEvent
 *
 * @author caisl
 * @desc 消费事件（消费支付模块）
 * @since 2017-06-13
 */
public class ConsumerEvent extends AchievementEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 支付类型
     */
    private String payType;
    /**
     * 消费去向 1-充值火会员
     */
    private int goods;
    /**
     * 消费金额
     */
    private double fee;
    /**
     * 优惠数量 用了几中优惠
     */
    private int offerCount;

    public ConsumerEvent(){

    }
    public ConsumerEvent(String entityId, List<String> customerRegisterIds, int source, int type) {
        super(entityId, customerRegisterIds, source, type);
    }

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

    public int getOfferCount() {
        return offerCount;
    }

    public void setOfferCount(int offerCount) {
        this.offerCount = offerCount;
    }
}
