package com.food.exp.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.exp.dto.FileDTO;
import com.food.exp.dto.MainDTO;
import com.food.exp.service.MainService;
import com.food.exp.service.UploadService;

@Controller
public class MainController {

	@Autowired
	ServletContext application;
	
	@Autowired
	private MainService service;
	
	@Autowired
	UploadService uploadService;

	
	@GetMapping("/main")
	public String main(Model model, HttpSession session) {
		System.out.println("MainController 실행");
			
		List<MainDTO> top10Rst = service.top10Rst();
		model.addAttribute("top10Rst", top10Rst);
		
		// 이미지 가져오기
	    String rst_id = (String) session.getAttribute("rst_id");
	    List<FileDTO> attachList = uploadService.getFilesRst(rst_id);
	    model.addAttribute("attachList", attachList);
		    
		return "main";
	}
	
	@RestController
	public class RestaurantController {
	    @Autowired
	    private MainService mainService;

	    @GetMapping("/api/top10Restaurants")
	    public List<MainDTO> getTop10Restaurants() {
	        return mainService.top10Rst();
	    }
	}

	
	@GetMapping("/template")
	public String template_thymeleaf(){
		return "sample_template/template_thymeleaf";
	}
}