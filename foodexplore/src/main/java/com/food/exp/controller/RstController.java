package com.food.exp.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RstController {

	@Autowired
	ServletContext application;
	
	@GetMapping("/rst")
	public String rst04(Model model) {
		model.addAttribute("apiKey", "8b9300f39b51a93d7bd9c98a76473b1d");
		return "/rst/rst";
	}

}
