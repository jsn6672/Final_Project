package com.sh.pj.mypage;

import java.util.List;

import com.sh.pj.ReviewDTO;
import javax.servlet.http.HttpServletRequest;

import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;
import com.sh.pj.care.CareDTO;
import com.sh.pj.care.CareTakerDTO;
import com.sh.pj.mom.MomDTO;
import com.sh.pj.mom.MomTakerDTO;
import com.sh.pj.pet.PetDTO;
import com.sh.pj.pet.PetTakerDTO;

public interface MypageMapper {

	public MemberDTO getMemberById(MemberDTO m);

	public List<MemberDTO> getMember();

	public int PWUpdate(MemberDTO m);

	public int updateProfile(MemberDTO m);

	public List<ContractDTO> getAllSitterCont(ContractDTO cntDTO);

	public PetDTO getPetDTO(ContractDTO cntDTO);

	public DolbomDTO getDolbomDTO(ContractDTO cntDTO);

	public List<ContractDTO> getAllDolbomCont(ContractDTO cntDTO);

	public MemberDTO getTakerDTO(DolbomDTO dDTO);
	public int insertmoney(MoneyDTO mmDTO);

	public List<MoneyDTO> getbuylist();
	
	
	
	//시터로서 들어온 계약 갯수 확인용
	public int countSitterCont(ContractDTO cntDTO);
	//돌보미로서 들어온 계약 갯수 확인용
	public int countDolbomCont(ContractDTO cntDTO);
	//테이커로서 돌보미가 몇명인지 확인용
	public int countTakerCont(MemberDTO mDTO);

	public List<DolbomDTO> getDolbomList(MemberDTO mDTO);
	public List<DolbomDTO> getPetDolbomList(MemberDTO mDTO);
	public List<DolbomDTO> getMomDolbomList(MemberDTO mDTO);
	public List<DolbomDTO> getCareDolbomList(MemberDTO mDTO);

	public MemberDTO getUserID(ContractDTO cntDTO2);

	public int confirmticket(MoneyDTO mm);


	public int confirmdate1(MoneyDTO mm); 
	public int confirmdate3(MoneyDTO mm); 	
	public int confirmdate6(MoneyDTO mm); 
	public int confirmdate12(MoneyDTO mm); 

	public int confirmdatePet1(MoneyDTO mm); 
	public int confirmdatePet3(MoneyDTO mm); 	
	public int confirmdatePet6(MoneyDTO mm); 
	public int confirmdatePet12(MoneyDTO mm); 

	public int confirmdateCare1(MoneyDTO mm); 
	public int confirmdateCare3(MoneyDTO mm); 	
	public int confirmdateCare6(MoneyDTO mm); 
	public int confirmdateCare12(MoneyDTO mm); 
	

	public PetDTO getPetSitter(MemberDTO sitterDTO);
	public CareDTO getCareSitter(MemberDTO sitterDTO);
	public MomDTO getMomSitter(MemberDTO sitterDTO);

	public DolbomDTO getDolbomInfo(DolbomDTO dDTO);

	public int updateCntSitter(ContractDTO cntDTO);

	public int updateCntSitterNope(ContractDTO cntDTO);
	
	public int updateCntDolbom(ContractDTO cntDTO);
	
	public int updateCntDolbomNope(ContractDTO cntDTO);

	public List<MoneyDTO> getcertiflist();

	public List<MomDTO> getperiod(String user_id);

	public List<MoneyDTO> getbuypersonallist(String user_id);

	public int regReview(ReviewDTO rDTO);

	public List<ReviewDTO> getAllReview(MemberDTO mDTO);

	public DolbomDTO getDolbomReviewInfo(ReviewDTO rr);
	public List<CouponDTO> couponlist(String user_id);

	public int usecoupon(CouponDTO cp);

	public int updateMsStatusUp(MemberDTO mDTO);
	public int updateMsStatusDown(MemberDTO mDTO);
	public int updateCsStatusUp(MemberDTO mDTO);
	public int updateCsStatusDown(MemberDTO mDTO);
	public int updatePsStatusUp(MemberDTO mDTO);
	public int updatePsStatusDown(MemberDTO mDTO);

	public List<ReviewDTO> review();

	public List<MomDTO> getmsconfirm();

	public List<PetDTO> getpsconfirm();
	
	public List<CareDTO> getcsconfirm();
	
	public MemberDTO getMSuserinfo(MomDTO mmm);

	public MemberDTO getPSuserinfo(PetDTO mmm);
	
	public MemberDTO getCSuserinfo(CareDTO mmm);

	public int givecoupon(CouponDTO cp);

	public List<MomTakerDTO> getmtconfirm();

	public List<PetTakerDTO> getptconfirm();

	public List<CareTakerDTO> getctconfirm();

	public MemberDTO getMTuserinfo(MomTakerDTO mmm);

	public MemberDTO getPTuserinfo(PetTakerDTO mmm);

	public MemberDTO getCTuserinfo(CareTakerDTO mmm);
	public int userstatus(MoneyDTO mm);

	public List<MomDTO> getpointsMS();

	public List<PetDTO> getpointsPS();

	public List<PetDTO> getpointsCS();

	public int updateMsWriteDate(MemberDTO mDTO);
	public int updateCsWriteDate(MemberDTO mDTO);
	public int updatePsWriteDate(MemberDTO mDTO);







}
