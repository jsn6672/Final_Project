package com.sh.pj.account;

import org.springframework.web.multipart.MultipartFile;

public class AccountDTO {
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_gender;
	private String user_location;
	private String user_pic;
	private MultipartFile pic;
	private String ms_id;
	private String mt_id;
	private String ps_id;
	private String pt_id;
	private String cs_id;
	private String ct_id;
	@Override
	public String toString() {
		return "AccountDTO [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", user_gender="
				+ user_gender + ", user_location=" + user_location + ", user_pic=" + user_pic + ", pic=" + pic
				+ ", ms_id=" + ms_id + ", mt_id=" + mt_id + ", ps_id=" + ps_id + ", pt_id=" + pt_id + ", cs_id=" + cs_id
				+ ", ct_id=" + ct_id + "]";
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
