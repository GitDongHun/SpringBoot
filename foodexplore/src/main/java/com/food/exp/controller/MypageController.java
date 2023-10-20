package com.food.exp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {

	@GetMapping("/main")
	public String mypage() {
		//System.out.println("mypageController");
		return "member/mypage";
	}
	
	@GetMapping("/myLikes")
	public String myLikes() {
		//System.out.println("myLikesController");
		return "member/myLikes";
	}

	@GetMapping("/changeInfo")
	public String changeInfo() {
		return "member/changeInfo";
	}
}
