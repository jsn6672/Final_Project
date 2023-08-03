package com.sh.pj;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.pj.account.AccountDAO;
import com.sh.pj.account.AccountDTO;


@Controller
public class HomeController {
	
	@Autowired
	private AccountDAO aDAO;
	

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
	public String logindo(HttpServletRequest req, AccountDTO aDTO) {
		
		aDAO.login(req, aDTO);
		System.out.println("첫번째 메소드");
		aDAO.logincheck(req);
		System.out.println("두번째 메소드");
		if (req.getAttribute("loginfail") != null) {
			req.setAttribute("contentPage", "loginPage.jsp");			
		} else {
			req.setAttribute("contentPage", "index.jsp");
		}
		
		return "home";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req, AccountDTO aDTO) {
		
		aDAO.logout(req);
		aDAO.logincheck(req);
			req.setAttribute("contentPage", "index.jsp");
		
		return "home";
	}
	
	
	
	
}
