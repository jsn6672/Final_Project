package com.sh.pj.care;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


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

	
}
