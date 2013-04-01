package com.lemon.union.operator.controller;

import com.lemon.union.operator.dto.DeductScaleDTO;
import com.lemon.union.operator.service.DeductScaleService;
import com.lemon.union.utils.HttpUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    private static Log LOG = LogFactory.getLog(DeductScaleController.class);

    @Value("${deduct.url}")
    private String DEDUCT_URL;


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
        call();
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
        call();
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
        call();
        return mav;
    }


    private void call() {
        try {
            String s = HttpUtil.requestHttpContent(DEDUCT_URL);
            LOG.info("call url=" + DEDUCT_URL + " response=" + s);
            System.out.println("call url=" + DEDUCT_URL + " response=" + s);
        } catch (IOException e) {
            LOG.error("call deduct url error.", e);
        }

    }
}
