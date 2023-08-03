package com.sh.pj.mom;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.pj.account.AccountDAO;

@Controller
public class MomController {

	@Autowired
	private AccountDAO aDAO;
	
	
	@RequestMapping(value = "/momsitter.go", method = RequestMethod.GET)
	public String momsitter(HttpServletRequest req) {
		req.setAttribute("contentPage", "mom/momsitter.jsp");
		aDAO.logincheck(req);	

		req.setAttribute("background_color", "#FCE4EC");
		return "home";
	}
	
	@RequestMapping(value = "/momtaker.go", method = RequestMethod.GET)
	public String momtaker(HttpServletRequest req) {
		req.setAttribute("contentPage", "mom/momtaker.jsp");
		aDAO.logincheck(req);	

		req.setAttribute("background_color", "#FCE4EC");
		return "home";
	}
}
