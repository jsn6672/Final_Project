package com.sh.pj.mypage;

import java.util.List;

import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;
import com.sh.pj.pet.PetDTO;

public class ContractDTO {

	private int cnt_no;
	private int cnt_type;
	private String cnt_sitter_id;
	private String cnt_dolbom_no;
	private String cnt_sitter_ok;
	private String cnt_dolbom_ok;

	private PetDTO cnt_petdto;
	private DolbomDTO cnt_dolbomdto;

	private List<DolbomDTO> cnt_list_dolbomdto;

	private MemberDTO cnt_memberDTO;
	private int age;
	private String agetype;

	private String cnt_can_do;

	@Override
	public String toString() {
		return "ContractDTO [cnt_no=" + cnt_no + ", cnt_type=" + cnt_type + ", cnt_sitter_id=" + cnt_sitter_id
				+ ", cnt_dolbom_no=" + cnt_dolbom_no + ", cnt_sitter_ok=" + cnt_sitter_ok + ", cnt_dolbom_ok="
				+ cnt_dolbom_ok + ", cnt_petdto=" + cnt_petdto + ", cnt_dolbomdto=" + cnt_dolbomdto
				+ ", cnt_list_dolbomdto=" + cnt_list_dolbomdto + ", cnt_memberDTO=" + cnt_memberDTO + ", age=" + age
				+ ", agetype=" + agetype + ", cnt_can_do=" + cnt_can_do + "]";
	}

	public List<DolbomDTO> getCnt_list_dolbomdto() {
		return cnt_list_dolbomdto;
	}

	public void setCnt_list_dolbomdto(List<DolbomDTO> cnt_list_dolbomdto) {
		this.cnt_list_dolbomdto = cnt_list_dolbomdto;
	}

	public String getCnt_can_do() {
		return cnt_can_do;
	}

	public void setCnt_can_do(String cnt_can_do) {
		this.cnt_can_do = cnt_can_do;
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

	public MemberDTO getCnt_memberDTO() {
		return cnt_memberDTO;
	}

	public void setCnt_memberDTO(MemberDTO cnt_memberDTO) {
		this.cnt_memberDTO = cnt_memberDTO;
	}

	public int getCnt_no() {
		return cnt_no;
	}

	public void setCnt_no(int cnt_no) {
		this.cnt_no = cnt_no;
	}

	public int getCnt_type() {
		return cnt_type;
	}

	public void setCnt_type(int cnt_type) {
		this.cnt_type = cnt_type;
	}

	public String getCnt_sitter_id() {
		return cnt_sitter_id;
	}

	public void setCnt_sitter_id(String cnt_sitter_id) {
		this.cnt_sitter_id = cnt_sitter_id;
	}

	public String getCnt_dolbom_no() {
		return cnt_dolbom_no;
	}

	public void setCnt_dolbom_no(String cnt_dolbom_no) {
		this.cnt_dolbom_no = cnt_dolbom_no;
	}

	public String getCnt_sitter_ok() {
		return cnt_sitter_ok;
	}

	public void setCnt_sitter_ok(String cnt_sitter_ok) {
		this.cnt_sitter_ok = cnt_sitter_ok;
	}

	public String getCnt_dolbom_ok() {
		return cnt_dolbom_ok;
	}

	public void setCnt_dolbom_ok(String cnt_dolbom_ok) {
		this.cnt_dolbom_ok = cnt_dolbom_ok;
	}

	public PetDTO getCnt_petdto() {
		return cnt_petdto;
	}

	public void setCnt_petdto(PetDTO cnt_petdto) {
		this.cnt_petdto = cnt_petdto;
	}

	public DolbomDTO getCnt_dolbomdto() {
		return cnt_dolbomdto;
	}

	public void setCnt_dolbomdto(DolbomDTO cnt_dolbomdto) {
		this.cnt_dolbomdto = cnt_dolbomdto;
	}

}
