package com.sh.pj.mypage;

import java.util.List;


import com.sh.pj.account.MemberDTO;
import com.sh.pj.mom.MomDTO;

public interface MypageMapper {

	public MemberDTO getMemberById(MemberDTO m);
	
	public List<MemberDTO> getMember();

	public int PWUpdate(MemberDTO m);

	public int updateProfile(MemberDTO m);

	public AcceptDTO getAllcare(AcceptDTO aDTO);

	public AcceptDTO getAllmom(AcceptDTO aDTO);

	public AcceptDTO getAllpet(AcceptDTO aDTO);



	public int insertmoney(MoneyDTO mmDTO);

	public List<MoneyDTO> getbuylist();


}
