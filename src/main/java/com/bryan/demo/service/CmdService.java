package com.bryan.demo.service;

import com.bryan.demo.common.util.Result;
import com.bryan.demo.service.model.TextBO;

import java.util.List;

public interface CmdService {

    // 运行命令行得到结果
    Result<List<String>> cmd(String cmd);

}
