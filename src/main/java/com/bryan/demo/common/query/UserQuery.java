package com.bryan.demo.common.query;

import java.io.Serializable;
import com.bryan.demo.common.util.BaseQuery;

public class UserQuery extends BaseQuery implements Serializable{

    /**
     * 主键
     */
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
