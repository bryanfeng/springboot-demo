package com.bryan.demo.dal.dao;

import com.bryan.demo.dal.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public UserDO findById(Long id);
}
