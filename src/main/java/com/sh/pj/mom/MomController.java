package com.sh.pj.mom;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.pj.account.MembertDAO;

@Controller
public class MomController {

	@Autowired
	private MembertDAO mDAO;
	
	@Autowired
	private MomDAO momDAO;
	
	
	@RequestMapping(value = "/momsitter.go", method = RequestMethod.GET)
	public String momsitter(HttpServletRequest req, MomDTO momDTO, Model m) {
		mDAO.logincheck(req);	
		momDAO.getAll(req, momDTO, m);
		req.setAttribute("contentPage", "mom/momsitter.jsp");

		return "home";
	}
	
	@RequestMapping(value = "/momtaker.go", method = RequestMethod.GET)
	public String momtaker(HttpServletRequest req, MomDTO momDTO, Model m) {
		mDAO.logincheck(req);	
		momDAO.getAll(req, momDTO, m);
		req.setAttribute("contentPage", "mom/momtaker.jsp");

		return "home";
	}
	
	@RequestMapping(value = "/momsitter.detail.go", method = RequestMethod.GET)
	public String momsitterDetail(HttpServletRequest req, MomDTO momDTO, Model m) {
		mDAO.logincheck(req);	
		momDAO.detail(req, momDTO, m);
		req.setAttribute("contentPage", "detail/sitter.jsp");
		
		return "home";
	}
	
	@RequestMapping(value = "/momtaker.detail.go", method = RequestMethod.GET)
	public String momtakerDetail(HttpServletRequest req, MomDTO momDTO, Model m) {
		mDAO.logincheck(req);	
		momDAO.detail(req, momDTO, m);
		req.setAttribute("contentPage", "detail/taker.jsp");
		
		return "home";
	}
	
}
