package com.food.exp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.food.exp.dto.MemberDTO;

@Controller
public class MemberController {

	@GetMapping("/joinform")
	public String join() {
		System.out.println("MemberController");
		return "member/joinform";
	}
	
	// 2. 글쓰기
	@PostMapping(value = "/join")
	public String write(MemberDTO dto) {
		//int num = service.noticeWrite(notice);
		return "redirect:main";
	}

	@GetMapping("/loginform")
	public String loginform() {
		System.out.println("MemberController");
		return "member/loginform";
	}
}
