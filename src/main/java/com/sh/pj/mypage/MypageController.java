package com.sh.pj.mypage;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	// 등록페이지
	@RequestMapping(value = "/mypage.sitterReg.go", method = RequestMethod.GET)
	public String mypageSitterRegAndModi(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "mypageSitterReg.jsp");
		return "home";
	}

	// 펫시터페이지
	@RequestMapping(value = "/mypage.sitterRegPet.go", method = RequestMethod.GET)
	public String mypageSitterRegPet(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "sitter/mypageSitterRegPet.jsp");

		return "home";
	}

	// 맘시터페이지
	@RequestMapping(value = "/mypage.sitterRegMom.go", method = RequestMethod.GET)
	public String mypageSitterRegMom(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "sitter/mypageSitterRegMom.jsp");

		return "home";
	}

	// 케어시터페이지
	@RequestMapping(value = "/mypage.sitterRegCare.go", method = RequestMethod.GET)
	public String mypageSitterRegCare(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "sitter/mypageSitterRegCare.jsp");

		return "home";
	}

	/*
	 * @RequestMapping(value = "/mypage.sitterRegPet.do", method =
	 * RequestMethod.GET) public String mypageSitterRegPetDo(HttpServletRequest req)
	 * { req.setAttribute("contentPage", "mypage/mypage.jsp"); mDAO.logincheck(req);
	 * req.setAttribute("mypageContentPage", "mypageSitterRegPet.jsp"); return
	 * "home"; }
	 */

	// 펫테이커페이지
	@RequestMapping(value = "/mypage.takerRegPet.go", method = RequestMethod.GET)
	public String mypageTakerRegPet(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "taker/mypageTakerRegPet.jsp");
		return "home";
	}

	// 맘테이커페이지
	@RequestMapping(value = "/mypage.takerRegMom.go", method = RequestMethod.GET)
	public String mypageTakerRegMom(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "taker/mypageTakerRegMom.jsp");
		return "home";
	}

	// 케어테이커페이지
	@RequestMapping(value = "/mypage.takerRegCare.go", method = RequestMethod.GET)
	public String mypageTakerRegCare(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		req.setAttribute("mypageContentPage", "taker/mypageTakerRegCare.jsp");
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
	public String mypageUsage(HttpServletRequest req, ContractDTO cntDTO) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		mpDAO.countSitterCont(req, cntDTO);
		mpDAO.getSitterAllCont(req, cntDTO);
		mpDAO.countTakerCont(req, cntDTO);
		mpDAO.getTakerAllCont(req);
		
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

	@RequestMapping(value = "/mypage.ticket.send", method = RequestMethod.POST)
	public @ResponseBody String ticketSend(HttpServletRequest req, MoneyDTO mm) {
		req.setAttribute("contentPage", "mypage/mypageTicket2Buy.jsp");
		mDAO.logincheck(req);
		mpDAO.insertmoney(req, mm);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "mypageProfile.jsp");

		String result = (String) req.getAttribute("result");
		if (result.equals("성공")) {
			return "home";
		} else {
			return "";
		}
	}

	@RequestMapping(value = "/mypage.ticket.check", method = RequestMethod.GET)
	public String ticketCheck(HttpServletRequest req, MoneyDTO mm) {
		mDAO.logincheck(req);
		mpDAO.getbuylist(req, mm);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "mypageTicket3Check.jsp");
		return "home";
	}

	@RequestMapping(value = "/mypage.ticket.confirm", method = RequestMethod.POST)
	public String ticketConfirm(HttpServletRequest req, MoneyDTO mm) {
		mDAO.logincheck(req);
		mpDAO.confirmticket(req, mm);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "mypageTicket3Check.jsp");

		return ticketCheck(req, mm);
	}

	

	@RequestMapping(value = "/contract.get", method = RequestMethod.GET)
	public String contract_get(HttpServletRequest req, ContractDTO cntDTO, Model m) {
		mDAO.logincheck(req);
		mpDAO.countSitterCont(req, cntDTO);
		mpDAO.getSitterAllCont(req, cntDTO);	
		req.setAttribute("contentPage", "mypage/check123.jsp");

		return "home";
	}

}
