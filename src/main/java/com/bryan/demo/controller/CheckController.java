package com.bryan.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.bryan.demo.common.util.Result;
import com.bryan.demo.service.CmdService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/check")
public class CheckController {

    private static Log logger = LogFactory.getLog(CheckController.class);

    @Autowired
    CmdService cmdService;


    @RequestMapping("/all")
    public Result all() {
        Result result = new Result();
        List<JSONObject> list = new ArrayList<>();

        // python Flask.py 进程是否在
        // flask接口 是否正常
        // springboot 接口是否正常
        JSONObject flaskProcess = new JSONObject();
        JSONObject flaskInterface = new JSONObject();
        JSONObject springInterface = new JSONObject();

        flaskProcess.put("flaskProcess", false);
        flaskInterface.put("flaskInterface", false);
        springInterface.put("springInterface", false);

        // 进程检查
        result =  cmdService.cmd("ps -ax");
        if (!result.isSuccess()){
            return result;
        }

        List<String> psList = (List<String>)result.getData();
        psList.forEach(ps->{
            if (ps.contains("python -u Flask.py")){
                flaskProcess.put("flaskProcess", true);
                flaskProcess.put("desc", "python进程在线");
            }
        });

        // python接口检查
        result =  cmdService.cmd("curl http://127.0.0.1:5000/");
        if (!result.isSuccess()){
            return result;
        }

        psList = (List<String>)result.getData();
        psList.forEach(ps->{
            if (ps.contains("hello_word")){
                flaskInterface.put("flaskInterface", true);
                flaskInterface.put("desc", "python接口测试通过");
            }
        });

        // java 接口检查
        result =  cmdService.cmd("curl http://127.0.0.1:8080/check/test");
        if (!result.isSuccess()){
            return result;
        }

        psList = (List<String>)result.getData();
        psList.forEach(ps->{
            if (ps.contains("BryanCheck")){
                springInterface.put("springInterface", true);
                springInterface.put("desc", "java接口测试通过");
            }
        });


        list.add(flaskProcess);
        list.add(flaskInterface);
        list.add(springInterface);
        result.setData(list);
        result.setSuccess(true);
        return result;
    }


    @RequestMapping("/test")
    public String test() {
        return "BryanCheck";
    }
}
