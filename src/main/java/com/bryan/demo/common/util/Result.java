package com.bryan.demo.common.util;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 6500777700479329953L;

    /*
     *  本次请求是否成功
     */
    private boolean success;

    /*
     *  请求返回结果
     */
    private T data;

    /*
     *  请求出错时候的信息
     */
    private String msg;

    /*
     *  请求结果code
     */
    private String resultCode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "Result: success=" + success + ", result=" + data + ", msg=" + msg + ", resultCode=" + resultCode;
    }
}
