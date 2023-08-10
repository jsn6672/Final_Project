package com.sh.pj.mypage;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.sh.pj.account.MemberDTO;
import com.sh.pj.account.MemberMapper;

@Service
public class MypageDAO {

	@Autowired
	private SqlSession ss;
	
	public void getMember(HttpServletRequest req) {
		req.setAttribute("myMembers", ss.getMapper(MypageMapper.class).getMember());
		
	}

	public static void update(MemberDTO m, HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		
		MemberDTO loginMember = (MemberDTO) req.getSession().getAttribute("loginMember");
		
	}
}
