package com.lemon.union.auth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.lemon.union.auth.vo.PermissionVO;
import com.lemon.union.auth.vo.RoleVO;
import com.lemon.union.service.PermissionService;

@Controller
@RequestMapping("/auth/permission")
public class PermissionController {

	@Autowired
	PermissionService permissionService;

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		List<PermissionVO> permissionList = permissionService
				.getAllPermission();
		ModelAndView mav = new ModelAndView("/auth/permission/list");
		mav.addObject("permissionList", permissionList);
		return mav;
	}
	
	
	@RequestMapping("/jlist")
	public String jlist(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		List<PermissionVO> permissionList = permissionService
				.getAllPermission();
		resp.getWriter().write(JSON.toJSONString(permissionList));
		resp.flushBuffer();
		resp.setCharacterEncoding("UTF-8");
		return null;
	}

	@RequestMapping("/fetch")
	public ModelAndView fetch(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		long id = new Long(req.getParameter("id"));
		PermissionVO permissionVO = permissionService.fetch(id);
		ModelAndView mav = new ModelAndView("/auth/permission/list");
		mav.addObject("permissionVO", permissionVO);
		return mav;
	}

	@RequestMapping("/create")
	public ModelAndView create(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String name = req.getParameter("name");
		String url = req.getParameter("url");
		permissionService.create(name, url);
		ModelAndView mav = new ModelAndView("/auth/permission/list");
		return mav;
	}

	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		long id = new Long(req.getParameter("id"));
		String name = req.getParameter("name");
		String url = req.getParameter("url");
		permissionService.update(id, name, url);
		ModelAndView mav = new ModelAndView("/auth/permission/list");
		return mav;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		long id = new Long(req.getParameter("id"));
		permissionService.delete(id);
		ModelAndView mav = new ModelAndView("/auth/permission/list");
		return mav;
	}
	
}
