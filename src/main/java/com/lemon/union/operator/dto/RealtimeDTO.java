package com.lemon.union.operator.dto;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 12-11-1
 * Time: 下午11:02
 * To change this template use File | Settings | File Templates.
 */
public class RealtimeDTO {
    private long wid;
    private long pid;
    private int total;
    private float feeincome;

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public float getFeeincome() {
        return feeincome;
    }

    public void setFeeincome(float feeincome) {
        this.feeincome = feeincome;
    }
}
