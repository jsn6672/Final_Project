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

}
