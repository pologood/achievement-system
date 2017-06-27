/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.achievement.domain;

import java.util.List;

/**
 * AchievementDTO
 *
 * @author shinan
 * @since 2017-06-13
 */
public class AchievementDTO {

    /**
     * 小二Id
     */
    private String customerRegisterId;
    /**
     * 成就达成奖励
     */
    private AchievementReward reward;
    /**
     * 成就Id
     */
    private String achievementId;
    /**
     * 条件集合以及完成进度
     */
    private List<Condition> conditions;
    /**
     * 成就状态
     */
    private short status;
    /**
     * 成就记录Id
     */
    private String achievementRecordId;
    /**
     * 版本号
     */
    private int version;

    public AchievementDTO(String customerRegisterId) {
        this.customerRegisterId = customerRegisterId;
    }


    public String getCustomerRegisterId() {
        return customerRegisterId;
    }

    public void setCustomerRegisterId(String customerRegisterId) {
        this.customerRegisterId = customerRegisterId;
    }

    public AchievementReward getReward() {
        return reward;
    }

    public void setReward(AchievementReward reward) {
        this.reward = reward;
    }

    public String getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(String achievementId) {
        this.achievementId = achievementId;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getAchievementRecordId() {
        return achievementRecordId;
    }

    public void setAchievementRecordId(String achievementRecordId) {
        this.achievementRecordId = achievementRecordId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
