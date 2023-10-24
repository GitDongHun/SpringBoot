package com.food.exp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.food.exp.dto.LikesDTO;
import com.food.exp.dto.MemberDTO;
import com.food.exp.service.MypageService;

@Controller
@RequestMapping("/mypage")
public class MypageController {

	@Autowired
	MypageService service;
	
	// 메인 페이지
	@GetMapping("/main")
	public String mypage(HttpSession session, Model m) {
		
		// 회원 정보
		String user_email = (String) session.getAttribute("login");
		MemberDTO memberDTO = service.getInfo(user_email);
		m.addAttribute("MemberDTO", memberDTO);
		
		// 즐겨찾기 정보
		LikesDTO lieksDTO = service.getLikes(user_email);
	    m.addAttribute("LikesDTO", lieksDTO);
	    
	    // 리뷰 정보
		
		return "member/mypage";
	}
	
	// 나의 즐겨찾기 페이지
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
	//회원정보 수정 
	@PostMapping("/updateInfo")
	public String updateInfo(MemberDTO dto) {
		int num = service.changeInfo(dto);
		return "redirect:main";
	}
	//회원 탈퇴 
	@PostMapping("/delMember")
	public String delMember(HttpSession session) {
		String user_email = (String) session.getAttribute("login");

		int num = service.delMember(user_email);
		session.invalidate();
		return "redirect:/main";
	}
}
