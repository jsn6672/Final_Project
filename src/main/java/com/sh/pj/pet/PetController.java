package com.sh.pj.pet;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.pj.account.AccountDAO;

@Controller
public class PetController {
	
	@Autowired
	private AccountDAO aDAO;
	
	@RequestMapping(value = "/petsitter.go", method = RequestMethod.GET)
	public String petsitter(HttpServletRequest req) {
		req.setAttribute("contentPage", "pet/petsitter.jsp");
		aDAO.logincheck(req);	

		return "home";
	}
	
	@RequestMapping(value = "/pettaker.go", method = RequestMethod.GET)
	public String pettaker(HttpServletRequest req) {
		req.setAttribute("contentPage", "pet/pettaker.jsp");
		aDAO.logincheck(req);	

		return "home";
	}
	
}
