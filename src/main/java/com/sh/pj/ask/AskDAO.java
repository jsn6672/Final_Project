package com.sh.pj.ask;

import java.math.BigDecimal;
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

	@Autowired
	private SiteOption so;	//한페이지에 몇개씩 보여줄지.
	
	private int allMsgCount; //전체개수

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



	public void updateask(AskDTO aDTO) {
		ss.getMapper(AskMapper.class).upadteask(aDTO);
		
	}



	public void searchask(Model model, AskDTO aDTO) {
		model.addAttribute("s", ss.getMapper(AskMapper.class).searchask(aDTO));
		
	}

	public void getMsg(int pageNo, HttpServletRequest req) {
        int count = so.getSnsCountPerPage();
        int start = (pageNo - 1) * count + 1;
        int end = start + (count - 1);

        AskSelector search = (AskSelector) req.getSession().getAttribute("search"); //SNSSelector bean
        int msgCount = 0;

        if (search == null) {
            search = new AskSelector("", new BigDecimal(start), new BigDecimal(end));
            msgCount = allMsgCount;
        } else {
            search.setStart(new BigDecimal(start));
            search.setEnd(new BigDecimal(end));
            msgCount = ss.getMapper(AskMapper.class).getMsgCount(search);
        }


        int pageCount = (int) Math.ceil(msgCount / (double) count);
        System.out.println(pageCount);
        req.setAttribute("pageCount", pageCount);

        req.setAttribute("curPage", pageNo);

    }

}
