package com.sh.pj.pet;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class PetDTO {

	private int ps_no;
	private String ps_id;
	private MultipartFile ps_file;
	private String ps_certif;
	private String ps_cctv;
	private String ps_location1;
	private String ps_location2;
	private String ps_location3;
	private String ps_intro;
	private String ps_exp;
	private int ps_pay;
	private int ps_point;
	private int ps_count;
	private String ps_can_do;
	private int ps_can_age;
	private Date ps_ticket_start;
	private Date ps_ticket_end;
	private Date ps_write_date;
	
	public PetDTO() {
		// TODO Auto-generated constructor stub
	}

	public PetDTO(int ps_no, String ps_id, MultipartFile ps_file, String ps_certif, String ps_cctv, String ps_location1,
			String ps_location2, String ps_location3, String ps_intro, String ps_exp, int ps_pay, int ps_point,
			int ps_count, String ps_can_do, int ps_can_age, Date ps_ticket_start, Date ps_ticket_end,
			Date ps_write_date) {
		super();
		this.ps_no = ps_no;
		this.ps_id = ps_id;
		this.ps_file = ps_file;
		this.ps_certif = ps_certif;
		this.ps_cctv = ps_cctv;
		this.ps_location1 = ps_location1;
		this.ps_location2 = ps_location2;
		this.ps_location3 = ps_location3;
		this.ps_intro = ps_intro;
		this.ps_exp = ps_exp;
		this.ps_pay = ps_pay;
		this.ps_point = ps_point;
		this.ps_count = ps_count;
		this.ps_can_do = ps_can_do;
		this.ps_can_age = ps_can_age;
		this.ps_ticket_start = ps_ticket_start;
		this.ps_ticket_end = ps_ticket_end;
		this.ps_write_date = ps_write_date;
	}

	public int getps_no() {
		return ps_no;
	}

	public void setps_no(int ps_no) {
		this.ps_no = ps_no;
	}

	public String getps_id() {
		return ps_id;
	}

	public void setps_id(String ps_id) {
		this.ps_id = ps_id;
	}

	public MultipartFile getps_file() {
		return ps_file;
	}

	public void setps_file(MultipartFile ps_file) {
		this.ps_file = ps_file;
	}

	public String getps_certif() {
		return ps_certif;
	}

	public void setps_certif(String ps_certif) {
		this.ps_certif = ps_certif;
	}

	public String getps_cctv() {
		return ps_cctv;
	}

	public void setps_cctv(String ps_cctv) {
		this.ps_cctv = ps_cctv;
	}

	public String getps_location1() {
		return ps_location1;
	}

	public void setps_location1(String ps_location1) {
		this.ps_location1 = ps_location1;
	}

	public String getps_location2() {
		return ps_location2;
	}

	public void setps_location2(String ps_location2) {
		this.ps_location2 = ps_location2;
	}

	public String getps_location3() {
		return ps_location3;
	}

	public void setps_location3(String ps_location3) {
		this.ps_location3 = ps_location3;
	}

	public String getps_intro() {
		return ps_intro;
	}

	public void setps_intro(String ps_intro) {
		this.ps_intro = ps_intro;
	}

	public String getps_exp() {
		return ps_exp;
	}

	public void setps_exp(String ps_exp) {
		this.ps_exp = ps_exp;
	}

	public int getps_pay() {
		return ps_pay;
	}

	public void setps_pay(int ps_pay) {
		this.ps_pay = ps_pay;
	}

	public int getps_point() {
		return ps_point;
	}

	public void setps_point(int ps_point) {
		this.ps_point = ps_point;
	}

	public int getps_count() {
		return ps_count;
	}

	public void setps_count(int ps_count) {
		this.ps_count = ps_count;
	}

	public String getps_can_do() {
		return ps_can_do;
	}

	public void setps_can_do(String ps_can_do) {
		this.ps_can_do = ps_can_do;
	}

	public int getps_can_age() {
		return ps_can_age;
	}

	public void setps_can_age(int ps_can_age) {
		this.ps_can_age = ps_can_age;
	}

	public Date getps_ticket_start() {
		return ps_ticket_start;
	}

	public void setps_ticket_start(Date ps_ticket_start) {
		this.ps_ticket_start = ps_ticket_start;
	}

	public Date getps_ticket_end() {
		return ps_ticket_end;
	}

	public void setps_ticket_end(Date ps_ticket_end) {
		this.ps_ticket_end = ps_ticket_end;
	}

	public Date getps_write_date() {
		return ps_write_date;
	}

	public void setps_write_date(Date ps_write_date) {
		this.ps_write_date = ps_write_date;
	}

	@Override
	public String toString() {
		return "MomDTO [ps_no=" + ps_no + ", ps_id=" + ps_id + ", ps_file=" + ps_file + ", ps_certif=" + ps_certif
				+ ", ps_cctv=" + ps_cctv + ", ps_location1=" + ps_location1 + ", ps_location2=" + ps_location2
				+ ", ps_location3=" + ps_location3 + ", ps_intro=" + ps_intro + ", ps_exp=" + ps_exp + ", ps_pay="
				+ ps_pay + ", ps_point=" + ps_point + ", ps_count=" + ps_count + ", ps_can_do=" + ps_can_do
				+ ", ps_can_age=" + ps_can_age + ", ps_ticket_start=" + ps_ticket_start + ", ps_ticket_end="
				+ ps_ticket_end + ", ps_write_date=" + ps_write_date + "]";
	}
	
	
	
	
	
	
	 
	
	
}
