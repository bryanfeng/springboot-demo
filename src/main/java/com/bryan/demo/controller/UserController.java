package com.bryan.demo.controller;

import com.bryan.demo.dal.entity.UserDO;
import com.bryan.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getMachineInfo")
    String getMachineInfo() {
        return "Hello World!";
    }

    @RequestMapping("/getInfo")
    String getInfo() {
        UserDO userDO = userService.findById(1L);
        return "name："+userDO.getNick() + " age："+userDO.getAge();
    }
}
