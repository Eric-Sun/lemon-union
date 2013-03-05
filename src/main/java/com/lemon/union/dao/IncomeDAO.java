package com.lemon.union.dao;

import com.lemon.union.finance.dto.AdownerBillDTO;
import com.lemon.union.finance.dto.BillDTO;
import com.lemon.union.finance.dto.WebownerBillDTO;
import com.lemon.union.finance.dto.WebownerPeriodBillDTO;
import com.lemon.union.operator.dto.ProductRealtimeDTO;
import com.lemon.union.operator.dto.ProvinceIncomeDTO;
import com.lemon.union.operator.dto.RealtimeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-3
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class IncomeDAO {

    @Autowired
    JdbcTemplate j;

    public List<ProvinceIncomeDTO> queryProvinceIvrIncome(Date beginDate, Date endDate) {
        String sql = "select b.province as province, count(*) as ivrcount, sum(totalincome) as ivrincome from lez_service_log" +
                " a, api_haoduan b where a.subtime between ? and ? " +
                "and left(a.mobile, 7) = b.mobile and a.pid = 10 group by b.province";
        return j.query(sql, new Object[]{beginDate, endDate}, new BeanPropertyRowMapper<ProvinceIncomeDTO>(ProvinceIncomeDTO.class));
    }

    public List<ProvinceIncomeDTO> queryProvinceSmsIncome(Date beginDate, Date endDate) {
        String sql = "select b.province as province, count(*) as smscount, sum(totalincome) as smsincome from lez_service_log" +
                " a, api_haoduan b where a.subtime between ? and ? " +
                "and left(a.mobile, 7) = b.mobile and a.pid = 11 group by b.province";
        return j.query(sql, new Object[]{beginDate, endDate}, new BeanPropertyRowMapper<ProvinceIncomeDTO>(ProvinceIncomeDTO.class));
    }


    public List<ProductRealtimeDTO> queryForProductRealTime() {
        String sql = "select id, wid, channel, pid, mobile, ordercode, orderdest, totalincome, feeincome, feeflag, subtime from lez_service_log where subtime >= date_add(now(), interval -1 day) and subtime<now()";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<ProductRealtimeDTO>(ProductRealtimeDTO.class));
    }

    public List<RealtimeDTO> queryForRealtime() {
        String sql = "select pid, wid, sum(feeincome) as feeincome, count(*) as total from lez_service_log where subtime >= '<%=day%>' and feeflag = 1 group by pid, wid order by feeincome desc";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<RealtimeDTO>(RealtimeDTO.class));
    }


    public List<AdownerBillDTO> queryForAdownerBill(Date beginDate, Date endDate) {
        String sql = "select servicecode, sum(showcount) showcount, sum(showincome) showincome, sum(feecount) feecount," +
                " sum(feeincome) feeincome, sum(totalincome) totalincome from lez_bill_day where subdate " +
                "between ? and ? group by servicecode order by totalincome desc";
        return j.query(sql, new Object[]{beginDate, endDate}, new BeanPropertyRowMapper<AdownerBillDTO>(AdownerBillDTO.class));
    }


    public List<BillDTO> queryForBill() {
        String sql = "select billdate, sum(showcount) showcount, sum(showincome) showincome, sum(feecount) feecount, sum(feeincome) feeincome, sum(totalincome) totalincome, sum(totalincome-showincome) ownerincome from lez_webowner_bill group by billdate order by billdate desc";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<BillDTO>(BillDTO.class));
    }


    public List<WebownerPeriodBillDTO> queryForWebownerPeriodBill(Date beginDate, Date endDate) {
        String sql = "select wid, sum(showcount) showcount, sum(showincome) showincome, sum(feecount) feecount, sum(feeincome) feeincome, sum(totalincome) totalincome from lez_webowner_bill where billdate " +
                "between ? and ? group by wid order by totalincome desc";
        return j.query(sql, new Object[]{beginDate, endDate}, new BeanPropertyRowMapper<WebownerPeriodBillDTO>(WebownerPeriodBillDTO.class));
    }

    public List<WebownerBillDTO> queryForWebownerBill() {
        String sql = "select id, billdate, wid, pid, showcount, showincome, feecount, feeincome, totalincome, payflag, paytime from lez_webowner_bill";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<WebownerBillDTO>(WebownerBillDTO.class));
    }
}
