package com.lemon.union.finance.controller;

import com.lemon.union.finance.dto.AdownerBillDTO;
import com.lemon.union.finance.dto.BillDTO;
import com.lemon.union.finance.dto.WebownerBillDTO;
import com.lemon.union.finance.service.AdownerBillService;
import com.lemon.union.finance.service.WebownerBillService;
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
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-3-5
 * Time: 下午10:14
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/finance/webownerbill")
public class WebownerBillController {
    @Autowired
    WebownerBillService service;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping("/query")
    public ModelAndView query(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(value = "wid", required = true, defaultValue = "") String wid,
                              @RequestParam(value = "pid", required = true, defaultValue = "") String pid) throws ParseException {
        int pageNum = 1;
        int pageSize = 50;
        if (request.getParameter("pageNum") != null) {
            pageNum = new Integer(request.getParameter("pageNum"));
        }
        List<WebownerBillDTO> list = service.query(wid, pid, pageNum, pageSize);
        int count = service.queryCount();
        ModelAndView mav = new ModelAndView("/finance/webownerbill/list");
        Page<WebownerBillDTO> page = PageUtil.getPage(count, pageNum, list, pageSize);
        mav.addObject("pageHtml", PageUtil.toPageHtml(page, request.getRequestURI(), request.getQueryString()));
        mav.addObject("list", list);
        return mav;
    }


    @RequestMapping("/pay")
    public ModelAndView pay(HttpServletRequest request, HttpServletResponse response) {
        String[] ids = request.getParameterValues("ids");
        int type = new Integer(request.getParameter("type"));
        if (ids.length == 0) {
            ModelAndView mav = new ModelAndView("/finance/webownerbill/list");
            return mav;
        }
        // type 1 支付 0 取消支付
        StringBuffer sb = new StringBuffer();
        for (String s : ids) {
            sb.append(s).append(",");
        }
        service.pay(type, sb.substring(0, sb.length() - 1));
        ModelAndView mav = new ModelAndView("redirect:/finance/webownerbill/query");
        return mav;
    }
}
