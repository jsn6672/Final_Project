package com.sh.pj.care;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MembertDAO;
import com.sh.pj.mom.MomSelector;
import com.sh.pj.pet.PetDTO;
import com.sh.pj.pet.PetSelector;
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
		req.getSession().removeAttribute("searchSession");
		cDAO.getMsg(1, req);
		cDAO.getallpoint(req,cDTO);
		req.setAttribute("contentPage", "care/caresitter.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/caretaker.go", method = RequestMethod.GET)
	public String caretaker(HttpServletRequest req,Model m, DolbomDTO dolbomDTO) {
		req.setAttribute("contentPage", "care/caretaker.jsp");
		mDAO.logincheck(req);
		mDAO.countAll(req);
		/*
		 * cDAO.getAlltaker(req,dolbomDTO,m);
		 */		
		cDAO.getMsg2(1, req);
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
		
		return "redirect:/mypage.go";
	}
	


    @RequestMapping(value = "/caresitter.be", method = RequestMethod.POST)
    public String caresitter_be(HttpServletRequest req, CareDTO cDTO) {
        mDAO.logincheck(req);    
        cDAO.regcareSitter(req, cDTO);
        req.setAttribute("contentPage", "mypage/mypage.jsp");
        req.setAttribute("mypageContentPage", "mypageProfile.jsp");
        System.out.println(cDTO);
        return "redirect:/mypage.go";
    }
    
    @RequestMapping(value = "/caresitter.update", method = RequestMethod.POST)
    public String caresitter_update(HttpServletRequest req, CareDTO cDTO) {
    	mDAO.logincheck(req);    
    	cDAO.updatecareSitter(req, cDTO);
    	req.setAttribute("contentPage", "mypage/mypage.jsp");
    	req.setAttribute("mypageContentPage", "mypageProfile.jsp");
    	System.out.println(cDTO);
    	return "redirect:/mypage.go";
    }
    
    @RequestMapping(value = "/updateCareDolbom.do", method = RequestMethod.POST)
	public String updateCareDolbom(HttpServletRequest req, DolbomDTO dDTO) {
		cDAO.updateCareDolbom(req, dDTO);

		return "redirect:/mypage.takerRegCare.go";
	}
    
    @RequestMapping(value = "/page.change.caresitter", method = RequestMethod.GET)
    public String paging(HttpServletRequest req, @RequestParam int p, Model model, CareSelector cs) {
//		aDAO.getAllAsk(model);
	    // 검색어가 입력되었다면, 검색어를 AskSelector 객체에 설정하고 세션에 저장합니다.
		System.out.println(cs.getCs_search());
		String careSearch = cs.getCs_search();
	    if (careSearch != null && !careSearch.isEmpty()) {
	        cs.setCs_search(careSearch);
	        req.getSession().setAttribute("searchSession", cs);
	    } else {
	        // 검색어가 입력되지 않았다면 세션에서 검색어 정보를 제거합니다.
	        req.getSession().removeAttribute("searchSession");
	        System.out.println("여기오면 세션값 죽음 ㄹㅇ");
	    }
//	    req.getSession().setAttribute("asksearch", askSearch);
	    cDAO.getMsg(p, req);
	    mDAO.logincheck(req);
	    
	    req.setAttribute("contentPage", "care/caresitter.jsp");	
	    
        return "home";
    }
	
	@RequestMapping(value = "/page.change5", method = RequestMethod.GET)
    public String paging3(HttpServletRequest req, @RequestParam int p, Model model, CareSelector cs) {
//		aDAO.getAllAsk(model);
	    // 검색어가 입력되었다면, 검색어를 AskSelector 객체에 설정하고 세션에 저장합니다.
		System.out.println(cs.getCs_search());
		String caresearch = cs.getCs_search();
	    if (caresearch != null && !caresearch.isEmpty()) {
	        cs.setCs_search(caresearch);
	        req.getSession().setAttribute("searchSession", cs);
	    } else {
	        // 검색어가 입력되지 않았다면 세션에서 검색어 정보를 제거합니다.
	        req.getSession().removeAttribute("searchSession");
	        System.out.println("여기오면 세션값 죽음 ㄹㅇ");
	    }
//	    req.getSession().setAttribute("asksearch", askSearch);
	    cDAO.getMsg2(p, req);
	    mDAO.logincheck(req);
	    
	    req.setAttribute("contentPage", "mom/momtaker.jsp");	
	    
        return "home";
    }
	
}
