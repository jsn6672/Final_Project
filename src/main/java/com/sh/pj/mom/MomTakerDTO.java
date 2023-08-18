package com.sh.pj.mom;

import org.springframework.web.multipart.MultipartFile;

public class MomTakerDTO {
	private String mt_id;
	private String mt_file;
	private MultipartFile mt_Rfile;
	
	public MomTakerDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getMt_id() {
		return mt_id;
	}

	public void setMt_id(String mt_id) {
		this.mt_id = mt_id;
	}

	public String getMt_file() {
		return mt_file;
	}

	public void setMt_file(String mt_file) {
		this.mt_file = mt_file;
	}

	public MultipartFile getMt_Rfile() {
		return mt_Rfile;
	}

	public void setMt_Rfile(MultipartFile mt_Rfile) {
		this.mt_Rfile = mt_Rfile;
	}

	public MomTakerDTO(String mt_id, String mt_file, MultipartFile mt_Rfile) {
		super();
		this.mt_id = mt_id;
		this.mt_file = mt_file;
		this.mt_Rfile = mt_Rfile;
	}

	@Override
	public String toString() {
		return "MomTakerDTO [mt_id=" + mt_id + ", mt_file=" + mt_file + ", mt_Rfile=" + mt_Rfile + "]";
	}
	
}
