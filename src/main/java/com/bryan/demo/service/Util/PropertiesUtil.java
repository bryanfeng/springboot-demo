package com.bryan.demo.service.Util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Properties;

public class PropertiesUtil {

    private static Log logger = LogFactory.getLog(PropertiesUtil.class);

    private static PropertiesUtil instance;
    private Properties props;

    public static synchronized PropertiesUtil getInstance() {
        if (instance == null) {
            instance = new PropertiesUtil();
        }
        return instance;
    }

    private PropertiesUtil(){
        try {
            Resource resource = new ClassPathResource("application.properties");
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (Exception e) {
            logger.error("读取配置文件异常");
            e.printStackTrace();
        }
    }

    public String readPropertiesFile(String name){
        if (props != null) {
            return props.getProperty(name);
        }
        return "";
    }
}
