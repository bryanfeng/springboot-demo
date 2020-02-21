package com.bryan.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bryan.demo.common.util.Result;
import com.bryan.demo.service.BleuService;
import com.bryan.demo.service.TextService;
import com.bryan.demo.service.Util.HttpUtil;
import com.bryan.demo.service.Util.PropertiesUtil;
import com.bryan.demo.service.helper.TextHelper;
import com.bryan.demo.service.model.BleuResultBO;
import com.bryan.demo.service.model.TextBO;
import netscape.javascript.JSObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BleuServiceImpl implements BleuService {

    private static Log logger = LogFactory.getLog(BleuServiceImpl.class);

    @Override
    public Result<BleuResultBO> calc(String source, String ref) {
        Result<BleuResultBO> result = new Result<BleuResultBO>();
        if (null == source || ref == null) {
            result.setSuccess(false);
            result.setMsg("input param is null!");
            return result;
        }
        try {
            String filePath = PropertiesUtil.getInstance().readPropertiesFile("upload-file-path");
            String url = "http://127.0.0.1:5000/bleu?source="+filePath+source+"&ref="+filePath+ref;
            Result<JSONObject> res = HttpUtil.get(url);
            if (!res.isSuccess()){
                result.setMsg(res.getMsg());
                return result;
            }

            BleuResultBO bo = new BleuResultBO();
            JSONObject json = res.getData();
            if (json.containsKey("P1")){
                bo.setP1(json.getDouble("P1"));
                bo.setP2(json.getDouble("P2"));
                bo.setP3(json.getDouble("P3"));
                bo.setP4(json.getDouble("P4"));
            }
            if (json.containsKey("BP")){
                bo.setBp(json.getDouble("BP"));
            }
            if (json.containsKey("BLEU")){
                bo.setBleu(json.getDouble("BLEU"));
            }

            result.setSuccess(true);
            result.setData(bo);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsg(e.toString());
        }
        return result;
    }
}
