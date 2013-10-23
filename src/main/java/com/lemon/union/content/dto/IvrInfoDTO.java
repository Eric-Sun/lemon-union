package com.lemon.union.content.dto;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-2
 * Time: 下午4:06
 * To change this template use File | Settings | File Templates.
 */
public class IvrInfoDTO {
    private long id;
    private long wid;
    private long channel;
    private String servicecode;
    private String ivrnum;
    private String feenum;
    private String orderdest;
    private int status;
    private Date subtime;
    private int curCount;

    public int getCurCount() {
        return curCount;
    }

    public void setCurCount(int curCount) {
        this.curCount = curCount;
    }

    public long getChannel() {
        return channel;
    }

    public void setChannel(long channel) {
        this.channel = channel;
    }

    public String getFeenum() {
        return feenum;
    }

    public void setFeenum(String feenum) {
        this.feenum = feenum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIvrnum() {
        return ivrnum;
    }

    public void setIvrnum(String ivrnum) {
        this.ivrnum = ivrnum;
    }

    public String getOrderdest() {
        return orderdest;
    }

    public void setOrderdest(String orderdest) {
        this.orderdest = orderdest;
    }

    public String getServicecode() {
        return servicecode;
    }

    public void setServicecode(String servicecode) {
        this.servicecode = servicecode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getSubtime() {
        return subtime;
    }

    public void setSubtime(Date subtime) {
        this.subtime = subtime;
    }

    public long getWid() {
        return wid;
    }

    public void setWid(long wid) {
        this.wid = wid;
    }
}
