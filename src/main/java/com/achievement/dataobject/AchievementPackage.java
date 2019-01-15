
package com.achievement.dataobject;

import java.io.Serializable;

/**
 * AchievementPackage
 *
 * @author caisl
 * @desc 成就包表
 * @since 2017-06-13
 */
public class AchievementPackage implements Serializable {
    private static final long serialVersionUID = 4338356542993963011L;
    /**
     * 成就包Id
     */
    private String achievementPackageId;
    /**
     * 成就包名称
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
    private Short isValid = 1;
    /**
     * 国际化编码
     */
    private String nameCode;

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

    public String getNameCode() {
        return nameCode;
    }

    public void setNameCode(String nameCode) {
        this.nameCode = nameCode;
    }
}