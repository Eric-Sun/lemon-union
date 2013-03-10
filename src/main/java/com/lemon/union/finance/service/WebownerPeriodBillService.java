package com.lemon.union.finance.service;

import com.lemon.union.dao.IncomeDAO;
import com.lemon.union.finance.dto.WebownerPeriodBillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-5
 * Time: 下午10:07
 * To change this template use File | Settings | File Templates.
 */
@Service
public class WebownerPeriodBillService {

    @Autowired
    IncomeDAO dao;

    public List<WebownerPeriodBillDTO> query(Date beginDate, Date endDate, int pageNum, int pageSize) {
        return dao.queryForWebownerPeriodBill(beginDate, endDate, pageNum, pageSize);
    }

    public int queryCount(Date beginDate, Date endDate) {
        return dao.queryForWebownerPeriodBillCount(beginDate, endDate);
    }
}

