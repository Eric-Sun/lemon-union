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

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public List<ProvinceIncomeDTO> queryProvinceIvrIncome(Date beginDate, Date endDate, int pageNum, int pageSize) {
        String sql = "select b.province as province, count(*) as ivrcount, sum(totalincome) as ivrincome from lez_service_log" +
                " a, api_haoduan b where a.subtime between ? and ? " +
                "and left(a.mobile, 7) = b.mobile and a.pid = 10 group by b.province limit " + (pageNum - 1) * pageSize + "," + pageSize;
        return j.query(sql, new Object[]{beginDate, endDate}, new BeanPropertyRowMapper<ProvinceIncomeDTO>(ProvinceIncomeDTO.class));
    }

    public List<ProvinceIncomeDTO> queryProvinceSmsIncome(Date beginDate, Date endDate, int pageNum, int pageSize) {
        String sql = "select b.province as province, count(*) as smscount, sum(totalincome) as smsincome from lez_service_log" +
                " a, api_haoduan b where a.subtime between ? and ? " +
                "and left(a.mobile, 7) = b.mobile and a.pid = 11 group by b.province  limit " + (pageNum - 1) * pageSize + "," + pageSize;
        return j.query(sql, new Object[]{beginDate, endDate}, new BeanPropertyRowMapper<ProvinceIncomeDTO>(ProvinceIncomeDTO.class));
    }


    public List<ProductRealtimeDTO> queryForProductRealTime(int pageNum, int pageSize) {
        String sql = "select id, wid, channel, pid, mobile, ordercode, orderdest, totalincome, feeincome, feeflag, subtime" +
                " from lez_service_log where subtime >= date_add(now(), interval -1 day) and subtime<now() limit " + (pageNum - 1) * pageSize + "," + pageSize;
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<ProductRealtimeDTO>(ProductRealtimeDTO.class));
    }

    public List<RealtimeDTO> queryForRealtime(int pageNum, int pageSize) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        String sql = "select pid, wid, sum(feeincome) as feeincome, count(*) as total from lez_service_log where " +
                "subtime >= ? and feeflag = 1 group by pid, wid order by feeincome desc limit " + (pageNum - 1) * pageSize + "," + pageSize;
        return j.query(sql, new Object[]{cal.getTime()}, new BeanPropertyRowMapper<RealtimeDTO>(RealtimeDTO.class));
    }


    public List<AdownerBillDTO> queryForAdownerBill(Date beginDate, Date endDate, int pageNum, int pageSize) {
        String sql = "select servicecode, sum(showcount) showcount, sum(showincome) showincome, sum(feecount) feecount," +
                " sum(feeincome) feeincome, sum(totalincome) totalincome from lez_bill_day where subdate " +
                "between ? and ? group by servicecode order by totalincome desc limit " + (pageNum - 1) * pageSize + "," + pageSize;
        return j.query(sql, new Object[]{beginDate, endDate}, new BeanPropertyRowMapper<AdownerBillDTO>(AdownerBillDTO.class));
    }


    public List<BillDTO> queryForBill(int pageNum, int pageSize) {
        String sql = "select billdate, sum(showcount) showcount, sum(showincome) showincome, sum(feecount) feecount, sum(feeincome) feeincome," +
                " sum(totalincome) totalincome, sum(totalincome-showincome) ownerincome from " +
                "lez_webowner_bill group by billdate order by billdate desc limit " + (pageNum - 1) * pageSize + "," + pageSize;
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<BillDTO>(BillDTO.class));
    }


    public List<WebownerPeriodBillDTO> queryForWebownerPeriodBill(Date beginDate, Date endDate, int pageNum, int pageSize) {
        String sql = "select wid, sum(showcount) showcount, sum(showincome) showincome, sum(feecount) feecount, sum(feeincome) feeincome, sum(totalincome) totalincome from lez_webowner_bill where billdate " +
                "between ? and ? group by wid order by totalincome desc limit " + (pageNum - 1) * pageSize + "," + pageSize;
        return j.query(sql, new Object[]{beginDate, endDate}, new BeanPropertyRowMapper<WebownerPeriodBillDTO>(WebownerPeriodBillDTO.class));
    }

    public List<WebownerBillDTO> queryForWebownerBill(int pageNum, int pageSize) {
        String sql = "select id, billdate, wid, pid, showcount, showincome, feecount, feeincome, totalincome, payflag, paytime " +
                "from lez_webowner_bill order by billdate desc limit " + (pageNum - 1) * pageSize + "," + pageSize;
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<WebownerBillDTO>(WebownerBillDTO.class));
    }


    //////////////////////////////////
    public int queryProvinceIvrIncomeCount(Date beginDate, Date endDate) {
        String sql = "select ifnull(count(distinct(b.province)),0) from lez_service_log" +
                " a, api_haoduan b where a.subtime between ? and ? " +
                "and left(a.mobile, 7) = b.mobile and a.pid = 10 ";
        return j.queryForInt(sql, new Object[]{beginDate, endDate});
    }

    public int queryProvinceSmsIncomeCount(Date beginDate, Date endDate) {
        String sql = "select ifnull(count(distinct(b.province)),0) from lez_service_log" +
                " a, api_haoduan b where a.subtime between ? and ? " +
                "and left(a.mobile, 7) = b.mobile and a.pid = 11";
        return j.queryForInt(sql, new Object[]{beginDate, endDate});
    }


    public int queryForProductRealTimeCount() {
        String sql = "select ifnull(count(*),0)" +
                " from lez_service_log where subtime >= date_add(now(), interval -1 day) and subtime<now() ";
        return j.queryForInt(sql, new Object[]{});
    }

    public int queryForRealtimeCount() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        String sql = "select ifnull(count(distinct(concat(pid, wid))),0) from lez_service_log where " +
                "subtime >= ? and feeflag = 1";
        return j.queryForInt(sql, new Object[]{cal.getTime()});
    }


    public int queryForAdownerBillCount(Date beginDate, Date endDate) {
        String sql = "select ifnull(count(distinct(servicecode)),0) from lez_bill_day where subdate " +
                "between ? and ?";
        return j.queryForInt(sql, new Object[]{beginDate, endDate});
    }


    public int queryForBillCount() {
        String sql = "select ifnull(count(distinct(billdate)),0) from lez_webowner_bill";
        return j.queryForInt(sql, new Object[]{});
    }


    public int queryForWebownerPeriodBillCount(Date beginDate, Date endDate) {
        String sql = "select ifnull(count(distinct(wid)),0) from lez_webowner_bill where billdate " +
                "between ? and ?";
        return j.queryForInt(sql, new Object[]{beginDate, endDate});
    }

    public int queryForWebownerBillCount() {
        String sql = "select ifnull(count(*),0) from lez_webowner_bill";
        return j.queryForInt(sql, new Object[]{});
    }
}
