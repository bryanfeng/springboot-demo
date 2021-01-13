package com.bryan.demo.service.helper;

import com.alibaba.fastjson.JSONObject;
import com.bryan.demo.dal.entity.VisitDO;
import com.bryan.demo.service.model.VisitBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class VisitHelper {

    private static Logger logger = LoggerFactory.getLogger(VisitHelper.class);

    // json字符串转为bo对象
    public static VisitBO json2bo(String jsonString) {
        if (null == jsonString) {
            return null;
        }
        VisitBO boModel = new VisitBO();

        try {
            JSONObject jsonObject = JSONObject.parseObject(jsonString);
            if (jsonObject.containsKey("id")){
                boModel.setId(jsonObject.getLong("id"));
            }
            if (jsonObject.containsKey("ip")){
                boModel.setIp(jsonObject.getString("ip"));
            }
            if (jsonObject.containsKey("loginTime")){
                boModel.setLoginTime(jsonObject.getString("loginTime"));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return boModel;
    }

    // 数据库do对象转为业务对象bo
    public static VisitBO do2bo(VisitDO doModel) {
        if (null == doModel) {
            return null;
        }
        VisitBO boModel = new VisitBO();

        try {
            boModel.setId(doModel.getId());
            boModel.setIp(doModel.getIp());
            boModel.setLoginTime(doModel.getLoginTime());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return boModel;
    }

    // 业务对象bo转为数据库do对象
    public static VisitDO bo2do(VisitBO boModel) {
        if (null == boModel) {
            return null;
        }
        VisitDO doModel = new VisitDO();

        try {
            doModel.setId(boModel.getId());
            doModel.setIp(boModel.getIp());
            doModel.setLoginTime(boModel.getLoginTime());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return doModel;
    }

    public static List<VisitDO> bos2dos(List<VisitBO> boModels){
        List<VisitDO> doModels = new ArrayList<VisitDO>();
        if (null == boModels || boModels.isEmpty()) {
            return doModels;
        }
        for (VisitBO boModel : boModels) {
            VisitDO doModel = bo2do(boModel);
            doModels.add(doModel);
        }
        return doModels;
    }

    public static List<VisitBO> dos2bos(List<VisitDO> doModels){
        List<VisitBO> boModels = new ArrayList<VisitBO>();
        if (null == doModels || doModels.isEmpty()) {
            return boModels;
        }
        for (VisitDO doModel : doModels) {
            VisitBO boModel = do2bo(doModel);
            boModels.add(boModel);
        }
        return boModels;
    }

}
