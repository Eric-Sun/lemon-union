package com.lemon.union.auth.vo;

import java.util.List;

public class RoleVO {
	private long id;
	private String name;
	private List<PermissionVO> permissionList;
	public List<PermissionVO> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(List<PermissionVO> permissionList) {
		this.permissionList = permissionList;
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
