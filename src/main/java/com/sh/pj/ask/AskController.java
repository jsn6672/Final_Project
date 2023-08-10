package com.sh.pj.ask;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.pj.account.MemberDTO;
import com.sh.pj.account.MembertDAO;

@Controller
public class AskController {

	@Autowired
	private MembertDAO mDAO;

	@Autowired
	private AskDAO aDAO;
	

	
	@RequestMapping(value = "/mainask.go", method = RequestMethod.GET)
	public String mainask(AskDTO aDTO, Model model, HttpServletRequest req) {
//		aDAO.getAllAsk(model);
		req.getSession().removeAttribute("asksearch");
	    aDAO.getMsg(1, req);
		req.setAttribute("contentPage", "ask/mainask.jsp");
		mDAO.logincheck(req);
		return "home";
		
	}	
	
	@RequestMapping(value = "/regask.go", method = RequestMethod.GET)
	public String regask(AskDTO aDTO, Model model, HttpServletRequest req) {
		req.setAttribute("contentPage", "ask/regask.jsp");
		mDAO.logincheck(req);
		return "home";
		
	}	
	
	@RequestMapping(value = "/manyask.go", method = RequestMethod.GET)
	public String manyask(AskDTO aDTO, HttpServletRequest req) {
		req.setAttribute("contentPage", "ask/manyask.jsp");
		mDAO.logincheck(req);

		return "home";
	}
	
	@RequestMapping(value = "/detail.go", method = RequestMethod.GET)
	public String detailgo(AskDTO aDTO, HttpServletRequest req,Model model) {
		req.setAttribute("contentPage", "ask/detailpage.jsp");
		mDAO.logincheck(req);
		aDAO.getAskNo(model, aDTO);
		return "home";
	}
	
	@RequestMapping(value = "/qanda.go", method = RequestMethod.GET)
	public String qanda(HttpServletRequest req, Model model,AskDTO aDTO) {
		req.setAttribute("contentPage", "ask/qanda.jsp");
		mDAO.logincheck(req);
		aDAO.getAskNo(model,aDTO);
		return "home";
	}

	@RequestMapping(value = "/manyask.do", method = RequestMethod.GET)
	public String manyaskdo(HttpServletRequest req, Model model) {
		System.out.println();
		mDAO.logincheck(req);
		aDAO.getAllAsk(model);
		return "home";
	}
	
	@RequestMapping(value = "/QnAInsert.do", method = RequestMethod.GET)
	public String QnAInsertdo(AskDTO aDTO,HttpServletRequest req) {
		MemberDTO m = (MemberDTO) req.getSession().getAttribute("userInfo");
		mDAO.logincheck(req);
		aDAO.insertask(aDTO,req);
		return "redirect:mainask.go";
	}



	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(AskDTO aDTO,HttpServletRequest req) {
		mDAO.logincheck(req);
		aDAO.deleteask(aDTO);
		return "redirect:mainask.go";
	}
	
	@RequestMapping(value = "/update.go", method = RequestMethod.GET)
	public String updatego(HttpServletRequest req, Model model,AskDTO aDTO) {
		req.setAttribute("contentPage", "ask/update.jsp");
		mDAO.logincheck(req);
		aDAO.getAskNo(model,aDTO);
		return "home";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String upadte(AskDTO aDTO,HttpServletRequest req) {
		mDAO.logincheck(req);
		aDAO.updateask(aDTO);
		return "redirect:mainask.go";
	}
	
	@RequestMapping(value = "/searchask", method = RequestMethod.GET)
	public String searchask(HttpServletRequest req, Model model, AskDTO aDTO) {
		mDAO.logincheck(req);
		aDAO.searchask(model,aDTO);
		req.setAttribute("contentPage", "ask/mainask.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/page.change", method = RequestMethod.GET)
    public String paging(HttpServletRequest req, @RequestParam int p, Model model, AskSelector as) {
//		aDAO.getAllAsk(model);
	    // 검색어가 입력되었다면, 검색어를 AskSelector 객체에 설정하고 세션에 저장합니다.
		System.out.println(as.getA_search());
		String askSearch = as.getA_search();
	    if (askSearch != null && !askSearch.isEmpty()) {
	        AskSelector searchSelector = new AskSelector();
	        searchSelector.setA_search(askSearch);
	        req.getSession().setAttribute("asksearch", searchSelector);
	    } else {
	        // 검색어가 입력되지 않았다면 세션에서 검색어 정보를 제거합니다.
	        req.getSession().removeAttribute("asksearch");
	        System.out.println("여기오면 세션값 죽음 ㄹㅇ");
	    }
//	    req.getSession().setAttribute("asksearch", askSearch);
	    aDAO.getMsg(p, req);
	    mDAO.logincheck(req);
        req.setAttribute("contentPage", "ask/mainask.jsp");
        return "home";
    }
	

}
