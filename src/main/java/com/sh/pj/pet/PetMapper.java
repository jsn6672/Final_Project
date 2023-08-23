package com.sh.pj.pet;

import com.sh.pj.ReviewDTO;
import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;
import com.sh.pj.care.CareDTO;

import java.util.List;

public interface PetMapper {

	List<PetDTO> getAll(PetDTO petDTO);

    PetDTO detail(PetDTO petDTO);

    int regPetSitter(PetDTO pDTO);
    MemberDTO detailUser(PetDTO pp);
    int deletePetsitter(PetDTO pDTO);
    int regDolbom(DolbomDTO dDTO);
    int changemsstatus(MemberDTO mDTO);


}
