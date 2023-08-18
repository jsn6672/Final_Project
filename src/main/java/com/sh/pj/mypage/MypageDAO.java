package com.sh.pj.mypage;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.channels.Selector;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.mail.Session;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;
import com.sh.pj.account.MemberMapper;
import com.sh.pj.mom.MomDTO;

@Service
public class MypageDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private ServletContext sc;

	public void getMember(HttpServletRequest req) {
		req.setAttribute("myMembers", ss.getMapper(MypageMapper.class).getMember());

	}

	public void pwupdate(MemberDTO m, HttpServletRequest req) {
		MemberDTO loginMember = (MemberDTO) req.getSession().getAttribute("loginMember");
		String mpPPWInput = req.getParameter("user_pw");
		System.out.println("PW-----------------------");
		System.out.println(mpPPWInput);
		String mpPPWInputCheck = req.getParameter("mpPPWInputCheck");
		System.out.println("PWC-----------------------");
		System.out.println(mpPPWInputCheck);
		try {
			if (mpPPWInput != null) {
				if (mpPPWInput.equals(mpPPWInputCheck)) {
					m.setUser_pw(mpPPWInput);
					System.out.println("*-----------------------*");
					System.out.println(m.getUser_pw());
					if (ss.getMapper(MypageMapper.class).PWUpdate(m) == 1) {
						System.out.println(ss.getMapper(MypageMapper.class).PWUpdate(m));
						System.out.println("수정완료");
						req.setAttribute("loginfail", "비밀번호가 변경되었습니다<br>다시 로그인해주세요");
						/* req.getSession().setAttribute("userInfo", null); */
					}
				} else {
					System.out.println(ss.getMapper(MypageMapper.class).PWUpdate(m));
					req.setAttribute("wrongMessage", "비밀번호가 일치하지 않습니다.");
				}
			}
		} catch (Exception e) {
			req.setAttribute("wrongMessage", "비밀번호 변경에 실패했습니다.");
			e.printStackTrace();
		}

	}

	public void updateProfile(MemberDTO mDTO, HttpServletRequest req) {

		try {
			String imgOrgName = mDTO.getPic().getOriginalFilename(); // 이미지 원래 이름
			long imgSize = mDTO.getPic().getSize(); // 이미지 사이즈
			
			System.out.println("파일 크기 : " + imgSize);
			
			if (imgSize == 0) {
				mDTO.setUser_pic(req.getParameter("org_pic"));

			} else {
				String extension = imgOrgName.substring(imgOrgName.lastIndexOf("."), imgOrgName.length()); // 원래 이름에서
																											// 확장자만 따오기

				String newName = UUID.randomUUID().toString().split("-")[0]; // 새로운 이름 만들기

				String path = sc.getRealPath("resources/img"); // 이미지 저장할 루트

				File saveImg = new File(path + "//" + newName + extension); // 그래서 java에서 file 인식시키게 하기 (루트 + 새 이름 + 기존에
																			// 따온 확장자)

				mDTO.getPic().transferTo(saveImg); // 실제 업로드 코드
				mDTO.setUser_pic(newName + extension); // db에 넣는 이름
			}

			mDTO.setUser_phone(req.getParameter("phone_first") + "-" + req.getParameter("phone_second") + "-"
					+ req.getParameter("phone_third"));

			mDTO.setUser_location(req.getParameter("m_addr1") + "!" + req.getParameter("m_addr2") + "!"
					+ req.getParameter("m_addr3"));

			System.out.println("수정 직전 확인용 mdto" +  mDTO);

			if (ss.getMapper(MypageMapper.class).updateProfile(mDTO) == 1) {
				System.out.println("프로필 수정 성공");
				req.setAttribute("mypageContentPage", "mypageProfile.jsp");
//				req.getSession().setAttribute("loginMember", mDTO);

				req.getSession().setAttribute("userInfo", ss.getMapper(MypageMapper.class).getMemberById(mDTO));

			} else {
				System.out.println("프로필 수정 실패");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("loginfail", "회원가입이 실패하였습니다<br>왤까요");

		}

	}

	public void mypage(HttpServletRequest req) {
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		String[] addr = mDTO.getUser_location().split("!");
		mDTO.setM_addr1(addr[0]);
		mDTO.setM_addr2(addr[1]);
		mDTO.setM_addr3(addr[2]);
		String phoneNum[] = mDTO.getUser_phone().split("-");
		mDTO.setPhone_first(phoneNum[0]);
		mDTO.setPhone_second(phoneNum[1]);
		mDTO.setPhone_third(phoneNum[2]);

		req.setAttribute("memberProfile", mDTO);

	}

	public void getAll(HttpServletRequest req, ContractDTO cntDTO, Model m) {

		List<ContractDTO> dolbomCnt = ss.getMapper(MypageMapper.class).getAllDolbomCont(cntDTO);
		for (ContractDTO contractDTO : dolbomCnt) {
			contractDTO.setCnt_petdto(ss.getMapper(MypageMapper.class).getPetDTO(contractDTO));
		}
		req.setAttribute("contractDolbomInfo", dolbomCnt);
		
		
		
		
		
	}

	public void getSitterAllCont(HttpServletRequest req, ContractDTO cntDTO) {
		
//		시터로서 테이커에게 받을 경우
		
		 // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
        LocalDate now = LocalDate.now();
 
        // 연도, 월(문자열, 숫자), 일, 일(year 기준), 요일(문자열, 숫자)
        int nowyear = now.getYear();
        int nowmonthValue = now.getMonthValue();
		
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		cntDTO.setCnt_sitter_id(mDTO.getUser_id());
		System.out.println("1" + cntDTO);
		
		List<ContractDTO> sitterCnt = ss.getMapper(MypageMapper.class).getAllSitterCont(cntDTO);
		System.out.println("2" + sitterCnt);
		for (ContractDTO contractDTO : sitterCnt) {
			contractDTO.setCnt_dolbomdto(ss.getMapper(MypageMapper.class).getDolbomDTO(contractDTO));
			
			DolbomDTO dDTO = contractDTO.getCnt_dolbomdto();
			
			contractDTO.setCnt_memberDTO(ss.getMapper(MypageMapper.class).getTakerDTO(dDTO));
			
			int year = nowyear - dDTO.getD_year();
			int month = nowmonthValue - dDTO.getD_month();
			
			if ((year*12)+month >= 36) {
				contractDTO.setAge(year+1);
				contractDTO.setAgetype("살");
			} else {
				contractDTO.setAge((year*12)+month+1);
				contractDTO.setAgetype("개월");
			}
			
			int can_do = Integer.parseInt(dDTO.getD_can_do());
			contractDTO.setCnt_can_do(""); 
			if (contractDTO.getCnt_type() == 3) {
				
				if (can_do % 2 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 산책");
				}
				if (can_do % 3 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 목욕");
				}
				if (can_do % 5 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 밥챙겨주기");
				}
				if (can_do % 7 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 호텔링");
				}
				if (can_do % 11 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 배변훈련");
				}
				if (can_do % 13 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 놀이훈련");
				}
				if (can_do % 17 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 사회화훈련");
				}
				if (can_do % 19 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 기타활동");
				}
			}
			
			contractDTO.setCnt_can_do(contractDTO.getCnt_can_do().substring(3));
			
		}
		
		req.setAttribute("contractSitterInfo", sitterCnt);
		
	}

	public void insertmoney(HttpServletRequest req, MoneyDTO mm) {
		
		String mm_id = req.getParameter("mm_id");
		String mm_name = req.getParameter("mm_name");
		Date mm_date = new Date();
		String mm_ticket = req.getParameter("mm_ticket");
		int mm_price = Integer.parseInt(req.getParameter("mm_price"));
		String mm_state = req.getParameter("mm_state");
		/* System.out.println(mm_id) */;
		
		mm.setMm_id(mm_id);
		mm.setMm_name(mm_name);
		mm.setMm_date(mm_date);
		mm.setMm_ticket(mm_ticket);
		mm.setMm_price(mm_price);
		mm.setMm_state(mm_state);
		System.out.println("---*---*---*");
		System.out.println(mm.toString());
		req.setAttribute("money", mm);
		
		if (ss.getMapper(MypageMapper.class).insertmoney(mm) == 1) {
			System.out.println("거래성공");
			req.setAttribute("result", "성공");

		
		} else {
			req.setAttribute("result", "실패");
		}
	}

	public void getbuylist(HttpServletRequest req, MoneyDTO mm) {
		List<MoneyDTO> moneyList =  ss.getMapper(MypageMapper.class).getbuylist();
		req.setAttribute("moneyList", moneyList);
		System.out.println("이밑에 리스트");
		System.out.println(moneyList);
		System.out.println();
	}

	
	
	
	

}
