package com.food.exp.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.exp.dto.RevDTO;

@Repository("RevDAO")
public class RevDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	// 리뷰 추가
	public void addReview(RevDTO review) {
        session.insert("RevMapper.addReview", review);
    }

	// id에 해당하는 리뷰 가져오기
    public RevDTO getReviewById(String user_email) {
        return session.selectOne("RevMapper.getReviewById", user_email);
    }
    
    // 전체 리뷰 가져오기
    public List<RevDTO> getAllReviews() {
        return session.selectList("RevMapper.getAllReviews");
    }
    
    // 리뷰 수정
    public void updateReview(RevDTO review) {
        session.update("RevMapper.updateReview", review);
    }

    // 리뷰 삭제
    public void deleteReview(int rev_no) {
        session.delete("RevMapper.deleteReview", rev_no);
    }
}
