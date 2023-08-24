package com.sh.pj.care;

import java.util.List;

import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;

public interface CareMapper {

	List<CareDTO> getAll(CareDTO cDTO);

	CareDTO detail(CareDTO cDTO);

	int regCareSitter(CareDTO cDTO);

	int regDolbom(DolbomDTO dDTO);

	int changecsstatus(MemberDTO mDTO);


}
