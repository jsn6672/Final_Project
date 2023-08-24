package com.sh.pj.mom;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MembertDAO;
import com.sh.pj.pet.PetDTO;
import com.sh.pj.pet.PetTakerDTO;

@Controller
public class MomController {

	@Autowired
	private MembertDAO mDAO;
	
	@Autowired
	private MomDAO momDAO;
	
	
	@RequestMapping(value = "/momsitter.go", method = RequestMethod.GET)
	public String momsitter(HttpServletRequest req, MomDTO momDTO, Model m) {
		mDAO.logincheck(req);	
		mDAO.countAll(req);
		momDAO.getAll(req, momDTO, m);
		req.setAttribute("contentPage", "mom/momsitter.jsp");

		return "home";
	}
	
	@RequestMapping(value = "/momtaker.go", method = RequestMethod.GET)
	public String momtaker(HttpServletRequest req, MomDTO momDTO, Model m) {
		mDAO.logincheck(req);	
		mDAO.countAll(req);
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
	
	@RequestMapping(value = "/momtaker.be", method = RequestMethod.POST)
	public String momtaker_be(HttpServletRequest req, MomTakerDTO mtDTO, DolbomDTO dDTO) {
		mDAO.logincheck(req);	
		
		mDAO.regMomTaker(req, mtDTO);
		momDAO.regMomDolbom(req, dDTO);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "mypageProfile.jsp");
		
		return "home";
	}
	@RequestMapping(value = "/momsitter.be", method = RequestMethod.POST)
	public String momsitter_be(HttpServletRequest req, MomDTO mDTO) {
		mDAO.logincheck(req);	
		
		momDAO.regMomSitter(req, mDTO);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "mypageProfile.jsp");
		
		return "home";
	}
	@RequestMapping(value = "/momsitter.delete.go", method = RequestMethod.POST)
	public String momsitter_delete(HttpServletRequest req, MomDTO mDTO, Model model) {
		mDAO.logincheck(req);	
		momDAO.deteteMomsitter(req, mDTO, model);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "mypageProfile.jsp");
		
		return "home";
	}
	
}
