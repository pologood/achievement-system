/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.constant;

/**
 * AchievementEnum
 *
 * @author shinan
 * @since 2017-06-13
 */
public class AchievementEnum {

    public enum EventTypeEnum {
        ORDER_EVENT(1, "订单事件"),
        CONSUMER_EVENT(2, "消费事件"),
        ATTENTION_EVENT(3, "关注事件"),
        SHARE_EVENT(4, "分享事件"),
        REVEIVE_EVENT(5, "领取事件");

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

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public enum OrderActionEnum {
        SUBIMT(1, "提交订单"),
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

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
