package com.bryan.demo.controller;

import com.bryan.demo.service.UploadService;
import com.bryan.demo.service.model.UploadFileResponseBO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

    private static Log logger = LogFactory.getLog(UploadController.class);

    @Autowired
    UploadService uploadService;


    @RequestMapping("/")
    public UploadFileResponseBO upload(@RequestParam("file") MultipartFile file) {

        return uploadService.uploadFile(file);
    }

}
