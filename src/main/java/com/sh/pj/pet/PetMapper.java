package com.sh.pj.pet;
import com.sh.pj.account.DolbomDTO;

import java.util.List;

public interface PetMapper {

	
	List<PetDTO> getAll(PetDTO petDTO);
	PetDTO detail(PetDTO petDTO);
	int regDolbom(DolbomDTO dDTO);





}
