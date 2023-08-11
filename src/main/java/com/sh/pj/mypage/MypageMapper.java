package com.sh.pj.mypage;

import java.util.List;

import com.sh.pj.account.MemberDTO;

public interface MypageMapper {

	MemberDTO getMemberById(MemberDTO m);
	
	public List<MemberDTO> getMember();

	public int PWUpdate(MemberDTO m);

}
