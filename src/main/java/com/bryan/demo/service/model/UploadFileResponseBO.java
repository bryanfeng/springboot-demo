package com.bryan.demo.service.model;

import java.io.Serializable;

public class UploadFileResponseBO implements Serializable {


    private static final long serialVersionUID = 3635773296348275729L;


    /*
     是否上传成功
     */
    Boolean success;

    /*
     success=false 时候可以展示错误
     */
    String message;

    /*
     返回格式 （jpg/txt）
     */
    String fileType;

    /*
     返回文件名
     */
    String fileName;

    /*
    图片url
    */
    String imgURL;

    /*
     下载url
     */
    String downloadURL;


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
