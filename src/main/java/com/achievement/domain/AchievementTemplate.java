package com.achievement.domain;

public class AchievementTemplate {
    private String achievementTemplateId;

    private String name;

    private String nameCode;

    private String context;

    private String contextCode;

    private String reward;

    private String scheduleDesc;

    private String achievementPackageId;

    private Long startTime;

    private Long endTime;

    private Long createTime;

    private Long opTime;

    private Integer lastVer;

    private Byte isValid;

    private String conditions;

    public String getAchievementTemplateId() {
        return achievementTemplateId;
    }

    public void setAchievementTemplateId(String achievementTemplateId) {
        this.achievementTemplateId = achievementTemplateId == null ? null : achievementTemplateId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNameCode() {
        return nameCode;
    }

    public void setNameCode(String nameCode) {
        this.nameCode = nameCode == null ? null : nameCode.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getContextCode() {
        return contextCode;
    }

    public void setContextCode(String contextCode) {
        this.contextCode = contextCode == null ? null : contextCode.trim();
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward == null ? null : reward.trim();
    }

    public String getScheduleDesc() {
        return scheduleDesc;
    }

    public void setScheduleDesc(String scheduleDesc) {
        this.scheduleDesc = scheduleDesc == null ? null : scheduleDesc.trim();
    }

    public String getAchievementPackageId() {
        return achievementPackageId;
    }

    public void setAchievementPackageId(String achievementPackageId) {
        this.achievementPackageId = achievementPackageId == null ? null : achievementPackageId.trim();
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
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

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions == null ? null : conditions.trim();
    }
}