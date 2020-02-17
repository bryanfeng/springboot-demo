package com.bryan.demo.service;

import com.bryan.demo.common.util.Result;
import com.bryan.demo.service.model.TextBO;
import com.bryan.demo.service.model.UploadFileResponseBO;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    // 上传文件
    UploadFileResponseBO uploadFile(MultipartFile file);

    // 上传文件
    UploadFileResponseBO uploadFile(MultipartFile file, String destFilename);

}
