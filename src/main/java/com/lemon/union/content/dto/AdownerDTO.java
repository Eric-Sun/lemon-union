package com.lemon.union.content.dto;

import java.util.Date;

public class AdownerDTO {
	private long adownerid;
	private String name;
	private String company;
	private String brief;
	private int status;
	private Date createtime;

    public long getAdownerid() {
        return adownerid;
    }

    public void setAdownerid(long adownerid) {
        this.adownerid = adownerid;
    }

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
}
