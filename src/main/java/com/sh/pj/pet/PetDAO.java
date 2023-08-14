package com.sh.pj.pet;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.pj.account.DolbomDTO;

@Service
public class PetDAO {

	@Autowired
	private SqlSession ss;

	public void regPetDolbom(HttpServletRequest req, DolbomDTO dDTO) {

//		사진 넣는거 오늘 회의때 회의하기


		String d_day = dDTO.getMonday() + "!" + dDTO.getTuesday() + "!" + dDTO.getWednesday() + "!" + dDTO.getThursday()
				+ "!" + dDTO.getFriday() + "!" + dDTO.getSaturday() + "!" + dDTO.getSunday();
		
		dDTO.setD_day(d_day);
		
		String d_hour = dDTO.getMonday_start() + "!" + dDTO.getMonday_end() + "!" + 
				dDTO.getTuesday_start() + "!" + dDTO.getTuesday_end() + "!" + 
				dDTO.getWednesday_start() + "!" + dDTO.getWednesday_end() + "!" + 
				dDTO.getThursday_start() + "!" + dDTO.getThursday_end() + "!" + 
				dDTO.getFriday_start() + "!" + dDTO.getFriday_end() + "!" + 
				dDTO.getSaturday_start() + "!" + dDTO.getSaturday_end() + "!" + 
				dDTO.getSunday_start() + "!" + dDTO.getSunday_end();
		dDTO.setD_hour(d_hour);
		
		System.out.println(dDTO);
	}

}
