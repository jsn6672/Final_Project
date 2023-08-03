package com.sh.pj.ask;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class AskDAO {

	@Autowired
	private SqlSession ss;

	public void getAllAsk(Model model) {
		model.addAttribute("s",ss.getMapper(AskMapper.class).getAllAsk());
	}
	
	
}
