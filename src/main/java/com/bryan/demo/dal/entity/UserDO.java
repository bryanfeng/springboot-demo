package com.bryan.demo.dal.entity;

import java.io.Serializable;

public class UserDO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    private String nick;
    private int age;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
