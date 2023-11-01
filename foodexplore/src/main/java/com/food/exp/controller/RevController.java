package com.food.exp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.food.exp.dto.RevDTO;
import com.food.exp.service.RevService;

@Controller
@RequestMapping("/mypage")
public class RevController {

	@Autowired
	RevService service;
	
	// 내 리뷰 목록
	@GetMapping("/rev")
	public String rev(Model model, HttpSession session) {
		String user_email = (String) session.getAttribute("login");
		List<RevDTO> reviews = service.getReviewById(user_email);
		model.addAttribute("reviews", reviews);
		return "rev/rev";
	}
	
	// 글 자세히 보기
	@RequestMapping(value = "/revedit", method = RequestMethod.GET)
	public String retrieve(@RequestParam("rev_no") int rev_no, Model model) {
	    RevDTO revDTO = service.selectByRev_No(rev_no);
	    model.addAttribute("review", revDTO);
	    return "/rev/rev_edit";
	}
	
	// 리뷰 수정
	@PostMapping("/update")
	public String updateReview(@ModelAttribute("review") RevDTO revDTO, HttpSession session) {
		String user_email = (String) session.getAttribute("login");
		revDTO.setUser_email(user_email);
		service.updateReview(revDTO);
		System.out.println(revDTO.toString());
		return "redirect:/mypage/rev";
	}
	
	// 리뷰 삭제
	@PostMapping("/delete")
	public String deleteReview(@RequestParam("rev_no") int rev_no) {
	    service.deleteReview(rev_no);
	    return "redirect:/mypage/rev";
	}
	
	// 선택 삭제 (구현 안됨)
	@PostMapping("/DelSelect")
    public ResponseEntity<String> DelSelect(@RequestBody List<Integer> revNos) {
	    for (int revNo : revNos) {
	        service.deleteReview(revNo);
	    }
	    return ResponseEntity.ok("리뷰 삭제 요청이 성공적으로 처리되었습니다.");
    }
	
//	@GetMapping("/rev")
//	public String rev(Model model, HttpSession session, @RequestParam(defaultValue = "0") int page) {
//	    int pageSize = 10; // 페이지 당 표시할 항목 수
//	    String user_email = (String) session.getAttribute("login");
//	    Page<RevDTO> reviewsPage = service.getReviewById(user_email, PageRequest.of(page, pageSize, Sort.by("rev_date").descending()));
//	    model.addAttribute("reviews", reviewsPage.getContent());
//	    model.addAttribute("currentPage", page);
//	    model.addAttribute("totalPages", reviewsPage.getTotalPages());
//	    return "rev/rev";
//	}
}
