package com.lemon.union.operator.service;

import com.lemon.union.dao.IncomeDAO;
import com.lemon.union.operator.dto.ProductRealtimeDTO;
import com.lemon.union.operator.dto.RealtimeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-4
 * Time: 下午10:42
 * To change this template use File | Settings | File Templates.
 */
@Service
public class RealtimeService {

    @Autowired
    IncomeDAO dao;

    public List<RealtimeDTO> query() {
        return dao.queryForRealtime();
    }

}
