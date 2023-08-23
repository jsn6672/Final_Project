package com.sh.pj.pet;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MembertDAO;

@Controller
public class PetController {
	
	@Autowired
	private MembertDAO mDAO;

	@Autowired
	private PetDAO pDAO;
	
	
	
	@RequestMapping(value = "/petsitter.go", method = RequestMethod.GET)
	public String petsitter(HttpServletRequest req, PetDTO petDTO, Model m) {
		req.setAttribute("contentPage", "pet/petsitter.jsp");
		mDAO.logincheck(req);	
		pDAO.getAll(req,petDTO,m);
		return "home";
	}
	
	@RequestMapping(value = "/pettaker.go", method = RequestMethod.GET)
	public String pettaker(HttpServletRequest req) {
		req.setAttribute("contentPage", "pet/pettaker.jsp");
		mDAO.logincheck(req);	

		return "home";
	}
	
	@RequestMapping(value = "/petsitter.detail.go", method = RequestMethod.GET)
	public String petsitterDetail(HttpServletRequest req, PetDTO petDTO, Model m) {
		mDAO.logincheck(req);	
		pDAO.detail(req, petDTO, m);
		req.setAttribute("contentPage", "detail/petsitter.jsp");
		
		return "home";
	}
	
	
	
	@RequestMapping(value = "/pettaker.be", method = RequestMethod.POST)
	public String pettaker_be(HttpServletRequest req, PetTakerDTO ptDTO, DolbomDTO dDTO) {
		mDAO.logincheck(req);	
		mDAO.regPetTaker(req, ptDTO);
		pDAO.regPetDolbom(req, dDTO);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "mypageProfile.jsp");
		
		return "home";
	}
	
	/*
	 * @RequestMapping(value = "/petsitter.be", method = RequestMethod.POST) public
	 * String petsitter_be(HttpServletRequest req, PetDTO pDTO) {
	 * mDAO.logincheck(req); pDAO.regPetSitter(req, pDTO);
	 * req.setAttribute("contentPage", "mypage/mypage.jsp");
	 * req.setAttribute("mypageContentPage", "mypageProfile.jsp");
	 * 
	 * return "home"; }
	 */
	
	@RequestMapping(value = "/updatePetDolbom.do", method = RequestMethod.POST)
	public String updatePetDolbom(HttpServletRequest req, DolbomDTO dDTO) {
		mDAO.logincheck(req);	
		pDAO.updatePetDolbom(req, dDTO);
		
		return "redirect:/mypage.takerRegPet.go";
	}
	
	/*
	 * @RequestMapping(value = "/petsitter.delete.go", method = RequestMethod.POST)
	 * public String petsitter_delete(HttpServletRequest req, PetDTO pDTO, Model
	 * model) { mDAO.logincheck(req); pDAO.deletePetsitter(req, pDTO, model);
	 * req.setAttribute("contentPage", "mypage/mypage.jsp");
	 * req.setAttribute("mypageContentPage", "mypageProfile.jsp");
	 * 
	 * return "home"; }
	 */
	
	
	
	
	
	
	
}
