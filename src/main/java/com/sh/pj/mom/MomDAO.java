package com.sh.pj.mom;

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

import com.sh.pj.ReviewDTO;
import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;
import com.sh.pj.account.MemberMapper;


import com.sh.pj.ask.SiteOption;
import com.sh.pj.care.CareMapper;
import com.sh.pj.pet.PetDTO;

import com.sh.pj.pet.PetMapper;
import com.sh.pj.pet.PetSelector;




@Service
public class MomDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private ServletContext sc;


	private int allMsgCountMomDolbom;

	public void getAll(HttpServletRequest req, MomDTO momDTO, Model m) {

		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");

		m.addAttribute("momsitters", ss.getMapper(MomMapper.class).getAll(momDTO));
	}

	
	@Autowired
	private SiteOption su;
	
	private int allMsgCountMomSitter;


	public void detail(HttpServletRequest req, MomDTO momDTO, Model m) {
		MomDTO mm = ss.getMapper(MomMapper.class).detail(momDTO);

		String[] ms_hour = mm.getMs_hour().split("!");

		mm.setMonday_start(Integer.parseInt(ms_hour[0]));
		mm.setMonday_end(Integer.parseInt(ms_hour[1]));
		mm.setTuesday_start(Integer.parseInt(ms_hour[2]));
		mm.setTuesday_end(Integer.parseInt(ms_hour[3]));
		mm.setWednesday_start(Integer.parseInt(ms_hour[4]));
		mm.setWednesday_end(Integer.parseInt(ms_hour[5]));
		mm.setThursday_start(Integer.parseInt(ms_hour[6]));
		mm.setThursday_end(Integer.parseInt(ms_hour[7]));
		mm.setFriday_start(Integer.parseInt(ms_hour[8]));
		mm.setFriday_end(Integer.parseInt(ms_hour[9]));
		mm.setSaturday_start(Integer.parseInt(ms_hour[10]));
		mm.setSaturday_end(Integer.parseInt(ms_hour[11]));
		mm.setSunday_start(Integer.parseInt(ms_hour[12]));
		mm.setSunday_end(Integer.parseInt(ms_hour[13]));

		String[] ps_day = mm.getMs_day().split("!");

		mm.setMonday(ps_day[0]);
		mm.setTuesday(ps_day[1]);
		mm.setWednesday(ps_day[2]);
		mm.setThursday(ps_day[3]);
		mm.setFriday(ps_day[4]);
		mm.setSaturday(ps_day[5]);
		mm.setSunday(ps_day[6]);

		mm.setMm(ss.getMapper(MomMapper.class).detailUser(mm));

		List<ReviewDTO> rDTO = ss.getMapper(MomMapper.class).review(momDTO);

		if (rDTO == null || rDTO.isEmpty()) {
			m.addAttribute("review", "none");
        } else {
        	for (ReviewDTO reviewDTO : rDTO) {
        		reviewDTO.setMemberDTO(ss.getMapper(MomMapper.class).detailReview(reviewDTO));
        	}
        	m.addAttribute("review", rDTO);
		}

		System.out.println(ss.getMapper(MomMapper.class).review(momDTO));

		m.addAttribute("momsitter", mm);

	}

	public void regMomDolbom(HttpServletRequest req, DolbomDTO dDTO) {
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

		if (ss.getMapper(MomMapper.class).regDolbom(dDTO) == 1) {
			System.out.println("돌보미 등록 완료");
			ss.getMapper(MemberMapper.class).upDCount();
		}

	}

	public void regMomSitter(HttpServletRequest req, MomDTO momDTO) {
		try {
			String imgOrgName = momDTO.getMs_Rfile().getOriginalFilename();
			long imgSize = momDTO.getMs_Rfile().getSize();

			String extension = imgOrgName.substring(imgOrgName.lastIndexOf("."), imgOrgName.length());

			String newName = UUID.randomUUID().toString().split("-")[0];

			String path = sc.getRealPath("resources/img");

			File saveImg = new File(path + "//" + newName + extension);

			momDTO.getMs_Rfile().transferTo(saveImg);
			momDTO.setMs_file(newName + extension);

			MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");

			momDTO.setMs_id(mDTO.getUser_id());

			momDTO.setMs_confirm("0");
			momDTO.setMs_confirm_answer("ndy");

			int j = 1;
			for (int i = 0; i < momDTO.getMomsitter_act().length; i++) {
				j *= momDTO.getMomsitter_act()[i];
			}

			momDTO.setMs_can_do(Integer.toString(j));

			String ms_day = momDTO.getMonday() + "!" + momDTO.getTuesday() + "!" + momDTO.getWednesday() + "!"

					+ momDTO.getThursday() + "!" + momDTO.getFriday() + "!" + momDTO.getSaturday() + "!"
					+ momDTO.getSunday();

			momDTO.setMs_day(ms_day);

			String d_hour = momDTO.getMonday_start() + "!" + momDTO.getMonday_end() + "!" + momDTO.getTuesday_start()
					+ "!" + momDTO.getTuesday_end() + "!" + momDTO.getWednesday_start() + "!"
					+ momDTO.getWednesday_end() + "!" + momDTO.getThursday_start() + "!" + momDTO.getThursday_end()
					+ "!" + momDTO.getFriday_start() + "!" + momDTO.getFriday_end() + "!" + momDTO.getSaturday_start()
					+ "!" + momDTO.getSaturday_end() + "!" + momDTO.getSunday_start() + "!" + momDTO.getSunday_end();
			momDTO.setMs_hour(d_hour);

			int j1 = 1;
			for (int i1 = 0; i1 < momDTO.getMs_type().length; i1++) {
				j1 *= momDTO.getMs_type()[i1];
			}
			momDTO.setMs_can_type(Integer.toString(j1));

			System.out.println(momDTO);

			if (ss.getMapper(MomMapper.class).regMomSitter(momDTO) == 1) {

				System.out.println("등록 완료");
				mDTO.setUser_ms_status(1);
				ss.getMapper(MomMapper.class).changemsstatus(mDTO);
				req.getSession().setAttribute("userInfo", mDTO);
				ss.getMapper(MemberMapper.class).upSCount();

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void detailtaker(HttpServletRequest req, DolbomDTO dolbomDTO, Model m) {
		DolbomDTO pp = ss.getMapper(MomMapper.class).detailtaker(dolbomDTO);

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

		pp.setMm(ss.getMapper(MomMapper.class).detailUser2(pp));

		/*
		 * m.addAttribute("reviews", ss.getMapper(PetMapper.class).review(dolbomDTO));
		 * System.out.println(ss.getMapper(PetMapper.class).review(dolbomDTO));
		 */

		m.addAttribute("dolbom", pp);
	}

	public void getAlltaker(HttpServletRequest req, DolbomDTO dolbomDTO, Model m) {
		List<DolbomDTO>dDTOs = ss.getMapper(MomMapper.class).getAllTaker(dolbomDTO);
		
		for (DolbomDTO d : dDTOs) {
			String location[] = d.getD_location().split("!");
			d.setM_addr1(location[0]);
			d.setM_addr2(location[1]);
			d.setM_addr3(location[2]);
			System.out.println(location[0]);
		}
		
		
		m.addAttribute("dolbom",dDTOs);
	}


	public void getMomSitterInfo(HttpServletRequest req) {

		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");

		MomDTO momDTO = ss.getMapper(MomMapper.class).getMomSitterInfo(mDTO);

		String[] petsitter_hour = momDTO.getMs_hour().split("!");

		momDTO.setMonday_start(Integer.parseInt(petsitter_hour[0]));
		momDTO.setMonday_end(Integer.parseInt(petsitter_hour[1]));
		momDTO.setTuesday_start(Integer.parseInt(petsitter_hour[2]));
		momDTO.setTuesday_end(Integer.parseInt(petsitter_hour[3]));
		momDTO.setWednesday_start(Integer.parseInt(petsitter_hour[4]));
		momDTO.setWednesday_end(Integer.parseInt(petsitter_hour[5]));
		momDTO.setThursday_start(Integer.parseInt(petsitter_hour[6]));
		momDTO.setThursday_end(Integer.parseInt(petsitter_hour[7]));
		momDTO.setFriday_start(Integer.parseInt(petsitter_hour[8]));
		momDTO.setFriday_end(Integer.parseInt(petsitter_hour[9]));
		momDTO.setSaturday_start(Integer.parseInt(petsitter_hour[10]));
		momDTO.setSaturday_end(Integer.parseInt(petsitter_hour[11]));
		momDTO.setSunday_start(Integer.parseInt(petsitter_hour[12]));
		momDTO.setSunday_end(Integer.parseInt(petsitter_hour[13]));

		String[] petsitter_day = momDTO.getMs_day().split("!");

		momDTO.setMonday(petsitter_day[0]);
		momDTO.setTuesday(petsitter_day[1]);
		momDTO.setWednesday(petsitter_day[2]);
		momDTO.setThursday(petsitter_day[3]);
		momDTO.setFriday(petsitter_day[4]);
		momDTO.setSaturday(petsitter_day[5]);
		momDTO.setSunday(petsitter_day[6]);

		req.setAttribute("msInfo", momDTO);

	}

	public void updateMomSitter(HttpServletRequest req, MomDTO momDTO) {

		try {
			String imgOrgName = momDTO.getMs_Rfile().getOriginalFilename();
			long imgSize = momDTO.getMs_Rfile().getSize();
			if (imgSize != 0) {
				String extension = imgOrgName.substring(imgOrgName.lastIndexOf("."), imgOrgName.length());

				String newName = UUID.randomUUID().toString().split("-")[0];

				String path = sc.getRealPath("resources/img");

				File saveImg = new File(path + "//" + newName + extension);

				momDTO.getMs_Rfile().transferTo(saveImg);
				momDTO.setMs_file(newName + extension);
				momDTO.setMs_confirm("0");
				momDTO.setMs_confirm_answer("ndy");
			}

			MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");

			momDTO.setMs_id(mDTO.getUser_id());

			int j = 1;
			for (int i = 0; i < momDTO.getMomsitter_act().length; i++) {
				j *= momDTO.getMomsitter_act()[i];
			}

			momDTO.setMs_can_do(Integer.toString(j));

			String ms_day = momDTO.getMonday() + "!" + momDTO.getTuesday() + "!" + momDTO.getWednesday() + "!"

					+ momDTO.getThursday() + "!" + momDTO.getFriday() + "!" + momDTO.getSaturday() + "!"
					+ momDTO.getSunday();

			momDTO.setMs_day(ms_day);

			String d_hour = momDTO.getMonday_start() + "!" + momDTO.getMonday_end() + "!" + momDTO.getTuesday_start()
					+ "!" + momDTO.getTuesday_end() + "!" + momDTO.getWednesday_start() + "!"
					+ momDTO.getWednesday_end() + "!" + momDTO.getThursday_start() + "!" + momDTO.getThursday_end()
					+ "!" + momDTO.getFriday_start() + "!" + momDTO.getFriday_end() + "!" + momDTO.getSaturday_start()
					+ "!" + momDTO.getSaturday_end() + "!" + momDTO.getSunday_start() + "!" + momDTO.getSunday_end();
			momDTO.setMs_hour(d_hour);

			int j1 = 1;
			for (int i1 = 0; i1 < momDTO.getMs_type().length; i1++) {
				j1 *= momDTO.getMs_type()[i1];
			}
			momDTO.setMs_can_type(Integer.toString(j1));


			System.out.println(momDTO);

			if (ss.getMapper(MomMapper.class).updateMomSitter(momDTO) == 1) {

				System.out.println("수정 완료");

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void updateMomDolbom(HttpServletRequest req, DolbomDTO dDTO) {
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
		
//		따로 만드는게 맞지만 다른게 없어서 그냥 하나로 통일...(petmapper에 있는건 좀 안타깝긴 함)
		if (ss.getMapper(PetMapper.class).updateDolbom(dDTO) == 1) {
			System.out.println("돌보미 수정 완료");
		}

	}
	

	public void calcAllMsgCountMomDolbom() {
		MomSelector mSel = new MomSelector("", null, null);
		allMsgCountMomDolbom = ss.getMapper(MomMapper.class).getMsgCount2(mSel);
		System.out.println(allMsgCountMomDolbom);
	}

	public void getMsg2(int pageNo, HttpServletRequest req) {
		int count = 5;
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);

		MomSelector momSearch = (MomSelector) req.getSession().getAttribute("searchSession");
		int msgCount = 1;
		System.out.println("세션 petsearch = " + momSearch);

		if (momSearch != null) {
			momSearch.setMs_start(new BigDecimal(start));
			momSearch.setMs_end(new BigDecimal(end));
			msgCount = ss.getMapper(MomMapper.class).getMsgCount2(momSearch);
		} else {
			// 검색 조건이 없는 경우에 전체 데이터 수를 가져오도록 변경
			momSearch = new MomSelector("", new BigDecimal(start), new BigDecimal(end));
			
			msgCount = allMsgCountMomDolbom;
			System.out.println("앙 공주띠");	
			System.out.println(allMsgCountMomDolbom);
			
		}

//		aDTO.setInquiry_category(req.getParameter("inquiry_category"));
		System.out.println("asksearch = " + momSearch);
		try {
			List<DolbomDTO> resultList = ss.getMapper(MomMapper.class).getMsg2(momSearch);
			
			for (DolbomDTO p : resultList) {
				p.setMm(ss.getMapper(MomMapper.class).detailUser2(p));
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

	public void calcAllMsgCountMomSitter() {
		MomSelector sSel = new MomSelector("", null, null);
		allMsgCountMomSitter = ss.getMapper(MomMapper.class).getMsgCount(sSel);
		System.out.println(allMsgCountMomSitter);
	}

	public void getMsg(int pageNo, HttpServletRequest req) {
		int count = 3;
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);

		MomSelector momSearch = (MomSelector) req.getSession().getAttribute("searchSession");
		int msgCount = 1;
		System.out.println("세션 petsearch = " + momSearch);

		if (momSearch != null) {
			momSearch.setMs_start(new BigDecimal(start));
			momSearch.setMs_end(new BigDecimal(end));

			msgCount = ss.getMapper(MomMapper.class).getMsgCount(momSearch);

		} else {
			// 검색 조건이 없는 경우에 전체 데이터 수를 가져오도록 변경
			momSearch = new MomSelector("", new BigDecimal(start), new BigDecimal(end));
			

			msgCount = allMsgCountMomSitter;
			System.out.println("앙 공주띠");	
			System.out.println(allMsgCountMomSitter);

			
		}

//		aDTO.setInquiry_category(req.getParameter("inquiry_category"));
		System.out.println("asksearch = " + momSearch);
		try {

			List<MomDTO> resultList = ss.getMapper(MomMapper.class).getMsg(momSearch);
			
			for (MomDTO m : resultList) {
				m.setMm(ss.getMapper(MomMapper.class).detailUser(m));

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

	public void deleteMomsitter(HttpServletRequest req, MomDTO momDTO, Model m) {
		
		if (ss.getMapper(MomMapper.class).deleteMomsitter(momDTO) == 1) {
			System.out.println("삭제 성공");
		}
		
	}

	public void noticeUP(HttpServletRequest req, MomDTO momDTO, Model m) {
		if(ss.getMapper(MomMapper.class).noticeUP(momDTO) == 1) {
			System.out.println("공고 성공");
		}
	}

	public void noticeUpdate(HttpServletRequest req, MomDTO momDTO, Model m) {
		if (ss.getMapper(MomMapper.class).noticeUpdate(momDTO) == 1) {
			System.out.println("날짜 최신화");
		}
		
	}

	public void noticeDOWN(HttpServletRequest req, MomDTO momDTO, Model m) {
		if (ss.getMapper(MomMapper.class).noticeDOWN(momDTO) == 1) {
			System.out.println("내리기 성공");
		}
		
	}

	public void msAccept(HttpServletRequest req, MomDTO momDTO) {
		if(ss.getMapper(MomMapper.class).msAccept(momDTO)==1) {
			if(ss.getMapper(MemberMapper.class).msUpdate(momDTO) == 1) {
				System.out.println("당신을 맘시터로 인정합니다");				
			}
		}
		
	}

	public void msReject(HttpServletRequest req, MomDTO momDTO) {
		
		if(ss.getMapper(MomMapper.class).msReject(momDTO)==1) {
			System.out.println("넌 못지나간다");
		}
	}

	public List<DolbomDTO> getUserDolbomData(HttpServletRequest req, DolbomDTO dDTO) {
		
		MemberDTO memberDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		
		return ss.getMapper(MomMapper.class).getUserDolbomData(memberDTO);
		
	}

	public void getallpoint(HttpServletRequest req, MomDTO momDTO) {
		List<MomDTO> resultList = ss.getMapper(MomMapper.class).getAllPoint(momDTO);
		
		for (MomDTO m : resultList) {
			m.setMm(ss.getMapper(MomMapper.class).detailUser(m));
		}
		
		req.setAttribute("ss", resultList);
	
	}		
	


}

