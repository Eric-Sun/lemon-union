package com.lemon.union.finance.service;

import com.lemon.union.dao.IncomeDAO;
import com.lemon.union.finance.dto.BillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-5
 * Time: 下午9:52
 * To change this template use File | Settings | File Templates.
 */
@Service
public class BillService {

    @Autowired
    IncomeDAO dao;

    public List<BillDTO> query() {
        return dao.queryForBill();
    }

}
