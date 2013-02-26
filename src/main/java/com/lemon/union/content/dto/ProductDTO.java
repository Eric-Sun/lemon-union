package com.lemon.union.content.dto;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-2-27
 * Time: 上午12:02
 * To change this template use File | Settings | File Templates.
 */
public class ProductDTO {

    private long pid;
    private String name;
    private String thumbnail ;
    private String brief;
    private String commission;
    private int status;
    private Date createtime;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
