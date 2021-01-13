package com.bryan.demo.service.model;

import java.io.Serializable;

public class VisitBO implements Serializable {

    private static final long serialVersionUID = 8990267856400042482L;

    private Long id;

    private String loginTime;
    private String ip;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

   /*
    *
    CREATE TABLE `visit` (
        `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
        `login_time` varchar(128) NULL COMMENT '日期',
        `ip` varchar(128) NULL COMMENT 'IP',
        PRIMARY KEY (`id`)
    ) DEFAULT CHARACTER SET=utf8 COMMENT='访问的用户信息';
    * */
}
