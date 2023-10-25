package com.food.exp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

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
	public String rst_main(Model model) {

		// 이 위치에서 현재위치로 검색할지, 다른위치로 검색할지 구분할 함수 만들어야함

		// api키 가지고오기
		model.addAttribute("apiKey", "8b9300f39b51a93d7bd9c98a76473b1d");
		model.addAttribute("keyword", "");
		System.out.println("RstController 실행-GET");
		return "/rst/rst";
	}

	@PostMapping("/rst")
	public String rst_post(@RequestParam("query") String rst_query, Model model) {
		model.addAttribute("apiKey", "8b9300f39b51a93d7bd9c98a76473b1d");

		if (rst_query != "") {
			model.addAttribute("keyword", rst_query);
		} else {
			model.addAttribute("keyword", "");
		}
		System.out.println("RstController 실행-POST");
		return "/rst/rst";
	}

	@PostMapping("/htmltodb")
	public String htmltodb(@RequestBody List<RstTempDTO> rsttempList) {
		List<RstDTO> rstDTOList = new ArrayList<>();
		System.out.println("===============================================");
		System.out.println("00. debug: 서버에서 그대로 가져온 key와 value");
		for (RstTempDTO rstTempDTO : rsttempList) {

			// 00. debug: 잘왔는지 데이터 출력
			System.out.println(rstTempDTO.getAll());

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

		System.out.println("===============================================");
		System.out.println("01. 서버에서 가져온 데이터를 rstDTO로 옮기고 재출력 ");
		for (RstDTO dto : rstDTOList) {
			System.out.println(dto.getAll());
		}
		System.out.println("===============================================");
		System.out.println("02. Mybatis 사용하여 DB로 전송 ");
		for (RstDTO dto : rstDTOList) {
			System.out.println();
			rstService.saveRestaurant(dto);
		}
		return "/rst/rst";
	}

}
