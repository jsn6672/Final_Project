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
			
			mDTO.setUser_email_auth("1");
			
			mDTO.setUser_phone(req.getParameter("phone_first") + "-" + req.getParameter("phone_second") + "-" + req.getParameter("phone_third"));
			
			System.out.println(mDTO);
			
			
			if (ss.getMapper(MemberMapper.class).regAccount(mDTO) == 1) {
				
				System.out.println("등록 완료");
				req.setAttribute("loginfail", "회원가입이 완료되었습니다<br>다시 로그인해주세요");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("loginfail", "회원가입이 실패하였습니다<br>왤까요");

		}

	}

	public int emailcheck(HttpServletRequest req, MemberDTO mDTO) {
	
		return ss.getMapper(MemberMapper.class).checkEmail(mDTO);
	}


	public void pwchangego(HttpServletRequest req, MemberDTO mDTO) {
		
		req.setAttribute("info", ss.getMapper(MemberMapper.class).getUserEMail(mDTO));
		
	}

	public void pwchangedo(HttpServletRequest req, MemberDTO mDTO) {
		
		if(ss.getMapper(MemberMapper.class).updateUserPW(mDTO) == 1) {
			System.out.println("수정 완료");
			req.setAttribute("loginfail", "비밀번호가 변경되었습니다<br>다시 로그인해주세요");
		}
	}


}
