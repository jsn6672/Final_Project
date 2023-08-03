package com.sh.pj.ask;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.pj.account.AccountDAO;

@Controller
public class AskController {
	
	@Autowired
	private AccountDAO aDAO;

	@RequestMapping(value = "/manyask.go", method = RequestMethod.GET)
	public String manyask(HttpServletRequest req) {
		req.setAttribute("contentPage", "ask/manyask.jsp");
		aDAO.logincheck(req);	

		return "home";
	}
	
	@RequestMapping(value = "/mainask.go", method = RequestMethod.GET)
	public String mainaks(HttpServletRequest req) {
		req.setAttribute("contentPage", "ask/mainask.jsp");
		aDAO.logincheck(req);	

		return "home";
		
	}	
	@RequestMapping(value = "/qanda.go", method = RequestMethod.GET)
	public String qanda(HttpServletRequest req) {
		req.setAttribute("contentPage", "ask/qanda.jsp");
		aDAO.logincheck(req);	

		return "home";	
	}
}
