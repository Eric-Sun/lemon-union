package com.lemon.union.content.service;

import com.lemon.union.content.dto.IvrInfoDTO;
import com.lemon.union.dao.IvrInfoDAO;
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
public class IvrInfoService {

    @Autowired
    private IvrInfoDAO dao;

    public List<IvrInfoDTO> list() {
        List<IvrInfoDTO> list = dao.list();
        for (IvrInfoDTO ivr : list) {
            int count = dao.getCount(ivr.getServicecode());
            ivr.setCurCount(count);
        }
        return list;
    }

    public IvrInfoDTO show(long id) {
        return dao.show(id);
    }

    public void create(final long wid, final String channel, final String servicecode, final String ivrnum, final String feenum,
                       final String orderdest, final int status) {
        dao.create(wid, channel, servicecode, ivrnum, feenum, orderdest, status
        );
    }

    public void update(final long id, final long wid, final String channel, final String servicecode, final String ivrnum, final String feenum,
                       final String orderdest, final int status) {
        dao.update(id, wid, channel, servicecode, ivrnum, feenum, orderdest, status);
    }

    public void delete(long id) {
        dao.delete(id);
    }
}
