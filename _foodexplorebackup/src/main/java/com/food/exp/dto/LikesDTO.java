package com.food.exp.dto;

import org.apache.ibatis.type.Alias;

@Alias("LikesDTO")
public class LikesDTO {
	String user_email;
	String rst_id;
	String rst_name;
	String rst_addr1;
	String rst_cate;
	int likes_total;
	double rev_avg;
	
	public LikesDTO() {}

	public LikesDTO(String user_email, String rst_id, String rst_name, String rst_addr1, String rst_cate,
			int likes_total, double rev_avg) {
		super();
		this.user_email = user_email;
		this.rst_id = rst_id;
		this.rst_name = rst_name;
		this.rst_addr1 = rst_addr1;
		this.rst_cate = rst_cate;
		this.likes_total = likes_total;
		this.rev_avg = rev_avg;
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

	public String getRst_name() {
		return rst_name;
	}

	public void setRst_name(String rst_name) {
		this.rst_name = rst_name;
	}

	public String getRst_addr1() {
		return rst_addr1;
	}

	public void setRst_addr1(String rst_addr1) {
		this.rst_addr1 = rst_addr1;
	}

	public String getRst_cate() {
		return rst_cate;
	}

	public void setRst_cate(String rst_cate) {
		this.rst_cate = rst_cate;
	}

	public int getLikes_total() {
		return likes_total;
	}

	public void setLikes_total(int likes_total) {
		this.likes_total = likes_total;
	}

	public double getRev_avg() {
		return rev_avg;
	}

	public void setRev_avg(double rev_avg) {
		this.rev_avg = rev_avg;
	}

	@Override
	public String toString() {
		return "LikesDTO [user_email=" + user_email + ", rst_id=" + rst_id + ", rst_name=" + rst_name + ", rst_addr1="
				+ rst_addr1 + ", rst_cate=" + rst_cate + ", likes_total=" + likes_total + ", rev_avg=" + rev_avg + "]";
	}

	


}