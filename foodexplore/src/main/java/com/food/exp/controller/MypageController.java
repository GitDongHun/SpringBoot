package com.food.exp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.food.exp.dto.MemberDTO;
import com.food.exp.service.MypageService;

@Controller
@RequestMapping("/mypage")
public class MypageController {

	@Autowired
	MypageService service;
	
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
	
	//회원정보 수정 페이지로 이동
	@GetMapping("/changeInfo")
	public String changeInfo(HttpSession session, Model m) {
		
		String user_email = (String) session.getAttribute("login");
		System.out.println(user_email);
		
		MemberDTO dto = service.getInfo(user_email);
		m.addAttribute("MemberDTO", dto);
		return "member/changeInfo";
	}
}
