package com.food.exp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.food.exp.dto.LikesDTO;
import com.food.exp.dto.MemberDTO;
import com.food.exp.dto.PageDTO;
import com.food.exp.dto.RevDTO;
import com.food.exp.service.MypageService;

@Controller
@RequestMapping("/mypage")
public class MypageController {

	@Autowired
	MypageService service;

	// 메인 페이지
	@GetMapping("/main")
	public String mypage(HttpSession session, Model m, PageDTO pageDTO) {
		// 회원 정보
		String user_email = (String) session.getAttribute("login");
		MemberDTO memberDTO = service.getInfo(user_email);
		m.addAttribute("MemberDTO", memberDTO);
		// 즐겨찾기 정보
		int curPage = 0;
	    pageDTO = service.getLikes(curPage, user_email);
	    m.addAttribute("pageDTO", pageDTO);
		// 리뷰 정보
		List<RevDTO> revDTO = service.getRev(user_email);
		m.addAttribute("RevDTO", revDTO);
		return "member/mypage";
	}

	// 나의 즐겨찾기 페이지
	/*
	 * @GetMapping("/myLikes") public String myLikes(HttpSession session, Model m,
	 * LikesDTO dto) { // 즐겨찾기 정보 String user_email = (String)
	 * session.getAttribute("login"); dto.setUser_email(user_email); List<LikesDTO>
	 * likesDTO = service.getLikes(user_email); m.addAttribute("LikesDTO",
	 * likesDTO); return "member/myLikes"; }
	 */
	@GetMapping("/myLikes")
	public String myLikes(HttpSession session, Model m, PageDTO pageDTO) {
	    // 즐겨찾기 정보
	    String user_email = (String) session.getAttribute("login");
	    int curPage = pageDTO.getCurPage(); // 현재 페이지
	    pageDTO = service.getLikes(curPage, user_email);
	    int totalNum = pageDTO.getTotalCount() / pageDTO.getPerPage();
	    if (pageDTO.getTotalCount() % pageDTO.getPerPage() != 0) {
	        totalNum++; // 나머지가 있는 경우 1을 추가
	    }
	    pageDTO.setTotalNum(totalNum);
	    m.addAttribute("pageDTO", pageDTO);
	    return "member/myLikes";}

	// 즐겨찾기 삭제
	@PostMapping("/delLikes")
	public String delLikes(HttpSession session, LikesDTO dto) {
		String user_email = (String) session.getAttribute("login");
		dto.setUser_email(user_email);
		int num = service.delLikes(dto);
		return "redirect:/mypage/myLikes";
	}

	// 회원정보 수정 페이지로 이동
	@GetMapping("/changeInfo")
	public String changeInfo(HttpSession session, Model m) {

		String user_email = (String) session.getAttribute("login");
		System.out.println(user_email);

		MemberDTO dto = service.getInfo(user_email);
		m.addAttribute("MemberDTO", dto);
		return "member/changeInfo";
	}

	// 회원정보 수정
	@PostMapping("/updateInfo")
	public String updateInfo(MemberDTO dto) {
		int num = service.changeInfo(dto);
		return "redirect:main";
	}

	// 회원 탈퇴
	@PostMapping("/delMember")
	public String delMember(HttpSession session) {
		String user_email = (String) session.getAttribute("login");

		int num = service.delMember(user_email);
		session.invalidate();
		return "redirect:/main";
	}
}
