package com.sh.pj.care;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class CareDTO {
	
	private int cs_no;
	private String cs_id;
	private MultipartFile cs_file;
	private String cs_certif;
	private String cs_cctv;
	private String cs_location1;
	private String cs_location2;
	private String cs_location3;
	private String cs_intro;
	private String cs_exp;
	private int cs_pay;
	private int cs_point;
	private int cs_count;
	private String cs_can_do;
	private int cs_can_age;
	private Date cs_ticket_start;
	private Date cs_ticket_end;
	private Date cs_write_date;
	
	public CareDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "careDTO [cs_no=" + cs_no + ", cs_id=" + cs_id + ", cs_file=" + cs_file + ", cs_certif=" + cs_certif
				+ ", cs_cctv=" + cs_cctv + ", cs_location1=" + cs_location1 + ", cs_location2=" + cs_location2
				+ ", cs_location3=" + cs_location3 + ", cs_intro=" + cs_intro + ", cs_exp=" + cs_exp + ", cs_pay="
				+ cs_pay + ", cs_point=" + cs_point + ", cs_count=" + cs_count + ", cs_can_do=" + cs_can_do
				+ ", cs_can_age=" + cs_can_age + ", cs_ticket_start=" + cs_ticket_start + ", cs_ticket_end="
				+ cs_ticket_end + ", cs_write_date=" + cs_write_date + "]";
	}

	public int getCs_no() {
		return cs_no;
	}

	public void setCs_no(int cs_no) {
		this.cs_no = cs_no;
	}

	public String getCs_id() {
		return cs_id;
	}

	public void setCs_id(String cs_id) {
		this.cs_id = cs_id;
	}

	public MultipartFile getCs_file() {
		return cs_file;
	}

	public void setCs_file(MultipartFile cs_file) {
		this.cs_file = cs_file;
	}

	public String getCs_certif() {
		return cs_certif;
	}

	public void setCs_certif(String cs_certif) {
		this.cs_certif = cs_certif;
	}

	public String getCs_cctv() {
		return cs_cctv;
	}

	public void setCs_cctv(String cs_cctv) {
		this.cs_cctv = cs_cctv;
	}

	public String getCs_location1() {
		return cs_location1;
	}

	public void setCs_location1(String cs_location1) {
		this.cs_location1 = cs_location1;
	}

	public String getCs_location2() {
		return cs_location2;
	}

	public void setCs_location2(String cs_location2) {
		this.cs_location2 = cs_location2;
	}

	public String getCs_location3() {
		return cs_location3;
	}

	public void setCs_location3(String cs_location3) {
		this.cs_location3 = cs_location3;
	}

	public String getCs_intro() {
		return cs_intro;
	}

	public void setCs_intro(String cs_intro) {
		this.cs_intro = cs_intro;
	}

	public String getCs_exp() {
		return cs_exp;
	}

	public void setCs_exp(String cs_exp) {
		this.cs_exp = cs_exp;
	}

	public int getCs_pay() {
		return cs_pay;
	}

	public void setCs_pay(int cs_pay) {
		this.cs_pay = cs_pay;
	}

	public int getCs_point() {
		return cs_point;
	}

	public void setCs_point(int cs_point) {
		this.cs_point = cs_point;
	}

	public int getCs_count() {
		return cs_count;
	}

	public void setCs_count(int cs_count) {
		this.cs_count = cs_count;
	}

	public String getCs_can_do() {
		return cs_can_do;
	}

	public void setCs_can_do(String cs_can_do) {
		this.cs_can_do = cs_can_do;
	}

	public int getCs_can_age() {
		return cs_can_age;
	}

	public void setCs_can_age(int cs_can_age) {
		this.cs_can_age = cs_can_age;
	}

	public Date getCs_ticket_start() {
		return cs_ticket_start;
	}

	public void setCs_ticket_start(Date cs_ticket_start) {
		this.cs_ticket_start = cs_ticket_start;
	}

	public Date getCs_ticket_end() {
		return cs_ticket_end;
	}

	public void setCs_ticket_end(Date cs_ticket_end) {
		this.cs_ticket_end = cs_ticket_end;
	}

	public Date getCs_write_date() {
		return cs_write_date;
	}

	public void setCs_write_date(Date cs_write_date) {
		this.cs_write_date = cs_write_date;
	}

	public CareDTO(int cs_no, String cs_id, MultipartFile cs_file, String cs_certif, String cs_cctv,
			String cs_location1, String cs_location2, String cs_location3, String cs_intro, String cs_exp, int cs_pay,
			int cs_point, int cs_count, String cs_can_do, int cs_can_age, Date cs_ticket_start, Date cs_ticket_end,
			Date cs_write_date) {
		super();
		this.cs_no = cs_no;
		this.cs_id = cs_id;
		this.cs_file = cs_file;
		this.cs_certif = cs_certif;
		this.cs_cctv = cs_cctv;
		this.cs_location1 = cs_location1;
		this.cs_location2 = cs_location2;
		this.cs_location3 = cs_location3;
		this.cs_intro = cs_intro;
		this.cs_exp = cs_exp;
		this.cs_pay = cs_pay;
		this.cs_point = cs_point;
		this.cs_count = cs_count;
		this.cs_can_do = cs_can_do;
		this.cs_can_age = cs_can_age;
		this.cs_ticket_start = cs_ticket_start;
		this.cs_ticket_end = cs_ticket_end;
		this.cs_write_date = cs_write_date;
	}
	
	
}
