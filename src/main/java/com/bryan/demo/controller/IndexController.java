package com.bryan.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class IndexController {

    private static Log logger = LogFactory.getLog(IndexController.class);

    @RequestMapping("/index")
    public String index(Map<String, Object> map) {

        map.put("location", "星巴克(新荟城购物中心店) ");
        map.put("time", "一个周末的下午");

        map.put("timestamp", new Date().getTime());

        //自动寻找resources/templates中名字为index.ftl 文件作为模板，拼装后返回
        return "index";
    }


    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> map) {

        map.put("text", "一段文字");
        return "welcome";
    }

    @RequestMapping("/react")
    public String react(Map<String, Object> map) {
        return "react";
    }

}
