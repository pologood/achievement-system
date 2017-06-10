package com.caisl.domain;

public class SignRecord {
    /**
     * 签到记录Id
     */
    private String signRecordId;
    /**
     * 小二Id
     */
    private String customerRegisterId;
    /**
     * 签到日期
     */
    private Long signDate;
    /**
     * 累计签到次数
     */
    private Integer signTotalNumber;
    /**
     * 连续签到次数
     */
    private Short signContinueNumber;
    /**
     * 创建时间
     */
    private Long createTime;

    private Long updateTime;

    private Integer lastVer;

    private Byte isValid;

    public String getSignRecordId() {
        return signRecordId;
    }

    public void setSignRecordId(String signRecordId) {
        this.signRecordId = signRecordId == null ? null : signRecordId.trim();
    }

    public String getCustomerRegisterId() {
        return customerRegisterId;
    }

    public void setCustomerRegisterId(String customerRegisterId) {
        this.customerRegisterId = customerRegisterId == null ? null : customerRegisterId.trim();
    }

    public Long getSignDate() {
        return signDate;
    }

    public void setSignDate(Long signDate) {
        this.signDate = signDate;
    }

    public Integer getSignTotalNumber() {
        return signTotalNumber;
    }

    public void setSignTotalNumber(Integer signTotalNumber) {
        this.signTotalNumber = signTotalNumber;
    }

    public Short getSignContinueNumber() {
        return signContinueNumber;
    }

    public void setSignContinueNumber(Short signContinueNumber) {
        this.signContinueNumber = signContinueNumber;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
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