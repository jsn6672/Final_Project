package com.sh.pj.mom;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sh.pj.account.MemberDTO;
import com.sh.pj.account.MemberMapper;

@Service
public class MomDAO {

	
	@Autowired
	private SqlSession ss;

	@Autowired
	private ServletContext sc;

	public void getAll(HttpServletRequest req, MomDTO momDTO, Model m ) {
		
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		
		momDTO.setMs_id(mDTO.getUser_id());	
		
		m.addAttribute("momsitters", ss.getMapper(MomMapper.class).getAll(momDTO));
		
		
		
	}
	
	
	
}
