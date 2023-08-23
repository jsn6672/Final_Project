package com.sh.pj.pet;

import com.sh.pj.ReviewDTO;
import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;

import java.util.List;

public interface PetMapper {

	List<PetDTO> getAll(PetDTO petDTO);

	PetDTO detail(PetDTO petDTO);

	int regDolbom(DolbomDTO dDTO);

	int regPetSitter(PetDTO pDTO);

	MemberDTO detailUser(PetDTO pp);

	int deletePetsitter(PetDTO pDTO);

	List<ReviewDTO> review(PetDTO petDTO);

	int updateDolbom(DolbomDTO dDTO);

}
