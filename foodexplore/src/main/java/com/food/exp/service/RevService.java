package com.food.exp.service;

import java.util.List;

import com.food.exp.dto.RevDTO;

public interface RevService {
	public void addReview(RevDTO review);
    public List<RevDTO> getReviewById(String user_email);
    public List<RevDTO> getAllReviews();
    public int updateReview(RevDTO review);
    public void deleteReview(int rev_no);
	public RevDTO selectByRev_No(int rev_no);
}
