package com.lemon.union.auth.vo;

import java.util.Date;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

public class PermissionVO {

	@Override
	public int hashCode() {
		return new Long(this.getId()).intValue();
	}

	@Override
	public boolean equals(Object obj) {
		PermissionVO vo = (PermissionVO) obj;
		if (vo.getId() == this.id)
			return true;
		else
			return false;
	}
	

	private long id;
	private String name;
	private Date createTime;
	private String url;
	private boolean selected;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
