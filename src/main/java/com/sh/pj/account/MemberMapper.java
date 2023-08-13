package com.sh.pj.account;

public interface MemberMapper {

	MemberDTO getUserID(MemberDTO aDTO);

	int regAccount(MemberDTO mDTO);

	int checkEmail(MemberDTO mDTO);

	MemberDTO getUserEMail(MemberDTO mDTO);

	int updateUserPW(MemberDTO mDTO);

	int checkid(MemberDTO mDTO);

	int checkuserEMail(MemberDTO mDTO);


}
