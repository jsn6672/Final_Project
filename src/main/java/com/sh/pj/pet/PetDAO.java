package com.sh.pj.pet;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;


@Service
public class PetDAO {

	@Autowired
	private SqlSession ss;

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

		dDTO.setD_act(Integer.toString(i));
		
		dDTO.setD_location(req.getParameter("m_addr1") + "!" + req.getParameter("m_addr2") + "!"
				+ req.getParameter("m_addr3"));
		
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		dDTO.setD_id(mDTO.getUser_id());
		
		dDTO.setD_sitterage("ndy");
		dDTO.setD_title("ndy");
		
		System.out.println(dDTO);
		
		if(ss.getMapper(PetMapper.class).regDolbom(dDTO) == 1) {
			System.out.println("돌보미 등록 완료");
		}
		
		
		
	}
	public void getAll(HttpServletRequest req, PetDTO petDTO, Model m) {
		m.addAttribute("petsitter",ss.getMapper(PetMapper.class).getAll(petDTO));
	}

	public void detail(HttpServletRequest req, PetDTO petDTO, Model m) {
		m.addAttribute("petsitter",ss.getMapper(PetMapper.class).detail(petDTO));

	}


}
