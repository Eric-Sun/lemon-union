package com.lemon.union.operator.controller;

import com.lemon.union.operator.dto.DeductScaleDTO;
import com.lemon.union.operator.service.DeductScaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-2-27
 * Time: 下午6:54
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/operator/deduct")
public class DeductScaleController {

    @Autowired
    DeductScaleService service;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) {
        List<DeductScaleDTO> list = service.list();
        ModelAndView mav = new ModelAndView("/operator/deduct/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping("/show")
    public ModelAndView show(HttpServletRequest request,
                             HttpServletResponse response) {
        Long id = new Long(request.getParameter("id"));
        DeductScaleDTO dto = service.show(id);
        ModelAndView mav = new ModelAndView("/operator/deduct/show");
        mav.addObject("dto", dto);
        return mav;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request,
                               HttpServletResponse response) {
        Long id = new Long(request.getParameter("id"));
        service.delete(id);
        ModelAndView mav = new ModelAndView("forward:/operator/deduct/list");
        return mav;
    }

    @RequestMapping("/create")
    public ModelAndView create(HttpServletRequest request,
                               HttpServletResponse response) {
        long wid = new Long(request.getParameter("wid"));
        long pid = new Long(request.getParameter("pid"));
        int offbase = new Integer(request.getParameter("offbase"));
        int offno = new Integer(request.getParameter("offno"));

        int status = 1;
        service.create(wid, pid, offbase, offno, status);
        ModelAndView mav = new ModelAndView("forward:/operator/deduct/list");
        return mav;
    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request,
                               HttpServletResponse response) {
        long id = new Long(request.getParameter("id"));
        long wid = new Long(request.getParameter("wid"));
        long pid = new Long(request.getParameter("pid"));
        int offbase = new Integer(request.getParameter("offbase"));
        int offno = new Integer(request.getParameter("offno"));
        int status = 1;
        service.update(id, wid, pid, offbase, offno, status);
        ModelAndView mav = new ModelAndView("forward:/operator/deduct/list");
        return mav;
    }
}
