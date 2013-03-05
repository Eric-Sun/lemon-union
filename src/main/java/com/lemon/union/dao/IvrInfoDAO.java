package com.lemon.union.dao;

import com.lemon.union.content.dto.IvrInfoDTO;
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
 * Date: 13-3-2
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class IvrInfoDAO {

    @Autowired
    JdbcTemplate j;

    public List<IvrInfoDTO> list() {
        String sql = "select * from lem_ivr_info";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<IvrInfoDTO>(IvrInfoDTO.class));
    }

    public IvrInfoDTO show(long id) {
        String sql = "select * from lem_ivr_info where id=?";
        return j.query(sql, new Object[]{id}, new BeanPropertyRowMapper<IvrInfoDTO>(IvrInfoDTO.class)).get(0);
    }

    public void create(final long wid, final String channel, final String servicecode, final String ivrnum, final String feenum,
                       final String orderdest, final int status) {
        final String sql = "insert into lem_ivr_info " +
                "(wid,channel,servicecode,ivrnum,feenum,orderdest,status,subtime) " +
                "values" +
                "(?,?,?,?,?,?,?,now())";
        j.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setLong(1, wid);
                pstmt.setString(2, channel);
                pstmt.setString(3, servicecode);
                pstmt.setString(4, ivrnum);
                pstmt.setString(6, orderdest);
                pstmt.setString(5, feenum);
                pstmt.setInt(7, status);
                return pstmt;
            }
        });
    }

    public void update(final long id, final long wid, final String channel, final String servicecode, final String ivrnum, final String feenum,
                       final String orderdest, final int status) {
        String sql = "update lem_ivr_info set wid=?,channel=?,servicecode=?," +
                "ivrnum=?,feenum=?,orderdest=?,status=? where id=?";
        j.update(sql, new Object[]{wid, channel, servicecode, ivrnum, feenum, orderdest, status, id});
    }

    public void delete(long id) {
        String sql = "delete from lem_ivr_info where id=?";
        j.update(sql, new Object[]{id});
    }
}
