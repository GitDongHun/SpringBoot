package com.food.exp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.food.exp.dto.LikesDTO;
import com.food.exp.dto.RevDTO;
import com.food.exp.dto.RevTempDTO;
import com.food.exp.dto.RstDTO;
import com.food.exp.dto.RstTempDTO;
import com.food.exp.service.RevService;
import com.food.exp.service.RstService;

@Controller
public class RstController {    
	@Value("${com.food.exp.mapapikey}")
	private String mapApiKey;

	@Autowired
	ServletContext application;

	@Autowired
	RstService rstService;
	
	@Autowired
	RevService revService;

	@GetMapping("/maintest")
	public String maintest(){
		
		return "/maintest";
	}
	
	@GetMapping("/rst")
	public String rst_main(HttpSession session,Model model) {

		// 이 위치에서 현재위치로 검색할지, 다른위치로 검색할지 구분
		model.addAttribute("inputLoadSelector","myLocation");
		// api키 가지고오기
		model.addAttribute("apiKey", mapApiKey);
		model.addAttribute("searchinput", "");
		System.out.println("RstController 실행-GET 현재위치, 다른위치 검색할 함수 만들어야함");
		return "/rst/rst";
	}

	@PostMapping("/rst")
	public String rst_post(@RequestParam("query") String rst_query, Model model,HttpSession session) {
		// 이 위치에서 현재위치로 검색할지, 다른위치로 검색할지 구분
		model.addAttribute("inputLoadSelector","nationwide");
		
		model.addAttribute("apiKey", mapApiKey);

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
	
	@PostMapping("/reg_post")
	public String reg_post(@RequestParam("h_area1")String h_area1,@RequestParam("h_area2")String h_area2,Model model) {
		// 이 위치에서 현재위치로 검색할지, 다른위치로 검색할지 구분
		model.addAttribute("inputLoadSelector","nationwide");
		
		model.addAttribute("apiKey", mapApiKey);
		
		model.addAttribute("h_area1",h_area1);
		model.addAttribute("h_area2",h_area2);
		
		return "/rst/rst";
	}

	@PostMapping("/htmltodb")
	public String htmltodb(@RequestBody List<RstTempDTO> rsttempList) {
		List<RstDTO> rstDTOList = new ArrayList<>();
			for (RstTempDTO rstTempDTO : rsttempList) {
			// 01. rstDTO에 rsttempList값을 재전달
				
				
			// 01-1. null값 에러처리를 위한 공백처리
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
			
			
			//01-2. rstDTOList에 rstDTO값 넣기 
			rstDTOList.add(rstDTO);
		}
		for (RstDTO dto : rstDTOList) {
			//02. rstService, rstServiceImpl, rstDAO, rstMapper
			//    위치에 정의된 서비스 실행하여 데이터 삽입 or 수정 
			rstService.insertOrUpdateRestaurant(dto);
		}
		return "/rst/rst";
	}
	
	//00. 식당정보(rst_id) > 세부정보(rst_id)를 GET방식으로 가지고옵니다.
	@GetMapping("/rst/rst_detail")
	public String rst_detail(@RequestParam("rst_id") String rst_id,Model model) {
		
		//01. GET으로 받은 rst_id로 DB에서 가져오기
		RstDTO rstDTO=rstService.selectRestaurantById(rst_id);
//		List<RevDTO> revDTOList = revService.getreviewByRst(rst_id);
		List<RevTempDTO> revTempDTOList = revService.getreviewByRst(rst_id);
		
		
		//02. DB에서 가져온 데이터 html로 쏴주기
        model.addAttribute("rst_addr1", rstDTO.getRst_addr1());
        model.addAttribute("rst_addr2", rstDTO.getRst_addr2());
        model.addAttribute("rst_cate", rstDTO.getRst_cate());
        model.addAttribute("rst_id", rstDTO.getRst_id());
        model.addAttribute("rst_name", rstDTO.getRst_name());
        model.addAttribute("rst_phone", rstDTO.getRst_phone());
        model.addAttribute("revTempDTOList",revTempDTOList);
        
        
        //03. 리뷰평균, 리뷰갯수를 count하기위한 작업
        double rev_star_avg=0;
        int rev_count=0;
        double rev_star_hop=0;
        
        rev_count=revTempDTOList.size();
        for(RevTempDTO tmp:revTempDTOList) {
        	rev_star_hop += Double.valueOf(tmp.getRev_star());
        }
        rev_star_avg=(double)(Math.round((rev_star_hop/rev_count) * 2) / 2.0);
        
        if (Double.isNaN(rev_star_avg)) {
        	rev_star_avg = 0.0; // null 또는 NaN 값을 0으로 처리
        }
        
        
        
        //04. Controller에서 계산한 리뷰평균, 리뷰갯수를 html로 쏴주기
        model.addAttribute("rev_all_star_avg",rev_star_avg);
        model.addAttribute("rev_all_count",rev_count);
  
        //05. 리뷰평균 DB로 Update하기
        //필요한정보: rev_star_avg, rst_id를 담은 rstDTO
        //넣는 위치: restaurant 테이블
        rstDTO.setRev_star_avg(rev_star_avg);
        rstService.updateAvgStar(rstDTO);
        
        // 즐겨찾기 개수
		List<LikesDTO> likesTotal = rstService.getLikesTotal(rst_id);
		model.addAttribute("likesTotal", likesTotal);
		
		return "/rst/rst_detail";
	}

	// 리뷰 작성 페이지
	@GetMapping("/rst/revwrite")
	public String addReview(@RequestParam("rst_id") String rst_id, Model model) {
		RstDTO rstDTO = rstService.selectRestaurantById(rst_id);
		model.addAttribute("rst_id",rst_id);
	    model.addAttribute("rst_name", rstDTO.getRst_name());
		return "/rst/rev_write";
	}
	
	// 글쓰기
	@RequestMapping(value = "/rst/write", method = RequestMethod.POST)
	public String write(RevDTO revDTO, HttpSession session) {
		String user_email = (String) session.getAttribute("login");
	    revDTO.setUser_email(user_email);
		revService.addReview(revDTO);
		System.out.println(revDTO.toString());
		return "redirect:/rst/rst_detail?rst_id=" + revDTO.getRst_id();
	}
	
}
