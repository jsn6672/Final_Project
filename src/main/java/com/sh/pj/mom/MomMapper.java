package com.sh.pj.mom;

import java.util.List;

public interface MomMapper {

	List<MomDTO> getAll(MomDTO momDTO);

	MomDTO detail(MomDTO momDTO);

	int regMomSitter(MomDTO momDTO);

}
