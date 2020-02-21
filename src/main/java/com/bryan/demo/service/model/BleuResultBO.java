package com.bryan.demo.service.model;

import java.io.Serializable;

public class BleuResultBO implements Serializable {


    private static final long serialVersionUID = -3509395367604555361L;

    private double p1;
    private double p2;
    private double p3;
    private double p4;
    private double bp;
    private double bleu;

    public double getP1() {
        return p1;
    }

    public void setP1(double p1) {
        this.p1 = p1;
    }

    public double getP2() {
        return p2;
    }

    public void setP2(double p2) {
        this.p2 = p2;
    }

    public double getP3() {
        return p3;
    }

    public void setP3(double p3) {
        this.p3 = p3;
    }

    public double getP4() {
        return p4;
    }

    public void setP4(double p4) {
        this.p4 = p4;
    }

    public double getBp() {
        return bp;
    }

    public void setBp(double bp) {
        this.bp = bp;
    }

    public double getBleu() {
        return bleu;
    }

    public void setBleu(double bleu) {
        this.bleu = bleu;
    }
}
