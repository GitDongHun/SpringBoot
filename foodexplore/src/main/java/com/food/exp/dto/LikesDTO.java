package com.food.exp.dto;

import org.apache.ibatis.type.Alias;

@Alias("LikesDTO")
public class LikesDTO {
	String user_email;
	String rst_id;
	
	public LikesDTO() {}

	public LikesDTO(String user_email, String rst_id) {
		super();
		this.user_email = user_email;
		this.rst_id = rst_id;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getRst_id() {
		return rst_id;
	}

	public void setRst_id(String rst_id) {
		this.rst_id = rst_id;
	}

	@Override
	public String toString() {
		return "LikesDTO [user_email=" + user_email + ", rst_id=" + rst_id + "]";
	}

}