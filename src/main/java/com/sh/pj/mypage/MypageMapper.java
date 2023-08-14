package com.sh.pj.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sh.pj.account.MemberDTO;

public interface MypageMapper {

	public MemberDTO getMemberById(MemberDTO m);
	
	public List<MemberDTO> getMember();

	public int PWUpdate(MemberDTO m);

	public int updateProfile(MemberDTO m);

}
