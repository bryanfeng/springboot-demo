package com.bryan.demo.service.impl;

import com.bryan.demo.common.util.Result;
import com.bryan.demo.service.TextService;
import com.bryan.demo.service.helper.TextHelper;
import com.bryan.demo.service.model.TextBO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class TextServiceImpl implements TextService {

    private static Log logger = LogFactory.getLog(TextServiceImpl.class);

    @Override
    public Result<TextBO> replace(String jsonString) {

        Result<TextBO> result = new Result<TextBO>();
        if (null == jsonString || jsonString.isEmpty()) {
            result.setSuccess(false);
            result.setMsg("input param jsonString is null!");
            return result;
        }
        try {
            TextBO textBO = TextHelper.json2bo(jsonString);
            String target = textBO.getSource().replace(textBO.getReplaceSource(), textBO.getReplaceTarget());
            textBO.setTarget(target);

            result.setSuccess(true);
            result.setData(textBO);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error("replace action fail!param :" + jsonString , e);
            result.setMsg("替换失败！");
        }
        return result;
    }
}
