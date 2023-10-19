package com.food.exp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.food.exp.dto.MemberDTO;
import com.food.exp.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService service;

	@GetMapping("/joinform")
	public String join() {
		System.out.println("MemberController");
		return "member/joinform";
	}
	
	// 2. 글쓰기
	@PostMapping(value = "/join")
	public String join(MemberDTO dto) {
		System.out.println(dto.toString());
		int num = service.join(dto);
		System.out.println("join "+num);
		return "redirect:/main";
	}

	@GetMapping("/loginform")
	public String loginform() {
		System.out.println("MemberController");
		return "member/loginform";
	}
}
