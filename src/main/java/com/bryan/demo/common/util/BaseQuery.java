package com.bryan.demo.common.util;

import java.io.Serializable;

public class BaseQuery implements Serializable {


    private static final long serialVersionUID = 7118202109778725819L;

    protected Integer pageSize = 10;
    protected Integer pageNum = 1;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /*
    * mybatis中<![CDATA[]]>中的size取自这里
    * */
    public Integer getSize() {
        return pageSize;
    }

    public Integer getStart() {
        if (null == pageNum || null == pageSize) {
            return null;
        } else {
            if (pageNum >= 1) {
                return (pageNum - 1) * pageSize;
            } else {
                return pageNum * pageSize;
            }
        }
    }
}
