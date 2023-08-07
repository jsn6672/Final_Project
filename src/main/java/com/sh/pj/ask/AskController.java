package com.sh.pj.ask;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		aDAO.getAllAsk(model);
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
		aDAO.getAskNo(model,aDTO);

		return "home";
	}
	
	@RequestMapping(value = "/qanda.go", method = RequestMethod.GET)
	public String qanda(HttpServletRequest req) {
		req.setAttribute("contentPage", "ask/qanda.jsp");
		mDAO.logincheck(req);	

		return "home";	
	}
	
	@RequestMapping(value = "/manyask.do", method = RequestMethod.GET)
	public String manyaskdo(Model model) {
		System.out.println();
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
	
}
