package com.lemon.union.content.controller;

import com.lemon.union.content.dto.WebownerDTO;
import com.lemon.union.content.service.WebownerService;
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
 * Date: 13-2-27
 * Time: 下午10:44
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/content/webowner")
public class WebownerController {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");

    @Autowired
    WebownerService service;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        List<WebownerDTO> list = service.list();
        ModelAndView mav = new ModelAndView("/content/webowner/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping("/show")
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response) {
        long wid = new Long(request.getParameter("wid"));
        WebownerDTO dto = service.show(wid);
        ModelAndView mav = new ModelAndView("/content/webowner/show");
        mav.addObject("dto", dto);
        return mav;
    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        long wid = new Long(request.getParameter("wid"));
        String truename = request.getParameter("truename");
        String mobile = request.getParameter("mobile");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        String qq = request.getParameter("qq");
        String sitename = request.getParameter("sitename");
        String siteurl = request.getParameter("siteurl");
        String sitetype = request.getParameter("sitetype");
        String bankaddr = request.getParameter("bankaddr");
        String bankcard = request.getParameter("bankcard");
        String account = request.getParameter("account");
        String regtime = request.getParameter("regtime");
        String channel = request.getParameter("channel");
        String remark = request.getParameter("remark");
        int msgCount = 0;
        if (request.getParameter("msgCount") != null)
            msgCount = new Integer(request.getParameter("msgCount"));
        service.update(wid, truename, mobile, telephone, address, qq, sitename,
                siteurl, sitetype, bankaddr, bankcard, account, sdf.parse(regtime), channel,
                remark,msgCount);
        ModelAndView mav = new ModelAndView("redirect:/content/webowner/list");
        return mav;
    }

    @RequestMapping("/pass")
    public ModelAndView pass(HttpServletRequest request, HttpServletResponse response) {
        long wid = new Long(request.getParameter("wid"));
        service.pass(wid);
        ModelAndView mav = new ModelAndView("redirect:/content/webowner/list");
        return mav;
    }

    @RequestMapping("/notpass")
    public ModelAndView notpass(HttpServletRequest request, HttpServletResponse response) {
        long wid = new Long(request.getParameter("wid"));
        service.notpass(wid);
        ModelAndView mav = new ModelAndView("redirect:/content/webowner/list");
        return mav;
    }

    @RequestMapping("/stop")
    public ModelAndView stop(HttpServletRequest request, HttpServletResponse response) {
        long wid = new Long(request.getParameter("wid"));
        service.stop(wid);
        ModelAndView mav = new ModelAndView("redirect:/content/webowner/list");
        return mav;
    }

    @RequestMapping("/resume")
    public ModelAndView resume(HttpServletRequest request, HttpServletResponse response) {
        long wid = new Long(request.getParameter("wid"));
        service.resume(wid);
        ModelAndView mav = new ModelAndView("redirect:/content/webowner/list");
        return mav;
    }
}
