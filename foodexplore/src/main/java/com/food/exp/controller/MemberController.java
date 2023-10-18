package com.food.exp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("/joinform")
	public String main() {
		System.out.println("MemberController");
		return "member/joinform";
	}
}
