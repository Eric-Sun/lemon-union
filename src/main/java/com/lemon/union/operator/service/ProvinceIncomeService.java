package com.lemon.union.operator.service;

import com.lemon.union.dao.IncomeDAO;
import com.lemon.union.operator.dto.ProvinceIncomeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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

    public List<ProvinceIncomeDTO> query(long wid, Date beginDate, Date endDate, int pageNum, int pageSize) {
        List<ProvinceIncomeDTO> l1 = dao.queryProvinceIvrIncome(wid, beginDate, endDate, pageNum, pageSize);
        List<ProvinceIncomeDTO> l2 = dao.queryProvinceSmsIncome(wid, beginDate, endDate, pageNum, pageSize);

        List<ProvinceIncomeDTO> finalList = new ArrayList<ProvinceIncomeDTO>();
        for (ProvinceIncomeDTO d1 : l1) {
            if (l2.contains(d1)) {
                for (ProvinceIncomeDTO d2 : l2) {
                    if (d1.equals(d2)) {
                        d1.setSmscount(d2.getSmscount());
                        d1.setSmsincome(d2.getSmsincome());
                        finalList.add(d1);
                    }
                }
            }
        }

        for (ProvinceIncomeDTO d2 : l2) {
            if (!l1.contains(d2)) {
                finalList.add(d2);
            }
        }

        return finalList;
    }

    public int queryCount(Long wid, Date beginDate, Date endDate) {
        return dao.queryProvinceSmsIncomeCount(beginDate, endDate);
    }
}
