package com.lemon.union.auth.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.lemon.union.auth.vo.PermissionVO;
import com.lemon.union.auth.vo.RoleVO;
import com.lemon.union.auth.vo.UserVO;
import com.lemon.union.service.PermissionService;
import com.lemon.union.service.RoleService;

@Controller
@RequestMapping("/auth/role")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@Autowired
	PermissionService permissionService;

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		List<RoleVO> userList = roleService.getAllRole();
		ModelAndView mav = new ModelAndView("/auth/role/list");
		mav.addObject("roleList", userList);
		return mav;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		long id = new Long(req.getParameter("id"));
		roleService.delete(id);
		ModelAndView mav = new ModelAndView("redirect:/auth/role/list");
		return mav;
	}

	@RequestMapping("/create")
	public ModelAndView create(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String name = req.getParameter("name");
		String[] permissionIdArray = req
				.getParameterValues("permissionIdArray");
		roleService.create(name, permissionIdArray);
		ModelAndView mav = new ModelAndView("redirect:/auth/role/list");
		return mav;
	}

	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		long id = new Long(req.getParameter("id"));
		String name = req.getParameter("name");
		String[] permissionIdArray = req
				.getParameterValues("permissionIdArray");
		roleService.update(id, name, permissionIdArray);
		ModelAndView mav = new ModelAndView("redirect:/auth/role/list");
		return mav;
	}

	@RequestMapping("/fetch")
	@ResponseBody
	public String fetch(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		long id = new Long(req.getParameter("id"));
		RoleVO roleVO = roleService.fetchRole(id);
		List<PermissionVO> pList = permissionService.getAllPermission();
		for( PermissionVO vo : pList){
			if(roleVO.getPermissionList().contains(vo))
				vo.setSelected(true);
		}
		roleVO.setPermissionList(pList);
		return JSON.toJSONString(roleVO);
	}

}
