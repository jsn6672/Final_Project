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

	private int allMsgCountMain; // 공지전체개수
	private int allMsgCountMany; // 자주묻는질문전체개수
	private int allMsgCountQandA; // 문의전체개수

	public int getAllMsgCountMain() {
		return allMsgCountMain;
	}

	public void setAllMsgCountMain(int allMsgCountMain) {
		this.allMsgCountMain = allMsgCountMain;
	}

	public int getAllMsgCountMany() {
		return allMsgCountMany;
	}

	public void setAllMsgCountMany(int allMsgCountMany) {
		this.allMsgCountMany = allMsgCountMany;
	}

	public int getAllMsgCountQandA() {
		return allMsgCountQandA;
	}

	public void setAllMsgCountQandA(int allMsgCountQandA) {
		this.allMsgCountQandA = allMsgCountQandA;
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

	public void calcAllMsgCountmain() {
		AskSelector sSel = new AskSelector("", null, null, "1");
		allMsgCountMain = ss.getMapper(AskMapper.class).getMsgCount(sSel);
	}

	public void calcAllMsgCountmany() {
		AskSelector sSel = new AskSelector("", null, null, "2");
		allMsgCountMany = ss.getMapper(AskMapper.class).getMsgCount(sSel);
	}

	public void calcAllMsgCountqanda() {
		AskSelector sSel = new AskSelector("", null, null, "3");
		allMsgCountQandA = ss.getMapper(AskMapper.class).getMsgCount(sSel);
	}

	public void getMsg(int pageNo, HttpServletRequest req) {
		int count = so.getSnsCountPerPage();
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);

		AskSelector askSearch = (AskSelector) req.getSession().getAttribute("asksearch");
		int msgCount = 1;
		System.out.println("세션 asksearch = " + askSearch);

		if (askSearch != null) {
			askSearch.setA_start(new BigDecimal(start));
			askSearch.setA_end(new BigDecimal(end));
			askSearch.setCategory(req.getParameter("category"));
			msgCount = ss.getMapper(AskMapper.class).getMsgCount(askSearch);
		} else {
			// 검색 조건이 없는 경우에 전체 데이터 수를 가져오도록 변경
			String category = req.getParameter("category");
			askSearch = new AskSelector("", new BigDecimal(start), new BigDecimal(end), category);
			
			msgCount = allMsgCountQandA;
						
			if (category.equals("1")) {
				msgCount = allMsgCountMain;				
			} else if (category.equals("2")) {
				msgCount = allMsgCountMany;								
			}
			
		}

//		aDTO.setInquiry_category(req.getParameter("inquiry_category"));
		System.out.println("asksearch = " + askSearch);
		try {
			List<AskDTO> resultList = ss.getMapper(AskMapper.class).getMsg(askSearch);
			req.setAttribute("s", resultList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("여기까지 나오나 쳌");

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
