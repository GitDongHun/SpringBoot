package com.food.exp.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RstController {

	@Autowired
	ServletContext application;
	

	
	
	@GetMapping("/rst")
	public String rst_main(Model model) {
		model.addAttribute("apiKey", "8b9300f39b51a93d7bd9c98a76473b1d");
		model.addAttribute("keyword","국밥");
		System.out.println("RstController 실행-GET");
		return "/rst/rst";
	}
	
	@PostMapping("/rst")
	public String rst_post(@RequestParam("query") String rst_query,Model model) {
		model.addAttribute("apiKey", "8b9300f39b51a93d7bd9c98a76473b1d");
		
		if(rst_query!="") {
			model.addAttribute("keyword",rst_query);
		}else
		{
			model.addAttribute("keyword","국밥");
		}
		System.out.println("RstController 실행-POST");
		return "/rst/rst";
	}

}
