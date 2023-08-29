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

	CareDTO getCareSitterInfo(MemberDTO mDTO);

	int updateCareSitter(CareDTO cDTO);

	public CareDTO getCareSitterPoint(ReviewDTO rDTO);

	public int updateCareSitterPoint(CareDTO c);


	public int getMsgCount2(CareSelector careSearch);

	public List<DolbomDTO> getMsg2(CareSelector careSearch);

	public int getMsgCount(CareSelector sSel);

	public List<CareDTO> getMsg(CareSelector careSearch);

	public MemberDTO detailReview(ReviewDTO reviewDTO);

	public int csAccept(CareDTO cDTO);

	public int csReject(CareDTO cDTO);




}
