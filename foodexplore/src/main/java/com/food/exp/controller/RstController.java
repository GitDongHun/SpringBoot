package com.food.exp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.food.exp.dto.RevDTO;
import com.food.exp.dto.RstDTO;
import com.food.exp.dto.RstTempDTO;
import com.food.exp.service.RevService;
import com.food.exp.service.RstService;

@Controller
public class RstController {

	@Autowired
	ServletContext application;

	@Autowired
	RstService rstService;
	
	@Autowired
	RevService service;

	@GetMapping("/rst")
	public String rst_main(Model model) {

		// 이 위치에서 현재위치로 검색할지, 다른위치로 검색할지 구분할 함수 만들어야함

		// api키 가지고오기
		model.addAttribute("apiKey", "8b9300f39b51a93d7bd9c98a76473b1d");
		model.addAttribute("keyword", "");
		System.out.println("RstController 실행-GET");
		return "/rst/rst";
	}

	@PostMapping("/rst")
	public String rst_post(@RequestParam("query") String rst_query, Model model) {
		model.addAttribute("apiKey", "8b9300f39b51a93d7bd9c98a76473b1d");

		if (rst_query != "") {
			model.addAttribute("keyword", rst_query);
		} else {
			model.addAttribute("keyword", "");
		}
		System.out.println("RstController 실행-POST");
		return "/rst/rst";
	}

	@PostMapping("/htmltodb")
	public String htmltodb(@RequestBody List<RstTempDTO> rsttempList) {
		List<RstDTO> rstDTOList = new ArrayList<>();
	
		System.out.println("===============================================");
		System.out.println("01. 서버에서 가져온 데이터를 rstDTO로 옮기기 ");

		for (RstTempDTO rstTempDTO : rsttempList) {

			// 00. debug: 잘왔는지 데이터 출력
			System.out.println(rstTempDTO.getAll());

			// 01. rstDTO에 rsttempList값을 재전달
			RstDTO rstDTO = new RstDTO();
			rstDTO.setRst_id((rstTempDTO.getId() != null) ? rstTempDTO.getId() : "");
			rstDTO.setRst_name((rstTempDTO.getPlace_name() != null) ? rstTempDTO.getPlace_name() : "");
			rstDTO.setRst_cate((rstTempDTO.getCategory_name() != null) ? rstTempDTO.getCategory_name() : "");
			rstDTO.setRst_phone((rstTempDTO.getPhone() != null) ? rstTempDTO.getPhone() : "");
			rstDTO.setRst_addr1((rstTempDTO.getRoad_address_name() != null) ? rstTempDTO.getRoad_address_name() : "");
			rstDTO.setRst_addr2((rstTempDTO.getAddress_name() != null) ? rstTempDTO.getAddress_name() : "");

			// rstDTO.setX(rstTempDTO.getX());
			// rstDTO.setY(rstTempDTO.getY());
			// rstDTO.setPlaceUrl(rstTempDTO.getPlace_url());
			// rstDTO.setDistance(rstTempDTO.getDistance());
			// rstDTO.setCategoryGroupCode(rstTempDTO.getCategory_group_code());
			// rstDTO.setCategoryGroupName(rstTempDTO.getCategory_group_name());

			rstDTOList.add(rstDTO);
		}


		System.out.println("===============================================");
		System.out.println("02. Mybatis 사용하여 DB로 전송 ");
		for (RstDTO dto : rstDTOList) {
			rstService.insertOrUpdateRestaurant(dto);
		}
		return "/rst/rst";
	}
	
	@GetMapping("/rst/rst_detail")
	public String rst_detail() {

		return "/rst/rst_detail";
	}

	// 리뷰 작성 페이지
	@GetMapping("/rst/revcreate")
	public String addReview(@ModelAttribute("review") RevDTO review) {
//		service.addReview(review);
//		System.out.println(review);
//		return "redirect:/rst";
		return "/rst/rev_create";
	}
	
//	@PostMapping("/rst/revcreate")
//	public String addReview(@RequestParam("rev_title") String Rev_title,
//				            @RequestParam("rev_star") int Rev_star,
//				            @RequestParam("rev_comment") String Rev_comment,
//				            @RequestParam("rst_name") String Rst_name,
//				            @RequestParam("rst_id") String Rst_id) {
//		RevDTO revDTO = new RevDTO();
//		revDTO.setRev_title(Rev_title);
//		revDTO.setRev_star(Rev_star);
//		revDTO.setRev_comment(Rev_comment);
//		revDTO.setRst_name(Rst_name);
//		revDTO.setRst_id(Rst_id);
//
//		// revDTO를 사용하여 DB에 리뷰를 추가하는 서비스 호출
//		
//		return "redirect:/rst"; // 리다이렉트할 경로를 지정합니다
//	}
	
}
