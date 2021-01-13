package com.bryan.demo.service.impl;

import com.bryan.demo.common.util.Result;
import com.bryan.demo.dal.dao.VisitMapper;
import com.bryan.demo.dal.entity.VisitDO;
import com.bryan.demo.service.VisitService;
import com.bryan.demo.service.helper.VisitHelper;
import com.bryan.demo.service.model.VisitBO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    private static Log logger = LogFactory.getLog(VisitServiceImpl.class);

    @Autowired
    public VisitMapper visitMapper;

    @Override
    public Result<VisitBO> add(String ip) {
        Result<VisitBO> result = new Result<VisitBO>();
        if (null == ip || ip.isEmpty()) {
            result.setSuccess(false);
            result.setMsg("input param ip is null!");
            return result;
        }

        try {

            VisitDO visitDO = new VisitDO();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String loginTime = df.format(new Date());
            visitDO.setIp(ip);
            visitDO.setLoginTime(loginTime);
            int id = visitMapper.add(visitDO);

            VisitBO visitBO = new VisitBO();
            if (id != 1) {
                result.setSuccess(false);
                result.setMsg("添加失败");
                logger.error("add error : id " + id);
            } else {
                // 插入完成后，do对象的id会被赋值
                visitBO.setId(visitDO.getId());
                result.setSuccess(true);
                result.setData(visitBO);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error("add action fail!param :" + e);
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
            int cnt = visitMapper.delById(id);
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
    public Result<VisitBO> update(String jsonString) {
        Result<VisitBO> result = new Result<VisitBO>();
        if (null == jsonString || jsonString.isEmpty()) {
            result.setSuccess(false);
            result.setMsg("update param jsonString is null!");
            return result;
        }
        try {
            VisitBO visitBO = VisitHelper.json2bo(jsonString);
            VisitDO visitDO = VisitHelper.bo2do(visitBO);
            int cnt = visitMapper.update(visitDO);
            if (cnt != 1) {
                result.setSuccess(false);
                result.setMsg("更新失败");
                logger.error("update error : jsonString " + jsonString);
            } else {
                visitDO = visitMapper.getById(visitDO.getId());
                visitBO = VisitHelper.do2bo(visitDO);
                result.setSuccess(true);
                result.setData(visitBO);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error("update action fail!param :" + jsonString , e);
            result.setMsg("更新失败！");
        }
        return result;
    }

    @Override
    public Result<VisitBO> getById(Long id) {

        Result<VisitBO> result = new Result<VisitBO>();
        if (null == id || id <= 0) {
            result.setSuccess(false);
            result.setMsg("input param id is null or less than 0, not allowed!");
            return result;
        }
        try {
            VisitDO visitDO = visitMapper.getById(id);
            if (visitDO == null) {
                result.setSuccess(false);
                result.setMsg("数据库中读取为空");
                logger.error("findById,id: not exist. id: " + id);
            } else {
                VisitBO visitBO = VisitHelper.do2bo(visitDO);
                result.setSuccess(true);
                result.setData(visitBO);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error("findById action fail!id :" + id + ",msg:" + e.getMessage(), e);
            result.setMsg("查询失败！");
        }
        return result;
    }

    @Override
    public Result<List<VisitBO>> queryAll() {
        Result<List<VisitBO>> result = new Result<List<VisitBO>>();
        try {
            List<VisitDO> visitDO = visitMapper.queryAll();
            if (visitDO == null) {
                result.setSuccess(false);
                result.setMsg("数据库中读取为空");
                logger.error("queryAll is null");
            } else {
                List<VisitBO> visitBOs = VisitHelper.dos2bos(visitDO);
                result.setSuccess(true);
                result.setData(visitBOs);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error("queryAll action fail!");
            result.setMsg("查询失败！");
        }
        return result;
    }

}
