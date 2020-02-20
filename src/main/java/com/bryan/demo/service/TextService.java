package com.bryan.demo.service;

import com.bryan.demo.common.query.UserQuery;
import com.bryan.demo.common.util.Page;
import com.bryan.demo.common.util.Result;
import com.bryan.demo.service.model.TextBO;
import com.bryan.demo.service.model.UserBO;

import java.util.List;

public interface TextService {

    // 替换
    Result<TextBO> replace(String jsonString);

}
