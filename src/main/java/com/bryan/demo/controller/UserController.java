package com.bryan.demo.controller;

import com.bryan.demo.common.query.UserQuery;
import com.bryan.demo.common.util.Page;
import com.bryan.demo.service.UserService;
import com.bryan.demo.common.util.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private static Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/getById")
    public Result getById(Long id) {

        Result result  = new Result();
        try {
            result = userService.getById(id);
        }
        catch (Exception e){
            result.setMsg(e.toString());
            result.setSuccess(false);
            logger.error("getById error: " + e.toString());
        }
        return result;
    }

    @RequestMapping("/add")
    public Result add(String jsonString) {
        Result result  = new Result();
        try {
            result =  userService.add(jsonString);
        }
        catch (Exception e){
            result.setMsg(e.toString());
            result.setSuccess(false);
            logger.error("getById error: " + e.toString());
        }
        return result;
    }

    @RequestMapping("/delById")
    public Result delById(Long id) {
        Result result  = new Result();
        try {
            result =  userService.delById(id);
        }
        catch (Exception e){
            result.setMsg(e.toString());
            result.setSuccess(false);
            logger.error("getById error: " + e.toString());
        }
        return result;
    }

    @RequestMapping("/update")
    public Result update(String jsonString) {
        Result result  = new Result();
        try {
            result =  userService.update(jsonString);
        }
        catch (Exception e){
            result.setMsg(e.toString());
            result.setSuccess(false);
            logger.error("getById error: " + e.toString());
        }
        return result;
    }

    @RequestMapping("/queryAll")
    public Result queryAll() {
        Result result  = new Result();
        try {
            result =  userService.queryAll();
        }
        catch (Exception e){
            result.setMsg(e.toString());
            result.setSuccess(false);
            logger.error("queryAll error: " + e.toString());
        }
        return result;
    }

    @RequestMapping("/getPageByQuery")
    public Result getPageByQuery(UserQuery userQuery) {
        Result result  = new Result();
        try {
            Page page =  userService.getPageByQuery(userQuery);
            if (page.getCount() != 0){
                result.setSuccess(true);
                result.setData(page);
            }
            else {
                result.setMsg("query res is null");
            }
        }
        catch (Exception e){
            result.setMsg(e.toString());
            result.setSuccess(false);
            logger.error("queryAll error: " + e.toString());
        }
        return result;
    }
}
