package com.sh.pj.account;

import java.util.List;

import com.sh.pj.ReviewDTO;
import com.sh.pj.care.CareDTO;
import com.sh.pj.care.CareTakerDTO;
import com.sh.pj.mom.MomDTO;
import com.sh.pj.mom.MomTakerDTO;
import com.sh.pj.mypage.ContractDTO;
import com.sh.pj.pet.PetDTO;
import com.sh.pj.pet.PetTakerDTO;

public interface MemberMapper {

	MemberDTO getUserID(MemberDTO aDTO);

	int regAccount(MemberDTO mDTO);

	int checkEmail(MemberDTO mDTO);

	MemberDTO getUserEMail(MemberDTO mDTO);

	int updateUserPW(MemberDTO mDTO);

	int checkid(MemberDTO mDTO);

	int checkuserEMail(MemberDTO mDTO);

	int regPTAccount(PetTakerDTO ptDTO);

	int regMTAccount(MomTakerDTO mtDTO);

	int regCTAccount(CareTakerDTO ctDTO);

	int changectstatus(MemberDTO mDTO);

	int changemtstatus(MemberDTO mDTO);

	int changeptstatus(MemberDTO mDTO);
	
	countDTO countAll();

	int upSCount();
	int upDCount();

	int endCnt(ContractDTO cntDTO);
	
	List<ContractDTO> getAllNotRegReview(DolbomDTO d);
	int countMustReviewCnt(DolbomDTO d);
	int updateReviewStatus(ReviewDTO rDTO);
	
//	최초 카운트 계산용 메소드 / 계산 후 주석처리해도 상관 없음
	int countPetSitter();
	int countMomSitter();
	int countCareSitter();

	int countDolbom();

	int countCont();

	int regDefaultcount(countDTO cntDTO);

	DolbomDTO getDolbomInfo(DolbomDTO dDTO);

	int updateOnDolbomInfo(DolbomDTO dd);
	int updateOffDolbomInfo(DolbomDTO dd);

	int msUpdate(MomDTO momDTO);
	int csUpdate(CareDTO cDTO);
	int psUpdate(PetDTO pDTO);





	
	


}
