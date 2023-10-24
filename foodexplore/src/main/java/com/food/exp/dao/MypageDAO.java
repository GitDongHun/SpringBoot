package com.food.exp.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.exp.dto.LikesDTO;
import com.food.exp.dto.MemberDTO;

@Repository("MypageDAO")
public class MypageDAO {

	@Autowired
	SqlSessionTemplate session;

	// 회원 정보 가져오기
	public MemberDTO getInfo(String user_email) {
		return session.selectOne("MypageMapper.getInfo", user_email);
	}

	// 즐겨찾기 가져오기
	public LikesDTO getLikes(String user_email) {
		return session.selectOne("MypageMapper.getLikes", user_email);
	}
}
