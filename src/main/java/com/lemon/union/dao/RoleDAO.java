package com.lemon.union.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lemon.union.auth.vo.PermissionVO;
import com.lemon.union.auth.vo.RoleVO;

@Repository
public class RoleDAO {

    @Autowired
    JdbcTemplate j;

    public String getRoleName(long roleId) {
        String sql = "select name from role where id=?";
        return j.queryForObject(sql, new Object[]{roleId}, String.class);
    }

    public List<RoleVO> getAllRoles() {
        String sql = "select id,name from role";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper(
                RoleVO.class));
    }

    public void delete(long roleId) {
        String sql = "delete from role where id=?";
        j.update(sql, new Object[]{roleId});
        // delete permission
        String d = "delete from roles_permissions where role_id=?";
        j.update(d, new Object[]{roleId});
    }

    public void update(long roleId, String roleName, String[] permissionIdArray) {
        String s1 = "update role set name=? where id=?";
        j.update(s1, new Object[]{roleName, roleId});

        String s2 = "delete from roles_permissions where role_id=?";
        j.update(s2, new Object[]{roleId});
        for (String id : permissionIdArray) {
            String s3 = "insert into roles_permissions (role_id,permission_id,create_time) values (?,?,now());";
            j.update(s3, new Object[]{roleId, id});
        }
    }

    public long create(final String roleName, String[] permissionIdArray) {
        KeyHolder kh = new GeneratedKeyHolder();
        final String sql = "insert into role (name,create_time) values (?,now())";
        j.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                    throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, roleName);
                return pstmt;
            }
        }, kh);
        long roleId = kh.getKey().longValue();
        for (String id : permissionIdArray) {
            String s3 = "insert into roles_permissions (role_id,permission_id,create_time) values (?,?,now());";
            j.update(s3, new Object[]{roleId, new Long(id)});
        }

        return roleId;
    }

    public long getRoleId(String roleName) {
        String sql = "select id from role where name=?";
        return j.queryForLong(sql, new Object[]{roleName});
    }

    public RoleVO fetchRole(long id) {
        String sql = "select id,name from role where id=?";
        RoleVO roleVO = (RoleVO) j.query(sql, new Object[]{id},
                new BeanPropertyRowMapper(RoleVO.class)).get(0);
        String sql2 = "select p.id,p.name from permission p,roles_permissions rp where rp.permission_id=p.id and rp.role_id=?";
        List<PermissionVO> pList = j.query(sql2, new Object[]{id},
                new BeanPropertyRowMapper(PermissionVO.class));
        roleVO.setPermissionList(pList);
        return roleVO;
    }

    public List<RoleVO> list() {
        String sql = "select id,name from role";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<RoleVO>(RoleVO.class));
    }
}
