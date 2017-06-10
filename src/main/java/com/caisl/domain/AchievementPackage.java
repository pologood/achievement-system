package com.caisl.domain;

public class AchievementPackage {

    /**
     * 成就包Id
     */
    private String achievementPackageId;
    /**
     * 包名
     */
    private String name;
    /**
     * 开始时间
     */
    private Long startTime;
    /**
     * 结束时间
     */
    private Long endTime;
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
    private Short isValid;

    public String getAchievementPackageId() {
        return achievementPackageId;
    }

    public void setAchievementPackageId(String achievementPackageId) {
        this.achievementPackageId = achievementPackageId == null ? null : achievementPackageId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Short getIsValid() {
        return isValid;
    }

    public void setIsValid(Short isValid) {
        this.isValid = isValid;
    }
}