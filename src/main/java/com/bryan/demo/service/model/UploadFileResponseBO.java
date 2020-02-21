package com.bryan.demo.service.model;

import java.io.Serializable;

public class UploadFileResponseBO implements Serializable {

    private static final long serialVersionUID = 3635773296348275729L;

    // 文件名
    String name;

    // 0 为正常 必须
    String code;

    // 大小（字节，非必须）
    Long size;

    // 服务端响应内容
    String message;

    /*
    url 三合一，ice都需要
    */
    String url;
    String imgURL;
    String downloadURL;

    /*
     返回格式 （jpg/txt）(自己加的 )
     */
    String fileType;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }



    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }



    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

