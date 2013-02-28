package com.lemon.union.content.dto;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-2-24
 * Time: 下午5:23
 * To change this template use File | Settings | File Templates.
 */
public class AdownerCodeDTO {
    private long id;
    private long adownerid;
    private long pid;
    private String servicecode;
    private String servicename;
    private String servicefee;
    private String ownerfee;
    private String ordercode;
    private String orderdest;
    private String servicephone;
    private String brief;
    private String offnum;
    private String offbase;
    private int status;

    private Date createtime;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAdownerid() {
        return adownerid;
    }

    public void setAdownerid(long adownerid) {
        this.adownerid = adownerid;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getServicecode() {
        return servicecode;
    }

    public void setServicecode(String servicecode) {
        this.servicecode = servicecode;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getServicefee() {
        return servicefee;
    }

    public void setServicefee(String servicefee) {
        this.servicefee = servicefee;
    }

    public String getOwnerfee() {
        return ownerfee;
    }

    public void setOwnerfee(String ownerfee) {
        this.ownerfee = ownerfee;
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

    public String getServicephone() {
        return servicephone;
    }

    public void setServicephone(String servicephone) {
        this.servicephone = servicephone;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getOffnum() {
        return offnum;
    }

    public void setOffnum(String offnum) {
        this.offnum = offnum;
    }

    public String getOffbase() {
        return offbase;
    }

    public void setOffbase(String offbase) {
        this.offbase = offbase;
    }

    private String remark;

}
