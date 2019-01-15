
package com.achievement.dataobject;

import java.io.Serializable;

/**
 * AchievementTemplate
 *
 * @author caisl
 * @desc 成就配置表
 * @since 2017-06-13
 */
public class AchievementTemplate implements Serializable {
    private static final long serialVersionUID = -4881284715896213545L;
    /**
     * 成就Id
     */
    private String achievementTemplateId;
    /**
     * 成就名称
     */
    private String name;
    /**
     * 名称对应国际化编码
     */
    private String nameCode;
    /**
     * 成就内容
     */
    private String context;
    /**
     * 成就内容国际化编码
     */
    private String contextCode;
    /**
     * 成就完成奖励 json串
     */
    private String reward;
    /**
     * 成就图片 json串 status：url
     */
    private String picUrl;
    /**
     * 成就归属的成就包Id
     */
    private String achievementPackageId;
    /**
     * 开始时间
     */
    private Long startTime = 0L;
    /**
     * 结束时间
     */
    private Long endTime = 0L;
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
    /**
     * 达成条件 json串
     */
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}