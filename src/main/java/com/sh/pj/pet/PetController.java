package com.sh.pj.pet;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PetController {

	@RequestMapping(value = "/petsitter.go", method = RequestMethod.GET)
	public String petsitter(HttpServletRequest req) {
		req.setAttribute("contentPage", "pet/petsitter.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/pettaker.go", method = RequestMethod.GET)
	public String pettaker(HttpServletRequest req) {
		req.setAttribute("contentPage", "pet/pettaker.jsp");
		return "home";
	}
	
}
