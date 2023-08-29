package com.sh.pj.pet;

import com.sh.pj.ReviewDTO;
import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;

import com.sh.pj.ask.AskDTO;
import com.sh.pj.ask.AskSelector;
import com.sh.pj.care.CareDTO;



import java.util.List;

public interface PetMapper {

	public List<PetDTO> getAll(PetDTO petDTO);

	public PetDTO detail(PetDTO petDTO);

	public int regPetSitter(PetDTO pDTO);

	public MemberDTO detailUser(PetDTO pp);

	public int deletePetsitter(PetDTO pDTO);

	public int regDolbom(DolbomDTO dDTO);

	public int changePsStatus(MemberDTO mDTO);

	public int updateDolbom(DolbomDTO dDTO);
	
	public List<ReviewDTO> review(PetDTO petDTO);

	public PetDTO getPetSitterInfo(MemberDTO mDTO);

	public int updatePetSitter(PetDTO pDTO);

	public PetDTO getPetSitterPoint(ReviewDTO rDTO);
	
	public int updatePetSitterPoint(PetDTO c);

	public int getMsgCount(PetSelector sSel);

	public List<PetDTO> getMsg(PetSelector petSearch);

	public List<DolbomDTO> getAllTaker(DolbomDTO dolbomDTO);

	public MemberDTO detailUser2(DolbomDTO pp);

	public DolbomDTO detailtaker(DolbomDTO dolbomDTO);

	public int getMsgCount2(PetSelector petSearch);

	public List<DolbomDTO> getMsg2(PetSelector petSearch);

	public int noticeUP(PetDTO petDTO);

	public int noticeDOWN(PetDTO petDTO);

	public int noticeUpdate(PetDTO petDTO);

	public List<PetDTO> getAllPoint(PetDTO petDTO);






}
