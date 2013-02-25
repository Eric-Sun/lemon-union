package com.lemon.union.content.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lemon.union.content.dto.LemCatalogDTO;
import com.lemon.union.content.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/content/catalog")
public class CatalogController {

    @Autowired
    CatalogService service;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) {
        List list = service.list();
        ModelAndView mav = new ModelAndView("/content/catalog/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping("/create")
    public ModelAndView create(HttpServletRequest request,
                               HttpServletResponse response) {
        String id = request.getParameter("id");
        String parentid = request.getParameter("parentid");
        String classid = request.getParameter("classid");
        String name = request.getParameter("name");
        String isleaf = request.getParameter("isleaf");
        String orders = request.getParameter("orders");
        service.create(id, parentid, classid, name, isleaf, orders);
        ModelAndView mav = new ModelAndView("forward:/content/catalog/content");
        return mav;
    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request,
                               HttpServletResponse response) {
        String id = request.getParameter("id");
        String parentid = request.getParameter("parentid");
        String classid = request.getParameter("classid");
        String name = request.getParameter("name");
        String isleaf = request.getParameter("isleaf");
        String orders = request.getParameter("orders");
        service.update(id, parentid, classid, name, isleaf, orders);
        ModelAndView mav = new ModelAndView("forward:/content/catalog/content");
        return null;
    }


    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request,
                               HttpServletResponse response) {
        String id = request.getParameter("id");
        service.delete(new Long(id));
        ModelAndView mav = new ModelAndView("forward:/content/catalog/content");
        return mav;
    }

    @RequestMapping("/show")
    @ResponseBody
    public String show(HttpServletRequest request,
                             HttpServletResponse response) {
        long id = new Long(request.getParameter("id"));
        LemCatalogDTO dto = service.show(id);
        return JSON.toJSONString(dto);
    }
}
