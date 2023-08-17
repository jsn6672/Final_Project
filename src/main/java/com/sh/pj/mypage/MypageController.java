package com.sh.pj.mypage;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.sh.pj.account.MemberDTO;
import com.sh.pj.account.MembertDAO;
import com.sh.pj.care.CareDTO;
import com.sh.pj.mom.MomDTO;
import com.sh.pj.pet.PetDTO;

@Controller
public class MypageController {

	@Autowired
	private MembertDAO mDAO;
	
	@Autowired
	private MypageDAO mpDAO;
	
	
	
	@RequestMapping(value = "/mypage.go", method = RequestMethod.GET)
	public String petsitter(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.getSession().setAttribute("checkMyPage", "2");
		mDAO.logincheck(req);
		mpDAO.mypage(req);
		req.setAttribute("mypageContentPage", "mypageHome.jsp");
		return "home";
	}
	@RequestMapping(value = "/mypage.go.jason", method = RequestMethod.GET)
	public String mypage(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.getSession().setAttribute("checkMyPage", "1");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "mypageHome.jsp");
		return "home";
	}

	@RequestMapping(value = "/mypage.profile.go", method = RequestMethod.GET)
	public String mypageProfile(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		mpDAO.mypage(req);
		req.setAttribute("mypageContentPage", "mypageProfile.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/mypage.pw.do", method = RequestMethod.GET)
	public String mypagePWUpdate(MemberDTO m, HttpServletRequest req) {
		/*
		 * req.setAttribute("contentPage", "mypage/mypage.jsp"); mDAO.logincheck(req);
		 */
		mpDAO.pwupdate(m, req);
		/* mDAO.pwchangedo(req, m); */
		mDAO.logincheck(req);
		req.setAttribute("contentPage", "mypageProfile.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/mypage.profile.do", method = RequestMethod.POST)
	public String mypageProfileUpdate(MemberDTO m, HttpServletRequest req) {
		/*
		 * req.setAttribute("contentPage", "mypage/mypage.jsp"); mDAO.logincheck(req);
		 */
		mpDAO.updateProfile(m, req);
		mDAO.logincheck(req);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "mypageHome.jsp");
		return "home";
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
		String checkMyPage = (String) req.getSession().getAttribute("checkMyPage");
		if (checkMyPage.equals("1")) {
//			여긴 제이슨이 만든 페이지 넣은 곳임다
			req.setAttribute("mypageContentPage", "mypageSitterRegPet.jsp");
		} else {
//			여기는 수진이가 쓴 페이지 넣어놔줘.... 
			req.setAttribute("mypageContentPage", "mypageSitterRegPet.jsp");			
		}
		
		return "home";
	}
	
	@RequestMapping(value = "/mypage.sitterRegPet.do", method = RequestMethod.GET)
	public String mypageSitterRegPetDo(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "mypageSitterRegPet.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/mypage.sitterRegPetCare.go", method = RequestMethod.GET)
	public String mypageSitterRegPetCare(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "mypageSitterRegPetCare.jsp");
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

	// 티켓 구매 페이지로 가는 컨트롤러
	@RequestMapping(value = "/mypage.ticket.do", method = RequestMethod.GET)
	public String ticket(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypageTicket1.jsp");
		mDAO.logincheck(req);
		return "home";
	}
	  
	@RequestMapping(value = "/mypage.ticket.buy", method = RequestMethod.POST)
	public String ticketBuy(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypageTicket2Buy.jsp");
		mDAO.logincheck(req);
		return "home";
	}
	
	@RequestMapping(value = "/mypage.ticket.sendMoney", method = RequestMethod.POST)
	public String ticketSendMoney(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypageTicket3SendMoney.jsp");
		String price = req.getParameter("choiceTicketPrice");
		System.out.println(price);
		mDAO.logincheck(req);
		return "home";
	}
	

	
	
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public String getallgo(HttpServletRequest req, MomDTO momDTO, PetDTO petDTO, CareDTO careDTO, Model m) {
		mDAO.logincheck(req);	
		/*
		 * mpDAO.getAll(req, momDTO, petDTO,careDTO, m);
		 */		
		req.setAttribute("contentPage", "mom/momtaker.jsp");

		return "home";
	}
	
	
	
}
