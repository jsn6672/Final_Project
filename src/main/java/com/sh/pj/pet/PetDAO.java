package com.sh.pj.pet;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sh.pj.account.DolbomDTO;
import com.sh.pj.mom.MomMapper;

@Service
public class PetDAO {

	@Autowired
	private SqlSession ss;

	public void regPetDolbom(HttpServletRequest req, DolbomDTO dDTO) {

//		사진 넣는거 오늘 회의때 회의하기

		System.out.println(dDTO);

		String d_day = dDTO.getMonday() + "!" + dDTO.getTuesday() + "!" + dDTO.getWednesday() + "!" + dDTO.getThursday()
				+ "!" + dDTO.getFriday() + "!" + dDTO.getSaturday() + "!" + dDTO.getSunday();

	}
	public void getAll(HttpServletRequest req, PetDTO petDTO, Model m) {
		m.addAttribute("petsitter",ss.getMapper(PetMapper.class).getAll(petDTO));
	}

	public void detail(HttpServletRequest req, PetDTO petDTO, Model m) {
		m.addAttribute("petsitter",ss.getMapper(PetMapper.class).detail(petDTO));

	}


}
