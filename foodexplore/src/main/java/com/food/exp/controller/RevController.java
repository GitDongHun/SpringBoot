package com.food.exp.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.food.exp.dto.RevDTO;
import com.food.exp.service.RevService;

@Controller
@RequestMapping("/mypage")
public class RevController {

	@Autowired
	RevService service;
	
	// 리뷰 관리 화면
	@GetMapping("/rev")
	public String rev(Model model, HttpSession session) {
		String user_email = (String) session.getAttribute("user_email");
		List<RevDTO> reviews = service.getAllReviews();
		List<RevDTO> userReviews = reviews.stream()
	                .filter(review -> review.getUser_email().equals(user_email))
	                .collect(Collectors.toList());
		model.addAttribute("reviews", reviews);
		return "/rev/rev";
	}
	
	// 리뷰 수정 화면
	@GetMapping("/revedit")
	public String rev_edit() {
		return "/rev/rev_edit";
	}

}
