package com.food.exp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.exp.dao.RstDAO;
import com.food.exp.dto.RstDTO;

@Service
public class RstServiceImpl implements RstService {
    private final RstDAO rstDAO;

    @Autowired
    public RstServiceImpl(RstDAO rstDAO) {
        this.rstDAO = rstDAO;
    }
	@Override
	public List<RstDTO> getAllRestaurants() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void saveRestaurant(RstDTO restaurant) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public RstDTO getRestaurantById(String rst_id) {
		// TODO Auto-generated method stub
		return null;
	}

    // 다른 비즈니스 로직 메서드의 구현
}
