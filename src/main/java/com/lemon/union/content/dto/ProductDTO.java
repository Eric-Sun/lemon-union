package com.lemon.union.content.dto;

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
    private String trumbnail ;
    private String brief;
    private String commission;
    private int status;

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

    public String getTrumbnail() {
        return trumbnail;
    }

    public void setTrumbnail(String trumbnail) {
        this.trumbnail = trumbnail;
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
