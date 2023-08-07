package com.sh.pj.ask;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sh.pj.account.MemberDTO;


@Service
public class AskDAO {

	@Autowired
	private SqlSession ss;
	

	public void getAllAsk(Model model) {
		
		model.addAttribute("s",ss.getMapper(AskMapper.class).getAllAsk());
	}

	public void insertask(AskDTO aDTO,HttpServletRequest req) {
		
		MemberDTO m = (MemberDTO) req.getSession().getAttribute("userInfo");
		aDTO.setInquiry_id(m.getUser_id());
		aDTO.setInquiry_encoding("secret");
		
		ss.getMapper(AskMapper.class).insertask(aDTO);		
	}

	public void getAskNo(Model model,AskDTO aDTO) {

		model.addAttribute("s",ss.getMapper(AskMapper.class).getaskno(aDTO));
	}

	public void deleteask(AskDTO aDTO) {
		ss.getMapper(AskMapper.class).deleteask(aDTO);
	}


	
}
