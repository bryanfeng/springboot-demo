package com.bryan.demo.dal.dao;

import com.bryan.demo.dal.entity.VisitDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VisitMapper {

    // 增
    public Integer add(VisitDO visitDO);

    // 删
    public Integer delById(Long id);

    // 改
    public Integer update(VisitDO visitDO);

    // 查
    public VisitDO getById(Long id);

    // 查全部
    public List<VisitDO> queryAll();


}
