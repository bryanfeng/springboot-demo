package com.bryan.demo.service;

import com.bryan.demo.common.query.UserQuery;
import com.bryan.demo.common.util.Page;
import com.bryan.demo.service.model.UserBO;
import com.bryan.demo.common.util.Result;

import java.util.List;

public interface UserService {

    // 增
    Result<UserBO> add(String jsonString);

    // 删
    Result<Boolean> delById(Long id);

    // 改
    Result<UserBO> update(String jsonString);

    // 查
    Result<UserBO> getById(Long id);

    // 查全部
    Result<List<UserBO>> queryAll();

    // 分页条件查询
    Page<UserBO> getPageByQuery(UserQuery userQuery);
}
