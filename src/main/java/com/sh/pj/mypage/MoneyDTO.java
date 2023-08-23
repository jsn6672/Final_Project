package com.sh.pj.mypage;

import java.util.Date;

public class MoneyDTO {
	private int mm_no;
	private String mm_id;
	private String mm_name;
	private int mm_date;
	private String mm_ticket;
	private int mm_price;
	private String mm_state;
	private Date mm_start_date;
	private Date mm_end_date;
	
	public MoneyDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getMm_no() {
		return mm_no;
	}

	public void setMm_no(int mm_no) {
		this.mm_no = mm_no;
	}

	public String getMm_id() {
		return mm_id;
	}

	public void setMm_id(String mm_id) {
		this.mm_id = mm_id;
	}

	public String getMm_name() {
		return mm_name;
	}

	public void setMm_name(String mm_name) {
		this.mm_name = mm_name;
	}

	public int getMm_date() {
		return mm_date;
	}

	public void setMm_date(int mm_date) {
		this.mm_date = mm_date;
	}

	public String getMm_ticket() {
		return mm_ticket;
	}

	public void setMm_ticket(String mm_ticket) {
		this.mm_ticket = mm_ticket;
	}

	public int getMm_price() {
		return mm_price;
	}

	public void setMm_price(int mm_price) {
		this.mm_price = mm_price;
	}

	public String getMm_state() {
		return mm_state;
	}

	public void setMm_state(String mm_state) {
		this.mm_state = mm_state;
	}

	public Date getMm_start_date() {
		return mm_start_date;
	}

	public void setMm_start_date(Date mm_start_date) {
		this.mm_start_date = mm_start_date;
	}

	public Date getMm_end_date() {
		return mm_end_date;
	}

	public void setMm_end_date(Date mm_end_date) {
		this.mm_end_date = mm_end_date;
	}

	public MoneyDTO(int mm_no, String mm_id, String mm_name, int mm_date, String mm_ticket, int mm_price,
			String mm_state, Date mm_start_date, Date mm_end_date) {
		super();
		this.mm_no = mm_no;
		this.mm_id = mm_id;
		this.mm_name = mm_name;
		this.mm_date = mm_date;
		this.mm_ticket = mm_ticket;
		this.mm_price = mm_price;
		this.mm_state = mm_state;
		this.mm_start_date = mm_start_date;
		this.mm_end_date = mm_end_date;
	}

	@Override
	public String toString() {
		return "MoneyDTO [mm_no=" + mm_no + ", mm_id=" + mm_id + ", mm_name=" + mm_name + ", mm_date=" + mm_date
				+ ", mm_ticket=" + mm_ticket + ", mm_price=" + mm_price + ", mm_state=" + mm_state + ", mm_start_date="
				+ mm_start_date + ", mm_end_date=" + mm_end_date + "]";
	}

	
	
}
