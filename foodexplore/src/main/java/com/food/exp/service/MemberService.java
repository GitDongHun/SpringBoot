package com.food.exp.service;

import com.food.exp.dto.MemberDTO;

public interface MemberService {

	public int join(MemberDTO dto);
	public String idCheck(String user_email);
	
	
}
