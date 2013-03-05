package com.lemon.union.finance.controller;

import com.lemon.union.finance.dto.BillDTO;
import com.lemon.union.finance.service.BillService;
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
 * Date: 13-3-5
 * Time: 下午7:11
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/finance/bill")
public class BillController {

    @Autowired
    BillService service;

    @RequestMapping("/query")
    public ModelAndView query(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        List<BillDTO> list = service.query();
        ModelAndView mav = new ModelAndView("/finance/bill/list");
        mav.addObject("list", list);
        return mav;
    }
}
