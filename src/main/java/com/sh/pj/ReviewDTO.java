package com.sh.pj;

import java.util.Date;

import com.sh.pj.account.MemberDTO;

public class ReviewDTO {

	 private int review_no; 
	 private String review_taker_id; 
	 private String review_sitter_id; 
	 private int review_dolbom_no; 
	 private String review_txt; 
	 private Date review_create_at; 
	 
	 private MemberDTO memberDTO;
	 
	 public ReviewDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReviewDTO(int review_no, String review_taker_id, String review_sitter_id, int review_dolbom_no,
			String review_txt, Date review_create_at, MemberDTO memberDTO) {
		super();
		this.review_no = review_no;
		this.review_taker_id = review_taker_id;
		this.review_sitter_id = review_sitter_id;
		this.review_dolbom_no = review_dolbom_no;
		this.review_txt = review_txt;
		this.review_create_at = review_create_at;
		this.memberDTO = memberDTO;
	}

	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}

	public String getReview_taker_id() {
		return review_taker_id;
	}

	public void setReview_taker_id(String review_taker_id) {
		this.review_taker_id = review_taker_id;
	}

	public String getReview_sitter_id() {
		return review_sitter_id;
	}

	public void setReview_sitter_id(String review_sitter_id) {
		this.review_sitter_id = review_sitter_id;
	}

	public int getReview_dolbom_no() {
		return review_dolbom_no;
	}

	public void setReview_dolbom_no(int review_dolbom_no) {
		this.review_dolbom_no = review_dolbom_no;
	}

	public String getReview_txt() {
		return review_txt;
	}

	public void setReview_txt(String review_txt) {
		this.review_txt = review_txt;
	}

	public Date getReview_create_at() {
		return review_create_at;
	}

	public void setReview_create_at(Date review_create_at) {
		this.review_create_at = review_create_at;
	}

	public MemberDTO getMemberDTO() {
		return memberDTO;
	}

	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}

	@Override
	public String toString() {
		return "ReviewDTO [review_no=" + review_no + ", review_taker_id=" + review_taker_id + ", review_sitter_id="
				+ review_sitter_id + ", review_dolbom_no=" + review_dolbom_no + ", review_txt=" + review_txt
				+ ", review_create_at=" + review_create_at + ", memberDTO=" + memberDTO + "]";
	}
	 
	 
	 
	 
	 
	
	
}
