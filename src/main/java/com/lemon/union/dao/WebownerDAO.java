package com.lemon.union.dao;

import com.lemon.union.content.dto.WebownerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-2-27
 * Time: 下午10:44
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class WebownerDAO {

    @Autowired
    JdbcTemplate j;

    public List<WebownerDTO> list() {
        String sql = "select * from lem_webowner order by wid desc";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<WebownerDTO>(WebownerDTO.class));
    }


    public WebownerDTO show(long id) {
        String sql = "select * from lem_webowner where wid=?";
        return j.query(sql, new Object[]{id}, new BeanPropertyRowMapper<WebownerDTO>(WebownerDTO.class)).get(0);
    }

    public void update(long wid, String truename, String mobile, String telephone, String address, String qq, String sitename,
                       String siteurl, String sitetype, String bankaddr, String bankcard, String account, Date regtime, String channel,
                       String remark, int msgCount) {
        String sql = "update lem_webowner set truename=?,mobile=?,telephone=?,address=?,qq=?,sitename=?," +
                "siteurl=?,sitetype=?,bankaddr=?,bankcard=?,account=?,regtime=?,channel=?,remark=?,msg_count=? where wid=?";
        j.update(sql, new Object[]{truename, mobile, telephone, address, qq, sitename, siteurl, sitetype, bankaddr, bankcard, account,
                regtime, channel.equals("") ? null : channel, remark, msgCount, wid});
    }

    public void delete(long id) {
        String sql = "delete from lem_webowner where wid=?";
        j.update(sql, new Object[]{id});
    }

    public void setStatus(long wid, int status) {
        String sql = "update lem_webowner set status=? where wid=?";
        j.update(sql, new Object[]{status, wid});
    }

    public List<Object[]> showprovince(long wid) {
        String sql = "select province,msg_count,today_count from webowner_province where wid=?";
        return j.query(sql, new Object[]{wid}, new RowMapper<Object[]>() {
            @Override
            public Object[] mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] o = new Object[3];
                o[0] = rs.getString(1);
                o[1] = rs.getInt(2);
                o[2] = rs.getInt(3);
                return o;
            }
        });
    }

    public void update(long wid, String province, Integer count) {
        String sql = "update webowner_province set msg_count=? where province=? and wid=?";
        j.update(sql, new Object[]{count, province, wid});
    }
}
