package com.lemon.union.finance.dto;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-5
 * Time: 下午10:04
 * To change this template use File | Settings | File Templates.
 */
public class WebownerPeriodBillDTO {

    private long wid;
    private float totalincome;
    private int feecount;
    private float feeincome;
    private int showcount;
    private float showincome;

    public int getFeecount() {
        return feecount;
    }

    public void setFeecount(int feecount) {
        this.feecount = feecount;
    }

    public long getWid() {
        return wid;
    }

    public void setWid(long wid) {
        this.wid = wid;
    }

    public float getTotalincome() {
        return totalincome;
    }

    public void setTotalincome(float totalincome) {
        this.totalincome = totalincome;
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
}
