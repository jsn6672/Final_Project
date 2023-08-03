package com.sh.pj.mom;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MomController {

	@RequestMapping(value = "/momsitter.go", method = RequestMethod.GET)
	public String momsitter(HttpServletRequest req) {
		req.setAttribute("contentPage", "mom/momsitter.jsp");
		req.setAttribute("background_color", "#FCE4EC");
		return "home";
	}
	
	@RequestMapping(value = "/momtaker.go", method = RequestMethod.GET)
	public String momtaker(HttpServletRequest req) {
		req.setAttribute("contentPage", "mom/momtaker.jsp");
		req.setAttribute("background_color", "#FCE4EC");
		return "home";
	}
}
