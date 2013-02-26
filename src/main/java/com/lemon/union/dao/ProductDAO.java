package com.lemon.union.dao;

import com.lemon.union.content.dto.ProductDTO;
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
 * Time: 上午12:03
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ProductDAO {

    @Autowired
    JdbcTemplate j;


    public List<ProductDTO> list() {
        String sql = "select * from lem_product";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<ProductDTO>(ProductDTO.class));
    }

    public void delete(long id) {
        String sql = "delete from lem_product where pid=?";
        j.update(sql, new Object[]{id});
    }

    public void create(final String name, final String thumbnail, final String brief, final String commission, final int status) {
        final String sql = "insert into lem_product (name,thumbnail,brief,commission,status,createtime) values (?,?,?,?,?,now())";
        j.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setString(2, thumbnail);
                pstmt.setString(3, brief);
                pstmt.setString(4, commission);
                pstmt.setInt(5, status);
                return pstmt;
            }
        });
    }

    public void update(long pid, String name, String thumbnail, String brief, String commission, int status) {
        String sql = "update lem_product set name=?,thumbnail=?,brief=?,commission=?,status=? where pid=?";
        j.update(name, thumbnail, brief, commission, status, pid);
    }

    public ProductDTO show(long pid) {
        String sql = "select * from lem_product where pid=?";
        List<ProductDTO> list = j.query(sql, new Object[]{pid}, new BeanPropertyRowMapper<ProductDTO>(ProductDTO.class));
        if (list.size() == 0)
            return null;
        return list.get(0);
    }

}
