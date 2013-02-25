package com.lemon.union.content.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lemon.union.content.dto.AdownerDTO;
import com.lemon.union.content.service.AdownerService;

@Controller
@RequestMapping("/content/adowner")
public class AdownerController {

	@Autowired
	AdownerService service;

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) {
		List<AdownerDTO> list = service.list();
		ModelAndView mav = new ModelAndView("/content/adowner/list");
		mav.addObject("list", list);
		return mav;
	}

    @RequestMapping("/show")
    @ResponseBody
    public String show(HttpServletRequest request,
                             HttpServletResponse response) {
        Long id = new Long(request.getParameter("id"));
        AdownerDTO dto = service.show(id);
        return JSON.toJSONString(dto);
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request,
                             HttpServletResponse response) {
        Long id = new Long(request.getParameter("id"));
        service.delete(id);
        ModelAndView mav = new ModelAndView("forward:/content/adowner/list");
        return mav;
    }

    @RequestMapping("/create")
    public ModelAndView create(HttpServletRequest request,
                             HttpServletResponse response) {
        String name = request.getParameter("name");
        String company = request.getParameter("company");
        String brief = request.getParameter("brief");
        int status = new Integer(request.getParameter("status"));
        service.create(name,company,brief,status);
        ModelAndView mav = new ModelAndView("forward:/content/adowner/list");
        return mav;
    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request,
                             HttpServletResponse response) {
        String name = request.getParameter("name");
        long id = new Long(request.getParameter("id"));
        String company = request.getParameter("company");
        String brief = request.getParameter("brief");
        ModelAndView mav = new ModelAndView("forward:/content/adowner/list");
        return mav;
    }

}
