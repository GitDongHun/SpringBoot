package com.food.exp.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.exp.dto.MemberDTO;

@Repository("MypageDAO")
public class MypageDAO {

	@Autowired
	SqlSessionTemplate session;
	
	// 회원 정보 가져오기 
	public MemberDTO getInfo(String user_email) {
		return session.selectOne("MypageMapper.getInfo", user_email);
	}
	// 회원 정보 변경 
	public int changeInfo(MemberDTO dto) {
		return session.update("MypageMapper.changeInfo", dto);
	}
	// 회원 탈퇴
	public int delMember(String user_email) {
		return session.delete("MypageMapper.delMember",user_email);
	}
}
