package com.bryan.demo.dal.dao;

import com.bryan.demo.common.query.UserQuery;
import com.bryan.demo.dal.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {

    // 增
    public Integer add(UserDO id);

    // 删
    public Integer delById(Long id);

    // 改
    public Integer update(UserDO userDO);

    // 查
    public UserDO getById(Long id);

    // 查全部
    public List<UserDO> queryAll();

    // 分页条件查
    public List<UserDO> getPageByQuery(UserQuery userQuery);

    // 条件查数量
    public Integer getCountByQuery(UserQuery userQuery);
}
