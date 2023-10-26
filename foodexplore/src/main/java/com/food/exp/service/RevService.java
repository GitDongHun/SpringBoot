package com.food.exp.service;

import java.util.List;

import com.food.exp.dto.RevDTO;

public interface RevService {
	public void addReview(RevDTO review);
    public RevDTO getReviewById(String user_email);
    public List<RevDTO> getAllReviews();
    public void updateReview(RevDTO review);
    public void deleteReview(int rev_no);
}
