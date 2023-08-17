package com.sh.pj.mypage;

public class AcceptDTO {

	private int ac_no;
	private int sitter_type;
	private String sitter_id;
	private String dolbom_type;
	private int dolbom_no;
	private String accept_sitter;
	private String accept_dolbom;
	
	public AcceptDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getAc_no() {
		return ac_no;
	}

	public void setAc_no(int ac_no) {
		this.ac_no = ac_no;
	}

	public int getSitter_type() {
		return sitter_type;
	}

	public void setSitter_type(int sitter_type) {
		this.sitter_type = sitter_type;
	}

	public String getSitter_id() {
		return sitter_id;
	}

	public void setSitter_id(String sitter_id) {
		this.sitter_id = sitter_id;
	}

	public String getDolbom_type() {
		return dolbom_type;
	}

	public void setDolbom_type(String dolbom_type) {
		this.dolbom_type = dolbom_type;
	}

	public int getDolbom_no() {
		return dolbom_no;
	}

	public void setDolbom_no(int dolbom_no) {
		this.dolbom_no = dolbom_no;
	}

	public String getAccept_sitter() {
		return accept_sitter;
	}

	public void setAccept_sitter(String accept_sitter) {
		this.accept_sitter = accept_sitter;
	}

	public String getAccept_dolbom() {
		return accept_dolbom;
	}

	public void setAccept_dolbom(String accept_dolbom) {
		this.accept_dolbom = accept_dolbom;
	}

	@Override
	public String toString() {
		return "AcceptDTO [ac_no=" + ac_no + ", sitter_type=" + sitter_type + ", sitter_id=" + sitter_id
				+ ", dolbom_type=" + dolbom_type + ", dolbom_no=" + dolbom_no + ", accept_sitter=" + accept_sitter
				+ ", accept_dolbom=" + accept_dolbom + "]";
	}

	public AcceptDTO(int ac_no, int sitter_type, String sitter_id, String dolbom_type, int dolbom_no,
			String accept_sitter, String accept_dolbom) {
		super();
		this.ac_no = ac_no;
		this.sitter_type = sitter_type;
		this.sitter_id = sitter_id;
		this.dolbom_type = dolbom_type;
		this.dolbom_no = dolbom_no;
		this.accept_sitter = accept_sitter;
		this.accept_dolbom = accept_dolbom;
	}
	
	

}
