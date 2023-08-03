package com.sh.pj.ask;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AskController {

	@RequestMapping(value = "/manyask.go", method = RequestMethod.GET)
	public String manyask(HttpServletRequest req) {
		req.setAttribute("contentPage", "ask/manyask.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/mainask.go", method = RequestMethod.GET)
	public String mainaks(HttpServletRequest req) {
		req.setAttribute("contentPage", "ask/mainask.jsp");
		return "home";
		
	}	
	@RequestMapping(value = "/qanda.go", method = RequestMethod.GET)
	public String qanda(HttpServletRequest req) {
		req.setAttribute("contentPage", "ask/qanda.jsp");
		return "home";	
	}
}
