package com.sh.pj.mom;

import java.util.List;

import com.sh.pj.ReviewDTO;
import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;
import com.sh.pj.care.CareDTO;
import com.sh.pj.pet.PetDTO;

import com.sh.pj.care.CareSelector;

import com.sh.pj.pet.PetSelector;

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

	public int updateMomSitter(MomDTO momDTO);

	public MomDTO getMomSitterInfo(MemberDTO mDTO);

	public MomDTO getMomSitterPoint(ReviewDTO rDTO);

	public int updateMomSitterPoint(MomDTO c);
	public int getMsgCount(MomSelector momSearch);

	public int getMsgCount2(MomSelector mSel);

	public List<DolbomDTO> getMsg2(MomSelector momSearch);

	public int updateDolbom(DolbomDTO dDTO);

	public List<MomDTO> getMsg(MomSelector momSearch);

	public MemberDTO detailReview(ReviewDTO reviewDTO);

	public int noticeUP(MomDTO momDTO);

	public int noticeUpdate(MomDTO momDTO);

	public int noticeDOWN(MomDTO momDTO);

	public List<MomDTO> test();
	public List<MomDTO> getMsConfirm();

	public List<MomDTO> getAllPoint(MomDTO momDTO);





}
