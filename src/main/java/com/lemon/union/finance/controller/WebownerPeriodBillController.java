package com.lemon.union.finance.controller;

import com.lemon.union.finance.dto.AdownerBillDTO;
import com.lemon.union.finance.dto.WebownerBillDTO;
import com.lemon.union.finance.dto.WebownerPeriodBillDTO;
import com.lemon.union.finance.service.AdownerBillService;
import com.lemon.union.finance.service.WebownerPeriodBillService;
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
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-5
 * Time: 下午10:04
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/finance/webownerperiodbill")
public class WebownerPeriodBillController {
    @Autowired
    WebownerPeriodBillService service;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @RequestMapping("/query")
    public ModelAndView query(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int pageNum = 1;
        int pageSize = 50;
        if (request.getParameter("pageNum") != null) {
            pageNum = new Integer(request.getParameter("pageNum"));
        }
        String beginDateStr = null;
        if (request.getParameter("beginDate") != null)
            beginDateStr = request.getParameter("beginDate");
        else {
            beginDateStr = sdf.format(new Date());
        }
        String endDateStr = null;
        if (request.getParameter("beginDate") != null)
            endDateStr = request.getParameter("endDate");
        else {
            endDateStr = sdf.format(new Date());
        }
        List<WebownerPeriodBillDTO> list = service.query(sdf2.parse(beginDateStr + " 00:00:00"),
                sdf2.parse(endDateStr + " 23:59:59"), pageNum, pageSize);
        int count = service.queryCount(sdf2.parse(beginDateStr + " 00:00:00"),
                sdf2.parse(endDateStr + " 23:59:59"));
        ModelAndView mav = new ModelAndView("/finance/webownerperiodbill/list");
        Page<WebownerPeriodBillDTO> page = PageUtil.getPage(count, pageNum, list, pageSize);
        mav.addObject("pageHtml", PageUtil.toPageHtml(page, request.getRequestURI(), request.getQueryString()));
        mav.addObject("list", list);
        return mav;
    }
}
