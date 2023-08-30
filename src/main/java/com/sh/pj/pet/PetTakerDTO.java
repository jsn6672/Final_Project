package com.sh.pj.pet;

import org.springframework.web.multipart.MultipartFile;

import com.sh.pj.account.MemberDTO;

public class PetTakerDTO {
	private String pt_id;
	private String pt_file;
	private MultipartFile pt_Rfile;

	private MemberDTO mm;

	@Override
	public String toString() {
		return "PetTakerDTO [pt_id=" + pt_id + ", pt_file=" + pt_file + ", pt_Rfile=" + pt_Rfile + ", mm=" + mm + "]";
	}

	public MemberDTO getMm() {
		return mm;
	}

	public void setMm(MemberDTO mm) {
		this.mm = mm;
	}

	public String getPt_id() {
		return pt_id;
	}

	public void setPt_id(String pt_id) {
		this.pt_id = pt_id;
	}

	public String getPt_file() {
		return pt_file;
	}

	public void setPt_file(String pt_file) {
		this.pt_file = pt_file;
	}

	public MultipartFile getPt_Rfile() {
		return pt_Rfile;
	}

	public void setPt_Rfile(MultipartFile pt_Rfile) {
		this.pt_Rfile = pt_Rfile;
	}

}
