package com.lemon.union.auth.vo;

import java.util.List;

public class RoleVO {
    private long id;
    private String name;
    private boolean selected;
    private List<PermissionVO> permissionList;


    @Override
    public int hashCode() {
        return new Long(this.getId()).intValue();
    }

    @Override
    public boolean equals(Object obj) {
        RoleVO vo = (RoleVO) obj;
        if (vo.getId() == this.id)
            return true;
        else
            return false;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

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
