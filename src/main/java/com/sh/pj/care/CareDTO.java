package com.sh.pj.care;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.sh.pj.account.MemberDTO;

public class CareDTO {

	private String cs_id;
	private String cs_file;
	private MultipartFile cs_Rfile;
	private String cs_confirm;
	private String cs_confirm_answer;
	private String cs_cctv;
	private String cs_term;
	private String cs_day;
	private String cs_hour;
	private String cs_location1;
	private String cs_location2;
	private String cs_location3;
	private String cs_extra;
	private String cs_exp;
	private int cs_pay;
	private BigDecimal cs_point;
	private int cs_count;
	private String cs_can_do;
	private String cs_can_type;
	private Date cs_ticket_start;
	private Date cs_ticket_end;
	private Date cs_write_date;
	private String cs_notice;

	private int[] cs_type;
	private int[] caresitter_act;

	private String monday;
	private String tuesday;
	private String wednesday;
	private String thursday;
	private String friday;
	private String saturday;
	private String sunday;

	private int monday_start;
	private int tuesday_start;
	private int wednesday_start;
	private int thursday_start;
	private int friday_start;
	private int saturday_start;
	private int sunday_start;
	private int monday_end;
	private int tuesday_end;
	private int wednesday_end;
	private int thursday_end;
	private int friday_end;
	private int saturday_end;
	private int sunday_end;

	private MemberDTO mm;

	public CareDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CareDTO [cs_id=" + cs_id + ", cs_file=" + cs_file + ", cs_Rfile=" + cs_Rfile + ", cs_confirm="
				+ cs_confirm + ", cs_confirm_answer=" + cs_confirm_answer + ", cs_cctv=" + cs_cctv + ", cs_term="
				+ cs_term + ", cs_day=" + cs_day + ", cs_hour=" + cs_hour + ", cs_location1=" + cs_location1
				+ ", cs_location2=" + cs_location2 + ", cs_location3=" + cs_location3 + ", cs_extra=" + cs_extra
				+ ", cs_exp=" + cs_exp + ", cs_pay=" + cs_pay + ", cs_point=" + cs_point + ", cs_count=" + cs_count
				+ ", cs_can_do=" + cs_can_do + ", cs_can_type=" + cs_can_type + ", cs_ticket_start=" + cs_ticket_start
				+ ", cs_ticket_end=" + cs_ticket_end + ", cs_write_date=" + cs_write_date + ", cs_notice=" + cs_notice
				+ ", cs_type=" + Arrays.toString(cs_type) + ", caresitter_act=" + Arrays.toString(caresitter_act)
				+ ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday + ", thursday=" + thursday
				+ ", friday=" + friday + ", saturday=" + saturday + ", sunday=" + sunday + ", monday_start="
				+ monday_start + ", tuesday_start=" + tuesday_start + ", wednesday_start=" + wednesday_start
				+ ", thursday_start=" + thursday_start + ", friday_start=" + friday_start + ", saturday_start="
				+ saturday_start + ", sunday_start=" + sunday_start + ", monday_end=" + monday_end + ", tuesday_end="
				+ tuesday_end + ", wednesday_end=" + wednesday_end + ", thursday_end=" + thursday_end + ", friday_end="
				+ friday_end + ", saturday_end=" + saturday_end + ", sunday_end=" + sunday_end + ", mm=" + mm + "]";
	}

	public BigDecimal getCs_point() {
		return cs_point;
	}

	public void setCs_point(BigDecimal cs_point) {
		this.cs_point = cs_point;
	}

	public String getCs_id() {
		return cs_id;
	}

	public void setCs_id(String cs_id) {
		this.cs_id = cs_id;
	}

	public String getCs_file() {
		return cs_file;
	}

	public void setCs_file(String cs_file) {
		this.cs_file = cs_file;
	}

	public MultipartFile getCs_Rfile() {
		return cs_Rfile;
	}

	public void setCs_Rfile(MultipartFile cs_Rfile) {
		this.cs_Rfile = cs_Rfile;
	}

	public String getCs_confirm() {
		return cs_confirm;
	}

	public void setCs_confirm(String cs_confirm) {
		this.cs_confirm = cs_confirm;
	}

	public String getCs_confirm_answer() {
		return cs_confirm_answer;
	}

	public void setCs_confirm_answer(String cs_confirm_answer) {
		this.cs_confirm_answer = cs_confirm_answer;
	}

	public String getCs_cctv() {
		return cs_cctv;
	}

	public void setCs_cctv(String cs_cctv) {
		this.cs_cctv = cs_cctv;
	}

	public String getCs_term() {
		return cs_term;
	}

	public void setCs_term(String cs_term) {
		this.cs_term = cs_term;
	}

	public String getCs_day() {
		return cs_day;
	}

	public void setCs_day(String cs_day) {
		this.cs_day = cs_day;
	}

	public String getCs_hour() {
		return cs_hour;
	}

	public void setCs_hour(String cs_hour) {
		this.cs_hour = cs_hour;
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

	public String getCs_extra() {
		return cs_extra;
	}

	public void setCs_extra(String cs_extra) {
		this.cs_extra = cs_extra;
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

	public String getCs_can_type() {
		return cs_can_type;
	}

	public void setCs_can_type(String cs_can_type) {
		this.cs_can_type = cs_can_type;
	}

	public String getCs_notice() {
		return cs_notice;
	}

	public void setCs_notice(String cs_notice) {
		this.cs_notice = cs_notice;
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

	public int[] getCs_type() {
		return cs_type;
	}

	public void setCs_type(int[] cs_type) {
		this.cs_type = cs_type;
	}

	public int[] getCaresitter_act() {
		return caresitter_act;
	}

	public void setCaresitter_act(int[] caresitter_act) {
		this.caresitter_act = caresitter_act;
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getWednesday() {
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	public int getMonday_start() {
		return monday_start;
	}

	public void setMonday_start(int monday_start) {
		this.monday_start = monday_start;
	}

	public int getTuesday_start() {
		return tuesday_start;
	}

	public void setTuesday_start(int tuesday_start) {
		this.tuesday_start = tuesday_start;
	}

	public int getWednesday_start() {
		return wednesday_start;
	}

	public void setWednesday_start(int wednesday_start) {
		this.wednesday_start = wednesday_start;
	}

	public int getThursday_start() {
		return thursday_start;
	}

	public void setThursday_start(int thursday_start) {
		this.thursday_start = thursday_start;
	}

	public int getFriday_start() {
		return friday_start;
	}

	public void setFriday_start(int friday_start) {
		this.friday_start = friday_start;
	}

	public int getSaturday_start() {
		return saturday_start;
	}

	public void setSaturday_start(int saturday_start) {
		this.saturday_start = saturday_start;
	}

	public int getSunday_start() {
		return sunday_start;
	}

	public void setSunday_start(int sunday_start) {
		this.sunday_start = sunday_start;
	}

	public int getMonday_end() {
		return monday_end;
	}

	public void setMonday_end(int monday_end) {
		this.monday_end = monday_end;
	}

	public int getTuesday_end() {
		return tuesday_end;
	}

	public void setTuesday_end(int tuesday_end) {
		this.tuesday_end = tuesday_end;
	}

	public int getWednesday_end() {
		return wednesday_end;
	}

	public void setWednesday_end(int wednesday_end) {
		this.wednesday_end = wednesday_end;
	}

	public int getThursday_end() {
		return thursday_end;
	}

	public void setThursday_end(int thursday_end) {
		this.thursday_end = thursday_end;
	}

	public int getFriday_end() {
		return friday_end;
	}

	public void setFriday_end(int friday_end) {
		this.friday_end = friday_end;
	}

	public int getSaturday_end() {
		return saturday_end;
	}

	public void setSaturday_end(int saturday_end) {
		this.saturday_end = saturday_end;
	}

	public int getSunday_end() {
		return sunday_end;
	}

	public void setSunday_end(int sunday_end) {
		this.sunday_end = sunday_end;
	}

	public MemberDTO getMm() {
		return mm;
	}

	public void setMm(MemberDTO mm) {
		this.mm = mm;
	}

}
