package com.bryan.demo.service.helper;

import com.alibaba.fastjson.JSONObject;
import com.bryan.demo.dal.entity.UserDO;
import com.bryan.demo.service.model.UserBO;
import com.mysql.cj.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class UserHelper  {

    private static Logger logger = LoggerFactory.getLogger(UserHelper.class);

    // json字符串转为bo对象
    public static UserBO json2bo(String jsonString) {
        if (null == jsonString) {
            return null;
        }
        UserBO boModel = new UserBO();

        try {
            JSONObject jsonObject = JSONObject.parseObject(jsonString);
            if (jsonObject.containsKey("id")){
                boModel.setId(jsonObject.getLong("id"));
            }
            if (jsonObject.containsKey("nick")){
                boModel.setNick(jsonObject.getString("nick"));
            }
            if (jsonObject.containsKey("age")){
                boModel.setAge(jsonObject.getInteger("age"));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return boModel;
    }

    // 数据库do对象转为业务对象bo
    public static UserBO do2bo(UserDO doModel) {
        if (null == doModel) {
            return null;
        }
        UserBO boModel = new UserBO();

        try {
            boModel.setId(doModel.getId());
            boModel.setNick(doModel.getNick());
            boModel.setAge(doModel.getAge());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return boModel;
    }

    // 业务对象bo转为数据库do对象
    public static UserDO bo2do(UserBO boModel) {
        if (null == boModel) {
            return null;
        }
        UserDO doModel = new UserDO();

        try {
            doModel.setId(boModel.getId());
            doModel.setNick(boModel.getNick());
            doModel.setAge(boModel.getAge());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return doModel;
    }

    public static List<UserDO> bos2dos(List<UserBO> boModels){
        List<UserDO> doModels = new ArrayList<UserDO>();
        if (null == boModels || boModels.isEmpty()) {
            return doModels;
        }
        for (UserBO boModel : boModels) {
            UserDO doModel = bo2do(boModel);
            doModels.add(doModel);
        }
        return doModels;
    }

    public static List<UserBO> dos2bos(List<UserDO> doModels){
        List<UserBO> boModels = new ArrayList<UserBO>();
        if (null == doModels || doModels.isEmpty()) {
            return boModels;
        }
        for (UserDO doModel : doModels) {
            UserBO boModel = do2bo(doModel);
            boModels.add(boModel);
        }
        return boModels;
    }

}
