package com.sh.pj.account;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.sh.pj.mypage.ContractDTO;

public class DolbomDTO {
	private int d_no;
	private String d_id;
	private String d_name;
	private int d_category;
	private int d_year;
	private int d_month;
	private String d_day;
	private String d_hour;
	private String d_check;
	private String d_location;
	private String d_gender;
	private String d_personality;
	private int d_pay;
	private String d_cctv;
	private String d_can_do;
	private int[] dolbom_act;

	private String location1;
	private String location2;
	private String location3;
	
	
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

	private String d_sitterage;
	private String d_need;
	private String d_onoff;
	private String d_term;
	private Date d_startdate;
	private Date d_writedate;
	private Date d_enddate;

	private List<ContractDTO> cntDTOs;
	private String cntDTOMessage;

	private int age;
	private String agetype;
	private String m_addr1;
	private String m_addr2;
	private String m_addr3;
	
	private MemberDTO mm;

	public DolbomDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getD_no() {
		return d_no;
	}

	public void setD_no(int d_no) {
		this.d_no = d_no;
	}

	public String getD_id() {
		return d_id;
	}

	public void setD_id(String d_id) {
		this.d_id = d_id;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public int getD_category() {
		return d_category;
	}

	public void setD_category(int d_category) {
		this.d_category = d_category;
	}

	public int getD_year() {
		return d_year;
	}

	public void setD_year(int d_year) {
		this.d_year = d_year;
	}

	public int getD_month() {
		return d_month;
	}

	public void setD_month(int d_month) {
		this.d_month = d_month;
	}

	public String getD_day() {
		return d_day;
	}

	public void setD_day(String d_day) {
		this.d_day = d_day;
	}

	public String getD_hour() {
		return d_hour;
	}

	public void setD_hour(String d_hour) {
		this.d_hour = d_hour;
	}

	public String getD_check() {
		return d_check;
	}

	public void setD_check(String d_check) {
		this.d_check = d_check;
	}

	public String getD_location() {
		return d_location;
	}

	public void setD_location(String d_location) {
		this.d_location = d_location;
	}

	public String getD_gender() {
		return d_gender;
	}

	public void setD_gender(String d_gender) {
		this.d_gender = d_gender;
	}

	public String getD_personality() {
		return d_personality;
	}

	public void setD_personality(String d_personality) {
		this.d_personality = d_personality;
	}

	public int getD_pay() {
		return d_pay;
	}

	public void setD_pay(int d_pay) {
		this.d_pay = d_pay;
	}

	public String getD_cctv() {
		return d_cctv;
	}

	public void setD_cctv(String d_cctv) {
		this.d_cctv = d_cctv;
	}

	public String getD_can_do() {
		return d_can_do;
	}

	public void setD_can_do(String d_can_do) {
		this.d_can_do = d_can_do;
	}

	public int[] getDolbom_act() {
		return dolbom_act;
	}

	public void setDolbom_act(int[] dolbom_act) {
		this.dolbom_act = dolbom_act;
	}

	public String getLocation1() {
		return location1;
	}

	public void setLocation1(String location1) {
		this.location1 = location1;
	}

	public String getLocation2() {
		return location2;
	}

	public void setLocation2(String location2) {
		this.location2 = location2;
	}

	public String getLocation3() {
		return location3;
	}

	public void setLocation3(String location3) {
		this.location3 = location3;
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

	public String getD_sitterage() {
		return d_sitterage;
	}

	public void setD_sitterage(String d_sitterage) {
		this.d_sitterage = d_sitterage;
	}

	public String getD_need() {
		return d_need;
	}

	public void setD_need(String d_need) {
		this.d_need = d_need;
	}

	public String getd_onoff() {
		return d_onoff;
	}

	public void setd_onoff(String d_onoff) {
		this.d_onoff = d_onoff;
	}

	public String getD_term() {
		return d_term;
	}

	public void setD_term(String d_term) {
		this.d_term = d_term;
	}

	public Date getD_startdate() {
		return d_startdate;
	}

	public void setD_startdate(Date d_startdate) {
		this.d_startdate = d_startdate;
	}

	public Date getD_writedate() {
		return d_writedate;
	}

	public void setD_writedate(Date d_writedate) {
		this.d_writedate = d_writedate;
	}

	public Date getD_enddate() {
		return d_enddate;
	}

	public void setD_enddate(Date d_enddate) {
		this.d_enddate = d_enddate;
	}

	public List<ContractDTO> getCntDTOs() {
		return cntDTOs;
	}

	public void setCntDTOs(List<ContractDTO> cntDTOs) {
		this.cntDTOs = cntDTOs;
	}

	public String getCntDTOMessage() {
		return cntDTOMessage;
	}

	public void setCntDTOMessage(String cntDTOMessage) {
		this.cntDTOMessage = cntDTOMessage;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAgetype() {
		return agetype;
	}

	public void setAgetype(String agetype) {
		this.agetype = agetype;
	}

	public String getM_addr1() {
		return m_addr1;
	}

	public void setM_addr1(String m_addr1) {
		this.m_addr1 = m_addr1;
	}

	public String getM_addr2() {
		return m_addr2;
	}

	public void setM_addr2(String m_addr2) {
		this.m_addr2 = m_addr2;
	}

	public String getM_addr3() {
		return m_addr3;
	}

	public void setM_addr3(String m_addr3) {
		this.m_addr3 = m_addr3;
	}

	public MemberDTO getMm() {
		return mm;
	}

	public void setMm(MemberDTO mm) {
		this.mm = mm;
	}

	@Override
	public String toString() {
		return "DolbomDTO [d_no=" + d_no + ", d_id=" + d_id + ", d_name=" + d_name + ", d_category=" + d_category
				+ ", d_year=" + d_year + ", d_month=" + d_month + ", d_day=" + d_day + ", d_hour=" + d_hour
				+ ", d_check=" + d_check + ", d_location=" + d_location + ", d_gender=" + d_gender + ", d_personality="
				+ d_personality + ", d_pay=" + d_pay + ", d_cctv=" + d_cctv + ", d_can_do=" + d_can_do + ", dolbom_act="
				+ Arrays.toString(dolbom_act) + ", location1=" + location1 + ", location2=" + location2 + ", location3="
				+ location3 + ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday + ", thursday="
				+ thursday + ", friday=" + friday + ", saturday=" + saturday + ", sunday=" + sunday + ", monday_start="
				+ monday_start + ", tuesday_start=" + tuesday_start + ", wednesday_start=" + wednesday_start
				+ ", thursday_start=" + thursday_start + ", friday_start=" + friday_start + ", saturday_start="
				+ saturday_start + ", sunday_start=" + sunday_start + ", monday_end=" + monday_end + ", tuesday_end="
				+ tuesday_end + ", wednesday_end=" + wednesday_end + ", thursday_end=" + thursday_end + ", friday_end="
				+ friday_end + ", saturday_end=" + saturday_end + ", sunday_end=" + sunday_end + ", d_sitterage="
				+ d_sitterage + ", d_need=" + d_need + ", d_onoff=" + d_onoff + ", d_term=" + d_term + ", d_startdate="
				+ d_startdate + ", d_writedate=" + d_writedate + ", d_enddate=" + d_enddate + ", cntDTOs=" + cntDTOs
				+ ", cntDTOMessage=" + cntDTOMessage + ", age=" + age + ", agetype=" + agetype + ", m_addr1=" + m_addr1
				+ ", m_addr2=" + m_addr2 + ", m_addr3=" + m_addr3 + ", mm=" + mm + "]";
	}

	public DolbomDTO(int d_no, String d_id, String d_name, int d_category, int d_year, int d_month, String d_day,
			String d_hour, String d_check, String d_location, String d_gender, String d_personality, int d_pay,
			String d_cctv, String d_can_do, int[] dolbom_act, String location1, String location2, String location3,
			String monday, String tuesday, String wednesday, String thursday, String friday, String saturday,
			String sunday, int monday_start, int tuesday_start, int wednesday_start, int thursday_start,
			int friday_start, int saturday_start, int sunday_start, int monday_end, int tuesday_end, int wednesday_end,
			int thursday_end, int friday_end, int saturday_end, int sunday_end, String d_sitterage, String d_need,
			String d_onoff, String d_term, Date d_startdate, Date d_writedate, Date d_enddate,
			List<ContractDTO> cntDTOs, String cntDTOMessage, int age, String agetype, String m_addr1, String m_addr2,
			String m_addr3, MemberDTO mm) {
		super();
		this.d_no = d_no;
		this.d_id = d_id;
		this.d_name = d_name;
		this.d_category = d_category;
		this.d_year = d_year;
		this.d_month = d_month;
		this.d_day = d_day;
		this.d_hour = d_hour;
		this.d_check = d_check;
		this.d_location = d_location;
		this.d_gender = d_gender;
		this.d_personality = d_personality;
		this.d_pay = d_pay;
		this.d_cctv = d_cctv;
		this.d_can_do = d_can_do;
		this.dolbom_act = dolbom_act;
		this.location1 = location1;
		this.location2 = location2;
		this.location3 = location3;
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
		this.d_sitterage = d_sitterage;
		this.d_need = d_need;
		this.d_onoff = d_onoff;
		this.d_term = d_term;
		this.d_startdate = d_startdate;
		this.d_writedate = d_writedate;
		this.d_enddate = d_enddate;
		this.cntDTOs = cntDTOs;
		this.cntDTOMessage = cntDTOMessage;
		this.age = age;
		this.agetype = agetype;
		this.m_addr1 = m_addr1;
		this.m_addr2 = m_addr2;
		this.m_addr3 = m_addr3;
		this.mm = mm;
	}

	
}
