package com.food.exp.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.exp.dto.MemberDTO;

@Repository("MemberDAO")
public class MemberDAO {

	@Autowired
	SqlSessionTemplate session;
	
	public int join(MemberDTO dto) {
		return session.insert("MemberMapper.join", dto);
	}
}
