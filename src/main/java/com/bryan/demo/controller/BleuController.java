package com.bryan.demo.controller;

import com.bryan.demo.common.util.Result;
import com.bryan.demo.service.BleuService;
import com.bryan.demo.service.UploadService;
import com.bryan.demo.service.model.BleuResultBO;
import com.bryan.demo.service.model.UploadFileResponseBO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bleu")
public class BleuController {

    private static Log logger = LogFactory.getLog(BleuController.class);


    @Autowired
    UploadService uploadService;

    @Autowired
    BleuService bleuService;


    @RequestMapping("/sourceUpload")
    public UploadFileResponseBO sourceUpload(@RequestParam("file") MultipartFile file) {

        return uploadService.uploadFile(file, "sourceFile.txt");
    }

    @RequestMapping("/refUpload")
    public UploadFileResponseBO refUpload(@RequestParam("file") MultipartFile file) {

        return uploadService.uploadFile(file, "refFile.txt");
    }

    @RequestMapping("/calc")
    public Result<List<BleuResultBO>> calcBleu(String source, String ref) {
        Result result = bleuService.calc(source, ref);

        List<BleuResultBO> bos= new ArrayList<>();
        BleuResultBO bo = (BleuResultBO)result.getData();

        if (result.isSuccess()){
            bos.add(bo);
            result.setData(bos);
        }
        return result;
    }



}
