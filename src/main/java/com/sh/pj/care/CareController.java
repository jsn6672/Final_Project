package com.sh.pj.care;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.pj.account.MembertDAO;

@Controller
public class CareController {
	
	@Autowired
	private MembertDAO mDAO;
	
	@Autowired
	private CareDAO cDAO;

	@RequestMapping(value = "/caresitter.go", method = RequestMethod.GET)
	public String caresitter(HttpServletRequest req,Model m, CareDTO cDTO) {
		req.setAttribute("contentPage", "care/caresitter.jsp");
		mDAO.logincheck(req);	
		cDAO.getAll(req,m,cDTO);
		System.out.println(m);
		System.out.println(cDTO);
		req.setAttribute("background_color", "#FBE9E7");
		return "home";
	}
	
	@RequestMapping(value = "/caretaker.go", method = RequestMethod.GET)
	public String caretaker(HttpServletRequest req,Model m, CareDTO cDTO) {
		req.setAttribute("contentPage", "care/caretaker.jsp");
		mDAO.logincheck(req);
		cDAO.getAll(req,m,cDTO);
		req.setAttribute("background_color", "#FBE9E7");
		return "home";
	}
	
	
	@RequestMapping(value = "/caresitter.detail", method = RequestMethod.GET)
	public String momtakerDetail(HttpServletRequest req, CareDTO cDTO, Model m) {
		mDAO.logincheck(req);	
		cDAO.detail(req, cDTO, m);
		req.setAttribute("contentPage", "detail/caresitter.jsp");
		
		return "home";
	}
	
	@RequestMapping(value = "/caretaker.detail", method = RequestMethod.GET)
	public String caretakerdetail(HttpServletRequest req) {
		mDAO.logincheck(req);	
		req.setAttribute("contentPage", "detail/caretaker.jsp");
		req.setAttribute("background_color", "#FBE9E7");
		return "home";
	}

	
}
