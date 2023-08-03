package com.sh.pj;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.pj.account.MembertDAO;
import com.sh.pj.account.MemberDTO;


@Controller
public class HomeController {
	
	@Autowired
	private MembertDAO aDAO;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		aDAO.logincheck(req);	

		req.setAttribute("contentPage", "index.jsp");
		return "home";
	}
	@RequestMapping(value = "go.home", method = RequestMethod.GET)
	public String home2(HttpServletRequest req) {
		aDAO.logincheck(req);	

		req.setAttribute("contentPage", "index.jsp");
		return "home";
	}
	
	@RequestMapping(value = "login.go", method = RequestMethod.GET)
	public String logingo(HttpServletRequest req) {

		aDAO.logincheck(req);	
		req.setAttribute("contentPage", "loginPage.jsp");
		return "home";
	}
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String logindo(HttpServletRequest req, MemberDTO aDTO) {
		
		aDAO.login(req, aDTO);
		aDAO.logincheck(req);
		if (req.getAttribute("loginfail") != null) {
			req.setAttribute("contentPage", "loginPage.jsp");			
		} else {
			req.setAttribute("contentPage", "index.jsp");
		}
		
		return "home";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req, MemberDTO aDTO) {
		
		aDAO.logout(req);
		aDAO.logincheck(req);
			req.setAttribute("contentPage", "index.jsp");
		
		return "home";
	}
	
	@RequestMapping(value = "regAccount.go", method = RequestMethod.GET)
	public String regaccountgo(HttpServletRequest req, MemberDTO aDTO) {
		
		aDAO.logincheck(req);
		req.setAttribute("contentPage", "regaccount.jsp");
		
		return "home";
	}
	
	
	
	
}
