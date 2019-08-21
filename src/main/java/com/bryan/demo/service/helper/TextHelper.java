package com.bryan.demo.service.helper;

import com.alibaba.fastjson.JSONObject;
import com.bryan.demo.dal.entity.UserDO;
import com.bryan.demo.service.model.TextBO;
import com.bryan.demo.service.model.UserBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TextHelper {

    private static Logger logger = LoggerFactory.getLogger(TextHelper.class);

    // json字符串转为bo对象
    public static TextBO json2bo(String jsonString) {
        if (null == jsonString) {
            return null;
        }
        TextBO boModel = new TextBO();

        try {
            JSONObject jsonObject = JSONObject.parseObject(jsonString);
            if (jsonObject.containsKey("source")){
                boModel.setSource(jsonObject.getString("source"));
            }
            if (jsonObject.containsKey("replaceSource")){
                boModel.setReplaceSource(jsonObject.getString("replaceSource"));
            }
            if (jsonObject.containsKey("replaceTarget")){
                boModel.setReplaceTarget(jsonObject.getString("replaceTarget"));
            }
            if (jsonObject.containsKey("target")){
                boModel.setTarget(jsonObject.getString("target"));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return boModel;
    }


}
