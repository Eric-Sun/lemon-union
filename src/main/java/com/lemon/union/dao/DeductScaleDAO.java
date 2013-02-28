package com.lemon.union.dao;

import com.lemon.union.operator.dto.DeductScaleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-2-27
 * Time: 下午6:33
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class DeductScaleDAO {

    @Autowired
    JdbcTemplate j;

    public List<DeductScaleDTO> list() {
        String sql = "select * from lem_webowner_scale";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<DeductScaleDTO>(DeductScaleDTO.class));
    }

    public void create(final long wid, final long pid, final int offbase, final int offno, final int status) {
        final String sql = "insert into lem_webowner_scale (wid,pid,offbase,offno,status,subtime) values (?,?,?,?,?,now())";
        j.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setLong(1, wid);
                pstmt.setLong(2, pid);
                pstmt.setInt(3, offbase);
                pstmt.setInt(4, offno);
                pstmt.setInt(5, status);
                return pstmt;
            }
        });
    }

    public void update(long id, long wid, long pid, int offbase, int offno, int status) {
        String sql = "update lem_webowner_scale set wid=?,pid=?,offbase=?,offno=?,status=? where id=?";
        j.update(sql, new Object[]{wid, pid, offbase, offno, status, id});
    }


    public DeductScaleDTO show(long id) {
        String sql = "select * from lem_webowner_scale where id=?";
        return j.query(sql, new Object[]{id}, new BeanPropertyRowMapper<DeductScaleDTO>(DeductScaleDTO.class)).get(0);
    }

    public void delete(long id) {
        String sql = "delete from lem_webowner_scale where id=?";
        j.update(sql, new Object[]{id});
    }


}
