package com.bryan.demo.controller;

import com.bryan.demo.common.util.Result;
import com.bryan.demo.service.UploadService;
import com.bryan.demo.service.model.UploadFileResponseBO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@RestController
@RequestMapping("/bleu")
public class BleuController {

    private static Log logger = LogFactory.getLog(BleuController.class);


    @Autowired
    UploadService uploadService;


    @RequestMapping("/sourceUpload")
    public UploadFileResponseBO sourceUpload(@RequestParam("file") MultipartFile file) {

        return uploadService.uploadFile(file, "sourceFile.txt");
    }

    @RequestMapping("/refUpload")
    public UploadFileResponseBO refUpload(@RequestParam("file") MultipartFile file) {

        return uploadService.uploadFile(file, "refFile.txt");
    }

    @RequestMapping("/calc")
    public Result calcBleu() {
        Result result = new Result();
        result.setSuccess(true);
        return result;
    }



}
