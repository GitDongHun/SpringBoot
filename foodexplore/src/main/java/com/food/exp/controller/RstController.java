package com.food.exp.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RstController {

	@Autowired
	ServletContext application;
	
	@GetMapping("/rst")
	public String rev() {
		return "/rst/rst";
	}
	
	

}
