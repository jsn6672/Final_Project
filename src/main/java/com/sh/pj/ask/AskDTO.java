package com.sh.pj.ask;

import java.util.Date;

public class AskDTO {

	 private int inquiry_no;
	 private String inquiry_id;
	 private String inquiry_title;
	 private String inquiry_body;
	 private Date inquiry_question_day;
	 private String inquiry_category;
	 private String inquiry_encoding;
	 private String inquiry_type;
	 
	 
	public AskDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getInquiry_no() {
		return inquiry_no;
	}

	public void setInquiry_no(int inquiry_no) {
		this.inquiry_no = inquiry_no;
	}

	public String getInquiry_id() {
		return inquiry_id;
	}

	public void setInquiry_id(String inquiry_id) {
		this.inquiry_id = inquiry_id;
	}

	public String getInquiry_title() {
		return inquiry_title;
	}

	public void setInquiry_title(String inquiry_title) {
		this.inquiry_title = inquiry_title;
	}

	public String getInquiry_body() {
		return inquiry_body;
	}

	public void setInquiry_body(String inquiry_body) {
		this.inquiry_body = inquiry_body;
	}

	public Date getInquiry_question_day() {
		return inquiry_question_day;
	}

	public void setInquiry_question_day(Date inquiry_question_day) {
		this.inquiry_question_day = inquiry_question_day;
	}

	public String getInquiry_category() {
		return inquiry_category;
	}

	public void setInquiry_category(String inquiry_category) {
		this.inquiry_category = inquiry_category;
	}

	public String getInquiry_encoding() {
		return inquiry_encoding;
	}

	public void setInquiry_encoding(String inquiry_encoding) {
		this.inquiry_encoding = inquiry_encoding;
	}

	public String getInquiry_type() {
		return inquiry_type;
	}

	public void setInquiry_type(String inquiry_type) {
		this.inquiry_type = inquiry_type;
	}

	public AskDTO(int inquiry_no, String inquiry_id, String inquiry_title, String inquiry_body,
			Date inquiry_question_day, String inquiry_category, String inquiry_encoding, String inquiry_type) {
		super();
		this.inquiry_no = inquiry_no;
		this.inquiry_id = inquiry_id;
		this.inquiry_title = inquiry_title;
		this.inquiry_body = inquiry_body;
		this.inquiry_question_day = inquiry_question_day;
		this.inquiry_category = inquiry_category;
		this.inquiry_encoding = inquiry_encoding;
		this.inquiry_type = inquiry_type;
	}

	@Override
	public String toString() {
		return "AskDTO [inquiry_no=" + inquiry_no + ", inquiry_id=" + inquiry_id + ", inquiry_title=" + inquiry_title
				+ ", inquiry_body=" + inquiry_body + ", inquiry_question_day=" + inquiry_question_day
				+ ", inquiry_category=" + inquiry_category + ", inquiry_encoding=" + inquiry_encoding
				+ ", inquiry_type=" + inquiry_type + "]";
	}
	
	 
}

