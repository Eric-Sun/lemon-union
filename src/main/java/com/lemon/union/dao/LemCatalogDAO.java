package com.lemon.union.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lemon.union.content.dto.LemCatalogDTO;

@Repository
public class LemCatalogDAO {

    @Autowired
    JdbcTemplate j;

    public List<LemCatalogDTO> listAll() {
        String sql = "select * from lem_catalog";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper(
                LemCatalogDTO.class));
    }

    public LemCatalogDTO show(long id) {
        String sql = "select 8 from lem_catalog where id=?";
        return (LemCatalogDTO) j.query(sql, new Object[]{}, new BeanPropertyRowMapper(
                LemCatalogDTO.class)).get(0);
    }

    public void delete(long id) {
        String sql = "delete from lem_catalog where id=?";
        j.update(sql, new Object[]{id});
    }

    public void create(String id, String parentid, String classid, String name, String isleaf, String orders) {
        String sql = "insert into lem_catalog (id,parentid,classid,name,isleaf,orders,createtime) values" +
                " (?,?,?,?,?,?,now())";
        j.update(sql, new Object[]{id, parentid, classid, name, isleaf, orders});
    }

    public void update(String id, String parentid, String classid, String name, String isleaf, String orders) {
        String sql = "update lem_catalog set parentid=?,classid=?,name=?,isleaf=?,orders=? where id=?";
        j.update(sql, new Object[]{parentid, classid, name, isleaf, orders, id});
    }
}
