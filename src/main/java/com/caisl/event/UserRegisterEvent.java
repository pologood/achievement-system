/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.caisl.event;

/**
 * UserRegisterEvent
 *
 * @author shinan
 * @since 2017-05-10
 */
public class UserRegisterEvent {
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
