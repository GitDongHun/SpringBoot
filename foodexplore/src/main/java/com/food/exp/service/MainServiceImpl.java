package com.food.exp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.exp.dao.MainDAO;
import com.food.exp.dto.MainDTO;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	MainDAO dao;

	@Override
	public List<MainDTO> top10Rst() {
		return dao.top10Rst();
	}

//	@Override
//	public String getRegionForRestaurant(String rst_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
