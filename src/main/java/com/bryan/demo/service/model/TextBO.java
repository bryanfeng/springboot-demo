package com.bryan.demo.service.model;

import java.io.Serializable;

public class TextBO implements Serializable {


    private static final long serialVersionUID = 4086145705016983876L;

    private String source;
    private String replaceSource;
    private String replaceTarget;
    private String target;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getReplaceSource() {
        return replaceSource;
    }

    public void setReplaceSource(String replaceSource) {
        this.replaceSource = replaceSource;
    }

    public String getReplaceTarget() {
        return replaceTarget;
    }

    public void setReplaceTarget(String replaceTarget) {
        this.replaceTarget = replaceTarget;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
