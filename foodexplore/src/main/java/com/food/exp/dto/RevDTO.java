package com.food.exp.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("RevDTO")
public class RevDTO {
	int rev_no;
	String user_email;
	int rst_id;
	int rev_star;
	String rev_comment;
	Date rev_date;
	 
	public RevDTO() {}

	public RevDTO(int rev_no, String user_email, int rst_id, int rev_star, String rev_comment, Date rev_date) {
		super();
		this.rev_no = rev_no;
		this.user_email = user_email;
		this.rst_id = rst_id;
		this.rev_star = rev_star;
		this.rev_comment = rev_comment;
		this.rev_date = rev_date;
	}

	public int getRev_no() {
		return rev_no;
	}

	public void setRev_no(int rev_no) {
		this.rev_no = rev_no;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public int getRst_id() {
		return rst_id;
	}

	public void setRst_id(int rst_id) {
		this.rst_id = rst_id;
	}

	public int getRev_star() {
		return rev_star;
	}

	public void setRev_star(int rev_star) {
		this.rev_star = rev_star;
	}

	public String getRev_comment() {
		return rev_comment;
	}

	public void setRev_comment(String rev_comment) {
		this.rev_comment = rev_comment;
	}

	public Date getRev_date() {
		return rev_date;
	}

	public void setRev_date(Date rev_date) {
		this.rev_date = rev_date;
	}

	@Override
	public String toString() {
		return "RevDTO [rev_no=" + rev_no + ", user_email=" + user_email + ", rst_id=" + rst_id + ", rev_star="
				+ rev_star + ", rev_comment=" + rev_comment + ", rev_date=" + rev_date + "]";
	}

}
