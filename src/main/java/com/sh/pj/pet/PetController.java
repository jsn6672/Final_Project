package com.sh.pj.pet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		mDAO.logincheck(req);
		mDAO.countAll(req);
		req.getSession().removeAttribute("searchSession");
		pDAO.getMsg(1, req);
		pDAO.getallpoint(req,petDTO);
		req.setAttribute("contentPage", "pet/petsitter.jsp");
		return "home";
	}

	@RequestMapping(value = "/pettaker.go", method = RequestMethod.GET)
	public String pettaker(HttpServletRequest req, DolbomDTO dolbomDTO, Model m) {
		mDAO.logincheck(req);
		mDAO.countAll(req);
//		pDAO.getAllTaker(req, dolbomDTO, m);
		pDAO.getMsg2(1, req);

		req.setAttribute("contentPage", "pet/pettaker.jsp");

		return "home";
	}

	@RequestMapping(value = "/petsitter.detail.go", method = RequestMethod.GET)
	public String petsitterDetail(HttpServletRequest req, PetDTO petDTO, Model m) {
		mDAO.logincheck(req);
		pDAO.detail(req, petDTO, m);
		req.setAttribute("contentPage", "detail/petsitter.jsp");

		return "home";
	}
	
	@RequestMapping(value = "/petsitter.delete.go", method = RequestMethod.GET)
	public String petsitterDelete(HttpServletRequest req, PetDTO petDTO, Model m) {
		mDAO.logincheck(req);
		pDAO.delete(req, petDTO, m);
		
		return "redirect:/mypage.go";
	}
	
	@RequestMapping(value = "/petsitter.notice.up", method = RequestMethod.GET)
	public String petsitterNoticeUP(HttpServletRequest req, PetDTO petDTO, Model m) {
		mDAO.logincheck(req);
		pDAO.noticeUP(req, petDTO, m);
		pDAO.noticeUpdate(req, petDTO, m);
		
		return "redirect:/mypage.go";
	}
	
	@RequestMapping(value = "/petsitter.notice.down", method = RequestMethod.GET)
	public String petsitterNoticeDOWN(HttpServletRequest req, PetDTO petDTO, Model m) {
		mDAO.logincheck(req);
		pDAO.noticeDOWN(req, petDTO, m);
		
		return "redirect:/mypage.go";
	}
	
	@RequestMapping(value = "/pettaker.detail.go", method = RequestMethod.GET)
	public String pettakerDetail(HttpServletRequest req, DolbomDTO dolbomDTO, Model m) {
		mDAO.logincheck(req);
		pDAO.detailtaker(req, dolbomDTO, m);
		req.setAttribute("contentPage", "detail/pettaker.jsp");

		return "home";
	}
	


	@RequestMapping(value = "/pettaker.be", method = RequestMethod.POST)
	public String pettaker_be(HttpServletRequest req, PetTakerDTO ptDTO, DolbomDTO dDTO) {
		mDAO.logincheck(req);
		mDAO.regPetTaker(req, ptDTO);
		pDAO.regPetDolbom(req, dDTO);

		return "redirect:/mypage.go";
	}
	@RequestMapping(value = "/pettaker.update", method = RequestMethod.POST)
	public String pettaker_update(HttpServletRequest req, PetTakerDTO ptDTO, DolbomDTO dDTO) {
		mDAO.logincheck(req);
		mDAO.updatePetTaker(req, ptDTO);
		
		return "redirect:/mypage.go";
	}
	
	@RequestMapping(value = "/petsitter.be", method = RequestMethod.POST)
	public String petsitter_be(HttpServletRequest req, PetDTO pDTO) {
		mDAO.logincheck(req);
		pDAO.regPetSitter(req, pDTO);


		return "redirect:/mypage.go";
	}
	
	@RequestMapping(value = "/petsitter.update", method = RequestMethod.POST)
	public String petsitter_update(HttpServletRequest req, PetDTO pDTO) {
		mDAO.logincheck(req);
		pDAO.updatePetSitter(req, pDTO);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "mypageProfile.jsp");

		return "redirect:/mypage.go";
	}

	@RequestMapping(value = "/updatePetDolbom.do", method = RequestMethod.POST)
	public String updatePetDolbom(HttpServletRequest req, DolbomDTO dDTO) {
		pDAO.updatePetDolbom(req, dDTO);

		return "redirect:/mypage.takerRegPet.go";
	}
	
	

	@RequestMapping(value = "/page.change2", method = RequestMethod.GET)
    public String paging(HttpServletRequest req, @RequestParam int p, Model model, PetSelector ps,PetDTO petDTO) {
//		aDAO.getAllAsk(model);
	    // 검색어가 입력되었다면, 검색어를 AskSelector 객체에 설정하고 세션에 저장합니다.
		System.out.println(ps.getPs_search());
		String petSearch = ps.getPs_search();
	    if (petSearch != null && !petSearch.isEmpty()) {
	        ps.setPs_search(petSearch);
	        req.getSession().setAttribute("searchSession", ps);
	    } else {
	        // 검색어가 입력되지 않았다면 세션에서 검색어 정보를 제거합니다.
	        req.getSession().removeAttribute("searchSession");
	        System.out.println("여기오면 세션값 죽음 ㄹㅇ");
	    }
//	    req.getSession().setAttribute("asksearch", askSearch);
	    pDAO.getMsg(p, req);
	    mDAO.logincheck(req);
	    pDAO.getallpoint(req,petDTO);
	    
	    req.setAttribute("contentPage", "pet/petsitter.jsp");	
	   
        return "home";
    }
	@RequestMapping(value = "/page.change3", method = RequestMethod.GET)
    public String paging3(HttpServletRequest req, @RequestParam int p, Model model, PetSelector ps) {
//		aDAO.getAllAsk(model);
	    // 검색어가 입력되었다면, 검색어를 AskSelector 객체에 설정하고 세션에 저장합니다.
		System.out.println(ps.getPs_search());
		String petSearch = ps.getPs_search();
	    if (petSearch != null && !petSearch.isEmpty()) {
	        ps.setPs_search(petSearch);
	        req.getSession().setAttribute("searchSession", ps);
	    } else {
	        // 검색어가 입력되지 않았다면 세션에서 검색어 정보를 제거합니다.
	        req.getSession().removeAttribute("searchSession");
	        System.out.println("여기오면 세션값 죽음 ㄹㅇ");
	    }
//	    req.getSession().setAttribute("asksearch", askSearch);
	    pDAO.getMsg2(p, req);
	    mDAO.logincheck(req);
	    
	    req.setAttribute("contentPage", "pet/pettaker.jsp");	
	    
        return "home";
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
