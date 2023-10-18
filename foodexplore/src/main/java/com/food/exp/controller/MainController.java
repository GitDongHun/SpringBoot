package com.food.exp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

		@GetMapping("main")
		public String main() {
			return "main";
		}
		
		@GetMapping("/template")
		public String template_thymeleaf(){
			return "sample_template/template_thymeleaf";
		}


}
