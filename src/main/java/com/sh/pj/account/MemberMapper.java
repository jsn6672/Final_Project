package com.sh.pj.account;

public interface MemberMapper {

	MemberDTO getUserID(MemberDTO aDTO);

	int regAccount(MemberDTO mDTO);

	int checkEmail(MemberDTO mDTO);

	MemberDTO getUserEMail(MemberDTO mDTO);

	int updateUserPW(MemberDTO mDTO);


}
