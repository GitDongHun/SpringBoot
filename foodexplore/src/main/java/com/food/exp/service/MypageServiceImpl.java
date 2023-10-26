package com.food.exp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.exp.dao.MypageDAO;
import com.food.exp.dto.LikesDTO;
import com.food.exp.dto.MemberDTO;

@Service
public class MypageServiceImpl implements MypageService{

	@Autowired
	MypageDAO dao;

	@Override
	public MemberDTO getInfo(String user_email) {
		return dao.getInfo(user_email);
	}

	@Override
	public int changeInfo(MemberDTO dto) {
		return dao.changeInfo(dto);
	}

	@Override
	public int delMember(String user_email) {
		return dao.delMember(user_email);
	}

	@Override
	public List<LikesDTO> getLikes(String user_email) {
		return dao.getLikes(user_email);
	}

	@Override
	public int delLikes(String rst_id) {
		return dao.delLikes(rst_id);
	}

	
}
