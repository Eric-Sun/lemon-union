package com.lemon.union.content.controller;

import com.lemon.union.content.dto.ProductDTO;
import com.lemon.union.content.service.ProductService;
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
 * Date: 13-2-26
 * Time: 下午11:50
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/content/product")
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/show")
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response) {
        Long id = new Long(request.getParameter("pid"));
        ProductDTO dto = service.show(id);
        ModelAndView mav = new ModelAndView("/content/adcode/show");
        mav.addObject("dto", dto);
        return mav;
    }

    @RequestMapping("/create")
    public ModelAndView create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String thumbnail = request.getParameter("thumbnail");
        String brief = request.getParameter("brief");
        String commission = request.getParameter("commission");
        service.create(name, thumbnail, brief, commission, 1);
        ModelAndView mav = new ModelAndView("forward:/content/adcode/list");
        return mav;
    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
        Long id = new Long(request.getParameter("pid"));
        String name = request.getParameter("name");
        String thumbnail = request.getParameter("thumbnail");
        String brief = request.getParameter("brief");
        String commission = request.getParameter("commission");
        service.update(id, name, thumbnail, brief, commission, 1);
        ModelAndView mav = new ModelAndView("forward:/content/adcode/list");
        return mav;
    }

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        List<ProductDTO> list = service.list();
        ModelAndView mav = new ModelAndView("/content/adcode/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {
        long id = new Long(request.getParameter("pid"));
        service.delete(id);
        ModelAndView mav = new ModelAndView("forward:/content/adcode/list");
        return mav;
    }

}
