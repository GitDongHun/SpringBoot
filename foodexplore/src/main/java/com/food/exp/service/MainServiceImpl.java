package com.food.exp.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.exp.dao.MainDAO;
import com.food.exp.dto.MainDTO;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MainDAO dao;

	public List<MainDTO> top10Rst() {
        List<MainDTO> top10Rst = dao.top10Rst();
        
        for (MainDTO restaurant : top10Rst) {
            int rev_count = dao.getRevCountByRestaurantId(restaurant.getRst_id());
            restaurant.setRev_count(rev_count);
        }
		return top10Rst;
	}
}
