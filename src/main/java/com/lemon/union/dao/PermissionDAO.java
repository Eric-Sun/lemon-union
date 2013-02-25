package com.lemon.union.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lemon.union.auth.vo.PermissionVO;

@Repository
public class PermissionDAO {

	@Autowired
	JdbcTemplate j;

	public List<PermissionVO> getAllPermission() {

		String sql = "select id,name,url,create_time from permission";
		return j.query(sql, new Object[] {}, new BeanPropertyRowMapper(
				PermissionVO.class));
	}

	public void create(String name, String url) {
		String sql = "insert into permission (name,url,create_time) values(?,?,now())";
		j.update(sql, new Object[] { name, url });
	}

	public void delete(long permissionId) {
		String sql = "delete from permission where id=?";
		j.update(sql, new Object[] { permissionId });
	}

	public void update(long permissionId, String name, String url) {
		String sql = "update permission set name=?,url=? where id=?";
		j.update(sql, new Object[] { name, url, permissionId });
	}

	public PermissionVO fetch(long id) {
		String sql = "select id,name,url,create_time from permission where id=?";
		return (PermissionVO) j.query(sql, new Object[] { id },
				new BeanPropertyRowMapper(PermissionVO.class)).get(0);

	}

}
