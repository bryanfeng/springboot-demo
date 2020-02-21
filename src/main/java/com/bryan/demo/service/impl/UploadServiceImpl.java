package com.bryan.demo.service.impl;

import com.bryan.demo.service.UploadService;
import com.bryan.demo.service.Util.PropertiesUtil;
import com.bryan.demo.service.Util.TimeUtil;
import com.bryan.demo.service.model.UploadFileResponseBO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class UploadServiceImpl implements UploadService {

    private static Log logger = LogFactory.getLog(UploadServiceImpl.class);

    // 上传文件路径 在配置文件中的key
    final String UPLOAD_FILE_PATH = "upload-file-path";


    @Override
    public UploadFileResponseBO uploadFile(MultipartFile file) {

        String fileName = file.getOriginalFilename() ;
        return uploadFile(file, fileName);
    }

    @Override
    public UploadFileResponseBO uploadFile(MultipartFile file, String destFilename) {
        UploadFileResponseBO responseBO = new UploadFileResponseBO();

        if (file == null || file.isEmpty()) {
            responseBO.setMessage("传入文件不可为空");
            return responseBO;
        }

        String fileName = TimeUtil.getTime() + "_" + destFilename;
        String filePath = PropertiesUtil.getInstance().readPropertiesFile(UPLOAD_FILE_PATH);
        File dest = new File(filePath + fileName);

        try {

            file.transferTo(dest);

            responseBO.setCode("0");
            String imageDownloadUrl = "http://39.105.173.45/cdn/" + fileName;
            //String imageDownloadUrl = "http://39.105.173.45/cdn/pic.JPG";
            responseBO.setImgURL(imageDownloadUrl);
            responseBO.setUrl(imageDownloadUrl);
            responseBO.setDownloadURL(imageDownloadUrl);
            if (destFilename.contains(".")) {
                responseBO.setFileType(destFilename.split("\\.")[1]);
            }
            responseBO.setName(fileName);
            responseBO.setSize(file.getSize());
            responseBO.setCode("0");
            responseBO.setMessage("上传成功");


        } catch (Exception e) {

            responseBO.setMessage(e.toString());
            logger.error("uploadFile exception: " + e.getMessage());
        }
        return responseBO;
    }
}
