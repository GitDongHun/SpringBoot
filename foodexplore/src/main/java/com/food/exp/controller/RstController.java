package com.food.exp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.food.exp.dto.RstDTO;
import com.food.exp.dto.RstTempDTO;
import com.food.exp.service.RstService;

@Controller
public class RstController {

	@Autowired
	ServletContext application;

	@Autowired
	RstService rstService;

	@GetMapping("/rst")
	public String rst_main(HttpSession session,Model model) {

		// 이 위치에서 현재위치로 검색할지, 다른위치로 검색할지 구분할 함수 만들어야함
		
		// api키 가지고오기
		model.addAttribute("apiKey", "8b9300f39b51a93d7bd9c98a76473b1d");
		model.addAttribute("searchinput", "");
		System.out.println("RstController 실행-GET 현재위치, 다른위치 검색할 함수 만들어야함");
		return "/rst/rst";
	}

	@PostMapping("/rst")
	public String rst_post(@RequestParam("query") String rst_query, Model model,HttpSession session) {
		model.addAttribute("apiKey", "8b9300f39b51a93d7bd9c98a76473b1d");

		if (rst_query != "") {
			model.addAttribute("searchinput", rst_query);
			session.setAttribute("searchinput", rst_query);
		} else {
			model.addAttribute("searchinput", "");
			session.setAttribute("searchinput", "");
		}
		System.out.println("RstController 실행-POST 키워드로 검색, 키워드는"+rst_query);
		return "/rst/rst";
	}

	@PostMapping("/htmltodb")
	public String htmltodb(@RequestBody List<RstTempDTO> rsttempList) {
		List<RstDTO> rstDTOList = new ArrayList<>();
			for (RstTempDTO rstTempDTO : rsttempList) {
			// 01. rstDTO에 rsttempList값을 재전달
			RstDTO rstDTO = new RstDTO();
			rstDTO.setRst_id((rstTempDTO.getId() != null) ? rstTempDTO.getId() : "");
			rstDTO.setRst_name((rstTempDTO.getPlace_name() != null) ? rstTempDTO.getPlace_name() : "");
			rstDTO.setRst_cate((rstTempDTO.getCategory_name() != null) ? rstTempDTO.getCategory_name() : "");
			rstDTO.setRst_phone((rstTempDTO.getPhone() != null) ? rstTempDTO.getPhone() : "");
			rstDTO.setRst_addr1((rstTempDTO.getRoad_address_name() != null) ? rstTempDTO.getRoad_address_name() : "");
			rstDTO.setRst_addr2((rstTempDTO.getAddress_name() != null) ? rstTempDTO.getAddress_name() : "");

			// rstDTO.setX(rstTempDTO.getX());
			// rstDTO.setY(rstTempDTO.getY());
			// rstDTO.setPlaceUrl(rstTempDTO.getPlace_url());
			// rstDTO.setDistance(rstTempDTO.getDistance());
			// rstDTO.setCategoryGroupCode(rstTempDTO.getCategory_group_code());
			// rstDTO.setCategoryGroupName(rstTempDTO.getCategory_group_name());
			rstDTOList.add(rstDTO);
		}
		for (RstDTO dto : rstDTOList) {
			rstService.insertOrUpdateRestaurant(dto);
		}
		return "/rst/rst";
	}

}
