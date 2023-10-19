package com.food.exp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.food.exp.dto.MemberDTO;
import com.food.exp.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService service;

	//회원가입 페이지로 이동
	@GetMapping("/joinform")
	public String join() {
		System.out.println("MemberController");
		return "member/joinform";
	}
	
	//회원가입
	@PostMapping(value = "/join")
	public String join(MemberDTO dto) {
		int num = service.join(dto);
		return "redirect:/main";
	}
	
	//아이디 중복 체크
	@GetMapping(value = "/idCheck", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String idCheck(@RequestParam("user_email") String user_email) {
		System.out.println("----");
		System.out.println(user_email);
		String chk = "";
		if(service.idCheck(user_email) != null) {
			//이미 존재하는 아이디
			return "0";
		}else {
			//사용 가능한 아이디
			return "1";
		}
	}

	@GetMapping("/loginform")
	public String loginform() {
		System.out.println("MemberController");
		return "member/loginform";
	}
	
}
