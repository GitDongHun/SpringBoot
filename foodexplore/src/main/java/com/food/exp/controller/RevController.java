package com.food.exp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	// 리뷰 관리 화면
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
	
//	@PostMapping("/updateReview")
//	public String updateReview(@ModelAttribute("review") RevDTO review) {
//	    service.updateReview(review);
//	    return "redirect:rev";
//	}

	@PostMapping("/deleteReview")
	public String deleteReview(@RequestParam("rev_no") int rev_no) {
	    service.deleteReview(rev_no);
	    return "redirect:rev";
	}
	
	@RequestMapping(value = "/updateReview", method = RequestMethod.POST)
	public String updateReview(RevDTO revDTO,Model model) {
		RevDTO num = service.updateReview(revDTO);
		System.out.println(num);
		model.addAttribute("review", num);
		return "redirect:/rev";
	}
	
	// 리뷰 수정 화면
//	@GetMapping("/revedit")
//	public String rev_edit(@RequestParam("rev_no") int rev_no, Model model) {
//	    RevDTO review = service.updateReview(rev_no); // RevDTO 객체를 가져오는 메소드를 사용하여 리뷰 정보 가져오기
//	    model.addAttribute("review", review);
//	    return "/rev/rev_edit";
//	}

}
