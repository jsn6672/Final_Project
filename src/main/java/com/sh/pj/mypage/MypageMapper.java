package com.sh.pj.mypage;

import java.util.List;

import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;
import com.sh.pj.mom.MomDTO;
import com.sh.pj.pet.PetDTO;

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

	public MemberDTO getUserID(ContractDTO cntDTO2);

	public int confirmticket(MoneyDTO mm);


}
