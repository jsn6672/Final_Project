package com.sh.pj.care;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.pj.account.MembertDAO;

@Controller
public class CareController {
	
	@Autowired
	private MembertDAO mDAO;

	@RequestMapping(value = "/caresitter.go", method = RequestMethod.GET)
	public String caresitter(HttpServletRequest req) {
		req.setAttribute("contentPage", "care/caresitter.jsp");
		mDAO.logincheck(req);	

		req.setAttribute("background_color", "#FBE9E7");
		return "home";
	}
	
	@RequestMapping(value = "/caretaker.go", method = RequestMethod.GET)
	public String caretaker(HttpServletRequest req) {
		req.setAttribute("contentPage", "care/caretaker.jsp");
		mDAO.logincheck(req);	

		req.setAttribute("background_color", "#FBE9E7");
		return "home";
	}
}
