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
	
	// 中文切词
    // http://127.0.0.1:8080/bleu/segment?source=abc%E4%BB%8A%E5%A4%A9%E5%A4%A9%E6%B0%94%E4%B8%8D%E9%94%99,%E6%88%91%E4%BB%AC%E4%B8%8B%E5%8D%88%E6%B2%A1%E6%9C%89class%E3%80%82%EF%BC%88%E8%BF%99%E6%98%AF%E7%AC%AC12%E5%A4%A9%EF%BC%89
    @RequestMapping("/segment")
    public Result<String> segmentWord(String source) {
        Result result = new Result();

        if (source == null || source.isEmpty()) {
            result.setMsg("参数传入为空");
            return result;
        }

        StringBuffer seg = new StringBuffer();

        /***
         * ^[\u2E80-\u9FFF]+$ 匹配所有东亚区的语言 ^[\u4E00-\u9FFF]+$ 匹配简体和繁体
         * ^[\u4E00-\u9FA5]+$ 匹配简体
         */
        String regExp = "^[\u4E00-\u9FFF]+$";

        int i = 0;
        for (i = 0; i < source.length()-1; i++) {
            String c = String.valueOf(source.charAt(i));
            String next = String.valueOf(source.charAt(i+1));

            seg.append(c);

            if (next.matches("[\u4E00-\u9FA5]+") || c.matches("[\u4E00-\u9FA5]+")){
                seg.append(" ");
            }
        }
        seg.append(source.charAt(i));

        result.setData(seg);
        result.setSuccess(true);

        return result;
    }




}
