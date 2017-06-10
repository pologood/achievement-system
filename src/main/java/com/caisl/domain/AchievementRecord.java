package com.caisl.domain;

public class AchievementRecord {
    /**
     * 记录Id
     */
    private String achievementRecordId;
    /**
     * 小二Id
     */
    private String customerRegisterId;
    /**
     * 成就Id
     */
    private String achievementTemplateId;
    /**
     * 奖励火种数
     */
    private Integer fireSeed;
    /**
     * 完成时间
     */
    private Long finishTime;
    /**
     * 成就状态 0-未开始 1-进行中 2-已完成 3-进行中已过期 4-未完成已过期
     */
    private Short status;
    /**
     * 进度 json串
     */
    private String schedule;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 操作时间
     */
    private Long opTime;
    /**
     * 版本号
     */
    private Integer lastVer;
    /**
     * 是否有效 0-无效 1-有效
     */
    private Byte isValid;

    public String getAchievementRecordId() {
        return achievementRecordId;
    }

    public void setAchievementRecordId(String achievementRecordId) {
        this.achievementRecordId = achievementRecordId == null ? null : achievementRecordId.trim();
    }

    public String getCustomerRegisterId() {
        return customerRegisterId;
    }

    public void setCustomerRegisterId(String customerRegisterId) {
        this.customerRegisterId = customerRegisterId == null ? null : customerRegisterId.trim();
    }

    public String getAchievementTemplateId() {
        return achievementTemplateId;
    }

    public void setAchievementTemplateId(String achievementTemplateId) {
        this.achievementTemplateId = achievementTemplateId == null ? null : achievementTemplateId.trim();
    }

    public Integer getFireSeed() {
        return fireSeed;
    }

    public void setFireSeed(Integer fireSeed) {
        this.fireSeed = fireSeed;
    }

    public Long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule == null ? null : schedule.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getOpTime() {
        return opTime;
    }

    public void setOpTime(Long opTime) {
        this.opTime = opTime;
    }

    public Integer getLastVer() {
        return lastVer;
    }

    public void setLastVer(Integer lastVer) {
        this.lastVer = lastVer;
    }

    public Byte getIsValid() {
        return isValid;
    }

    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    }
}