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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public List<ProvinceIncomeDTO> queryProvinceIvrIncome(Long wid, String adid, String cmd, String orderdest, Date beginDate, Date endDate,
                                                          int pageNum, int pageSize, String servicecode) {
        String cond = " and 1=1 ";
        if (wid != -1)
            cond = " and a.wid=" + wid + " ";
        String cond1 = " and 1=1 ";
        if (!"".equals(adid)) {
            cond1 = " and a.adid =" + adid + " ";
        }
        String cond2 = " and 1=1 ";
        if (!"".equals(cmd)) {
            cond2 = " and a.ordercode ='" + cmd + "' ";
        }
        String cond3 = " and 1=1 ";
        if (!"".equals(orderdest)) {
            cond3 = " and a.orderdest ='" + orderdest + "' ";
        }
        String cond4 = " and 1=1 ";
        if (!"".equals(servicecode)) {
            cond4 = " and a.servicecode='" + servicecode + "' ";
        }

        String sql = "select b.province as province, count(*) as ivrcount, sum(totalincome) as ivrincome from lez_service_log" +
                " a, api_haoduan b where a.subtime between ? and ? " +
                "and left(a.mobile, 7) = b.mobile and a.pid = 10 " + cond + cond1 + cond2 + cond3 + cond4 + "group by b.province limit " + (pageNum - 1) * pageSize + "," + pageSize;
        return j.query(sql, new Object[]{beginDate, endDate}, new BeanPropertyRowMapper<ProvinceIncomeDTO>(ProvinceIncomeDTO.class));
    }

    public List<ProvinceIncomeDTO> queryProvinceSmsIncome(Long wid, String adid, String cmd,
                                                          String orderdest, Date beginDate, Date endDate, int pageNum, int pageSize, String servicecode) {
        String cond1 = " and 1=1 ";
        if (!"".equals(adid)) {
            cond1 = " and a.adid =" + adid + " ";
        }
        String cond2 = " and 1=1 ";
        if (!"".equals(cmd)) {
            cond2 = " and a.ordercode ='" + cmd + "' ";
        }
        String cond3 = " and 1=1 ";
        if (!"".equals(orderdest)) {
            cond3 = " and a.orderdest ='" + orderdest + "' ";
        }
        String cond = " and 1=1 ";
        if (wid != -1)
            cond = " and a.wid=" + wid + " ";

        String cond4 = " and 1=1 ";
        if (!"".equals(servicecode)) {
            cond4 = " and a.servicecode='" + servicecode + "' ";
        }


        String sql = "select b.province as province, count(*) as smscount, sum(totalincome) as smsincome from lez_service_log" +
                " a, api_haoduan b where a.subtime between ? and ? " +
                "and left(a.mobile, 7) = b.mobile and a.pid = 11 " + cond + cond1 + cond2 + cond3 + cond4 + "group by b.province  limit " + (pageNum - 1) * pageSize + "," + pageSize;
        return j.query(sql, new Object[]{beginDate, endDate}, new BeanPropertyRowMapper<ProvinceIncomeDTO>(ProvinceIncomeDTO.class));
    }


    public List<ProductRealtimeDTO> queryForProductRealTime(Date startTime, Date endTime, Integer wid, String mobile, String totalincome,
                                                            String cmdid, String orderdest, String feeflag, int pageNum, int pageSize) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeCond = " subtime >= date_add(now(), interval -1 day) and subtime<now() ";
        if (startTime != null)
            timeCond = "  subtime between '" + sdf.format(startTime) + "' and '" + sdf.format(endTime) + "'";
        String widCond = " and 1=1 ";
        if (wid != null && wid != -99)
            widCond = " and wid=" + wid;
        String mobileCond = " and 1=1 ";
        if (mobile != null && !mobile.equals("")) {
            mobileCond = " and mobile='" + mobile + "'";
        }
        String totalincomeCond = " and 1=1";
        if (totalincome != null && !totalincome.equals("")) {
            totalincomeCond = " and totalincome=" + totalincome + "";
        }
        String cmdidCond = " and 1=1 ";
        if (cmdid != null && !cmdid.equals("")) {
            cmdidCond = " and ordercode='" + cmdid + "'";
        }
        String cond2 = " and 1=1 ";
        if (!orderdest.equals(""))
            cond2 = " and orderdest ='" + orderdest + "'";
        String cond3 = " and 1=1 ";
        if (!feeflag.equals(""))
            cond3 = " and FeeFlag=" + feeflag + "";
        String sql = "select id, wid, channel, pid, mobile, ordercode, orderdest, totalincome, feeincome, feeflag, subtime" +
                " from lez_service_log where " + timeCond + cond2 + cond3 + widCond + mobileCond + totalincomeCond + cmdidCond + "order by subtime desc limit " + (pageNum - 1) * pageSize + "," + pageSize;
        ;
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<ProductRealtimeDTO>(ProductRealtimeDTO.class));
    }

    public List<RealtimeDTO> queryForRealtime(int pageNum, int pageSize) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
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

    public List<WebownerBillDTO> queryForWebownerBill(String wid, String pid, int pageNum, int pageSize) {
        String c1 = " and 1=1 ";
        if (!"".equals(wid)) {
            c1 = " and wid=" + wid + " ";
        }
        String c2 = " and 1=1 ";
        if (!"".equals(pid)) {
            c2 = " and pid=" + pid + " ";
        }
        String sql = "select id, billdate, wid, pid, showcount, showincome, feecount, feeincome, totalincome, payflag, paytime " +
                "from lez_webowner_bill where 1=1" + c1 + c2 + " order by billdate desc limit " + (pageNum - 1) * pageSize + "," + pageSize;
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


    public int queryForProductRealTimeCount(Date startTime, Date endTime, Integer wid, String mobile, String totalincome,
                                            String cmdid) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeCond = " subtime >= date_add(now(), interval -1 day) and subtime<now() ";
        if (startTime != null)
            timeCond = "  subtime between '" + sdf.format(startTime) + "' and '" + sdf.format(endTime) + "'";
        String widCond = " and 1=1 ";
        if (wid != null && wid != -99)
            widCond = " and wid=" + wid;
        String mobileCond = " and 1=1 ";
        if (mobile != null && !mobile.equals("")) {
            mobileCond = " and mobile='" + mobile + "'";
        }
        String totalincomeCond = " and 1=1";
        if (totalincome != null && !totalincome.equals("")) {
            totalincomeCond = " and totalincome=" + totalincome + "";
        }
        String cmdidCond = " and 1=1 ";
        if (cmdid != null && !cmdid.equals("")) {
            cmdidCond = " and ordercode='" + cmdid + "'";
        }

        String sql = "select ifnull(count(*),0)" +
                " from lez_service_log where " + timeCond + widCond + mobileCond + totalincomeCond + cmdidCond;
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

    public void pay(int type, String ids) {
        String sql = "update lez_webowner_bill set payflag =?, paytime = ? where id in (" + ids + ")";
        j.update(sql, new Object[]{type, new Date()});
    }

    public List<Object[]> getLastMobile(int count) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        String sql = "select mobile,count(1) from lez_service_log " +
                "where subtime between ? and ? " +
                "group by mobile having count(1)>=?";
        return j.query(sql, new Object[]{cal.getTime(), new Date(), count}, new RowMapper<Object[]>() {
            @Override
            public Object[] mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] o = new Object[2];
                o[0] = rs.getString(1);
                o[1] = rs.getString(2);
                return o;
            }
        });
    }
}
