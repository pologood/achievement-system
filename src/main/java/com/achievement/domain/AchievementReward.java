/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.domain;

/**
 * AchievementReward
 *
 * @author shinan
 * @since 2017-06-13
 */
public class AchievementReward {
    /**
     * 火种数
     */
    private int fireSeed;

    public AchievementReward(int fireSeed) {
        this.fireSeed = fireSeed;
    }

    public int getFireSeed() {
        return fireSeed;
    }

    public void setFireSeed(int fireSeed) {
        this.fireSeed = fireSeed;
    }
}
