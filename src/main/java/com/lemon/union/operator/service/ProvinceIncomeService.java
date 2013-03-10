package com.lemon.union.operator.service;

import com.lemon.union.dao.IncomeDAO;
import com.lemon.union.operator.dto.ProvinceIncomeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-3
 * Time: 下午10:54
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ProvinceIncomeService {

    @Autowired
    IncomeDAO dao;

    public List<ProvinceIncomeDTO> query(Date beginDate, Date endDate, int pageNum, int pageSize) {
        List<ProvinceIncomeDTO> l1 = dao.queryProvinceIvrIncome(beginDate, endDate, pageNum, pageSize);
        List<ProvinceIncomeDTO> l2 = dao.queryProvinceSmsIncome(beginDate, endDate, pageNum, pageSize);

        for (ProvinceIncomeDTO d1 : l1) {
            for (ProvinceIncomeDTO d2 : l2) {
                if (d1.equals(d2)) {
                    d1.setSmscount(d2.getSmscount());
                    d1.setSmsincome(d2.getSmsincome());
                }
            }
        }

        return l1;
    }

    public int queryCount(Date beginDate, Date endDate) {
        return dao.queryProvinceIvrIncomeCount(beginDate, endDate) +
                dao.queryProvinceSmsIncomeCount(beginDate, endDate);

    }
}
