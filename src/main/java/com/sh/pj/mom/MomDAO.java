package com.sh.pj.mom;

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
import com.sh.pj.pet.PetDTO;
import com.sh.pj.pet.PetMapper;

@Service
public class MomDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private ServletContext sc;

	public void getAll(HttpServletRequest req, MomDTO momDTO, Model m) {

		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");

		m.addAttribute("momsitters", ss.getMapper(MomMapper.class).getAll(momDTO));
	}

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

		m.addAttribute("petsitter", mm);

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

		if (ss.getMapper(MomMapper.class).regDolbom(dDTO) == 1) {
			System.out.println("돌보미 등록 완료");
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
			mDTO.setMs_id(mDTO.getUser_id());

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
				mDTO.setMs_id(mDTO.getUser_id());
				req.getSession().setAttribute("userInfo", momDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void deteteMomsitter(HttpServletRequest req, MomDTO mDTO, Model model) {
		if(ss.getMapper(MomMapper.class).deleteMomsitter(mDTO) == 1) {
			System.out.println("삭제 성공!");
			req.setAttribute("deletecheck", "1");
		}
		
	}
	}


