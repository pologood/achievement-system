/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.constant;

/**
 * AchievementEnum
 *
 * @author caisl
 * @since 2017-06-13
 */
public class AchievementEnum {

    /**
     * 成就事件类型枚举
     */
    public enum EventTypeEnum {
        ORDER_EVENT(1, "订单事件"),
        CONSUMER_EVENT(2, "消费事件"),
        ATTENTION_EVENT(3, "关注事件"),
        SHARE_EVENT(4, "分享事件"),
        RECEIVE_EVENT(5, "领取事件"),
        SPARK_EVENT(6, "火种事件");

        /**
         * 类型
         */
        private int type;
        /**
         * 名称
         */
        private String name;

        EventTypeEnum(int type, String name) {
            this.type = type;
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public String getName() {
            return name;
        }

    }

    /**
     * 订单事件动作枚举
     */
    public enum OrderActionEnum {
        SUBMIT(1, "提交订单"),
        EVALUATION(2, "评价订单");
        private int code;
        private String name;

        OrderActionEnum(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

    }

    /**
     * 消费事件消费品枚举
     */
    public enum ConsumerGoodsEnum {
        VIP(1, "充值VIP");
        private int code;
        private String name;

        ConsumerGoodsEnum(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

    }
}
