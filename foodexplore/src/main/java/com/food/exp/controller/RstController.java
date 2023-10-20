package com.food.exp.controller;

import javax.servlet.ServletContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	
	@GetMapping("/crolling")
	public String crolling(Model model) {
	      // Selenium 설정
        System.setProperty("webdriver.chrome.driver", "src/main/resources/templates/rst/crolling/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 크롤링 대상 웹 페이지 열기
        driver.get("sc-gYrpUN eJNRnf Poi__List__Wrap");

        // 크롤링 로직
        WebElement element = driver.findElement(By.className("sc-gYrpUN eJNRnf Poi__List__Wrap"));
        String data = element.getText();

        // 모델에 데이터 추가
        model.addAttribute("data", data);

        // 브라우저 닫기
        driver.quit();
		return "/rst/crolling";
	}

}
