package com.lemon.union.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lemon.union.tools.MD5Util;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lemon.union.service.UserService;

@Controller
@RequestMapping("/passport")
public class PassportController {

    private static Logger LOG = Logger.getLogger(PassportController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        return "/passport/login";

    }

    @RequestMapping("/doLogin")
    public String doLogin(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {

        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        pwd = MD5Util.get(pwd);

        UsernamePasswordToken token = new UsernamePasswordToken(name, pwd, true);
        LOG.info(name + " " + pwd);
        try {
            SecurityUtils.getSubject().login(token);
            SecurityUtils.getSubject().getSession().setTimeout(3600000);
            req.getSession().setAttribute("name", name);
        } catch (AuthenticationException e) {
            LOG.error("login error. userName=" + name + " userPwd=" + pwd);
            return "/passport/login";
        }
        return "/passport/home";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        req.getSession().removeAttribute("name");
        SecurityUtils.getSubject().logout();
        return "/passport/login";

    }
}
