package com.sh.pj.account;

import com.sh.pj.mom.MomTakerDTO;
import com.sh.pj.pet.PetTakerDTO;

public interface MemberMapper {

	MemberDTO getUserID(MemberDTO aDTO);

	int regAccount(MemberDTO mDTO);

	int checkEmail(MemberDTO mDTO);

	MemberDTO getUserEMail(MemberDTO mDTO);

	int updateUserPW(MemberDTO mDTO);

	int checkid(MemberDTO mDTO);

	int checkuserEMail(MemberDTO mDTO);

	int regPTAccount(PetTakerDTO ptDTO);

	int regMTAccount(MomTakerDTO mtDTO);



}
