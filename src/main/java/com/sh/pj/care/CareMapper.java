package com.sh.pj.care;

import java.util.List;

import com.sh.pj.ReviewDTO;
import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;

public interface CareMapper {

	public List<CareDTO> getAll(CareDTO cDTO);

	public CareDTO detail(CareDTO cDTO);

	public int regCareSitter(CareDTO cDTO);

	public int regDolbom(DolbomDTO dDTO);

	public int changecsstatus(MemberDTO mDTO);

	public List<DolbomDTO> getAllTaker(DolbomDTO dolbomDTO);

	public MemberDTO detailUser(CareDTO pp);

	public List<ReviewDTO> review(CareDTO cDTO);

	public DolbomDTO detailtaker(DolbomDTO dolbomDTO);

	public MemberDTO detailUser2(DolbomDTO pp);


}
