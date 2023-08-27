package com.sh.pj;

import java.util.Date;

import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;

public class ReviewDTO {

	private int review_no;
	private String review_taker_id;
	private String review_sitter_id;
	private int review_dolbom_no;
	private String review_txt;
	private Date review_create_at;
	private int review_point;
	private int review_cont_no;

	private MemberDTO memberDTO;
	private String review_category;
	private DolbomDTO r_dolbomDTO;
	private int r_count;

	@Override
	public String toString() {
		return "ReviewDTO [review_no=" + review_no + ", review_taker_id=" + review_taker_id + ", review_sitter_id="
				+ review_sitter_id + ", review_dolbom_no=" + review_dolbom_no + ", review_txt=" + review_txt
				+ ", review_create_at=" + review_create_at + ", review_point=" + review_point + ", review_cont_no="
				+ review_cont_no + ", memberDTO=" + memberDTO + ", review_category=" + review_category
				+ ", r_dolbomDTO=" + r_dolbomDTO + ", r_count=" + r_count + "]";
	}

	public int getR_count() {
		return r_count;
	}

	public void setR_count(int r_count) {
		this.r_count = r_count;
	}

	public DolbomDTO getR_dolbomDTO() {
		return r_dolbomDTO;
	}

	public void setR_dolbomDTO(DolbomDTO r_dolbomDTO) {
		this.r_dolbomDTO = r_dolbomDTO;
	}

	public String getReview_category() {
		return review_category;
	}

	public void setReview_category(String review_category) {
		this.review_category = review_category;
	}

	public int getReview_point() {
		return review_point;
	}

	public void setReview_point(int review_point) {
		this.review_point = review_point;
	}

	public int getReview_cont_no() {
		return review_cont_no;
	}

	public void setReview_cont_no(int review_cont_no) {
		this.review_cont_no = review_cont_no;
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

}
