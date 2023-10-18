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
		
<<<<<<< HEAD
		@GetMapping("/rev")
		public String rev() {
			return "/rev/rev";
		}
=======
		@GetMapping("/template")
		public String template_thymeleaf(){
			return "sample_template/template_thymeleaf";
		}

>>>>>>> 97ded5ba63e7852c60387cbce2d389fa3dd3433f

}
