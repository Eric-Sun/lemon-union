package com.lemon.union.finance.controller;

import com.lemon.union.finance.dto.AdownerBillDTO;
import com.lemon.union.finance.dto.WebownerPeriodBillDTO;
import com.lemon.union.finance.service.AdownerBillService;
import com.lemon.union.finance.service.WebownerPeriodBillService;
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

    @RequestMapping("/query")
    public ModelAndView query(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        String beginDateStr = request.getParameter("beginDate");
        String endDateStr = request.getParameter("endDate");
        List<WebownerPeriodBillDTO> list = service.query(sdf.parse(beginDateStr + " 00:00:00"), sdf.parse(endDateStr + " 23:59:59"));
        ModelAndView mav = new ModelAndView("/finance/webownerperiodbill/list");
        mav.addObject("list", list);
        return mav;
    }
}
