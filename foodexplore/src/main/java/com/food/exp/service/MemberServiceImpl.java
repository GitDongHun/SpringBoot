package com.food.exp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.exp.dao.MemberDAO;
import com.food.exp.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDAO dao;
	
	@Override
	public int join(MemberDTO dto) {
		return dao.join(dto);
	}

	@Override
	public String idCheck(String user_email) {
		return dao.idCheck(user_email);
	}

}
