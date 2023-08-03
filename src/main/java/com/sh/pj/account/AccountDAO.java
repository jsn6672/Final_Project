package com.sh.pj.account;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDAO {
	
	@Autowired
	private SqlSession ss;
	
	
	public void login(HttpServletRequest req, AccountDTO aDTO) {
		
		AccountDTO dbAccount = ss.getMapper(AccountMapper.class).getUserID(aDTO);
		
		System.out.println(dbAccount);
		
		if (dbAccount != null) {
			if (dbAccount.getUser_pw().equals(aDTO.getUser_pw())) {
				req.getSession().setAttribute("userInfo", dbAccount);
			}else {
				req.setAttribute("loginfail", "이런! ID나 비밀번호가 틀렸습니다 <br> 다시 입력해주세요");
			}
		} else {
			req.setAttribute("loginfail", "이런! ID나 비밀번호가 틀렸습니다 <br> 다시 입력해주세요");
		}
	}
	

	public void logincheck(HttpServletRequest req) {
		
		AccountDTO a = (AccountDTO) req.getSession().getAttribute("userInfo");
		
		System.out.println(a);
		
		if (a != null) {
			req.setAttribute("loginPage", "loginok.jsp");
		}else {
			req.setAttribute("loginPage", "login.jsp");
		}
		
	}
	
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("userInfo", null);
	}
	
	

}
