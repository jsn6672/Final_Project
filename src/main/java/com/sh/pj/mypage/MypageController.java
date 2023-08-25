package com.sh.pj.mypage;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;
import com.sh.pj.account.MembertDAO;
import com.sh.pj.care.CareDAO;
import com.sh.pj.care.CareDTO;
import com.sh.pj.mom.MomDAO;
import com.sh.pj.mom.MomDTO;
import com.sh.pj.pet.PetDAO;
import com.sh.pj.pet.PetDTO;
import com.sh.pj.pet.PetTakerDTO;

@Controller
public class MypageController {

	@Autowired
	private MembertDAO mDAO;

	@Autowired
	private MypageDAO mpDAO;
	
	@Autowired
	private PetDAO pDAO;
	
	@Autowired
	private MomDAO momDAO;
	
	@Autowired
	private CareDAO cDAO;

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
		MemberDTO mDTO = (MemberDTO)req.getSession().getAttribute("userInfo");
		if (mDTO.getUser_ps_status() == 0) {
			req.setAttribute("mypageContentPage", "sitter/mypageSitterRegPet.jsp");			
		}else {
			pDAO.getPetSitterInfo(req);
			req.setAttribute("mypageContentPage", "sitter/mypageSitterUpdatePet.jsp");			
		}

		return "home";
	}

	// 맘시터페이지
	@RequestMapping(value = "/mypage.sitterRegMom.go", method = RequestMethod.GET)
	public String mypageSitterRegMom(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);

		MemberDTO mDTO = (MemberDTO)req.getSession().getAttribute("userInfo");
		if (mDTO.getUser_ms_status() == 0) {
			req.setAttribute("mypageContentPage", "sitter/mypageSitterRegMom.jsp");
		}else {
			momDAO.getMomSitterInfo(req);
			req.setAttribute("mypageContentPage", "sitter/mypageSitterUpdateMom.jsp");			
		}

		return "home";
	}

	// 케어시터페이지
	@RequestMapping(value = "/mypage.sitterRegCare.go", method = RequestMethod.GET)
	public String mypageSitterRegCare(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		MemberDTO mDTO = (MemberDTO)req.getSession().getAttribute("userInfo");
		if (mDTO.getUser_cs_status() == 0) {
		req.setAttribute("mypageContentPage", "sitter/mypageSitterRegCare.jsp");
		}else {
			cDAO.getCareSitterInfo(req);
			req.setAttribute("mypageContentPage", "sitter/mypageSitterUpdateCare.jsp");			
		}

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
		
		mDAO.logincheck(req);
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");		
		if (mDTO.getUser_pt_status()==0) {
			req.setAttribute("contentPage", "mypage/mypage.jsp");
			req.setAttribute("mypageContentPage", "taker/mypageTakerRegPet.jsp");
			
		} else {
			//해야할 것 > 새로운 돌보미 등록 or 기존 돌보미 수정?
			mpDAO.getListOfPetDolbom(req);
			req.setAttribute("contentPage", "mypage/mypage.jsp");
			req.setAttribute("mypageContentPage", "taker/mypageTakerRegAnotherPetDolbom.jsp");
		}
		return "home";
	}

	// 맘테이커페이지
	@RequestMapping(value = "/mypage.takerRegMom.go", method = RequestMethod.GET)
	public String mypageTakerRegMom(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);		
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");		
		if (mDTO.getUser_mt_status()==0) {
			req.setAttribute("mypageContentPage", "taker/mypageTakerRegMom.jsp");
		}else {
			mpDAO.getListOfMomDolbom(req);
			req.setAttribute("mypageContentPage", "taker/mypageTakerRegAnotherMomDolbom.jsp");
		}
		
		
		return "home";
	}

	// 케어테이커페이지
	@RequestMapping(value = "/mypage.takerRegCare.go", method = RequestMethod.GET)
	public String mypageTakerRegCare(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");		
		if (mDTO.getUser_mt_status()==0) {
			req.setAttribute("mypageContentPage", "taker/mypageTakerRegCare.jsp");
		}else {
			mpDAO.getListOfCareDolbom(req);
			req.setAttribute("mypageContentPage", "taker/mypageTakerRegAnotherCareDolbom.jsp");
		}
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
	@RequestMapping(value = "/mypage.regReview.go", method = RequestMethod.GET)
	public String mypageReview_go(HttpServletRequest req) {
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		mDAO.logincheck(req);
		mDAO.getAllReview(req);
		
		req.setAttribute("mypageContentPage", "mypageReview.jsp");
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
	
	@RequestMapping(value = "mypage.certif.check", method = RequestMethod.GET)
	public String certificationCheck(HttpServletRequest req, MoneyDTO mm) {
		mDAO.logincheck(req);
		mpDAO.getcertiflist(req, mm);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "mypageCertification.jsp");
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

	@RequestMapping(value = "/mypage.takerRegAnotherPetDolbom.go", method = RequestMethod.GET)
	public String regAnotherPet(HttpServletRequest req) {
		mDAO.logincheck(req);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "taker/mypageTakerRegAnotherPet.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/mypage.takerUpdateAnotherPetDolbom.go", method = RequestMethod.GET)
	public String updatePetDolbom(HttpServletRequest req, DolbomDTO dDTO) {
		mDAO.logincheck(req);
		mpDAO.getDolbomInfo(req, dDTO);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "taker/mypageTakerUpdatePetDolbom.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/mypage.takerRegAnotherMomDolbom.go", method = RequestMethod.GET)
	public String regAnotherMom(HttpServletRequest req) {
		mDAO.logincheck(req);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "taker/mypageTakerRegAnotherMom.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/mypage.takerUpdateAnotherMomDolbom.go", method = RequestMethod.GET)
	public String updateMomDolbom(HttpServletRequest req, DolbomDTO dDTO) {
		mDAO.logincheck(req);
		mpDAO.getDolbomInfo(req, dDTO);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "taker/mypageTakerUpdateMomDolbom.jsp");
		return "home";
	}
	@RequestMapping(value = "/mypage.takerRegAnotherCareDolbom.go", method = RequestMethod.GET)
	public String regAnotherCare(HttpServletRequest req) {
		mDAO.logincheck(req);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "taker/mypageTakerRegAnotherCare.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/mypage.takerUpdateAnotherCareDolbom.go", method = RequestMethod.GET)
	public String updateCareDolbom(HttpServletRequest req, DolbomDTO dDTO) {
		mDAO.logincheck(req);
		mpDAO.getDolbomInfo(req, dDTO);
		req.setAttribute("contentPage", "mypage/mypage.jsp");
		req.setAttribute("mypageContentPage", "taker/mypageTakerUpdateCareDolbom.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/regPetDolbom.do", method = RequestMethod.POST)
	public String regPetdolbom_do(HttpServletRequest req, PetTakerDTO ptDTO, DolbomDTO dDTO) {
		pDAO.regPetDolbom(req, dDTO);
		
		return "redirect:/mypage.takerRegPet.go";
	}
	
	@RequestMapping(value = "/regMomDolbom.do", method = RequestMethod.POST)
	public String regMomdolbom_do(HttpServletRequest req, PetTakerDTO ptDTO, DolbomDTO dDTO) {
		momDAO.regMomDolbom(req, dDTO);
		
		return "redirect:/mypage.takerRegMom.go";
	}
	
	@RequestMapping(value = "/regCareDolbom.do", method = RequestMethod.POST)
	public String regCaredolbom_do(HttpServletRequest req, PetTakerDTO ptDTO, DolbomDTO dDTO) {
		cDAO.regCareDolbom(req, dDTO);
		
		return "redirect:/mypage.takerRegCare.go";
	}
	
	@RequestMapping(value = "/cntSitterUpdate.do", method = RequestMethod.GET)
	public String cntSitterUpdate_do(HttpServletRequest req, ContractDTO cntDTO) {
		mpDAO.updateCntSitter(req, cntDTO);
		
		return "redirect:/mypage.usage.go";
	}
	@RequestMapping(value = "/cntSitterUpdate.nope", method = RequestMethod.GET)
	public String cntSitterUpdate_nope(HttpServletRequest req, ContractDTO cntDTO) {
		mpDAO.updateCntSitterNope(req, cntDTO);
		
		return "redirect:/mypage.usage.go";
	}
	@RequestMapping(value = "/cntDolbomUpdate.do", method = RequestMethod.GET)
	public String cntDolbomUpdate_do(HttpServletRequest req, ContractDTO cntDTO) {
		mpDAO.updateCntDolbom(req, cntDTO);
		
		return "redirect:/mypage.usage.go";
	}
	@RequestMapping(value = "/cntDolbomUpdate.nope", method = RequestMethod.GET)
	public String cntDolbomUpdate_nope(HttpServletRequest req, ContractDTO cntDTO) {
		mpDAO.updateCntDolbomNope(req, cntDTO);
		
		return "redirect:/mypage.usage.go";
	}
	
	
	
}
