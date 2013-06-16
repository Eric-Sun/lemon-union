package com.lemon.union.finance.controller;

import com.lemon.union.finance.dto.AdownerBillDTO;
import com.lemon.union.finance.service.AdownerBillService;
import com.lemon.union.operator.dto.ProductRealtimeDTO;
import com.lemon.union.tools.Page;
import com.lemon.union.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-5
 * Time: 下午7:11
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/finance/adownerbill")
public class AdownerBillController {

    @Autowired
    AdownerBillService service;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/query")
    public ModelAndView query(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String beginDateStr = null;
        if (request.getParameter("beginDate") != null)
            beginDateStr = request.getParameter("beginDate");
        else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            beginDateStr = sdf.format(cal.getTime());
        }
        String endDateStr = null;
        if (request.getParameter("beginDate") != null)
            endDateStr = request.getParameter("endDate");
        else {
            endDateStr = sdf.format(new Date());
        }
        int pageNum = 1;
        int pageSize = 50;
        if (request.getParameter("pageNum") != null) {
            pageNum = new Integer(request.getParameter("pageNum"));
        }
        List<AdownerBillDTO> list = service.query(sdf2.parse(beginDateStr + " 00:00:00"), sdf2.parse(endDateStr + " 23:59:59"), pageNum, pageSize);
        int count = service.queryCount(sdf2.parse(beginDateStr + " 00:00:00"), sdf2.parse(endDateStr + " 23:59:59"));
        Page<AdownerBillDTO> page = PageUtil.getPage(count, pageNum, list, pageSize);

        ModelAndView mav = new ModelAndView("/finance/adownerbill/list");
        mav.addObject("list", list);
        mav.addObject("pageHtml", PageUtil.toPageHtml(page, request.getRequestURI(), request.getQueryString()));
        return mav;
    }
}
