package com.food.exp.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class RevController {

	@Autowired
	ServletContext application;
	
	@GetMapping("/rev")
	public String rev() {
		return "/rev/rev";
	}
	
	@GetMapping("/revedit")
	public String rev_edit() {
		return "/rev/rev_edit";
	}

}
