package com.sh.pj.mom;

import java.util.List;

import com.sh.pj.ReviewDTO;
import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;

public interface MomMapper {

	public List<MomDTO> getAll(MomDTO momDTO);

	public MomDTO detail(MomDTO momDTO);

	public int regDolbom(DolbomDTO dDTO);

	public int regMomSitter(MomDTO momDTO);

	public MemberDTO detailUser(MomDTO mm);

	public int deleteMomsitter(MomDTO mDTO);

	public int changemsstatus(MemberDTO mDTO);

	public List<ReviewDTO> review(MomDTO momDTO);

	public DolbomDTO detailtaker(DolbomDTO dolbomDTO);

	public MemberDTO detailUser2(DolbomDTO pp);

	public List<DolbomDTO> getAllTaker(DolbomDTO dolbomDTO);

}
