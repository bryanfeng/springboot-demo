package com.bryan.demo.service.Util;

import com.alibaba.fastjson.JSONObject;
import com.bryan.demo.common.util.Result;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpUtil {

    public static Result<JSONObject> get(String url){
        Result result = new Result();

        if (url == null || url.isEmpty()) {
            result.setMsg("传入url为空");
            return result;
        }

        String contents = null;
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            //httpGet.setHeader("cookie", "***");

            HttpResponse response = httpClient.execute(httpGet);
            contents = EntityUtils.toString(response.getEntity(),"gbk");//utf-8

        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("http请求异常：" + e.toString() +"|"+url);
            return result;
        }

        if (contents == null){
            result.setMsg("http请求为空：" + url);
            return result;
        }


        JSONObject jsonRsp = new JSONObject();
        jsonRsp = JSONObject.parseObject(contents);

        result.setSuccess(true);
        result.setData(jsonRsp);

        return result;
    }

}
