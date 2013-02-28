package com.lemon.union.content.controller;

import com.alibaba.fastjson.JSON;
import com.lemon.union.content.dto.AdownerCodeDTO;
import com.lemon.union.content.service.AdownerCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-2-25
 * Time: 下午6:42
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/content/adcode")
public class AdownerCodeController {

    @Autowired
    AdownerCodeService service;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) {
        List<AdownerCodeDTO> list = service.list();
        ModelAndView mav = new ModelAndView("/content/adcode/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request,
                               HttpServletResponse response) {
        long id = new Long(request.getParameter("id"));
        service.delete(id);
        ModelAndView mav = new ModelAndView("forward:/content/adcode/list");
        return mav;
    }

    @RequestMapping("/show")
    public ModelAndView show(HttpServletRequest request,
                             HttpServletResponse response) {
        long id = new Long(request.getParameter("id"));
        AdownerCodeDTO dto = service.show(id);
        ModelAndView mav = new ModelAndView("/content/adcode/show");
        mav.addObject("dto", dto);
        return mav;
    }


    @RequestMapping("/create")
    public ModelAndView create(HttpServletRequest request,
                               HttpServletResponse response) {
        long adownerid = new Long(request.getParameter("adownerid"));
        long pid = new Long(request.getParameter("pid"));
        String servicecode = request.getParameter("servicecode");
        String servicename = request.getParameter("servicename");
        String servicefee = request.getParameter("servicefee");
        String ownerfee = request.getParameter("ownerfee");
        String ordercode = request.getParameter("ordercode");
        String orderdest = request.getParameter("orderdest");
        String servicephone = request.getParameter("servicephone");
        String brief = request.getParameter("brief");
        String offnum = request.getParameter("offnum");
        String offbase = request.getParameter("offbase");
        String remark = request.getParameter("remark");
        service.create(adownerid, pid, servicecode, servicename, servicefee, ownerfee, ordercode, orderdest, brief, offnum, offbase, servicephone, remark);
        ModelAndView mav = new ModelAndView("forward:/content/adcode/list");
        return mav;
    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request,
                               HttpServletResponse response) {
        long id = new Long(request.getParameter("id"));
        long adownerid = new Long(request.getParameter("adownerid"));
        long pid = new Long(request.getParameter("pid"));
        String servicecode = request.getParameter("servicecode");
        String servicename = request.getParameter("servicename");
        String servicefee = request.getParameter("servicefee");
        String ownerfee = request.getParameter("ownerfee");
        String ordercode = request.getParameter("ordercode");
        String orderdest = request.getParameter("orderdest");
        String brief = request.getParameter("brief");
        String offnum = request.getParameter("offnum");
        String offbase = request.getParameter("offbase");
        String servicephone = request.getParameter("servicephone");
        String remark = request.getParameter("remark");
        service.update(id, adownerid, pid, servicecode, servicename, servicefee, ownerfee, ordercode, orderdest, brief, offnum, offbase, servicephone, remark);
        ModelAndView mav = new ModelAndView("forward:/content/adcode/list");
        return mav;
    }
}
