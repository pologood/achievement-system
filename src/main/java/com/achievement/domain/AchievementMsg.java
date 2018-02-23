/*
 * Copyright (C) 2009-2017 Hangzhou  Technology Co., Ltd.All rights reserved
 */
package com.achievement.domain;

import com.achievement.constant.AchievementConstant;

import java.io.Serializable;

/**
 * AchievementMsg
 *
 * @author caisl
 * @desc 成就完成弹窗（推送给APP H5）
 * @since 2017-06-17
 */
public class AchievementMsg implements Serializable {

    private static final long serialVersionUID = -4191247003704755294L;
    /**
     * 成就记录Id
     */
    private String achievementRecordId;
    /**
     * 成就Id
     */
    private String achievementId;
    /**
     * 成就名称
     */
    private String achievementName;
    /**
     * 成就描述
     */
    private String context;
    /**
     * 完成时间
     */
    private long finishTime;
    /**
     * 火种价值
     */
    private int fireSeedValue;
    /**
     * 成就图片地址
     */
    private String picUrl;
    /**
     * 状态 {@link AchievementConstant.RecordStatus}
     */
    private short status = AchievementConstant.RecordStatus.STATUS_NOT_START;
    /**
     * 来源 {@link AchievementConstant.EventSource}
     */
    private int source;

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(String achievementId) {
        this.achievementId = achievementId;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }

    public int getFireSeedValue() {
        return fireSeedValue;
    }

    public void setFireSeedValue(int fireSeedValue) {
        this.fireSeedValue = fireSeedValue;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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
}
