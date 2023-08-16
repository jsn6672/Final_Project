package com.sh.pj.pet;

import java.util.List;

public interface PetMapper {

	
	List<PetDTO> getAll(PetDTO petDTO);
	
	PetDTO detail(PetDTO petDTO);


}
