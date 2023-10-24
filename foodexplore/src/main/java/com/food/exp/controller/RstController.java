package com.food.exp.controller;

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

@Controller
public class RstController {

	@Autowired
	ServletContext application;
	
	@GetMapping("/rst")
	public String rst_main(Model model) {
		
		//이 위치에서 현재위치로 검색할지, 다른위치로 검색할지 구분할 함수 만들어야함
		
		//api키 가지고오기
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
	
	@PostMapping("/htmltodb")
	public void htmltodb(@RequestBody List<RstDTO> rst){
		
		
	}

	/*
	@GetMapping("/crolling")
	public String crolling(Model model) {
			// Selenium 사용하여 크롤링 
			//>>> Firefox 브라우저 설치하고, Firefox Driver 파일인 geckodriver.exe를 하단에 설정한 경로에 넣어야 작동가능
		   // Selenium 설정
	    System.setProperty("webdriver.gecko.driver", "src/main/resources/templates/rst/crolling/geckodriver.exe");
	    FirefoxOptions options = new FirefoxOptions();
	    options.setHeadless(true); // Headless 모드로 설정
	    WebDriver driver = new FirefoxDriver(options);

	    // 크롤링 대상 웹 페이지 열기
	    driver.get("https://www.diningcode.com/list.dc?query=%EB%82%B4%EC%A3%BC%EB%B3%80");

	    try {
	        // WebDriverWait를 사용하여 요소가 나타날 때까지 대기
	        WebDriverWait wait = new WebDriverWait(driver, 15);
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sc-gYrpUN")));

	        // 크롤링 로직
	        String data = element.getText();
	        System.out.println("Crawled Data: " + data);

	        // 모델에 데이터 추가
	        model.addAttribute("data", data);
	    } catch (Exception e) {
	        // 요소를 찾지 못한 경우 처리할 예외 코드
	        e.printStackTrace();
	    } finally {
	        // 브라우저 닫기
	        driver.quit();
	    }

	    return "/rst/crolling_html";
	}
*/
	
}
