package com.bryan.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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

    @RequestMapping("/pm")
    public String pm(Map<String, Object> map) {
        return "pm";
    }

    @RequestMapping("/test")
    public String test(Map<String, Object> map) {

        Set<String> warningList = new TreeSet<>();
        warningList.add("内容");
        warningList.add("用户增长");
        warningList.add("内容");
        String test = warningList.toString();
        return "test";
    }


    // 本地ice环境的debug
    @RequestMapping("/debug")
    public String debug(Map<String, Object> map) {

        String cdnPath = "http://192.168.0.8:4444/build/";

        map.put("jsPath", cdnPath + "js/index.js");
        map.put("cssPath", cdnPath + "css/index.css");

        //自动寻找resources/templates中名字为index.ftl 文件作为模板，拼装后返回
        return "debug";
    }

}
