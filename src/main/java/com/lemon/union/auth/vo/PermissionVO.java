package com.lemon.union.auth.vo;

import java.util.Date;

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
	private String desc;
	private boolean selected;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
