package com.lemon.union.finance.dto;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-5
 * Time: 下午9:50
 * To change this template use File | Settings | File Templates.
 */
public class BillDTO {

    private Date billdate;
    private float totalincome;
    private int feecount;
    private float feeincome;
    private int showcount;
    private float showincome;
    private float ownerincome;

    public int getShowcount() {
        return showcount;
    }

    public void setShowcount(int showcount) {
        this.showcount = showcount;
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }

    public int getFeecount() {
        return feecount;
    }

    public void setFeecount(int feecount) {
        this.feecount = feecount;
    }

    public float getFeeincome() {
        return feeincome;
    }

    public void setFeeincome(float feeincome) {
        this.feeincome = feeincome;
    }

    public float getOwnerincome() {
        return ownerincome;
    }

    public void setOwnerincome(float ownerincome) {
        this.ownerincome = ownerincome;
    }

    public float getShowincome() {
        return showincome;
    }

    public void setShowincome(float showincome) {
        this.showincome = showincome;
    }

    public float getTotalincome() {
        return totalincome;
    }

    public void setTotalincome(float totalincome) {
        this.totalincome = totalincome;
    }
}
