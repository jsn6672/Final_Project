package com.sh.pj.account;

import org.springframework.web.multipart.MultipartFile;

public class MemberDTO {
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_gender;
	private String user_phone;
	private String user_email_authkey;
	private String user_email_auth;
	private String user_email;
	private String user_location;
	private String user_pic;
	private MultipartFile pic;
	private String ms_id;
	private String mt_id;
	private String ps_id;
	private String pt_id;
	private String cs_id;
	private String ct_id;
	private String phone_first;
	private String phone_second;
	private String phone_third;
	private String m_addr1;
	private String m_addr2;
	private String m_addr3;

	@Override
	public String toString() {
		return "MemberDTO [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", user_gender="
				+ user_gender + ", user_phone=" + user_phone + ", user_email_authkey=" + user_email_authkey
				+ ", user_email_auth=" + user_email_auth + ", user_email=" + user_email + ", user_location="
				+ user_location + ", user_pic=" + user_pic + ", pic=" + pic + ", ms_id=" + ms_id + ", mt_id=" + mt_id
				+ ", ps_id=" + ps_id + ", pt_id=" + pt_id + ", cs_id=" + cs_id + ", ct_id=" + ct_id + ", phone_first="
				+ phone_first + ", phone_second=" + phone_second + ", phone_third=" + phone_third + ", m_addr1="
				+ m_addr1 + ", m_addr2=" + m_addr2 + ", m_addr3=" + m_addr3 + "]";
	}

	public String getPhone_first() {
		return phone_first;
	}

	public void setPhone_first(String phone_first) {
		this.phone_first = phone_first;
	}

	public String getPhone_second() {
		return phone_second;
	}

	public void setPhone_second(String phone_second) {
		this.phone_second = phone_second;
	}

	public String getPhone_third() {
		return phone_third;
	}

	public void setPhone_third(String phone_third) {
		this.phone_third = phone_third;
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

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email_authkey() {
		return user_email_authkey;
	}

	public void setUser_email_authkey(String user_email_authkey) {
		this.user_email_authkey = user_email_authkey;
	}

	public String getUser_email_auth() {
		return user_email_auth;
	}

	public void setUser_email_auth(String user_email_auth) {
		this.user_email_auth = user_email_auth;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_location() {
		return user_location;
	}

	public void setUser_location(String user_location) {
		this.user_location = user_location;
	}

	public String getUser_pic() {
		return user_pic;
	}

	public void setUser_pic(String user_pic) {
		this.user_pic = user_pic;
	}

	public MultipartFile getPic() {
		return pic;
	}

	public void setPic(MultipartFile pic) {
		this.pic = pic;
	}

	public String getMs_id() {
		return ms_id;
	}

	public void setMs_id(String ms_id) {
		this.ms_id = ms_id;
	}

	public String getMt_id() {
		return mt_id;
	}

	public void setMt_id(String mt_id) {
		this.mt_id = mt_id;
	}

	public String getPs_id() {
		return ps_id;
	}

	public void setPs_id(String ps_id) {
		this.ps_id = ps_id;
	}

	public String getPt_id() {
		return pt_id;
	}

	public void setPt_id(String pt_id) {
		this.pt_id = pt_id;
	}

	public String getCs_id() {
		return cs_id;
	}

	public void setCs_id(String cs_id) {
		this.cs_id = cs_id;
	}

	public String getCt_id() {
		return ct_id;
	}

	public void setCt_id(String ct_id) {
		this.ct_id = ct_id;
	}

}
