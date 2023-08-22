package com.sh.pj.pet;

import java.io.File;
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

@Service
public class PetDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private ServletContext sc;

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

		if (ss.getMapper(PetMapper.class).regDolbom(dDTO) == 1) {
			System.out.println("돌보미 등록 완료");
		}

	}

	public void getAll(HttpServletRequest req, PetDTO petDTO, Model m) {
		m.addAttribute("petsitter", ss.getMapper(PetMapper.class).getAll(petDTO));
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
		
		m.addAttribute("reviews", ss.getMapper(PetMapper.class).review(petDTO));
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
				mDTO.setPs_id(mDTO.getUser_id());
				req.getSession().setAttribute("userInfo", mDTO);
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

}
