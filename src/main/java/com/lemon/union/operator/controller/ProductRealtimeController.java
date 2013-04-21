package com.lemon.union.operator.controller;

import com.lemon.union.operator.dto.ProductRealtimeDTO;
import com.lemon.union.operator.dto.RealtimeDTO;
import com.lemon.union.operator.service.ProductRealtimeService;
import com.lemon.union.tools.Page;
import com.lemon.union.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
 * Date: 13-3-4
 * Time: 下午10:41
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/operator/productrealtime")
public class ProductRealtimeController {

    @Autowired
    ProductRealtimeService service;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping("/query")
    public ModelAndView query(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(value = "wid", required = true, defaultValue = "-99") Integer wid,
                              @RequestParam(value = "startTime", required = true, defaultValue = "") String startTimeStr,
                              @RequestParam(value = "endTime", required = true, defaultValue = "") String endTimeStr,
                              @RequestParam(value = "mobile", required = true, defaultValue = "") String mobile,
                              @RequestParam(value = "totalincome", required = true, defaultValue = "") String totalincome,
                              @RequestParam(value = "cmdid", required = true, defaultValue = "") String cmdid
    ) throws ParseException {
        int pageNum = 1;
        int pageSize = 100;
        if (request.getParameter("pageNum") != null) {
            pageNum = new Integer(request.getParameter("pageNum"));
        }
        Date startTime = null;
        Date endTime = null;
        if (startTimeStr != null && !startTimeStr.equals("")) {
            startTime = sdf.parse(startTimeStr + " 00:00:00");
            endTime = sdf.parse(endTimeStr + " 23:59:59");
        } else {
            startTime = sdf.parse(sdf0.format(new Date(new Date().getTime())) + " 00:00:00");
            endTime = sdf.parse(sdf0.format(new Date(new Date().getTime())) + " 23:59:59");
        }

        List<ProductRealtimeDTO> list = service.query(startTime, endTime, wid, mobile, totalincome, cmdid, pageNum, pageSize);
        int count = service.queryCount(startTime, endTime, wid, mobile, totalincome, cmdid);
        ModelAndView mav = new ModelAndView("/operator/productrealtime/list");
        Page<ProductRealtimeDTO> page = PageUtil.getPage(count, pageNum, list, pageSize);
        mav.addObject("pageHtml", PageUtil.toPageHtml(page, request.getRequestURI(), request.getQueryString()));
        mav.addObject("list", list);
        return mav;
    }

}
