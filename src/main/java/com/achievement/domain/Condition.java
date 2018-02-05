/*
 * Copyright (C) 2009-2017 Hangzhou  Technology Co., Ltd.All rights reserved
 */
package com.achievement.domain;

import org.apache.commons.lang3.StringUtils;

/**
 * ScheduleVo
 *
 * @author caisl
 * @since 2017-06-14
 */
public class Condition {
    /**
     * 条件key
     */
    private String key;
    /**
     * 条件值
     */
    private String value;
    /**
     * 条件数量
     */
    private short count;
    /**
     * 条件描述
     */
    private String desc;
    /**
     * 描述对应国际化编码
     */
    private String code;
    /**
     * 进度数量统计
     */
    private short process;
    /**
     * 进度具体记录
     */
    private String processValue = StringUtils.EMPTY;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProcessValue() {
        return processValue;
    }

    public void setProcessValue(String processValue) {
        this.processValue = processValue;
    }

    public short getCount() {
        return count;
    }

    public void setCount(short count) {
        this.count = count;
    }

    public short getProcess() {
        return process;
    }

    public void setProcess(short process) {
        this.process = process;
    }
}
