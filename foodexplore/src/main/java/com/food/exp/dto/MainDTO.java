package com.food.exp.dto;

import org.apache.ibatis.type.Alias;

@Alias("mainDTO")
public class MainDTO {

	String rst_id;
	String rst_name;
	String rst_addr1;
	String rst_addr2;
	String rst_phone;
	String rst_cate;
	String rev_star_avg;
	
//	// 지역명만 가지고 오기
//	private String rst_Region;
//	
//	public MainDTO(String rst_Region) {
//		this.rst_Region = rst_Region;
//	}
//	public String getRst_Region() {
//		return rst_Region;
//	}
//	public void setRst_Region(String rst_Region) {
//		this.rst_Region = rst_Region;
//	}
	


	public MainDTO() {}


	public MainDTO(String rst_id, String rst_name, String rst_addr1, String rst_addr2, String rst_phone,
			String rst_cate, String rev_star_avg) {
		this.rst_id = rst_id;
		this.rst_name = rst_name;
		this.rst_addr1 = rst_addr1;
		this.rst_addr2 = rst_addr2;
		this.rst_phone = rst_phone;
		this.rst_cate = rst_cate;
		this.rev_star_avg = rev_star_avg;
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


	public String getRst_addr2() {
		return rst_addr2;
	}


	public void setRst_addr2(String rst_addr2) {
		this.rst_addr2 = rst_addr2;
	}


	public String getRst_phone() {
		return rst_phone;
	}


	public void setRst_phone(String rst_phone) {
		this.rst_phone = rst_phone;
	}


	public String getRst_cate() {
		return rst_cate;
	}


	public void setRst_cate(String rst_cate) {
		this.rst_cate = rst_cate;
	}


	public String getRev_star_avg() {
		return rev_star_avg;
	}


	public void setRev_star_avg(String rev_star_avg) {
		this.rev_star_avg = rev_star_avg;
	}


	@Override
	public String toString() {
		return "MainDTO [rst_id=" + rst_id + ", rst_name=" + rst_name + ", rst_addr1=" + rst_addr1 + ", rst_addr2="
				+ rst_addr2 + ", rst_phone=" + rst_phone + ", rst_cate=" + rst_cate + ", rev_star_avg=" + rev_star_avg
				+ "]";
	}
	
	
}
