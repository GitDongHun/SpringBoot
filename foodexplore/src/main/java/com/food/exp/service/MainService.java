package com.food.exp.service;

import java.util.List;

import com.food.exp.dto.MainDTO;

public interface MainService {

	List<MainDTO> top10Rst();
	
	// 리뷰 수를 가져오기 위한 메소드
    int getRevCountByRestaurantId(String rst_id);
}
