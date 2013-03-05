package com.lemon.union.operator.controller;

import com.lemon.union.operator.dto.ProductRealtimeDTO;
import com.lemon.union.operator.service.ProductRealtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
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


    @RequestMapping("/query")
    public ModelAndView query(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        List<ProductRealtimeDTO> list = service.query();
        ModelAndView mav = new ModelAndView("/operator/provinceincome/list");
        mav.addObject("list", list);
        return mav;
    }

}
