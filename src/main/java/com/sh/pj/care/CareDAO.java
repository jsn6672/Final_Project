package com.sh.pj.care;

import java.io.File;
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
import com.sh.pj.pet.PetMapper;


@Service
public class CareDAO {
	
	@Autowired
	private SqlSession ss;


	@Autowired
	private ServletContext sc;
	
	public void getAll(HttpServletRequest req, Model m, CareDTO cDTO) {
		m.addAttribute("caresitter",ss.getMapper(CareMapper.class).getAll(cDTO));
		System.out.println(cDTO);
	
	}
	public void detail(HttpServletRequest req, CareDTO cDTO, Model m) {
		m.addAttribute("caretaker",ss.getMapper(CareMapper.class).detail(cDTO));
		
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

		if (dDTO.getD_check()==null) {
			dDTO.setD_check("0");
		}else {
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

			if (ss.getMapper(CareMapper.class).regCareSitter(cDTO) == 1 ){

				System.out.println("등록 완료");
				ss.getMapper(CareMapper.class).changecsstatus(mDTO);
				mDTO.setUser_cs_status(1);
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

			if (ss.getMapper(CareMapper.class).updateCareSitter(cDTO) == 1 ){

				System.out.println("수정 완료");
				
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}
}
