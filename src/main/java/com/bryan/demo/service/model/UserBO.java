package com.bryan.demo.service.model;

import java.io.Serializable;

public class UserBO implements Serializable {

    private static final long serialVersionUID = 8990267856400042482L;

    private Long id;
    private String nick;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
