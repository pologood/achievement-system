
package com.achievement.domain;

import java.io.Serializable;
import java.util.List;

/**
 * AchievementEventMessage
 *
 * @author caisl
 * @since 2017-06-21
 */
public class AchievementEventMessage implements Serializable {

    /**
     * 店铺Id
     */
    private String entityId;
    /**
     * 用户Id集合 完成事件的人
     */
    private List<String> customerRegisterIds;
    /**
     * 事件来源 1-APP 2-H5
     *
     * @link com.achievement.constant.AchievementConstant.EventSource
     */
    private int source;
    /**
     * 事件类型 see com.achievement.constant.AchievementEnum
     */
    private int type;
    /**
     * 订单类型 com.achievement.constant.AchievementConstant.OrderType
     */
    private String orderType;
    /**
     * 动作 com.achievement.constant.AchievementEnum.OrderActionEnum
     */
    private int action;
    /**
     * 优惠数量
     */
    private int offerCount;

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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getOfferCount() {
        return offerCount;
    }

    public void setOfferCount(int offerCount) {
        this.offerCount = offerCount;
    }
}
