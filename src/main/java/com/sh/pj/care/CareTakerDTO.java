package com.sh.pj.care;

import org.springframework.web.multipart.MultipartFile;

public class CareTakerDTO {
	private String ct_id;
	private String ct_file;
	private MultipartFile ct_Rfile;
	
	public CareTakerDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getCt_id() {
		return ct_id;
	}

	public void setCt_id(String ct_id) {
		this.ct_id = ct_id;
	}

	public String getCt_file() {
		return ct_file;
	}

	public void setCt_file(String ct_file) {
		this.ct_file = ct_file;
	}

	public MultipartFile getCt_Rfile() {
		return ct_Rfile;
	}

	public void setCt_Rfile(MultipartFile ct_Rfile) {
		this.ct_Rfile = ct_Rfile;
	}

	@Override
	public String toString() {
		return "CareTakerDTO [ct_id=" + ct_id + ", ct_file=" + ct_file + ", ct_Rfile=" + ct_Rfile + "]";
	}

	public CareTakerDTO(String ct_id, String ct_file, MultipartFile ct_Rfile) {
		super();
		this.ct_id = ct_id;
		this.ct_file = ct_file;
		this.ct_Rfile = ct_Rfile;
	}
	
	
}
