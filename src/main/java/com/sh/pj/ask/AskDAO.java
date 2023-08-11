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
	private SiteOption so; // 한페이지에 몇개씩 보여줄지.

	private int allMsgCount; // 전체개수

	public int getAllMsgCount() {
		return allMsgCount;
	}

	public void setAllMsgCount(int allMsgCount) {
		this.allMsgCount = allMsgCount;
	}

	public void getAllAsk(Model model) {

		model.addAttribute("s", ss.getMapper(AskMapper.class).getAllAsk());
	}

	public void insertask(AskDTO aDTO, HttpServletRequest req) {

		MemberDTO m = (MemberDTO) req.getSession().getAttribute("userInfo");
		aDTO.setInquiry_id(m.getUser_id());
//		if (req.getParameter("inquiry_category").equals("공지사항")) {
//			aDTO.setInquiry_category("1");
//		} else if (req.getParameter("inquiry_category").equals("자주묻는질문")) {
//			aDTO.setInquiry_category("2");
//		} else {
//			aDTO.setInquiry_category("3");
//		}

		aDTO.setInquiry_encoding("미답변");

		ss.getMapper(AskMapper.class).insertask(aDTO);
	}

	public void getAskNo(Model model, AskDTO aDTO) {

		model.addAttribute("s", ss.getMapper(AskMapper.class).getaskno(aDTO));
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

	public void calcAllMsgCount() {
		AskSelector sSel = new AskSelector("", null, null);
		allMsgCount = ss.getMapper(AskMapper.class).getMsgCount(sSel);
	}

	public void getMsg(int pageNo, HttpServletRequest req) {
		int count = so.getSnsCountPerPage();
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);

		AskSelector askSearch = (AskSelector) req.getSession().getAttribute("asksearch");
		int msgCount = 1;

		if (askSearch != null) {
			askSearch.setA_start(new BigDecimal(start));
			askSearch.setA_end(new BigDecimal(end));
			msgCount = ss.getMapper(AskMapper.class).getMsgCount(askSearch);
		} else {
			// 검색 조건이 없는 경우에 전체 데이터 수를 가져오도록 변경
			askSearch = new AskSelector("", new BigDecimal(start), new BigDecimal(end)); // 이전에 구현한 메서드로 전체 데이터 수를 계산
			msgCount = allMsgCount;
		}

		List<AskDTO> resultList = ss.getMapper(AskMapper.class).getMsg(askSearch);
		req.setAttribute("s", resultList);

		int pageCount = (int) Math.ceil(msgCount / (double) count);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("curPage", pageNo);

		int numPagesToShow = 5;
		int startPage = Math.max(1, pageNo - numPagesToShow / 2);
		int endPage = Math.min(pageCount, startPage + numPagesToShow - 1);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
	}

}
