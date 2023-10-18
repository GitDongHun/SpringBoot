package com.food.exp.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	ServletContext application;
	
		@GetMapping("/main")
		public String main() {
			return "main";
		}
		
		@GetMapping("/rev")
		public String rev() {
			return "/rev/rev";
		}

}
