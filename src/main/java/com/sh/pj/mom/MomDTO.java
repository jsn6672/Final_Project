package com.sh.pj.mom;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.sh.pj.care.CareDTO;

public class MomDTO  {

	private int ms_no;
	private String ms_id;
	private MultipartFile ms_file;
	private String ms_certif;
	private String ms_cctv;
	private String ms_location1;
	private String ms_location2;
	private String ms_location3;
	private String ms_intro;
	private String ms_exp;
	private int ms_pay;
	private int ms_point;
	private int ms_count;
	private String ms_can_do;
	private int ms_can_age;
	private Date ms_ticket_start;
	private Date ms_ticket_end;
	private Date ms_write_date;
	
	public MomDTO() {
		// TODO Auto-generated constructor stub
	}

	public MomDTO(int ms_no, String ms_id, MultipartFile ms_file, String ms_certif, String ms_cctv, String ms_location1,
			String ms_location2, String ms_location3, String ms_intro, String ms_exp, int ms_pay, int ms_point,
			int ms_count, String ms_can_do, int ms_can_age, Date ms_ticket_start, Date ms_ticket_end,
			Date ms_write_date) {
		super();
		this.ms_no = ms_no;
		this.ms_id = ms_id;
		this.ms_file = ms_file;
		this.ms_certif = ms_certif;
		this.ms_cctv = ms_cctv;
		this.ms_location1 = ms_location1;
		this.ms_location2 = ms_location2;
		this.ms_location3 = ms_location3;
		this.ms_intro = ms_intro;
		this.ms_exp = ms_exp;
		this.ms_pay = ms_pay;
		this.ms_point = ms_point;
		this.ms_count = ms_count;
		this.ms_can_do = ms_can_do;
		this.ms_can_age = ms_can_age;
		this.ms_ticket_start = ms_ticket_start;
		this.ms_ticket_end = ms_ticket_end;
		this.ms_write_date = ms_write_date;
	}

	public int getMs_no() {
		return ms_no;
	}

	public void setMs_no(int ms_no) {
		this.ms_no = ms_no;
	}

	public String getMs_id() {
		return ms_id;
	}

	public void setMs_id(String ms_id) {
		this.ms_id = ms_id;
	}

	public MultipartFile getMs_file() {
		return ms_file;
	}

	public void setMs_file(MultipartFile ms_file) {
		this.ms_file = ms_file;
	}

	public String getMs_certif() {
		return ms_certif;
	}

	public void setMs_certif(String ms_certif) {
		this.ms_certif = ms_certif;
	}

	public String getMs_cctv() {
		return ms_cctv;
	}

	public void setMs_cctv(String ms_cctv) {
		this.ms_cctv = ms_cctv;
	}

	public String getMs_location1() {
		return ms_location1;
	}

	public void setMs_location1(String ms_location1) {
		this.ms_location1 = ms_location1;
	}

	public String getMs_location2() {
		return ms_location2;
	}

	public void setMs_location2(String ms_location2) {
		this.ms_location2 = ms_location2;
	}

	public String getMs_location3() {
		return ms_location3;
	}

	public void setMs_location3(String ms_location3) {
		this.ms_location3 = ms_location3;
	}

	public String getMs_intro() {
		return ms_intro;
	}

	public void setMs_intro(String ms_intro) {
		this.ms_intro = ms_intro;
	}

	public String getMs_exp() {
		return ms_exp;
	}

	public void setMs_exp(String ms_exp) {
		this.ms_exp = ms_exp;
	}

	public int getMs_pay() {
		return ms_pay;
	}

	public void setMs_pay(int ms_pay) {
		this.ms_pay = ms_pay;
	}

	public int getMs_point() {
		return ms_point;
	}

	public void setMs_point(int ms_point) {
		this.ms_point = ms_point;
	}

	public int getMs_count() {
		return ms_count;
	}

	public void setMs_count(int ms_count) {
		this.ms_count = ms_count;
	}

	public String getMs_can_do() {
		return ms_can_do;
	}

	public void setMs_can_do(String ms_can_do) {
		this.ms_can_do = ms_can_do;
	}

	public int getMs_can_age() {
		return ms_can_age;
	}

	public void setMs_can_age(int ms_can_age) {
		this.ms_can_age = ms_can_age;
	}

	public Date getMs_ticket_start() {
		return ms_ticket_start;
	}

	public void setMs_ticket_start(Date ms_ticket_start) {
		this.ms_ticket_start = ms_ticket_start;
	}

	public Date getMs_ticket_end() {
		return ms_ticket_end;
	}

	public void setMs_ticket_end(Date ms_ticket_end) {
		this.ms_ticket_end = ms_ticket_end;
	}

	public Date getMs_write_date() {
		return ms_write_date;
	}

	public void setMs_write_date(Date ms_write_date) {
		this.ms_write_date = ms_write_date;
	}

	@Override
	public String toString() {
		return "MomDTO [ms_no=" + ms_no + ", ms_id=" + ms_id + ", ms_file=" + ms_file + ", ms_certif=" + ms_certif
				+ ", ms_cctv=" + ms_cctv + ", ms_location1=" + ms_location1 + ", ms_location2=" + ms_location2
				+ ", ms_location3=" + ms_location3 + ", ms_intro=" + ms_intro + ", ms_exp=" + ms_exp + ", ms_pay="
				+ ms_pay + ", ms_point=" + ms_point + ", ms_count=" + ms_count + ", ms_can_do=" + ms_can_do
				+ ", ms_can_age=" + ms_can_age + ", ms_ticket_start=" + ms_ticket_start + ", ms_ticket_end="
				+ ms_ticket_end + ", ms_write_date=" + ms_write_date + "]";
	}
	
	
	
	
	
	
	 
	
	
}
