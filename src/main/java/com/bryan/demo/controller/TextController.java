package com.bryan.demo.controller;

import com.bryan.demo.common.query.UserQuery;
import com.bryan.demo.common.util.Page;
import com.bryan.demo.common.util.Result;
import com.bryan.demo.service.TextService;
import com.bryan.demo.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/text")
public class TextController {

    private static Log logger = LogFactory.getLog(TextController.class);

    @Autowired
    TextService textService;

    @RequestMapping("/replace")
    public Result getById(String jsonString) {

        Result result  = new Result();
        try {
            result = textService.replace(jsonString);
        }
        catch (Exception e){
            result.setMsg(e.toString());
            result.setSuccess(false);
            logger.error("getById error: " + e.toString());
        }
        return result;
    }


}
