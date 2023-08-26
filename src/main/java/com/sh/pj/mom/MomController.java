package com.sh.pj.mom;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MembertDAO;
import com.sh.pj.pet.PetDTO;
import com.sh.pj.pet.PetSelector;
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
	public String momtaker(HttpServletRequest req, DolbomDTO dolbomDTO, Model m) {
		mDAO.logincheck(req);	
		mDAO.countAll(req);
		/* momDAO.getAlltaker(req, dolbomDTO, m); */
		momDAO.getMsg2(1, req);
		req.setAttribute("contentPage", "mom/momtaker.jsp");

		return "home";
	}
	
	@RequestMapping(value = "/momsitter.detail.go", method = RequestMethod.GET)
	public String momsitterDetail(HttpServletRequest req, MomDTO momDTO, Model m) {
		mDAO.logincheck(req);	
		momDAO.detail(req, momDTO, m);
		req.setAttribute("contentPage", "detail/momsitter.jsp");
		
		return "home";
	}
	
	@RequestMapping(value = "/momtaker.detail.go", method = RequestMethod.GET)
	public String momtakerDetail(HttpServletRequest req, DolbomDTO dolbomDTO, Model m) {
		mDAO.logincheck(req);	
		momDAO.detailtaker(req, dolbomDTO, m);
		req.setAttribute("contentPage", "detail/momtaker.jsp");
		
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
	@RequestMapping(value = "/momsitter.update", method = RequestMethod.POST)
	public String momsitter_update(HttpServletRequest req, MomDTO mDTO) {
		mDAO.logincheck(req);	
		
		momDAO.updateMomSitter(req, mDTO);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "mypageProfile.jsp");
		
		return "home";
	}
	
	@RequestMapping(value = "/updateMomDolbom.do", method = RequestMethod.POST)
	public String updateMomDolbom(HttpServletRequest req, DolbomDTO dDTO) {
		momDAO.updateMomDolbom(req, dDTO);

		return "redirect:/mypage.takerRegMom.go";
	}
	
	@RequestMapping(value = "/momsitter.delete.go", method = RequestMethod.POST)
	public String momsitter_delete(HttpServletRequest req, MomDTO mDTO, Model model) {
		mDAO.logincheck(req);	
		momDAO.deteteMomsitter(req, mDTO, model);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "mypageProfile.jsp");
		
		return "home";
	}
	
	@RequestMapping(value = "/page.change4", method = RequestMethod.GET)
    public String paging3(HttpServletRequest req, @RequestParam int p, Model model, MomSelector ms) {
//		aDAO.getAllAsk(model);
	    // 검색어가 입력되었다면, 검색어를 AskSelector 객체에 설정하고 세션에 저장합니다.
		System.out.println(ms.getMs_search());
		String momSearch = ms.getMs_search();
	    if (momSearch != null && !momSearch.isEmpty()) {
	        ms.setMs_search(momSearch);
	        req.getSession().setAttribute("searchSession", ms);
	    } else {
	        // 검색어가 입력되지 않았다면 세션에서 검색어 정보를 제거합니다.
	        req.getSession().removeAttribute("searchSession");
	        System.out.println("여기오면 세션값 죽음 ㄹㅇ");
	    }
//	    req.getSession().setAttribute("asksearch", askSearch);
	    momDAO.getMsg2(p, req);
	    mDAO.logincheck(req);
	    
	    req.setAttribute("contentPage", "mom/momtaker.jsp");	
	    
        return "home";
    }
	

}
