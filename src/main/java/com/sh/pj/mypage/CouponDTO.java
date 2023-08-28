package com.sh.pj.mypage;

public class CouponDTO {
	private int cp_no;
	private String cp_id;
	private int cp_date;
	private int cp_used;
	private String cp_txt;
	
	public CouponDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getCp_no() {
		return cp_no;
	}

	public void setCp_no(int cp_no) {
		this.cp_no = cp_no;
	}

	public String getCp_id() {
		return cp_id;
	}

	public void setCp_id(String cp_id) {
		this.cp_id = cp_id;
	}

	public int getCp_date() {
		return cp_date;
	}

	public void setCp_date(int cp_date) {
		this.cp_date = cp_date;
	}

	public int getCp_used() {
		return cp_used;
	}

	public void setCp_used(int cp_used) {
		this.cp_used = cp_used;
	}

	public String getCp_txt() {
		return cp_txt;
	}

	public void setCp_txt(String cp_txt) {
		this.cp_txt = cp_txt;
	}

	public CouponDTO(int cp_no, String cp_id, int cp_date, int cp_used, String cp_txt) {
		super();
		this.cp_no = cp_no;
		this.cp_id = cp_id;
		this.cp_date = cp_date;
		this.cp_used = cp_used;
		this.cp_txt = cp_txt;
	}

	@Override
	public String toString() {
		return "CouponDTO [cp_no=" + cp_no + ", cp_id=" + cp_id + ", cp_date=" + cp_date + ", cp_used=" + cp_used
				+ ", cp_txt=" + cp_txt + "]";
	}
}
