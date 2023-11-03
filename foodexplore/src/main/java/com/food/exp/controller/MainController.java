package com.food.exp.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.food.exp.dto.MainDTO;
import com.food.exp.service.MainService;

@Controller
public class MainController {

	@Autowired
	ServletContext application;
	
	@Autowired
	private MainService service;
	
		@GetMapping("/main")
		public String main(Model model) {
			System.out.println("MainController 실행");
		    List<MainDTO> top10Rst = service.top10Rst();
		    model.addAttribute("top10Rst", top10Rst);
		    return "main";
		}
		
		@GetMapping("/template")
		public String template_thymeleaf(){
			return "sample_template/template_thymeleaf";
		}
		
//		List<MainDTO> top10Rst = service.top10Rst();
//		for(MainDTO restaurant : top10Rst) {
//			String rstRegion = service.getRegionForRestaurant(restaurant.getRst_id());
//			restaurant.setRst_Region(rst_Region);
//		}
//		model.addAttribute("top10Rst", top10Rst);
}
