package com.lemon.union.operator.controller;

import com.lemon.union.finance.dto.AdownerBillDTO;
import com.lemon.union.operator.dto.ProvinceIncomeDTO;
import com.lemon.union.operator.service.ProvinceIncomeService;
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
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-3
 * Time: 下午10:46
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/operator/provinceincome")
public class ProvinceIncomeController {

    @Autowired
    ProvinceIncomeService service;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/query")
    public ModelAndView query(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String beginDateStr = request.getParameter("beginDate");
        String endDateStr = request.getParameter("endDate");
        int pageNum = 1;
        int pageSize = 50;
        if (request.getParameter("pageNum") != null) {
            pageNum = new Integer(request.getParameter("pageNum"));
        }
        List<ProvinceIncomeDTO> list = service.query(sdf.parse(beginDateStr + " 00:00:00"), sdf.parse(endDateStr + " 23:59:59"), pageNum, pageSize);
        int count = service.queryCount(sdf.parse(beginDateStr + " 00:00:00"), sdf.parse(endDateStr + " 23:59:59"));
        Page<ProvinceIncomeDTO> page = PageUtil.getPage(count, pageNum, list, pageSize);

        ModelAndView mav = new ModelAndView("/operator/provinceincome/list");
        mav.addObject("list", list);
        mav.addObject("pageHtml", PageUtil.toPageHtml(page, request.getRequestURI(), request.getQueryString()));
        mav.addObject("list", list);
        return mav;
    }
}
