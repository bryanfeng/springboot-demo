package com.bryan.demo.service.impl;

import com.bryan.demo.common.query.UserQuery;
import com.bryan.demo.common.util.Page;
import com.bryan.demo.dal.dao.UserMapper;
import com.bryan.demo.dal.entity.UserDO;
import com.bryan.demo.service.UserService;
import com.bryan.demo.service.helper.UserHelper;
import com.bryan.demo.service.model.UserBO;
import com.bryan.demo.common.util.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static Log logger = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    public UserMapper userMapper;

    @Override
    public Result<UserBO> add(String jsonString) {
        Result<UserBO> result = new Result<UserBO>();
        if (null == jsonString || jsonString.isEmpty()) {
            result.setSuccess(false);
            result.setMsg("input param jsonString is null!");
            return result;
        }
        try {
            UserBO userBO = UserHelper.json2bo(jsonString);
            UserDO userDO = UserHelper.bo2do(userBO);
            int id = userMapper.add(userDO);
            if (id != 1) {
                result.setSuccess(false);
                result.setMsg("添加失败");
                logger.error("add error : id " + id);
            } else {
                // 插入完成后，do对象的id会被赋值
                userBO.setId(userDO.getId());
                result.setSuccess(true);
                result.setData(userBO);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error("add action fail!param :" + jsonString , e);
            result.setMsg("添加失败！");
        }
        return result;
    }

    @Override
    public Result<Boolean> delById(Long id) {
        Result<Boolean> result = new Result<Boolean>();
        if (null == id || id <= 0) {
            result.setSuccess(false);
            result.setMsg("del param id is null or less than 0, not allowed!");
            return result;
        }
        try {
            int cnt = userMapper.delById(id);
            if (cnt != 1) {
                result.setSuccess(false);
                result.setMsg("mapper删除失败");
                logger.error("delById error. id: " + id);
            } else {
                result.setSuccess(true);
                result.setData(true);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error("del action fail!id :" + id + ",msg:" + e.getMessage(), e);
            result.setMsg("删除失败！");
        }
        return result;
    }

    @Override
    public Result<UserBO> update(String jsonString) {
        Result<UserBO> result = new Result<UserBO>();
        if (null == jsonString || jsonString.isEmpty()) {
            result.setSuccess(false);
            result.setMsg("update param jsonString is null!");
            return result;
        }
        try {
            UserBO userBO = UserHelper.json2bo(jsonString);
            UserDO userDO = UserHelper.bo2do(userBO);
            int cnt = userMapper.update(userDO);
            if (cnt != 1) {
                result.setSuccess(false);
                result.setMsg("更新失败");
                logger.error("update error : jsonString " + jsonString);
            } else {
                userDO = userMapper.getById(userDO.getId());
                userBO = UserHelper.do2bo(userDO);
                result.setSuccess(true);
                result.setData(userBO);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error("update action fail!param :" + jsonString , e);
            result.setMsg("更新失败！");
        }
        return result;
    }

    @Override
    public Result<UserBO> getById(Long id) {

        Result<UserBO> result = new Result<UserBO>();
        if (null == id || id <= 0) {
            result.setSuccess(false);
            result.setMsg("input param id is null or less than 0, not allowed!");
            return result;
        }
        try {
            UserDO userDO = userMapper.getById(id);
            if (userDO == null) {
                result.setSuccess(false);
                result.setMsg("数据库中读取为空");
                logger.error("findById,id: not exist. id: " + id);
            } else {
                UserBO userBO = UserHelper.do2bo(userDO);
                result.setSuccess(true);
                result.setData(userBO);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error("findById action fail!id :" + id + ",msg:" + e.getMessage(), e);
            result.setMsg("查询失败！");
        }
        return result;
    }

    @Override
    public Result<List<UserBO>> queryAll() {
        Result<List<UserBO>> result = new Result<List<UserBO>>();
        try {
            List<UserDO> userDO = userMapper.queryAll();
            if (userDO == null) {
                result.setSuccess(false);
                result.setMsg("数据库中读取为空");
                logger.error("queryAll is null");
            } else {
                List<UserBO> userBOs = UserHelper.dos2bos(userDO);
                result.setSuccess(true);
                result.setData(userBOs);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error("queryAll action fail!");
            result.setMsg("查询失败！");
        }
        return result;
    }

    @Override
    public Page<UserBO> getPageByQuery(UserQuery userQuery) {
        Page<UserBO> result = new Page<UserBO>();
        try {

            int cnt = countByQuery(userQuery);
            result.setPageNum(userQuery.getPageNum());
            result.setPageSize(userQuery.getPageSize());
            result.setCount(cnt);

            if (cnt > 0){
                List<UserDO> userDOs = userMapper.getPageByQuery(userQuery);
                List<UserBO> userBOs = UserHelper.dos2bos(userDOs);
                result.setItems(userBOs);
            }

        } catch (Exception e) {
            result.setCount(0);
            logger.error("getPageByQuery exception: " + e.getMessage());
        }
        return result;
    }

    // 获取数量
    public Integer countByQuery(UserQuery query) {
        Integer count = 0;
        if (null == query) {
            return count;
        }
        try {
            count = userMapper.getCountByQuery(query);
        } catch (Exception e) {
            logger.error("count by query:{} exception:{}" + e.getMessage());
        }
        return count;
    }
}
