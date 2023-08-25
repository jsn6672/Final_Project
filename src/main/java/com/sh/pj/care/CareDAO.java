package com.sh.pj.care;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;
import com.sh.pj.account.MemberMapper;
import com.sh.pj.mom.MomDTO;
import com.sh.pj.mom.MomMapper;
import com.sh.pj.pet.PetDTO;
import com.sh.pj.pet.PetMapper;

@Service
public class CareDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private ServletContext sc;

	public void getAll(HttpServletRequest req, Model m, CareDTO cDTO) {
		m.addAttribute("caresitter", ss.getMapper(CareMapper.class).getAll(cDTO));
		System.out.println(cDTO);

	}

	public void detail(HttpServletRequest req, CareDTO cDTO, Model m) {



		CareDTO pp = ss.getMapper(CareMapper.class).detail(cDTO);

		String[] ps_hour = pp.getCs_hour().split("!");

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

		String[] ps_day = pp.getCs_day().split("!");

		pp.setMonday(ps_day[0]);
		pp.setTuesday(ps_day[1]);
		pp.setWednesday(ps_day[2]);
		pp.setThursday(ps_day[3]);
		pp.setFriday(ps_day[4]);
		pp.setSaturday(ps_day[5]);
		pp.setSunday(ps_day[6]);

		pp.setMm(ss.getMapper(CareMapper.class).detailUser(pp));

		
		  m.addAttribute("reviews", ss.getMapper(CareMapper.class).review(cDTO));
		  System.out.println(ss.getMapper(CareMapper.class).review(cDTO));
	

		m.addAttribute("caresitter", pp);


	}

	public void regcareDolbom(HttpServletRequest req, DolbomDTO dDTO) {

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
		dDTO.setD_title("ndy");

		System.out.println(dDTO);

		if (ss.getMapper(CareMapper.class).regDolbom(dDTO) == 1) {
			System.out.println("돌보미 등록 완료");
			ss.getMapper(MemberMapper.class).upDCount();
		}

	}

	public void regcareSitter(HttpServletRequest req, CareDTO cDTO) {
		try {
			String imgOrgName = cDTO.getCs_Rfile().getOriginalFilename();
			long imgSize = cDTO.getCs_Rfile().getSize();

			String extension = imgOrgName.substring(imgOrgName.lastIndexOf("."), imgOrgName.length());

			String newName = UUID.randomUUID().toString().split("-")[0];

			String path = sc.getRealPath("resources/img");

			File saveImg = new File(path + "//" + newName + extension);

			cDTO.getCs_Rfile().transferTo(saveImg);
			cDTO.setCs_file(newName + extension);

			MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
			cDTO.setCs_id(mDTO.getUser_id());

			cDTO.setCs_confirm("0");
			cDTO.setCs_confirm_answer("ndy");

			int j = 1;
			for (int i = 0; i < cDTO.getCaresitter_act().length; i++) {
				j *= cDTO.getCaresitter_act()[i];
			}

			cDTO.setCs_can_do(Integer.toString(j));

			String cs_day = cDTO.getMonday() + "!" + cDTO.getTuesday() + "!" + cDTO.getWednesday() + "!"
					+ cDTO.getThursday() + "!" + cDTO.getFriday() + "!" + cDTO.getSaturday() + "!" + cDTO.getSunday();

			cDTO.setCs_day(cs_day);

			String d_hour = cDTO.getMonday_start() + "!" + cDTO.getMonday_end() + "!" + cDTO.getTuesday_start() + "!"
					+ cDTO.getTuesday_end() + "!" + cDTO.getWednesday_start() + "!" + cDTO.getWednesday_end() + "!"
					+ cDTO.getThursday_start() + "!" + cDTO.getThursday_end() + "!" + cDTO.getFriday_start() + "!"
					+ cDTO.getFriday_end() + "!" + cDTO.getSaturday_start() + "!" + cDTO.getSaturday_end() + "!"
					+ cDTO.getSunday_start() + "!" + cDTO.getSunday_end();
			cDTO.setCs_hour(d_hour);

			/*
			 * int j1 = 1; for (int i1 = 0; i1 < cDTO.getCs_type().length; i1++) { j1 *=
			 * cDTO.getCs_type()[i1]; } cDTO.setCs_can_type(Integer.toString(j1));
			 */

			System.out.println(cDTO);

			if (ss.getMapper(CareMapper.class).regCareSitter(cDTO) == 1) {

				System.out.println("등록 완료");
				mDTO.setUser_cs_status(1);
				ss.getMapper(CareMapper.class).changecsstatus(mDTO);
				req.getSession().setAttribute("userInfo", mDTO);
				ss.getMapper(MemberMapper.class).upSCount();

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void getCareSitterInfo(HttpServletRequest req) {

		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");

		CareDTO cDTO = ss.getMapper(CareMapper.class).getCareSitterInfo(mDTO);

		String[] petsitter_hour = cDTO.getCs_hour().split("!");

		cDTO.setMonday_start(Integer.parseInt(petsitter_hour[0]));
		cDTO.setMonday_end(Integer.parseInt(petsitter_hour[1]));
		cDTO.setTuesday_start(Integer.parseInt(petsitter_hour[2]));
		cDTO.setTuesday_end(Integer.parseInt(petsitter_hour[3]));
		cDTO.setWednesday_start(Integer.parseInt(petsitter_hour[4]));
		cDTO.setWednesday_end(Integer.parseInt(petsitter_hour[5]));
		cDTO.setThursday_start(Integer.parseInt(petsitter_hour[6]));
		cDTO.setThursday_end(Integer.parseInt(petsitter_hour[7]));
		cDTO.setFriday_start(Integer.parseInt(petsitter_hour[8]));
		cDTO.setFriday_end(Integer.parseInt(petsitter_hour[9]));
		cDTO.setSaturday_start(Integer.parseInt(petsitter_hour[10]));
		cDTO.setSaturday_end(Integer.parseInt(petsitter_hour[11]));
		cDTO.setSunday_start(Integer.parseInt(petsitter_hour[12]));
		cDTO.setSunday_end(Integer.parseInt(petsitter_hour[13]));

		String[] petsitter_day = cDTO.getCs_day().split("!");

		cDTO.setMonday(petsitter_day[0]);
		cDTO.setTuesday(petsitter_day[1]);
		cDTO.setWednesday(petsitter_day[2]);
		cDTO.setThursday(petsitter_day[3]);
		cDTO.setFriday(petsitter_day[4]);
		cDTO.setSaturday(petsitter_day[5]);
		cDTO.setSunday(petsitter_day[6]);

		req.setAttribute("csInfo", cDTO);

	}

	public void updatecareSitter(HttpServletRequest req, CareDTO cDTO) {
		try {
			String imgOrgName = cDTO.getCs_Rfile().getOriginalFilename();
			long imgSize = cDTO.getCs_Rfile().getSize();

			if (imgSize != 0) {
				String extension = imgOrgName.substring(imgOrgName.lastIndexOf("."), imgOrgName.length());

				String newName = UUID.randomUUID().toString().split("-")[0];

				String path = sc.getRealPath("resources/img");

				File saveImg = new File(path + "//" + newName + extension);

				cDTO.getCs_Rfile().transferTo(saveImg);
				cDTO.setCs_file(newName + extension);
				cDTO.setCs_confirm("0");
				cDTO.setCs_confirm_answer("ndy");
			}

			MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
			cDTO.setCs_id(mDTO.getUser_id());

			int j = 1;
			for (int i = 0; i < cDTO.getCaresitter_act().length; i++) {
				j *= cDTO.getCaresitter_act()[i];
			}

			cDTO.setCs_can_do(Integer.toString(j));

			String cs_day = cDTO.getMonday() + "!" + cDTO.getTuesday() + "!" + cDTO.getWednesday() + "!"
					+ cDTO.getThursday() + "!" + cDTO.getFriday() + "!" + cDTO.getSaturday() + "!" + cDTO.getSunday();

			cDTO.setCs_day(cs_day);

			String d_hour = cDTO.getMonday_start() + "!" + cDTO.getMonday_end() + "!" + cDTO.getTuesday_start() + "!"
					+ cDTO.getTuesday_end() + "!" + cDTO.getWednesday_start() + "!" + cDTO.getWednesday_end() + "!"
					+ cDTO.getThursday_start() + "!" + cDTO.getThursday_end() + "!" + cDTO.getFriday_start() + "!"
					+ cDTO.getFriday_end() + "!" + cDTO.getSaturday_start() + "!" + cDTO.getSaturday_end() + "!"
					+ cDTO.getSunday_start() + "!" + cDTO.getSunday_end();
			cDTO.setCs_hour(d_hour);

			/*
			 * int j1 = 1; for (int i1 = 0; i1 < cDTO.getCs_type().length; i1++) { j1 *=
			 * cDTO.getCs_type()[i1]; } cDTO.setCs_can_type(Integer.toString(j1));
			 */

			System.out.println(cDTO);

			if (ss.getMapper(CareMapper.class).updateCareSitter(cDTO) == 1) {

				System.out.println("수정 완료");

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void getAlltaker(HttpServletRequest req, DolbomDTO dolbomDTO, Model m) {
		List<DolbomDTO>dDTOs = ss.getMapper(CareMapper.class).getAllTaker(dolbomDTO);
		
		for (DolbomDTO d : dDTOs) {
			String location[] = d.getD_location().split("!");
			d.setM_addr1(location[0]);
			d.setM_addr2(location[1]);
			d.setM_addr3(location[2]);
			System.out.println(location[0]);
		}
		
		
		m.addAttribute("dolbom",dDTOs);
	}
	public void detailtaker(HttpServletRequest req, DolbomDTO dolbomDTO, Model m) {
		DolbomDTO pp = ss.getMapper(CareMapper.class).detailtaker(dolbomDTO);

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

		pp.setMm(ss.getMapper(CareMapper.class).detailUser2(pp));

		/*
		 * m.addAttribute("reviews", ss.getMapper(PetMapper.class).review(dolbomDTO));
		 * System.out.println(ss.getMapper(PetMapper.class).review(dolbomDTO));
		 */

		m.addAttribute("dolbom", pp);
	}	

	public void regCareDolbom(HttpServletRequest req, DolbomDTO dDTO) {
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
		dDTO.setD_title("ndy");

		System.out.println(dDTO);

		if (ss.getMapper(MomMapper.class).regDolbom(dDTO) == 1) {
			System.out.println("돌보미 등록 완료");
			ss.getMapper(MemberMapper.class).upDCount();
		}
	}
	
	public void updateCareDolbom(HttpServletRequest req, DolbomDTO dDTO) {
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
		dDTO.setD_title("ndy");

		System.out.println(dDTO);
		
//		따로 만드는게 맞지만 다른게 없어서 그냥 하나로 통일...(petmapper에 있는건 좀 안타깝긴 함)
		if (ss.getMapper(PetMapper.class).updateDolbom(dDTO) == 1) {
			System.out.println("돌보미 수정 완료");
		}

	}
}
