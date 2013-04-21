package com.lemon.union.content.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lemon.union.operator.dto.ProductRealtimeDTO;
import com.lemon.union.tools.Page;
import com.lemon.union.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lemon.union.content.dto.LemNewsDTO;
import com.lemon.union.content.service.NewsService;

@Controller
@RequestMapping("/content/new")
public class NewController {

    int pageSize = 15;

    @Autowired
    NewsService service;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) {
        int pageNum = 1;
        if (request.getParameter("pageNum") != null)
            pageNum = new Integer(request.getParameter("pageNum"));
        List<LemNewsDTO> list = service.list(pageNum, pageSize);
        int count = service.count();

        ModelAndView mav = new ModelAndView("/content/new/list");
        mav.addObject("list", list);
        Page<LemNewsDTO> page = PageUtil.getPage(count, pageNum, list, pageSize);
        mav.addObject("pageHtml", PageUtil.toPageHtml(page, request.getRequestURI(), request.getQueryString()));
        return mav;
    }

    @RequestMapping("/create")
    public ModelAndView create(HttpServletRequest request,
                               HttpServletResponse response) {
        String title = request.getParameter("title");
        String orign = request.getParameter("orign");
        String editor = request.getParameter("editor");
        String link = request.getParameter("link");
        String brief = request.getParameter("brief");
        String content = request.getParameter("content");
        String catalogid = request.getParameter("catalogid");
        String classid = "sys_news";
        service.create(catalogid, classid, title, brief, content, orign,
                editor, link);
        ModelAndView mav = new ModelAndView("forward:/content/new/list");
        return mav;
    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request,
                               HttpServletResponse response) {
        int id = new Integer(request.getParameter("id"));
        String title = request.getParameter("title");
        String orign = request.getParameter("orign");
        String editor = request.getParameter("editor");
        String link = request.getParameter("link");
        String brief = request.getParameter("brief");
        String content = request.getParameter("content");
        String catalogid = request.getParameter("catalogid");
        String classid = "sys_news";
        service.update(id, catalogid, classid, title, brief, content, orign,
                editor, link);
        ModelAndView mav = new ModelAndView("forward:/content/new/list");
        return mav;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request,
                               HttpServletResponse response) {
        int id = new Integer(request.getParameter("id"));
        ModelAndView mav = new ModelAndView("forward:/content/new/list");
        service.delete(id);
        return mav;
    }

    @RequestMapping("/show")
    public ModelAndView show(HttpServletRequest request,
                             HttpServletResponse response) {
        int id = new Integer(request.getParameter("id"));
        LemNewsDTO dto = service.show(id);
        ModelAndView mav = new ModelAndView("/content/new/show");
        mav.addObject("dto", dto);
        return mav;
    }

}
