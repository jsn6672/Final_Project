package com.sh.pj.mypage;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.pj.account.MembertDAO;

@Controller
public class MypageController {

	@Autowired
	private MembertDAO mDAO;
	
	@RequestMapping(value = "/mypage.go", method = RequestMethod.GET)
	public String petsitter(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "mypageHome.jsp");
		return "home";
	}

	@RequestMapping(value = "/mypage.profile.go", method = RequestMethod.GET)
	public String mypageProfile(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "mypageProfile.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/mypage.profile.do", method = RequestMethod.GET)
	public String mypageProfileUpdate(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "mypageProfile.jsp");
		return "redirect:mypage.profile.go";
	}
	
	@RequestMapping(value = "/mypage.sitterReg.go", method = RequestMethod.GET)
	public String mypageSitterRegAndModi(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "mypageSitterReg.jsp");
		return "home";
	}

	@RequestMapping(value = "/mypage.sitterRegPet.go", method = RequestMethod.GET)
	public String mypageSitterRegPet(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "mypageSitterRegPet.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/mypage.ticket.go", method = RequestMethod.GET)
	public String mypageTicket(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "mypageTicket.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/mypage.usage.go", method = RequestMethod.GET)
	public String mypageUsage(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "mypageUsageDetail.jsp");
		return "home";
	}
	
	
	
}
