package com.sh.pj;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sh.pj.account.MembertDAO;
import com.sh.pj.ask.AskDAO;
import com.sh.pj.care.CareDAO;
import com.sh.pj.mom.MomDAO;
import com.sh.pj.mypage.ContractDTO;
import com.sh.pj.pet.PetDAO;
import com.sh.pj.account.MemberDTO;

@Controller
public class HomeController {

	@Autowired
	private MembertDAO mDAO;

	@Autowired
	private AskDAO aDAO;
	
	@Autowired
	private PetDAO pDAO;

	@Autowired
	private CareDAO cDAO;
	
	@Autowired
	private MomDAO momDAO;
	
	private boolean firstReq;
	
	private boolean firstReq2;
	
	public HomeController() {
		firstReq = true;
		firstReq2 = true;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		mDAO.logincheck(req);
		
		
		if (firstReq) {
			aDAO.calcAllMsgCountmain();
			aDAO.calcAllMsgCountmany();
			aDAO.calcAllMsgCountqanda();
			firstReq=false;
		}
		
		if (firstReq2) {
			pDAO.calcAllMsgCountPetSitter();
			pDAO.calcAllMsgCountPetDolbom();
			cDAO.calcAllMsgCountCareSitter();
			momDAO.calcAllMsgCountMomSitter();
		}
		
		req.setAttribute("contentPage", "index.jsp");
		return "home";
	}
	

	@RequestMapping(value = "go.home", method = RequestMethod.GET)
	public String home2(HttpServletRequest req) {
		mDAO.logincheck(req);

		req.setAttribute("contentPage", "index.jsp");
		return "home";
	}

	@RequestMapping(value = "login.go", method = RequestMethod.GET)
	public String logingo(HttpServletRequest req) {

		mDAO.logincheck(req);
		req.setAttribute("contentPage", "loginPage.jsp");
		return "home";
	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String logindo(HttpServletRequest req, MemberDTO mDTO) {

		mDAO.login(req, mDTO);
		mDAO.logincheck(req);
		if (req.getAttribute("loginfail") != null) {
			req.setAttribute("contentPage", "loginPage.jsp");
		} else {
			req.setAttribute("contentPage", "index.jsp");
		}

		return "home";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req, MemberDTO mDTO) {

		mDAO.logout(req);
		mDAO.logincheck(req);
		req.setAttribute("contentPage", "index.jsp");

		return "home";
	}

	@RequestMapping(value = "regAccount.go", method = RequestMethod.GET)
	public String regaccountgo(HttpServletRequest req, MemberDTO mDTO) {

		mDAO.logincheck(req);
		req.setAttribute("contentPage", "regaccount.jsp");

		return "home";
	}
	
//	이메일 인증 하려고 했는데 잘 안된 흔적
	@RequestMapping(value = "/emailAuth", method = RequestMethod.POST)
	public @ResponseBody String emailAuth(String user_email) {
		
		return mDAO.sendEmail(user_email);
	}
	
	@RequestMapping(value = "regAccount.do", method = RequestMethod.POST)
	public String regAccountdo(HttpServletRequest req, MemberDTO mDTO) {
		
		mDAO.regAccount(req, mDTO);
		mDAO.logincheck(req);
		
		req.setAttribute("contentPage", "loginPage.jsp");
		return "home";
	}
	
	@RequestMapping(value = "lost.id.pw.go", method = RequestMethod.GET)
	public String lostAccountgo(HttpServletRequest req, MemberDTO mDTO) {
		mDAO.logincheck(req);
		
		
		req.setAttribute("contentPage", "emailcheck.jsp");
		return "home";
	}
	
	@RequestMapping(value = "email_check", method = RequestMethod.GET)
	public @ResponseBody int email_check(HttpServletRequest req, MemberDTO mDTO) {

		return mDAO.emailcheck(req, mDTO);
	}
	
	@RequestMapping(value = "pwchange.go", method = RequestMethod.GET)
	public String pwchangego(HttpServletRequest req, MemberDTO mDTO) {
		mDAO.logincheck(req);	
		mDAO.pwchangego(req, mDTO);

		req.setAttribute("contentPage", "pwchange.jsp");
		return "home";
	}
	@RequestMapping(value = "pwchange.do", method = RequestMethod.POST)
	public String pwchangedo(HttpServletRequest req, MemberDTO mDTO) {
		mDAO.logincheck(req);	
		mDAO.pwchangedo(req, mDTO);
		
		req.setAttribute("contentPage", "loginPage.jsp");
		return "home";
	}

	@RequestMapping(value = "idCheck", method = RequestMethod.POST)
	public @ResponseBody int idcheck(HttpServletRequest req, MemberDTO mDTO) {
		
		return mDAO.idcheck(req, mDTO);
	}
	@RequestMapping(value = "emailCheck", method = RequestMethod.POST)
	public @ResponseBody int emailcheck(HttpServletRequest req, MemberDTO mDTO) {
		
		return mDAO.emailusercheck(req, mDTO);
	}
	
	@RequestMapping(value = "count.tbl", method = RequestMethod.GET)
	public String counttbl(HttpServletRequest req) {
		
		mDAO.countTBL();
		return "redirect:/go.home";
	}
	
	@RequestMapping(value = "endCnt", method = RequestMethod.GET)
	public String endCnt(HttpServletRequest req, ContractDTO cntDTO) {
		
		mDAO.EndCnt(req, cntDTO);
		return "redirect:/mypage.go";
	}
	
	
	
	



}
