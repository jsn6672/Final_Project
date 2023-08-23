package com.sh.pj.pet;

import com.sh.pj.ReviewDTO;
import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;
import com.sh.pj.care.CareDTO;

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

}
