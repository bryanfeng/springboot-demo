package com.bryan.demo.service.impl;

import com.bryan.demo.common.util.Result;
import com.bryan.demo.service.CmdService;
import com.bryan.demo.service.TextService;
import com.bryan.demo.service.helper.TextHelper;
import com.bryan.demo.service.model.TextBO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CmdServiceImpl implements CmdService {

    private static Log logger = LogFactory.getLog(CmdServiceImpl.class);

    @Override
    public Result<List<String>> cmd(String cmd) {
        Result result = new Result();

        Process process = null;
        List<String> processList = new ArrayList<String>();
        try {
            //process = Runtime.getRuntime().exec("ps -ax");
            //process = Runtime.getRuntime().exec("curl http://127.0.0.1:8080/info/ip");
            process = Runtime.getRuntime().exec(cmd);

            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = input.readLine()) != null) {
                processList.add(line);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();

            result.setMsg("CmdService exception:" + e.toString());
            return result;
        }

        result.setSuccess(true);
        result.setData(processList);
        return result;
    }
}
