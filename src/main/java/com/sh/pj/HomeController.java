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
import com.sh.pj.account.MemberDTO;

@Controller
public class HomeController {

	@Autowired
	private MembertDAO mDAO;
	
	@Autowired
	private JavaMailSenderImpl mailSender;

	@Autowired
	private AskDAO aDAO;
	
	private boolean firstReq;
	
	public HomeController() {
		firstReq = true;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		mDAO.logincheck(req);

		if (firstReq) {
			aDAO.calcAllMsgCount();
			firstReq=false;
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
		System.out.println("이메일 확인" + user_email);
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;

		/* 이메일 보내기 */
        String setFrom = "sold802sbt7@gmail.com";
        String toMail = user_email;
        String title = "회원가입 인증 이메일 입니다.";
        String content = 
                "홈페이지를 방문해주셔서 감사합니다." +
                "<br><br>" + 
                "인증 번호는 " + checkNum + "입니다." + 
                "<br>" + 
                "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
        
        try {
            
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(Integer.toString(checkNum));
        return Integer.toString(checkNum);
 
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





}
