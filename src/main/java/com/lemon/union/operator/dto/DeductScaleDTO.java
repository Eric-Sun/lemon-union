package com.lemon.union.operator.dto;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-2-27
 * Time: 下午6:36
 * To change this template use File | Settings | File Templates.
 */
public class DeductScaleDTO {

    private long id;
    private long wid;
    private long pid;
    private int offbase;
    private int offno;
    private int status;
    private Date subtime;

    public Date getSubtime() {
        return subtime;
    }

    public void setSubtime(Date subtime) {
        this.subtime = subtime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOffbase() {
        return offbase;
    }

    public void setOffbase(int offbase) {
        this.offbase = offbase;
    }

    public int getOffno() {
        return offno;
    }

    public void setOffno(int offno) {
        this.offno = offno;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getWid() {
        return wid;
    }

    public void setWid(long wid) {
        this.wid = wid;
    }
}
