package com.bryan.demo.service;

import com.bryan.demo.common.util.Result;
import com.bryan.demo.service.model.VisitBO;

import java.util.List;

public interface VisitService {

    // 增
    Result<VisitBO> add(String ip);

    // 删
    Result<Boolean> delById(Long id);

    // 改
    Result<VisitBO> update(String jsonString);

    // 查
    Result<VisitBO> getById(Long id);

    // 查全部
    Result<List<VisitBO>> queryAll();

}
