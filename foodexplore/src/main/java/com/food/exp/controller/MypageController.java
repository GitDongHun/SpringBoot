package com.food.exp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {

	@GetMapping("/mypage")
	public String mypage() {
		//System.out.println("mypageController");
		return "member/mypage";
	}
	
	@GetMapping("/myLikes")
	public String myLikes() {
		//System.out.println("myLikesController");
		return "member/myLikes";
	}

}
