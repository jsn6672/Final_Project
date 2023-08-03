package com.sh.pj.pet;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.pj.account.MembertDAO;

@Controller
public class PetController {
	
	@Autowired
	private MembertDAO mDAO;
	
	@RequestMapping(value = "/petsitter.go", method = RequestMethod.GET)
	public String petsitter(HttpServletRequest req) {
		req.setAttribute("contentPage", "pet/petsitter.jsp");
		mDAO.logincheck(req);	

		return "home";
	}
	
	@RequestMapping(value = "/pettaker.go", method = RequestMethod.GET)
	public String pettaker(HttpServletRequest req) {
		req.setAttribute("contentPage", "pet/pettaker.jsp");
		mDAO.logincheck(req);	

		return "home";
	}
	
}
