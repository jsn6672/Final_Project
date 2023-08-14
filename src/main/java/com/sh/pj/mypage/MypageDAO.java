package com.sh.pj.mypage;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.channels.Selector;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sh.pj.account.MemberDTO;
import com.sh.pj.account.MemberMapper;

@Service
public class MypageDAO {

	@Autowired
	private SqlSession ss;
	
	public void getMember(HttpServletRequest req) {
		req.setAttribute("myMembers", ss.getMapper(MypageMapper.class).getMember());
		
	}

	public void pwupdate(MemberDTO m, HttpServletRequest req) {
		MemberDTO loginMember = (MemberDTO) req.getSession().getAttribute("loginMember");
		String mpPPWInput = req.getParameter("user_pw");
		System.out.println("PW-----------------------");
		System.out.println(mpPPWInput);
		String mpPPWInputCheck = req.getParameter("mpPPWInputCheck");
		System.out.println("PWC-----------------------");
		System.out.println(mpPPWInputCheck);
		try {
			if (mpPPWInput != null) {
				if (mpPPWInput.equals(mpPPWInputCheck)) {
					m.setUser_pw(mpPPWInput);
					System.out.println("*-----------------------*");
					System.out.println(m.getUser_pw());
					if (ss.getMapper(MypageMapper.class).PWUpdate(m) == 1) {
						System.out.println(ss.getMapper(MypageMapper.class).PWUpdate(m));
						System.out.println("수정완료");
						req.setAttribute("loginfail", "비밀번호가 변경되었습니다<br>다시 로그인해주세요");
						/* req.getSession().setAttribute("userInfo", null); */
					}
				} else {
					System.out.println(ss.getMapper(MypageMapper.class).PWUpdate(m));
					req.setAttribute("wrongMessage", "비밀번호가 일치하지 않습니다.");
				}
			}
		} catch (Exception e) {
			req.setAttribute("wrongMessage", "비밀번호 변경에 실패했습니다.");
			e.printStackTrace();
		}
		
	}

	public void updateProfile(MemberDTO m, HttpServletRequest req) {
		MemberDTO loginMember = (MemberDTO) req.getSession().getAttribute("userInfo");
		String user_location = req.getParameter("user_location");
		System.out.println(user_location);
		String user_phone = req.getParameter("user_phone");
		System.out.println(user_phone);
		
		if (ss.getMapper(MypageMapper.class).updateProfile(m) == 1) {
			System.out.println("프로필 수정 성공");
			req.setAttribute("mypageContentPage", "mypageProfile.jsp");
			req.getSession().setAttribute("loginMember", m);
			
			req.getSession().setAttribute("userInfo", ss.getMapper(MypageMapper.class).getMemberById(m));
			 
		} else {
			System.out.println("프로필 수정 실패");
		}
	}
	
	
}
