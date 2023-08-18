package com.sh.pj.mom;

import java.util.Arrays;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class MomDTO  {

	private String ms_id;
	private String ms_file;
	private MultipartFile ms_Rfile;
	private String ms_confirm;
	private String ms_confirm_answer;
	private String ms_cctv;
	private String ms_term;
	private String ms_day;
	private String ms_hour;
	private String ms_location1;
	private String ms_location2;
	private String ms_location3;
	private String ms_extra;
	private String ms_exp;
	private int ms_pay;
	private int ms_point;
	private int ms_count;
	private String ms_can_do;
	private String ms_can_type;
	private Date ms_ticket_start;
	private Date ms_ticket_end;
	private Date ms_write_date;

	private int[] ms_type;
	private int[] momsitter_act;

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
	
	public MomDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getMs_id() {
		return ms_id;
	}

	public void setMs_id(String ms_id) {
		this.ms_id = ms_id;
	}

	public String getMs_file() {
		return ms_file;
	}

	public void setMs_file(String ms_file) {
		this.ms_file = ms_file;
	}

	public MultipartFile getMs_Rfile() {
		return ms_Rfile;
	}

	public void setMs_Rfile(MultipartFile ms_Rfile) {
		this.ms_Rfile = ms_Rfile;
	}

	public String getMs_confirm() {
		return ms_confirm;
	}

	public void setMs_confirm(String ms_confirm) {
		this.ms_confirm = ms_confirm;
	}

	public String getMs_confirm_answer() {
		return ms_confirm_answer;
	}

	public void setMs_confirm_answer(String ms_confirm_answer) {
		this.ms_confirm_answer = ms_confirm_answer;
	}

	public String getMs_cctv() {
		return ms_cctv;
	}

	public void setMs_cctv(String ms_cctv) {
		this.ms_cctv = ms_cctv;
	}

	public String getMs_term() {
		return ms_term;
	}

	public void setMs_term(String ms_term) {
		this.ms_term = ms_term;
	}

	public String getMs_day() {
		return ms_day;
	}

	public void setMs_day(String ms_day) {
		this.ms_day = ms_day;
	}

	public String getMs_hour() {
		return ms_hour;
	}

	public void setMs_hour(String ms_hour) {
		this.ms_hour = ms_hour;
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

	public String getMs_extra() {
		return ms_extra;
	}

	public void setMs_extra(String ms_extra) {
		this.ms_extra = ms_extra;
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

	public String getMs_can_type() {
		return ms_can_type;
	}

	public void setMs_can_type(String ms_can_type) {
		this.ms_can_type = ms_can_type;
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

	public int[] getMs_type() {
		return ms_type;
	}

	public void setMs_type(int[] ms_type) {
		this.ms_type = ms_type;
	}

	public int[] getMomsitter_act() {
		return momsitter_act;
	}

	public void setMomsitter_act(int[] momsitter_act) {
		this.momsitter_act = momsitter_act;
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

	@Override
	public String toString() {
		return "MomDTO [ms_id=" + ms_id + ", ms_file=" + ms_file + ", ms_Rfile=" + ms_Rfile + ", ms_confirm="
				+ ms_confirm + ", ms_confirm_answer=" + ms_confirm_answer + ", ms_cctv=" + ms_cctv + ", ms_term="
				+ ms_term + ", ms_day=" + ms_day + ", ms_hour=" + ms_hour + ", ms_location1=" + ms_location1
				+ ", ms_location2=" + ms_location2 + ", ms_location3=" + ms_location3 + ", ms_extra=" + ms_extra
				+ ", ms_exp=" + ms_exp + ", ms_pay=" + ms_pay + ", ms_point=" + ms_point + ", ms_count=" + ms_count
				+ ", ms_can_do=" + ms_can_do + ", ms_can_type=" + ms_can_type + ", ms_ticket_start=" + ms_ticket_start
				+ ", ms_ticket_end=" + ms_ticket_end + ", ms_write_date=" + ms_write_date + ", ms_type="
				+ Arrays.toString(ms_type) + ", momsitter_act=" + Arrays.toString(momsitter_act) + ", monday=" + monday
				+ ", tuesday=" + tuesday + ", wednesday=" + wednesday + ", thursday=" + thursday + ", friday=" + friday
				+ ", saturday=" + saturday + ", sunday=" + sunday + ", monday_start=" + monday_start
				+ ", tuesday_start=" + tuesday_start + ", wednesday_start=" + wednesday_start + ", thursday_start="
				+ thursday_start + ", friday_start=" + friday_start + ", saturday_start=" + saturday_start
				+ ", sunday_start=" + sunday_start + ", monday_end=" + monday_end + ", tuesday_end=" + tuesday_end
				+ ", wednesday_end=" + wednesday_end + ", thursday_end=" + thursday_end + ", friday_end=" + friday_end
				+ ", saturday_end=" + saturday_end + ", sunday_end=" + sunday_end + "]";
	}

	public MomDTO(String ms_id, String ms_file, MultipartFile ms_Rfile, String ms_confirm, String ms_confirm_answer,
			String ms_cctv, String ms_term, String ms_day, String ms_hour, String ms_location1, String ms_location2,
			String ms_location3, String ms_extra, String ms_exp, int ms_pay, int ms_point, int ms_count,
			String ms_can_do, String ms_can_type, Date ms_ticket_start, Date ms_ticket_end, Date ms_write_date,
			int[] ms_type, int[] momsitter_act, String monday, String tuesday, String wednesday, String thursday,
			String friday, String saturday, String sunday, int monday_start, int tuesday_start, int wednesday_start,
			int thursday_start, int friday_start, int saturday_start, int sunday_start, int monday_end, int tuesday_end,
			int wednesday_end, int thursday_end, int friday_end, int saturday_end, int sunday_end) {
		super();
		this.ms_id = ms_id;
		this.ms_file = ms_file;
		this.ms_Rfile = ms_Rfile;
		this.ms_confirm = ms_confirm;
		this.ms_confirm_answer = ms_confirm_answer;
		this.ms_cctv = ms_cctv;
		this.ms_term = ms_term;
		this.ms_day = ms_day;
		this.ms_hour = ms_hour;
		this.ms_location1 = ms_location1;
		this.ms_location2 = ms_location2;
		this.ms_location3 = ms_location3;
		this.ms_extra = ms_extra;
		this.ms_exp = ms_exp;
		this.ms_pay = ms_pay;
		this.ms_point = ms_point;
		this.ms_count = ms_count;
		this.ms_can_do = ms_can_do;
		this.ms_can_type = ms_can_type;
		this.ms_ticket_start = ms_ticket_start;
		this.ms_ticket_end = ms_ticket_end;
		this.ms_write_date = ms_write_date;
		this.ms_type = ms_type;
		this.momsitter_act = momsitter_act;
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
	}
	
	
	
	
	
	
	 
	
	
}
