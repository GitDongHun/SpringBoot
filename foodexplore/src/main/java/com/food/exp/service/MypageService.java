package com.food.exp.service;

import java.util.List;

import com.food.exp.dto.LikesDTO;
import com.food.exp.dto.MemberDTO;

public interface MypageService {

	public MemberDTO getInfo(String user_email);
	public int changeInfo(MemberDTO dto);
	public int delMember(String user_email);
	
	public List<LikesDTO> getLikes(String user_email);
	public int delLikes(String rst_id);
}
