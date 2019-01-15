
package com.achievement.event;

import com.achievement.constant.AchievementEnum;

import java.io.Serializable;
import java.util.List;

/**
 * OrderEvent
 *
 * @author caisl
 * @desc 订单事件（订单模块）
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
     * 事件类型 1-评价订单 2-提交订单 {@link AchievementEnum.OrderActionEnum}
     */
    private int action;

    public OrderEvent(){

    }
    public OrderEvent(String entityId, List<String> customerRegisterIds, int source, int type) {
        super(entityId, customerRegisterIds, source, type);
    }

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
