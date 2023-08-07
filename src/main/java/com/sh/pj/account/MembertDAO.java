package com.sh.pj.account;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembertDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private ServletContext sc;

	public void login(HttpServletRequest req, MemberDTO mDTO) {

		MemberDTO dbAccount = ss.getMapper(MemberMapper.class).getUserID(mDTO);

		System.out.println(dbAccount);

		if (dbAccount != null) {
			if (dbAccount.getUser_pw().equals(mDTO.getUser_pw())) {
				req.getSession().setAttribute("userInfo", dbAccount);
			} else {
				req.setAttribute("loginfail", "이런! ID나 비밀번호가 틀렸습니다 <br> 다시 입력해주세요");
			}
		} else {
			req.setAttribute("loginfail", "이런! ID나 비밀번호가 틀렸습니다 <br> 다시 입력해주세요");
		}
	}

	public void logincheck(HttpServletRequest req) {

		MemberDTO a = (MemberDTO) req.getSession().getAttribute("userInfo");

		System.out.println(a);

		if (a != null) {
			req.setAttribute("loginPage", "loginok.jsp");
		} else {
			req.setAttribute("loginPage", "login.jsp");
		}

	}

	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("userInfo", null);
	}

	public void regAccount(HttpServletRequest req, MemberDTO mDTO) {
		try {
			String imgOrgName = mDTO.getPic().getOriginalFilename();
			long imgSize = mDTO.getPic().getSize();

			String extension = imgOrgName.substring(imgOrgName.lastIndexOf("."), imgOrgName.length());

			String newName = UUID.randomUUID().toString().split("-")[0];

			String path = sc.getRealPath("resources/img");

			File saveImg = new File(path + "//" + newName + extension);

			mDTO.getPic().transferTo(saveImg);
			mDTO.setUser_pic(newName + extension);
			
//			이메일 인증 너무 힘들어서 일단 회원가입 기능 먼저 만들기 ^^7;
			mDTO.setUser_email_auth("1");
			mDTO.setUser_email_authkey("나중에 다시 만들 계획 일단은 회원가입 가능한지 먼저 확인");
			
			
			if (ss.getMapper(MemberMapper.class).regAccount(mDTO) == 1) {
				
				System.out.println("등록 완료");
				req.setAttribute("loginfail", "회원가입이 완료되었습니다<br>다시 로그인해주세요");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int emailcheck(HttpServletRequest req, MemberDTO mDTO) {
		
		
		
		
		
		return ss.getMapper(MemberMapper.class).checkEmail(mDTO);
	}

}
