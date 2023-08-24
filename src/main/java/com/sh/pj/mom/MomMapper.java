package com.sh.pj.mom;

import java.util.List;

import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;
import com.sh.pj.care.CareDTO;

public interface MomMapper {

	List<MomDTO> getAll(MomDTO momDTO);
	MomDTO detail(MomDTO momDTO);
	int regDolbom(DolbomDTO dDTO);
	int regMomSitter(MomDTO momDTO);
	MemberDTO detailUser(MomDTO mm);
	int deleteMomsitter(MomDTO mDTO);


	int changemsstatus(MemberDTO mDTO);
	MomDTO getMomSitterInfo(MemberDTO mDTO);
	int updateMomSitter(MomDTO momDTO);
	
	

}
