package com.lemon.union.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.union.auth.vo.RoleVO;
import com.lemon.union.dao.RoleDAO;

@Service
public class RoleService {

	@Autowired
	RoleDAO roleDAO;

	public String getRoleName(long roleId) {
		try {
			return roleDAO.getRoleName(roleId);
		} catch (Exception e) {
			return null;
		}
	}

	public long getRoleId(String roleName) {
		try {
			return roleDAO.getRoleId(roleName);
		} catch (Exception e) {
			return -1;
		}
	}

	public long create(String roleName, String[] permissionIdArray) {
		return roleDAO.create(roleName, permissionIdArray);
	}

	public void delete(long roleId) {
		roleDAO.delete(roleId);
	}

	public void update(long roleId, String roleName, String[] permissionIdArray) {
		roleDAO.update(roleId, roleName, permissionIdArray);
	}

	public List<RoleVO> getAllRole() {
		return roleDAO.getAllRoles();
	}

	public RoleVO fetchRole(long id) {
		return roleDAO.fetchRole(id);
	}
}
