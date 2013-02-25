package com.lemon.union.income.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/income/product")
public class ProductIncomeController {

	
	@RequestMapping("/query")
	public String query(HttpServletRequest request, HttpServletResponse response){
		
		
		
		return null;
	}
}
