package com.food.exp.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RevController {

	@Autowired
	ServletContext application;
	
	@GetMapping("/rev")
	public String rev() {
		return "/rev/rev";
	}

}
