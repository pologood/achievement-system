
package com.achievement.constant;

/**
 * AchievementConstant
 *
 * @author caisl
 * @since 2017-06-13
 */
public class AchievementConstant {

    public interface OrderType {
        String ORDER_SHOP = "1";//堂食订单
        String ORDER_TAKEOUT = "2";//外卖订单
    }

    public interface RecordStatus {
        short STATUS_ALL = -1;//所有状态
        short STATUS_NOT_START = 0;//未开始
        short STATUS_PROCESSING = 1;//进行中
        short STATUS_COMPLETED = 2;//已完成
        short STATUS_EXPIRE = 3;//已过期
    }

    public interface EventSource {
        int FROM_APP = 1;//APP
        int FROM_H5 = 2;//H5
    }

    public interface GoodsType {
        int VIP_RECHARGE = 1;//VIP充值
    }

    public interface VIPConstant {
        int VIPRate = 3;
    }
}

