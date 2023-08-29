package com.sh.pj.pet;

import java.io.File;

import java.math.BigDecimal;

import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.pj.ReviewDTO;
import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;
import com.sh.pj.account.MemberMapper;

import com.sh.pj.ask.SiteOption;
import com.sh.pj.care.CareMapper;


@Service
public class PetDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private ServletContext sc;
	
	@Autowired
	private SiteOption su; // 한페이지에 몇개씩 보여줄지.
	
	private int allMsgCountPetSitter; 

	private int allMsgCountPetDolbom; 
		
	
	public void regPetDolbom(HttpServletRequest req, DolbomDTO dDTO) {

//		사진 넣는거 오늘 회의때 회의하기

		String d_day = dDTO.getMonday() + "!" + dDTO.getTuesday() + "!" + dDTO.getWednesday() + "!" + dDTO.getThursday()
				+ "!" + dDTO.getFriday() + "!" + dDTO.getSaturday() + "!" + dDTO.getSunday();

		dDTO.setD_day(d_day);

		String d_hour = dDTO.getMonday_start() + "!" + dDTO.getMonday_end() + "!" + dDTO.getTuesday_start() + "!"
				+ dDTO.getTuesday_end() + "!" + dDTO.getWednesday_start() + "!" + dDTO.getWednesday_end() + "!"
				+ dDTO.getThursday_start() + "!" + dDTO.getThursday_end() + "!" + dDTO.getFriday_start() + "!"
				+ dDTO.getFriday_end() + "!" + dDTO.getSaturday_start() + "!" + dDTO.getSaturday_end() + "!"
				+ dDTO.getSunday_start() + "!" + dDTO.getSunday_end();
		dDTO.setD_hour(d_hour);

		if (dDTO.getD_check() == null) {
			dDTO.setD_check("0");
		} else {
			dDTO.setD_check("1");
		}

		int i = 1;

		for (int j = 0; j < dDTO.getDolbom_act().length; j++) {
			i *= dDTO.getDolbom_act()[j];
		}

		dDTO.setD_can_do(Integer.toString(i));

		dDTO.setD_location(
				req.getParameter("m_addr1") + "!" + req.getParameter("m_addr2") + "!" + req.getParameter("m_addr3"));

		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		dDTO.setD_id(mDTO.getUser_id());

		dDTO.setD_sitterage("ndy");
		dDTO.setd_onoff("off");

		System.out.println(dDTO);

		if (ss.getMapper(PetMapper.class).regDolbom(dDTO) == 1) {
			System.out.println("돌보미 등록 완료");
			ss.getMapper(MemberMapper.class).upDCount();
		}

	}

	public void detail(HttpServletRequest req, PetDTO petDTO, Model m) {

		PetDTO pp = ss.getMapper(PetMapper.class).detail(petDTO);

		String[] ps_hour = pp.getPs_hour().split("!");

		pp.setMonday_start(Integer.parseInt(ps_hour[0]));
		pp.setMonday_end(Integer.parseInt(ps_hour[1]));
		pp.setTuesday_start(Integer.parseInt(ps_hour[2]));
		pp.setTuesday_end(Integer.parseInt(ps_hour[3]));
		pp.setWednesday_start(Integer.parseInt(ps_hour[4]));
		pp.setWednesday_end(Integer.parseInt(ps_hour[5]));
		pp.setThursday_start(Integer.parseInt(ps_hour[6]));
		pp.setThursday_end(Integer.parseInt(ps_hour[7]));
		pp.setFriday_start(Integer.parseInt(ps_hour[8]));
		pp.setFriday_end(Integer.parseInt(ps_hour[9]));
		pp.setSaturday_start(Integer.parseInt(ps_hour[10]));
		pp.setSaturday_end(Integer.parseInt(ps_hour[11]));
		pp.setSunday_start(Integer.parseInt(ps_hour[12]));
		pp.setSunday_end(Integer.parseInt(ps_hour[13]));

		String[] ps_day = pp.getPs_day().split("!");

		pp.setMonday(ps_day[0]);
		pp.setTuesday(ps_day[1]);
		pp.setWednesday(ps_day[2]);
		pp.setThursday(ps_day[3]);
		pp.setFriday(ps_day[4]);
		pp.setSaturday(ps_day[5]);
		pp.setSunday(ps_day[6]);

		pp.setMm(ss.getMapper(PetMapper.class).detailUser(pp));
		
		List<ReviewDTO> rDTO = ss.getMapper(PetMapper.class).review(petDTO);
		m.addAttribute("review", rDTO);
		if (rDTO == null || rDTO.isEmpty()) {
			m.addAttribute("review", "none");
        }
		
		System.out.println(ss.getMapper(PetMapper.class).review(petDTO));

		m.addAttribute("petsitter", pp);

	}

	public void regPetSitter(HttpServletRequest req, PetDTO pDTO) {
		try {
			String imgOrgName = pDTO.getPs_Rfile().getOriginalFilename();
			long imgSize = pDTO.getPs_Rfile().getSize();

			String extension = imgOrgName.substring(imgOrgName.lastIndexOf("."), imgOrgName.length());

			String newName = UUID.randomUUID().toString().split("-")[0];

			String path = sc.getRealPath("resources/img");
  
			File saveImg = new File(path + "//" + newName + extension);

			pDTO.getPs_Rfile().transferTo(saveImg);
			pDTO.setPs_file(newName + extension);
			
			String extra = pDTO.getPs_extra();
			extra.replaceAll("\r\n", "<br>");
			pDTO.setPs_extra(extra);
			
			String exp = pDTO.getPs_exp();
			exp.replace("\r\n", "<br>");
			pDTO.setPs_exp(exp);

			MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
			pDTO.setPs_id(mDTO.getUser_id());

			pDTO.setPs_confirm("0");
			pDTO.setPs_confirm_answer("ndy");

			int j = 1;
			for (int i = 0; i < pDTO.getPetsitter_act().length; i++) {
				j *= pDTO.getPetsitter_act()[i];
			}

			pDTO.setPs_can_do(Integer.toString(j));

			String ps_day = pDTO.getMonday() + "!" + pDTO.getTuesday() + "!" + pDTO.getWednesday() + "!"
					+ pDTO.getThursday() + "!" + pDTO.getFriday() + "!" + pDTO.getSaturday() + "!" + pDTO.getSunday();

			pDTO.setPs_day(ps_day);

			String d_hour = pDTO.getMonday_start() + "!" + pDTO.getMonday_end() + "!" + pDTO.getTuesday_start() + "!"
					+ pDTO.getTuesday_end() + "!" + pDTO.getWednesday_start() + "!" + pDTO.getWednesday_end() + "!"
					+ pDTO.getThursday_start() + "!" + pDTO.getThursday_end() + "!" + pDTO.getFriday_start() + "!"
					+ pDTO.getFriday_end() + "!" + pDTO.getSaturday_start() + "!" + pDTO.getSaturday_end() + "!"
					+ pDTO.getSunday_start() + "!" + pDTO.getSunday_end();
			pDTO.setPs_hour(d_hour);

			int j1 = 1;
			for (int i1 = 0; i1 < pDTO.getPs_type().length; i1++) {
				j1 *= pDTO.getPs_type()[i1];
			}
			pDTO.setPs_can_type(Integer.toString(j1));

			System.out.println(pDTO);

			if (ss.getMapper(PetMapper.class).regPetSitter(pDTO) == 1) {

				System.out.println("등록 완료");
				mDTO.setUser_ps_status(1);
				ss.getMapper(PetMapper.class).changePsStatus(mDTO);
				req.getSession().setAttribute("userInfo", mDTO);
				ss.getMapper(MemberMapper.class).upSCount();

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void deletePetsitter(HttpServletRequest req, PetDTO pDTO, Model model) {

		if (ss.getMapper(PetMapper.class).deletePetsitter(pDTO) == 1) {
			System.out.println("삭제 성공!");
			req.setAttribute("deletecheck", "1");
		}

	}

	public void updatePetDolbom(HttpServletRequest req, DolbomDTO dDTO) {

		String d_day = dDTO.getMonday() + "!" + dDTO.getTuesday() + "!" + dDTO.getWednesday() + "!" + dDTO.getThursday()
				+ "!" + dDTO.getFriday() + "!" + dDTO.getSaturday() + "!" + dDTO.getSunday();

		dDTO.setD_day(d_day);

		String d_hour = dDTO.getMonday_start() + "!" + dDTO.getMonday_end() + "!" + dDTO.getTuesday_start() + "!"
				+ dDTO.getTuesday_end() + "!" + dDTO.getWednesday_start() + "!" + dDTO.getWednesday_end() + "!"
				+ dDTO.getThursday_start() + "!" + dDTO.getThursday_end() + "!" + dDTO.getFriday_start() + "!"
				+ dDTO.getFriday_end() + "!" + dDTO.getSaturday_start() + "!" + dDTO.getSaturday_end() + "!"
				+ dDTO.getSunday_start() + "!" + dDTO.getSunday_end();
		dDTO.setD_hour(d_hour);

		if (!dDTO.getD_check().equals("1")) {
			dDTO.setD_check("0");
		}

		int i = 1;

		for (int j = 0; j < dDTO.getDolbom_act().length; j++) {
			i *= dDTO.getDolbom_act()[j];
		}

		dDTO.setD_can_do(Integer.toString(i));

		dDTO.setD_location(
				req.getParameter("m_addr1") + "!" + req.getParameter("m_addr2") + "!" + req.getParameter("m_addr3"));

		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		dDTO.setD_id(mDTO.getUser_id());

		dDTO.setD_sitterage("ndy");
		dDTO.setd_onoff("off");

		System.out.println(dDTO);

		if (ss.getMapper(PetMapper.class).updateDolbom(dDTO) == 1) {
			System.out.println("돌보미 수정 완료");
		}
	}

	public void getPetSitterInfo(HttpServletRequest req) {
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");

		PetDTO pDTO = ss.getMapper(PetMapper.class).getPetSitterInfo(mDTO);

		String[] petsitter_hour = pDTO.getPs_hour().split("!");

		pDTO.setMonday_start(Integer.parseInt(petsitter_hour[0]));
		pDTO.setMonday_end(Integer.parseInt(petsitter_hour[1]));
		pDTO.setTuesday_start(Integer.parseInt(petsitter_hour[2]));
		pDTO.setTuesday_end(Integer.parseInt(petsitter_hour[3]));
		pDTO.setWednesday_start(Integer.parseInt(petsitter_hour[4]));
		pDTO.setWednesday_end(Integer.parseInt(petsitter_hour[5]));
		pDTO.setThursday_start(Integer.parseInt(petsitter_hour[6]));
		pDTO.setThursday_end(Integer.parseInt(petsitter_hour[7]));
		pDTO.setFriday_start(Integer.parseInt(petsitter_hour[8]));
		pDTO.setFriday_end(Integer.parseInt(petsitter_hour[9]));
		pDTO.setSaturday_start(Integer.parseInt(petsitter_hour[10]));
		pDTO.setSaturday_end(Integer.parseInt(petsitter_hour[11]));
		pDTO.setSunday_start(Integer.parseInt(petsitter_hour[12]));
		pDTO.setSunday_end(Integer.parseInt(petsitter_hour[13]));

		String[] petsitter_day = pDTO.getPs_day().split("!");

		pDTO.setMonday(petsitter_day[0]);
		pDTO.setTuesday(petsitter_day[1]);
		pDTO.setWednesday(petsitter_day[2]);
		pDTO.setThursday(petsitter_day[3]);
		pDTO.setFriday(petsitter_day[4]);
		pDTO.setSaturday(petsitter_day[5]);
		pDTO.setSunday(petsitter_day[6]);

		req.setAttribute("psInfo", pDTO);

	}

	public void updatePetSitter(HttpServletRequest req, PetDTO pDTO) {
		try {
			String imgOrgName = pDTO.getPs_Rfile().getOriginalFilename();
			long imgSize = pDTO.getPs_Rfile().getSize();
			if (imgSize != 0) {
				String extension = imgOrgName.substring(imgOrgName.lastIndexOf("."), imgOrgName.length());

				String newName = UUID.randomUUID().toString().split("-")[0];

				String path = sc.getRealPath("resources/img");

				File saveImg = new File(path + "//" + newName + extension);

				pDTO.getPs_Rfile().transferTo(saveImg);
				pDTO.setPs_file(newName + extension);
				pDTO.setPs_confirm("0");
				pDTO.setPs_confirm_answer("ndy");
			}
			
			String extra = pDTO.getPs_extra();
			extra.replaceAll("<br>", "\r\n");
			pDTO.setPs_extra(extra);
			
			String exp = pDTO.getPs_exp();
			exp.replace("<br>", "\r\n");
			pDTO.setPs_exp(exp);

			MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
			pDTO.setPs_id(mDTO.getUser_id());

			int j = 1;
			for (int i = 0; i < pDTO.getPetsitter_act().length; i++) {
				j *= pDTO.getPetsitter_act()[i];
			}

			pDTO.setPs_can_do(Integer.toString(j));

			String ps_day = pDTO.getMonday() + "!" + pDTO.getTuesday() + "!" + pDTO.getWednesday() + "!"
					+ pDTO.getThursday() + "!" + pDTO.getFriday() + "!" + pDTO.getSaturday() + "!" + pDTO.getSunday();

			pDTO.setPs_day(ps_day);

			String d_hour = pDTO.getMonday_start() + "!" + pDTO.getMonday_end() + "!" + pDTO.getTuesday_start() + "!"
					+ pDTO.getTuesday_end() + "!" + pDTO.getWednesday_start() + "!" + pDTO.getWednesday_end() + "!"
					+ pDTO.getThursday_start() + "!" + pDTO.getThursday_end() + "!" + pDTO.getFriday_start() + "!"
					+ pDTO.getFriday_end() + "!" + pDTO.getSaturday_start() + "!" + pDTO.getSaturday_end() + "!"
					+ pDTO.getSunday_start() + "!" + pDTO.getSunday_end();
			pDTO.setPs_hour(d_hour);

			int j1 = 1;
			for (int i1 = 0; i1 < pDTO.getPs_type().length; i1++) {
				j1 *= pDTO.getPs_type()[i1];
			}
			pDTO.setPs_can_type(Integer.toString(j1));

			System.out.println(pDTO);

			if (ss.getMapper(PetMapper.class).updatePetSitter(pDTO) == 1) {

				System.out.println("수정 완료");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	public void calcAllMsgCountPetSitter() {
		PetSelector sSel = new PetSelector("", null, null);
		allMsgCountPetSitter = ss.getMapper(PetMapper.class).getMsgCount(sSel);
		System.out.println(allMsgCountPetSitter);
	}
	public void calcAllMsgCountPetDolbom() {
		PetSelector sSel = new PetSelector("", null, null);
		allMsgCountPetDolbom = ss.getMapper(PetMapper.class).getMsgCount2(sSel);
		System.out.println(allMsgCountPetDolbom);
	}
	

	public void getMsg(int pageNo, HttpServletRequest req) {
		int count = 3;
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);

		PetSelector petSearch = (PetSelector) req.getSession().getAttribute("searchSession");
		int msgCount = 1;
		System.out.println("세션 petsearch = " + petSearch);

		if (petSearch != null) {
			petSearch.setPs_start(new BigDecimal(start));
			petSearch.setPs_end(new BigDecimal(end));
			msgCount = ss.getMapper(PetMapper.class).getMsgCount(petSearch);
		} else {
			// 검색 조건이 없는 경우에 전체 데이터 수를 가져오도록 변경
			petSearch = new PetSelector("", new BigDecimal(start), new BigDecimal(end));
			
			msgCount = allMsgCountPetSitter;
			System.out.println("앙 공주띠");	
			System.out.println(allMsgCountPetSitter);
			
		}

//		aDTO.setInquiry_category(req.getParameter("inquiry_category"));
		System.out.println("asksearch = " + petSearch);
		try {
			List<PetDTO> resultList = ss.getMapper(PetMapper.class).getMsg(petSearch);
			
			for (PetDTO p : resultList) {
				p.setMm(ss.getMapper(PetMapper.class).detailUser(p));
			}
			
			req.setAttribute("s", resultList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("여기까지 나오나 쳌");

		int pageCount = (int) Math.ceil(msgCount / (double) count);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("curPage", pageNo);

		int numPagesToShow = 5;
		int startPage = Math.max(1, pageNo - numPagesToShow / 2);
		int endPage = Math.min(pageCount, startPage + numPagesToShow - 1);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		System.out.println(endPage);
		
	}
	
	public void getMsg2(int pageNo, HttpServletRequest req) {
		int count = 5;
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);

		PetSelector petSearch = (PetSelector) req.getSession().getAttribute("searchSession");
		int msgCount = 1;
		System.out.println("세션 petsearch = " + petSearch);

		if (petSearch != null) {
			petSearch.setPs_start(new BigDecimal(start));
			petSearch.setPs_end(new BigDecimal(end));
			msgCount = ss.getMapper(PetMapper.class).getMsgCount2(petSearch);
		} else {
			// 검색 조건이 없는 경우에 전체 데이터 수를 가져오도록 변경
			petSearch = new PetSelector("", new BigDecimal(start), new BigDecimal(end));
			
			msgCount = allMsgCountPetDolbom;
			System.out.println("앙 공주띠");	
			System.out.println(allMsgCountPetDolbom);
			
		}

//		aDTO.setInquiry_category(req.getParameter("inquiry_category"));
		System.out.println("asksearch = " + petSearch);
		try {
			List<DolbomDTO> resultList = ss.getMapper(PetMapper.class).getMsg2(petSearch);
			
			for (DolbomDTO p : resultList) {
				p.setMm(ss.getMapper(PetMapper.class).detailUser2(p));
				String location[] = p.getD_location().split("!");
				p.setM_addr1(location[0]);
				p.setM_addr2(location[1]);
				p.setM_addr3(location[2]);
			}
			
			req.setAttribute("s", resultList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("여기까지 나오나 쳌");

		int pageCount = (int) Math.ceil(msgCount / (double) count);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("curPage", pageNo);

		int numPagesToShow = 5;
		int startPage = Math.max(1, pageNo - numPagesToShow / 2);
		int endPage = Math.min(pageCount, startPage + numPagesToShow - 1);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		System.out.println("너 맞지?" + endPage);
		
	}

	public void getAllTaker(HttpServletRequest req, DolbomDTO dolbomDTO, Model m) {
		
		List<DolbomDTO>dDTOs = ss.getMapper(PetMapper.class).getAllTaker(dolbomDTO);
		
		for (DolbomDTO d : dDTOs) {
			String location[] = d.getD_location().split("!");
			d.setM_addr1(location[0]);
			d.setM_addr2(location[1]);
			d.setM_addr3(location[2]);
			System.out.println(location[0]);
		}
		
		
		m.addAttribute("pettaker",dDTOs);
	}

	public void detailtaker(HttpServletRequest req, DolbomDTO dolbomDTO, Model m) {
		DolbomDTO pp = ss.getMapper(PetMapper.class).detailtaker(dolbomDTO);

		String[] ps_location = pp.getD_location().split("!");

		pp.setLocation1(ps_location[0]);
		pp.setLocation2(ps_location[1]);
		pp.setLocation3(ps_location[2]);

		String[] ps_hour = pp.getD_hour().split("!");

		pp.setMonday_start(Integer.parseInt(ps_hour[0]));
		pp.setMonday_end(Integer.parseInt(ps_hour[1]));
		pp.setTuesday_start(Integer.parseInt(ps_hour[2]));
		pp.setTuesday_end(Integer.parseInt(ps_hour[3]));
		pp.setWednesday_start(Integer.parseInt(ps_hour[4]));
		pp.setWednesday_end(Integer.parseInt(ps_hour[5]));
		pp.setThursday_start(Integer.parseInt(ps_hour[6]));
		pp.setThursday_end(Integer.parseInt(ps_hour[7]));
		pp.setFriday_start(Integer.parseInt(ps_hour[8]));
		pp.setFriday_end(Integer.parseInt(ps_hour[9]));
		pp.setSaturday_start(Integer.parseInt(ps_hour[10]));
		pp.setSaturday_end(Integer.parseInt(ps_hour[11]));
		pp.setSunday_start(Integer.parseInt(ps_hour[12]));
		pp.setSunday_end(Integer.parseInt(ps_hour[13]));

		String[] ps_day = pp.getD_day().split("!");

		pp.setMonday(ps_day[0]);
		pp.setTuesday(ps_day[1]);
		pp.setWednesday(ps_day[2]);
		pp.setThursday(ps_day[3]);
		pp.setFriday(ps_day[4]);
		pp.setSaturday(ps_day[5]);
		pp.setSunday(ps_day[6]);

		pp.setMm(ss.getMapper(PetMapper.class).detailUser2(pp));

		/*
		 * m.addAttribute("reviews", ss.getMapper(PetMapper.class).review(dolbomDTO));
		 * System.out.println(ss.getMapper(PetMapper.class).review(dolbomDTO));
		 */

		m.addAttribute("dolbom", pp);
	}

	public void delete(HttpServletRequest req, PetDTO petDTO, Model m) {

		if(ss.getMapper(PetMapper.class).deletePetsitter(petDTO) == 1) {
			System.out.println("삭제 성공");
		}
		
	}

	public void noticeUP(HttpServletRequest req, PetDTO petDTO, Model m) {
		
		if(ss.getMapper(PetMapper.class).noticeUP(petDTO) == 1) {
			System.out.println("공고 성공");
		}
		
	}

	public void noticeDOWN(HttpServletRequest req, PetDTO petDTO, Model m) {
		
		if (ss.getMapper(PetMapper.class).noticeDOWN(petDTO) == 1) {
			System.out.println("내리기 성공");
		}
		
	}

	public void noticeUpdate(HttpServletRequest req, PetDTO petDTO, Model m) {
		if (ss.getMapper(PetMapper.class).noticeUpdate(petDTO) == 1) {
			System.out.println("날짜 최신화");
		}
		
	}


}
