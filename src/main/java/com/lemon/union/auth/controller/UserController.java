package com.lemon.union.auth.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.lemon.union.auth.vo.UserVO;
import com.lemon.union.service.RoleService;
import com.lemon.union.service.UserService;

@Controller
@RequestMapping("/auth/user")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		List<UserVO> userList = userService.getAllUsers();
		ModelAndView mav = new ModelAndView("/auth/user/list");
		mav.addObject("userList", userList);
		return mav;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		long userId = new Long(req.getParameter("userId"));
		userService.delete(userId);
		ModelAndView mav = new ModelAndView("redirect:/auth/user/list");
		return mav;
	}

	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		long userId = new Long(req.getParameter("userId"));
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String roleName = req.getParameter("roleName");
		long roleId = roleService.getRoleId(roleName);

		userService.update(userId, name, pwd, roleId);
		ModelAndView mav = new ModelAndView("redirect:/auth/user/list");
		return mav;
	}

	@RequestMapping("/create")
	public ModelAndView create(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String roleName = req.getParameter("roleName");
		long roleId = roleService.getRoleId(roleName);
		ModelAndView mav = new ModelAndView("redirect:/auth/user/list");
		if (roleId == -1) {
		} else {
			userService.create(name, pwd, roleId);
		}
		return mav;
	}

	@RequestMapping("/fetch")
	public ModelAndView fetch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		long userId = new Long(req.getParameter("userId"));
		UserVO user = userService.getUser(userId);
		resp.getWriter().write(JSON.toJSONString(user));
		resp.flushBuffer();
		return null;
	}

}
