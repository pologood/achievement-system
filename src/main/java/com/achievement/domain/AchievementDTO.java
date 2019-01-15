
package com.achievement.domain;

import java.util.List;

/**
 * AchievementDTO
 *
 * @author caisl
 * @since 2017-06-13
 */
public class AchievementDTO {

    /**
     * 用户Id
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
     * 成就包Id
     */
    private String achievementPackageId;
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
     * 店铺Id
     */
    private String entityId;
    /**
     * 版本号
     */
    private int version;
    /**
     * 成就名
     */
    private String achievementName;
    /**
     * 成就内容
     */
    private String context;
    /**
     * 成就达成时间
     */
    private long finishTime;
    /**
     * 来源
     */
    private int source;
    /**
     * 成就图片地址
     */
    private String picUrl;

    public AchievementDTO(String entityId, String customerRegisterId, String achievementId, int source) {
        this.entityId = entityId;
        this.customerRegisterId = customerRegisterId;
        this.achievementId = achievementId;
        this.source = source;
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

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
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

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getAchievementPackageId() {
        return achievementPackageId;
    }

    public void setAchievementPackageId(String achievementPackageId) {
        this.achievementPackageId = achievementPackageId;
    }
}
