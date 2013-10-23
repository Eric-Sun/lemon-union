package com.lemon.union.finance.service;

import com.lemon.union.dao.IncomeDAO;
import com.lemon.union.finance.dto.WebownerBillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-5
 * Time: 下午10:14
 * To change this template use File | Settings | File Templates.
 */
@Service
public class WebownerBillService {

    @Autowired
    IncomeDAO dao;

    public List<WebownerBillDTO> query(String wid,String pid,int pageNum, int pageSize) {
        return dao.queryForWebownerBill(wid,pid,pageNum, pageSize);
    }

    public int queryCount() {
        return dao.queryForWebownerBillCount();
    }

    public void pay(int type, String ids) {
        dao.pay(type, ids);
    }
}
