package com.food.exp.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@Autowired
	ServletContext application;
	
		@GetMapping("/main")
		public String main() {
			System.out.println("MainController 실행");
			return "main";
		}
		
		@GetMapping("/template")
		public String template_thymeleaf(){
			return "sample_template/template_thymeleaf";
		}
		

		
		
}
