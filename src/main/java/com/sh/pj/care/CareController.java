package com.sh.pj.care;


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
public class CareController {
	
	@Autowired
	private MembertDAO mDAO;
	
	@Autowired
	private CareDAO cDAO;

	@RequestMapping(value = "/caresitter.go", method = RequestMethod.GET)
	public String caresitter(HttpServletRequest req,Model m, CareDTO cDTO) {
		req.setAttribute("contentPage", "care/caresitter.jsp");
		mDAO.logincheck(req);
		mDAO.countAll(req);
		cDAO.getAll(req,m,cDTO);
		System.out.println(m);
		System.out.println(cDTO);
		req.setAttribute("background_color", "#FBE9E7");
		return "home";
	}
	
	@RequestMapping(value = "/caretaker.go", method = RequestMethod.GET)
	public String caretaker(HttpServletRequest req,Model m, DolbomDTO dolbomDTO) {
		req.setAttribute("contentPage", "care/caretaker.jsp");
		mDAO.logincheck(req);
		mDAO.countAll(req);
		cDAO.getAlltaker(req,dolbomDTO,m);
		req.setAttribute("background_color", "#FBE9E7");
		return "home";
	}
	
	
	@RequestMapping(value = "/caresitter.detail.go", method = RequestMethod.GET)
	public String momtakerDetail(HttpServletRequest req, CareDTO cDTO, Model m) {
		mDAO.logincheck(req);	
		cDAO.detail(req, cDTO, m);
		req.setAttribute("contentPage", "detail/caresitter.jsp");
		
		return "home";
	}
	
	@RequestMapping(value = "/caretaker.detail.go", method = RequestMethod.GET)
	public String caretakerdetail(HttpServletRequest req, DolbomDTO dolbomDTO, Model m) {
		mDAO.logincheck(req);
		cDAO.detailtaker(req, dolbomDTO, m);
		req.setAttribute("contentPage", "detail/caretaker.jsp");
		req.setAttribute("background_color", "#FBE9E7");
		return "home";
	}
	
	@RequestMapping(value = "/caretaker.be", method = RequestMethod.POST)
	public String caretaker_be(HttpServletRequest req, CareTakerDTO ctDTO, DolbomDTO dDTO) {
		mDAO.logincheck(req);	

		mDAO.regcareTaker(req, ctDTO);
		cDAO.regcareDolbom(req, dDTO);

		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "mypageProfile.jsp");
		
		return "home";
	}
	


    @RequestMapping(value = "/caresitter.be", method = RequestMethod.POST)
    public String caresitter_be(HttpServletRequest req, CareDTO cDTO) {
        mDAO.logincheck(req);    
        cDAO.regcareSitter(req, cDTO);
        req.setAttribute("contentPage", "mypage/mypage.jsp");
        req.setAttribute("mypageContentPage", "mypageProfile.jsp");
        System.out.println(cDTO);
        return "home";
    }
    
    @RequestMapping(value = "/caresitter.update", method = RequestMethod.POST)
    public String caresitter_update(HttpServletRequest req, CareDTO cDTO) {
    	mDAO.logincheck(req);    
    	cDAO.updatecareSitter(req, cDTO);
    	req.setAttribute("contentPage", "mypage/mypage.jsp");
    	req.setAttribute("mypageContentPage", "mypageProfile.jsp");
    	System.out.println(cDTO);
    	return "home";
    }
    
    @RequestMapping(value = "/updateCareDolbom.do", method = RequestMethod.POST)
	public String updateCareDolbom(HttpServletRequest req, DolbomDTO dDTO) {
		cDAO.updateCareDolbom(req, dDTO);

		return "redirect:/mypage.takerRegCare.go";
	}
	
}
