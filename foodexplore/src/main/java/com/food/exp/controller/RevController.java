package com.food.exp.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.food.exp.dto.RevDTO;
import com.food.exp.dto.RevPageDTO;
import com.food.exp.service.RevService;

@Controller
@RequestMapping("/mypage")
public class RevController {

	@Autowired
	RevService service;
	
	// 내 리뷰 목록
	@GetMapping("/rev")
	public String rev(Model model, HttpSession session, RevPageDTO revPageDTO) {
		String user_email = (String) session.getAttribute("login");
		int curPage = revPageDTO.getCurPage();
		revPageDTO = service.getReviewById(curPage, user_email);
		
		int totalCount = service.totalCount(user_email); // 총 개수
	    int totalNum = totalCount / revPageDTO.getPerPage();
	    if (totalCount % revPageDTO.getPerPage() != 0) {
	        totalNum++; // 나머지가 있는 경우 1을 추가
	    }
	    revPageDTO.setTotalCount(totalCount);
	    revPageDTO.setTotalNum(totalNum);

	    System.out.println(revPageDTO.toString());
	    model.addAttribute("revPageDTO", revPageDTO);
	    return "/rev/rev";
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
	
	// 리뷰 검색
	@GetMapping("/searchRev")
    public String searchRev(@RequestParam("keyword") String keyword, Model model) {
		RevDTO revDTO = new RevDTO();
		revDTO.setKeyword(keyword);
		System.out.println(keyword);
		List<RevDTO> result = service.searchRev(revDTO);
	    model.addAttribute("searchResult", result);
	    return "/rev/rev"; // HTML 템플릿의 이름
    }
	
//	// 선택된 리뷰 삭제
//    @PostMapping("/delSelect")
//    @ResponseBody
//    public String delSelect(@RequestParam("rev_no") int rev_no) {
//            service.delSelect(rev_no);
//        return "redirect:/mypage/rev";
//    }

}
