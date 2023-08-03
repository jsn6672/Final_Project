package com.sh.pj.care;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.pj.account.AccountDAO;

@Controller
public class CareController {
	
	@Autowired
	private AccountDAO aDAO;

	@RequestMapping(value = "/caresitter.go", method = RequestMethod.GET)
	public String caresitter(HttpServletRequest req) {
		req.setAttribute("contentPage", "care/caresitter.jsp");
		aDAO.logincheck(req);	

		return "home";
	}
	
	@RequestMapping(value = "/caretaker.go", method = RequestMethod.GET)
	public String caretaker(HttpServletRequest req) {
		req.setAttribute("contentPage", "care/caretaker.jsp");
		aDAO.logincheck(req);	

		return "home";
	}
}
