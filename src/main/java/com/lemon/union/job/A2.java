package com.lemon.union.job;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-18
 * Time: 下午6:15
 * To change this template use File | Settings | File Templates.
 */
public class A2 {
    private Date subdate;
    private long wid;
    private long pid;
    private int feecount;
    private float feeincome;
    private int showcount;
    private float showincome;
    private float totalincome;
    private Date now;

    public Date getSubdate() {
        return subdate;
    }

    public void setSubdate(Date subdate) {
        this.subdate = subdate;
    }

    public long getWid() {
        return wid;
    }

    public void setWid(long wid) {
        this.wid = wid;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
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

    public int getShowcount() {
        return showcount;
    }

    public void setShowcount(int showcount) {
        this.showcount = showcount;
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

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }
}