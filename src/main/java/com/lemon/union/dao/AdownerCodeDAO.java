package com.lemon.union.dao;

import java.util.List;

import com.lemon.union.content.dto.AdownerCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA. User: sunbo Date: 13-2-24 To change this template
 * use File | Settings | File Templates.
 */
@Repository
public class AdownerCodeDAO {

    @Autowired
    JdbcTemplate j;

    public List<AdownerCodeDTO> list() {
        String sql = "select * from lem_adowner_code";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper(
                AdownerCodeDTO.class));
    }

    public AdownerCodeDTO show(long id ) {
        String sql = "select * from lem_adowner_code where id=?";
        return (AdownerCodeDTO) j.query(sql, new Object[]{id},
                new BeanPropertyRowMapper(AdownerCodeDTO.class)).get(0);
    }

    public void delete(long id) {
        String sql = "delete from lem_adowner_code where id=?";
        j.update(sql, new Object[]{id});
    }

    public void create(long adownerid, long pid, String servicecode, String servicename, String servicefee, String ownerfee,
                       String ordercode, String orderdest, String brief, String offnum, String offbase) {
        String sql = "insert into lem_adowner_code( adownerid, pid, servicecode, servicename, servicefee, ownerfee," +
                "ordercode, orderdest, brief, offnum, offbase,createtime) values (?,?,?,?,?,?,?,?,?,?,?,now())";
        j.update(sql, new Object[]{adownerid, pid, servicecode, servicename, servicefee, ownerfee,
                ordercode, orderdest, brief, offnum, offbase});
    }

    public void update(long id, long adownerid, long pid, String servicecode, String servicename, String servicefee, String ownerfee,
                       String ordercode, String orderdest, String brief, String offnum, String offbase) {
        String sql = "update lem_adowner_code set adownerid=?,pid=?,servicecode=?,servicename=?,servicefee=?,ownerfee=?," +
                "ordercode=?,orderdest=?,brief=?,offnum=?,offbase=? where id=?";
        j.update(sql, new Object[]{adownerid, pid, servicecode, servicename, servicefee,
                ownerfee, ordercode, orderdest, brief, offnum, offbase, id});
    }

}


