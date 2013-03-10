package com.lemon.union.operator.controller;

import com.lemon.union.finance.dto.WebownerBillDTO;
import com.lemon.union.operator.dto.ProductRealtimeDTO;
import com.lemon.union.operator.dto.RealtimeDTO;
import com.lemon.union.operator.service.ProductRealtimeService;
import com.lemon.union.operator.service.RealtimeService;
import com.lemon.union.tools.Page;
import com.lemon.union.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-4
 * Time: 下午10:41
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/operator/realtime")
public class RealtimeController {

    @Autowired
    RealtimeService service;


    @RequestMapping("/query")
    public ModelAndView query(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int pageNum = 1;
        int pageSize = 50;
        if (request.getParameter("pageNum") != null) {
            pageNum = new Integer(request.getParameter("pageNum"));
        }
        List<RealtimeDTO> list = service.query(pageNum, pageSize);
        int count = service.queryCount();
        ModelAndView mav = new ModelAndView("/operator/realtime/list");
        Page<RealtimeDTO> page = PageUtil.getPage(count, pageNum, list, pageSize);
        mav.addObject("pageHtml", PageUtil.toPageHtml(page, request.getRequestURI(), request.getQueryString()));
        mav.addObject("list", list);
        return mav;
    }

}
