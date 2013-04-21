package com.lemon.union.content.controller;

import com.lemon.union.content.dto.IvrInfoDTO;
import com.lemon.union.content.service.IvrInfoService;
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
 * Date: 13-3-2
 * Time: 下午4:02
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/content/ivrinfo")
public class IvrInfoController {

    @Autowired
    private IvrInfoService service;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) {
        List<IvrInfoDTO> list = service.list();
        ModelAndView mav = new ModelAndView("/content/ivrinfo/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request,
                               HttpServletResponse response) {
        long wid = new Long(request.getParameter("wid"));
        String channel = request.getParameter("channel");
        String servicecode = request.getParameter("servicecode");
        String ivrnum = request.getParameter("ivrnum");
        String feenum = request.getParameter("feenum");
        long id = new Long(request.getParameter("id"));
        service.update(id, wid, channel, servicecode, ivrnum, feenum, ivrnum + feenum, 1);
        ModelAndView mav = new ModelAndView("forward:/content/ivrinfo/list");
        return mav;
    }

    @RequestMapping("/create")
    public ModelAndView create(HttpServletRequest request,
                               HttpServletResponse response) {
        long wid = new Long(request.getParameter("wid"));
        String channel = request.getParameter("channel");
        String servicecode = request.getParameter("servicecode");
        String ivrnum = request.getParameter("ivrnum");
        String feenum = request.getParameter("feenum");
        service.create(wid, channel, servicecode, ivrnum, feenum, ivrnum + feenum, 1);
        ModelAndView mav = new ModelAndView("forward:/content/ivrinfo/list");
        return mav;
    }

    @RequestMapping("/show")
    public ModelAndView show(HttpServletRequest request,
                             HttpServletResponse response) {
        long id = new Long(request.getParameter("id"));
        IvrInfoDTO dto = service.show(id);
        ModelAndView mav = new ModelAndView("/content/ivrinfo/show");
        mav.addObject("dto", dto);
        return mav;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request,
                               HttpServletResponse response) {
        long id = new Long(request.getParameter("id"));
        service.delete(id);
        ModelAndView mav = new ModelAndView("forward:/content/ivrinfo/list");
        return mav;
    }


}
