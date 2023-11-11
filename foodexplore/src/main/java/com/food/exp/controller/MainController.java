package com.food.exp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	UploadService UploadService;
	
    private final ResourceLoader resourceLoader;

    public MainController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
	
	@GetMapping("/main")
	public String main(Model model, HttpSession session) {
		System.out.println("MainController 실행");
			
		List<MainDTO> top10Rst = service.top10Rst();
		model.addAttribute("top10Rst", top10Rst);
		
		// 리뷰 이미지 가져오기
	    String rst_id = (String) session.getAttribute("rst_id");
	    List<FileDTO> attachList = UploadService.getFilesRst(rst_id);
	    model.addAttribute("attachList", attachList);
		
        // JSON 파일 읽기
        try {
            Resource resource = resourceLoader.getResource("classpath:region.json");
            InputStream inputStream = resource.getInputStream();
            String jsonString = convertInputStreamToString(inputStream);

            // jsonString을 모델에 추가
            model.addAttribute("jsonData", jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return "main";
	}
	
    private String convertInputStreamToString(InputStream inputStream) {
        try (Scanner scanner = new Scanner(inputStream).useDelimiter("\\A")) {
            return scanner.hasNext() ? scanner.next() : "";
        }
    }

	@GetMapping("/template")
	public String template_thymeleaf(){
		return "sample_template/template_thymeleaf";
	}
}