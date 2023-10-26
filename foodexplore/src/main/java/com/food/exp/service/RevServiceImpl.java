package com.food.exp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.exp.dao.RevDAO;
import com.food.exp.dto.RevDTO;

@Service
public class RevServiceImpl implements RevService {
	
	@Autowired
	RevDAO dao;

	@Override
	public void addReview(RevDTO review) {
		dao.addReview(review);
	}

	@Override
	public RevDTO getReviewById(String user_email) {
		 return dao.getReviewById(user_email);
	}

	@Override
	public List<RevDTO> getAllReviews() {
		 return dao.getAllReviews();
	}

	@Override
	public void updateReview(RevDTO review) {
		dao.updateReview(review);
	}

	@Override
	public void deleteReview(int rev_no) {
		dao.deleteReview(rev_no);
	}
	
}
