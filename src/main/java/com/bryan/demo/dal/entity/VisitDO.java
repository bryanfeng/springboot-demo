package com.bryan.demo.dal.entity;

public class VisitDO {

    /**
     * 主键
     */
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
