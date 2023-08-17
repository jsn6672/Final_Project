package com.sh.pj.mypage;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.channels.Selector;
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

	public void getAll(HttpServletRequest req, MomDTO momDTO, Model m) {
		//for문
		
		/*
		 * m.addAttribute("getall",ss.getMapper(MypageMapper.class).getAllmom(momDTO));
		 * 
		 * 
		 * m.addAttribute("getallsi",ss.getMapper(MypageMapper.class).getAllmom(accDTO);
		 * );
		 * m.addAttribute("getall",ss.getMapper(MypageMapper.class).getAllmom(accDTO););
		 */
		
	}

}
