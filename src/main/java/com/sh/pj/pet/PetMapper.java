package com.sh.pj.pet;

import com.sh.pj.ReviewDTO;
import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;

import java.util.List;

public interface PetMapper {

	public List<PetDTO> getAll(PetDTO petDTO);

	public PetDTO detail(PetDTO petDTO);

	public int regPetSitter(PetDTO pDTO);

	public MemberDTO detailUser(PetDTO pp);

	public int deletePetsitter(PetDTO pDTO);

	public int regDolbom(DolbomDTO dDTO);

	public int changemsstatus(MemberDTO mDTO);

	public int updateDolbom(DolbomDTO dDTO);
	
	public List<ReviewDTO> review(PetDTO petDTO);

	public PetDTO getPetSitterInfo(MemberDTO mDTO);

	
	public int updatePetSitter(PetDTO pDTO);

	public List<DolbomDTO> getAllTaker(DolbomDTO dolbomDTO);

	public MemberDTO detailUser2(DolbomDTO pp);

	public DolbomDTO detailtaker(DolbomDTO dolbomDTO);


}
