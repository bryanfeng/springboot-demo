package com.bryan.demo.service;

import com.bryan.demo.dal.entity.UserDO;

public interface UserService {
    UserDO findById(Long id);
}
