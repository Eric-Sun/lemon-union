package com.lemon.union.finance.service;

import com.lemon.union.dao.IncomeDAO;
import com.lemon.union.finance.dto.AdownerBillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-5
 * Time: 下午9:40
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AdownerBillService {

    @Autowired
    IncomeDAO dao;

    public List<AdownerBillDTO> query(Date beginDate, Date endDate,int pageNum,int pageSize) {
        return dao.queryForAdownerBill(beginDate,endDate,pageNum,pageSize);
    }

    public int queryCount(Date beginDate, Date endDate) {
        return dao.queryForAdownerBillCount(beginDate,endDate);
    }
}
