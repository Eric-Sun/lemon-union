package com.lemon.union.dao;

import com.lemon.union.content.dto.WebownerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
                       String remark) {
        String sql = "update lem_webowner set truename=?,mobile=?,telephone=?,address=?,qq=?,sitename=?," +
                "siteurl=?,sitetype=?,bankaddr=?,bankcard=?,account=?,regtime=?,channel=?,remark=? where wid=?";
        j.update(sql, new Object[]{truename, mobile, telephone, address, qq, sitename, siteurl, sitetype, bankaddr, bankcard, account,
                regtime, channel.equals("") ? null : channel, remark, wid});
    }

    public void delete(long id) {
        String sql = "delete from lem_webowner where wid=?";
        j.update(sql, new Object[]{id});
    }

    public void setStatus(long wid, int status) {
        String sql = "update lem_webowner set status=? where wid=?";
        j.update(sql, new Object[]{status, wid});
    }
}
