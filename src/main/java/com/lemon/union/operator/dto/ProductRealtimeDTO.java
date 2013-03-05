package com.lemon.union.operator.dto;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-4
 * Time: 下午10:42
 * To change this template use File | Settings | File Templates.
 */
public class ProductRealtimeDTO {

    private long id;
    private long wid;
    private long channel;
    private String mobile;
    private String ordercode;
    private String orderdest;
    private float totalincome;
    private float feeincome;
    private int feeflag;
    private Date subtime;

    public long getChannel() {
        return channel;
    }

    public void setChannel(long channel) {
        this.channel = channel;
    }

    public int getFeeflag() {
        return feeflag;
    }

    public void setFeeflag(int feeflag) {
        this.feeflag = feeflag;
    }

    public float getFeeincome() {
        return feeincome;
    }

    public void setFeeincome(float feeincome) {
        this.feeincome = feeincome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getOrderdest() {
        return orderdest;
    }

    public void setOrderdest(String orderdest) {
        this.orderdest = orderdest;
    }

    public Date getSubtime() {
        return subtime;
    }

    public void setSubtime(Date subtime) {
        this.subtime = subtime;
    }

    public float getTotalincome() {
        return totalincome;
    }

    public void setTotalincome(float totalincome) {
        this.totalincome = totalincome;
    }

    public long getWid() {
        return wid;
    }

    public void setWid(long wid) {
        this.wid = wid;
    }
}
