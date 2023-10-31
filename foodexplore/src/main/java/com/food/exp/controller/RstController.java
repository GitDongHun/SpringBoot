package com.food.exp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	RevService revService;

	@GetMapping("/rst")
	public String rst_main(HttpSession session,Model model) {

		// 이 위치에서 현재위치로 검색할지, 다른위치로 검색할지 구분할 함수 만들어야함
		
		// api키 가지고오기
		model.addAttribute("apiKey", "8b9300f39b51a93d7bd9c98a76473b1d");
		model.addAttribute("searchinput", "");
		System.out.println("RstController 실행-GET 현재위치, 다른위치 검색할 함수 만들어야함");
		return "/rst/rst";
	}

	@PostMapping("/rst")
	public String rst_post(@RequestParam("query") String rst_query, Model model,HttpSession session) {
		model.addAttribute("apiKey", "8b9300f39b51a93d7bd9c98a76473b1d");

		if (rst_query != "") {
			model.addAttribute("searchinput", rst_query);
			session.setAttribute("searchinput", rst_query);
		} else {
			model.addAttribute("searchinput", "");
			session.setAttribute("searchinput", "");
		}
		System.out.println("RstController 실행-POST 키워드로 검색, 키워드는"+rst_query);
		return "/rst/rst";
	}

	@PostMapping("/htmltodb")
	public String htmltodb(@RequestBody List<RstTempDTO> rsttempList) {
		List<RstDTO> rstDTOList = new ArrayList<>();
			for (RstTempDTO rstTempDTO : rsttempList) {
			// 01. rstDTO에 rsttempList값을 재전달
			RstDTO rstDTO = new RstDTO();
			rstDTO.setRst_id((rstTempDTO.getId() != null) ? rstTempDTO.getId() : " ");
			rstDTO.setRst_name((rstTempDTO.getPlace_name() != null) ? rstTempDTO.getPlace_name() : " ");
			rstDTO.setRst_cate((rstTempDTO.getCategory_name() != null) ? rstTempDTO.getCategory_name() : " ");
			rstDTO.setRst_phone((rstTempDTO.getPhone() != null) ? rstTempDTO.getPhone() : " ");
			rstDTO.setRst_addr1((rstTempDTO.getRoad_address_name() != null) ? rstTempDTO.getRoad_address_name() : " ");
			rstDTO.setRst_addr2((rstTempDTO.getAddress_name() != null) ? rstTempDTO.getAddress_name() : " ");

			// rstDTO.setX(rstTempDTO.getX());
			// rstDTO.setY(rstTempDTO.getY());
			// rstDTO.setPlaceUrl(rstTempDTO.getPlace_url());
			// rstDTO.setDistance(rstTempDTO.getDistance());
			// rstDTO.setCategoryGroupCode(rstTempDTO.getCategory_group_code());
			// rstDTO.setCategoryGroupName(rstTempDTO.getCategory_group_name());
			rstDTOList.add(rstDTO);
		}
		for (RstDTO dto : rstDTOList) {
			rstService.insertOrUpdateRestaurant(dto);
		}
		return "/rst/rst";
	}
	
	//00. 식당정보(rst_id) > 세부정보(rst_id)를 GET방식으로 가지고옵니다.
	@GetMapping("/rst/rst_detail")
	public String rst_detail(@RequestParam("rst_id") String rst_id) {
		
		//01. 가지고온 rst_id를 RstDTO에 정의된 형태로 넣기위해, rstService를 사용합니다.
		//rstService에 미리 정의해놓은 ID값으로 식당DB를 가지고오는 함수를 실행시킵니다.
		RstDTO rstDTO=rstService.selectRestaurantById(rst_id);
		
		//01. DEBUG 테스트, rstDTO에 잘 가지고 왔는지 값 확인
		System.out.println(rstDTO.getAll());
		
		//02. 가지고온 rst_id를 RevDTO에 정의된 형태로 가지고 오기 위해, revService를 사용합니다.
		//revService에 미리 정의해놓은 ID값으로 리뷰DB를 가지고오는 함수를 실행시킵니다.
		//(여기서부터 구현중!!!!!!!)
		
		List<RevDTO> revDTOList = revService.getreviewByRst(rst_id);
		
		
		//02. DEBUG 테스트, List형태의 revDTOList에 잘 가지고 왔는지 값 확인
		for(RevDTO revDTO: revDTOList) {
			System.out.println(revDTO.toString());
		}
		
		
		return "/rst/rst_detail";
	}

	// 리뷰 작성 페이지
	@GetMapping("/rst/revwrite")
	public String addReview(@ModelAttribute("review") RevDTO review) {
//		service.addReview(review);
//		System.out.println(review);
//		return "redirect:/rst";
		
//		review.setRev_date(new Date());
//	    service.addReview(review);
	    
		return "/rst/rev_write";
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
