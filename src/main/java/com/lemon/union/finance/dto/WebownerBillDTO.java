package com.lemon.union.finance.dto;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-5
 * Time: 下午10:15
 * To change this template use File | Settings | File Templates.
 */
public class WebownerBillDTO {
    private long id;
    private Date billdate;
    private long wid;
    private long pid;
    private float totalincome;
    private int feecount;
    private float feeincome;
    private int showcount;
    private float showincome;
    private int payflag ;
    private Date paytime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
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

    public float getTotalincome() {
        return totalincome;
    }

    public void setTotalincome(float totalincome) {
        this.totalincome = totalincome;
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

    public int getPayflag() {
        return payflag;
    }

    public void setPayflag(int payflag) {
        this.payflag = payflag;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }
}
