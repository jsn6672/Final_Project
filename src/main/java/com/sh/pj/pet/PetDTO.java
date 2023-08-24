package com.sh.pj.pet;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sh.pj.account.MemberDTO;

public class PetDTO {

	private String ps_id;
	private String ps_file;
	private MultipartFile ps_Rfile;
	private String ps_confirm;
	private String ps_confirm_answer;
	private String ps_cctv;
	private String ps_term;
	private String ps_day;
	private String ps_hour;
	private String ps_location1;
	private String ps_location2;
	private String ps_location3;
	private String ps_extra;
	private String ps_exp;
	private int ps_pay;
	private int ps_point;
	private int ps_count;
	private String ps_can_do;
	private String ps_can_type;
	private String ps_notice;
	private Date ps_ticket_start;
	private Date ps_ticket_end;
	private Date ps_write_date;

	private int[] ps_type;
	private int[] petsitter_act;

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
	
	public PetDTO() {
		// TODO Auto-generated constructor stub
	}

	public PetDTO(String ps_id, String ps_file, MultipartFile ps_Rfile, String ps_confirm, String ps_confirm_answer,
			String ps_cctv, String ps_term, String ps_day, String ps_hour, String ps_location1, String ps_location2,
			String ps_location3, String ps_extra, String ps_exp, int ps_pay, int ps_point, int ps_count,
			String ps_can_do, String ps_can_type, String ps_notice, Date ps_ticket_start, Date ps_ticket_end,
			Date ps_write_date, int[] ps_type, int[] petsitter_act, String monday, String tuesday, String wednesday,
			String thursday, String friday, String saturday, String sunday, int monday_start, int tuesday_start,
			int wednesday_start, int thursday_start, int friday_start, int saturday_start, int sunday_start,
			int monday_end, int tuesday_end, int wednesday_end, int thursday_end, int friday_end, int saturday_end,
			int sunday_end, MemberDTO mm) {
		super();
		this.ps_id = ps_id;
		this.ps_file = ps_file;
		this.ps_Rfile = ps_Rfile;
		this.ps_confirm = ps_confirm;
		this.ps_confirm_answer = ps_confirm_answer;
		this.ps_cctv = ps_cctv;
		this.ps_term = ps_term;
		this.ps_day = ps_day;
		this.ps_hour = ps_hour;
		this.ps_location1 = ps_location1;
		this.ps_location2 = ps_location2;
		this.ps_location3 = ps_location3;
		this.ps_extra = ps_extra;
		this.ps_exp = ps_exp;
		this.ps_pay = ps_pay;
		this.ps_point = ps_point;
		this.ps_count = ps_count;
		this.ps_can_do = ps_can_do;
		this.ps_can_type = ps_can_type;
		this.ps_notice = ps_notice;
		this.ps_ticket_start = ps_ticket_start;
		this.ps_ticket_end = ps_ticket_end;
		this.ps_write_date = ps_write_date;
		this.ps_type = ps_type;
		this.petsitter_act = petsitter_act;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
		this.monday_start = monday_start;
		this.tuesday_start = tuesday_start;
		this.wednesday_start = wednesday_start;
		this.thursday_start = thursday_start;
		this.friday_start = friday_start;
		this.saturday_start = saturday_start;
		this.sunday_start = sunday_start;
		this.monday_end = monday_end;
		this.tuesday_end = tuesday_end;
		this.wednesday_end = wednesday_end;
		this.thursday_end = thursday_end;
		this.friday_end = friday_end;
		this.saturday_end = saturday_end;
		this.sunday_end = sunday_end;
		this.mm = mm;
	}

	public String getPs_id() {
		return ps_id;
	}

	public void setPs_id(String ps_id) {
		this.ps_id = ps_id;
	}

	public String getPs_file() {
		return ps_file;
	}

	public void setPs_file(String ps_file) {
		this.ps_file = ps_file;
	}

	public MultipartFile getPs_Rfile() {
		return ps_Rfile;
	}

	public void setPs_Rfile(MultipartFile ps_Rfile) {
		this.ps_Rfile = ps_Rfile;
	}

	public String getPs_confirm() {
		return ps_confirm;
	}

	public void setPs_confirm(String ps_confirm) {
		this.ps_confirm = ps_confirm;
	}

	public String getPs_confirm_answer() {
		return ps_confirm_answer;
	}

	public void setPs_confirm_answer(String ps_confirm_answer) {
		this.ps_confirm_answer = ps_confirm_answer;
	}

	public String getPs_cctv() {
		return ps_cctv;
	}

	public void setPs_cctv(String ps_cctv) {
		this.ps_cctv = ps_cctv;
	}

	public String getPs_term() {
		return ps_term;
	}

	public void setPs_term(String ps_term) {
		this.ps_term = ps_term;
	}

	public String getPs_day() {
		return ps_day;
	}

	public void setPs_day(String ps_day) {
		this.ps_day = ps_day;
	}

	public String getPs_hour() {
		return ps_hour;
	}

	public void setPs_hour(String ps_hour) {
		this.ps_hour = ps_hour;
	}

	public String getPs_location1() {
		return ps_location1;
	}

	public void setPs_location1(String ps_location1) {
		this.ps_location1 = ps_location1;
	}

	public String getPs_location2() {
		return ps_location2;
	}

	public void setPs_location2(String ps_location2) {
		this.ps_location2 = ps_location2;
	}

	public String getPs_location3() {
		return ps_location3;
	}

	public void setPs_location3(String ps_location3) {
		this.ps_location3 = ps_location3;
	}

	public String getPs_extra() {
		return ps_extra;
	}

	public void setPs_extra(String ps_extra) {
		this.ps_extra = ps_extra;
	}

	public String getPs_exp() {
		return ps_exp;
	}

	public void setPs_exp(String ps_exp) {
		this.ps_exp = ps_exp;
	}

	public int getPs_pay() {
		return ps_pay;
	}

	public void setPs_pay(int ps_pay) {
		this.ps_pay = ps_pay;
	}

	public int getPs_point() {
		return ps_point;
	}

	public void setPs_point(int ps_point) {
		this.ps_point = ps_point;
	}

	public int getPs_count() {
		return ps_count;
	}

	public void setPs_count(int ps_count) {
		this.ps_count = ps_count;
	}

	public String getPs_can_do() {
		return ps_can_do;
	}

	public void setPs_can_do(String ps_can_do) {
		this.ps_can_do = ps_can_do;
	}

	public String getPs_can_type() {
		return ps_can_type;
	}

	public void setPs_can_type(String ps_can_type) {
		this.ps_can_type = ps_can_type;
	}

	public String getPs_notice() {
		return ps_notice;
	}

	public void setPs_notice(String ps_notice) {
		this.ps_notice = ps_notice;
	}

	public Date getPs_ticket_start() {
		return ps_ticket_start;
	}

	public void setPs_ticket_start(Date ps_ticket_start) {
		this.ps_ticket_start = ps_ticket_start;
	}

	public Date getPs_ticket_end() {
		return ps_ticket_end;
	}

	public void setPs_ticket_end(Date ps_ticket_end) {
		this.ps_ticket_end = ps_ticket_end;
	}

	public Date getPs_write_date() {
		return ps_write_date;
	}

	public void setPs_write_date(Date ps_write_date) {
		this.ps_write_date = ps_write_date;
	}

	public int[] getPs_type() {
		return ps_type;
	}

	public void setPs_type(int[] ps_type) {
		this.ps_type = ps_type;
	}

	public int[] getPetsitter_act() {
		return petsitter_act;
	}

	public void setPetsitter_act(int[] petsitter_act) {
		this.petsitter_act = petsitter_act;
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

	@Override
	public String toString() {
		return "PetDTO [ps_id=" + ps_id + ", ps_file=" + ps_file + ", ps_Rfile=" + ps_Rfile + ", ps_confirm="
				+ ps_confirm + ", ps_confirm_answer=" + ps_confirm_answer + ", ps_cctv=" + ps_cctv + ", ps_term="
				+ ps_term + ", ps_day=" + ps_day + ", ps_hour=" + ps_hour + ", ps_location1=" + ps_location1
				+ ", ps_location2=" + ps_location2 + ", ps_location3=" + ps_location3 + ", ps_extra=" + ps_extra
				+ ", ps_exp=" + ps_exp + ", ps_pay=" + ps_pay + ", ps_point=" + ps_point + ", ps_count=" + ps_count
				+ ", ps_can_do=" + ps_can_do + ", ps_can_type=" + ps_can_type + ", ps_notice=" + ps_notice
				+ ", ps_ticket_start=" + ps_ticket_start + ", ps_ticket_end=" + ps_ticket_end + ", ps_write_date="
				+ ps_write_date + ", ps_type=" + Arrays.toString(ps_type) + ", petsitter_act="
				+ Arrays.toString(petsitter_act) + ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday="
				+ wednesday + ", thursday=" + thursday + ", friday=" + friday + ", saturday=" + saturday + ", sunday="
				+ sunday + ", monday_start=" + monday_start + ", tuesday_start=" + tuesday_start + ", wednesday_start="
				+ wednesday_start + ", thursday_start=" + thursday_start + ", friday_start=" + friday_start
				+ ", saturday_start=" + saturday_start + ", sunday_start=" + sunday_start + ", monday_end=" + monday_end
				+ ", tuesday_end=" + tuesday_end + ", wednesday_end=" + wednesday_end + ", thursday_end=" + thursday_end
				+ ", friday_end=" + friday_end + ", saturday_end=" + saturday_end + ", sunday_end=" + sunday_end
				+ ", mm=" + mm + "]";
	}
	
	
	
	}
