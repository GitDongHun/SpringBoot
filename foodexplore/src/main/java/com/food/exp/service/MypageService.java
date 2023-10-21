package com.food.exp.service;

import com.food.exp.dto.MemberDTO;

public interface MypageService {

	public MemberDTO getInfo(String user_email);
}
