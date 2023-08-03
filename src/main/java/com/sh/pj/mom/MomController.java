package com.sh.pj.mom;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

		return "home";
	}
	
	@RequestMapping(value = "/momtaker.go", method = RequestMethod.GET)
	public String momtaker(HttpServletRequest req) {
		req.setAttribute("contentPage", "mom/momtaker.jsp");
		aDAO.logincheck(req);	

		return "home";
	}
}
