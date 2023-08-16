package com.sh.pj.account;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sh.pj.pet.PetTakerDTO;

@Service
public class MembertDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private ServletContext sc;

	@Autowired
	private JavaMailSenderImpl mailSender;

	public void login(HttpServletRequest req, MemberDTO mDTO) {

		MemberDTO dbAccount = ss.getMapper(MemberMapper.class).getUserID(mDTO);

		System.out.println(dbAccount);

		if (dbAccount != null) {
			if (dbAccount.getUser_pw().equals(mDTO.getUser_pw())) {
				req.getSession().setAttribute("userInfo", dbAccount);
			} else {
				req.setAttribute("loginfail", "이런! ID나 비밀번호가 틀렸습니다 <br> 다시 입력해주세요");
			}
		} else {
			req.setAttribute("loginfail", "이런! ID나 비밀번호가 틀렸습니다 <br> 다시 입력해주세요");
		}
	}

	public void logincheck(HttpServletRequest req) {

		MemberDTO a = (MemberDTO) req.getSession().getAttribute("userInfo");

		System.out.println(a);

		if (a != null) {
			req.setAttribute("loginPage", "loginok.jsp");
		} else {
			req.setAttribute("loginPage", "login.jsp");
		}

	}

	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("userInfo", null);
	}

	public void regAccount(HttpServletRequest req, MemberDTO mDTO) {
		try {
			String imgOrgName = mDTO.getPic().getOriginalFilename(); // 이미지 원래 이름
			long imgSize = mDTO.getPic().getSize(); //이미지 사이즈

			if (imgSize == 0) {
//				mDTO.setUser_pic(req.getParameter("org_pic"));
				mDTO.setUser_pic("anonymousicon.png");
			} else {
				String extension = imgOrgName.substring(imgOrgName.lastIndexOf("."), imgOrgName.length()); //원래 이름에서 확장자만 따오기

				String newName = UUID.randomUUID().toString().split("-")[0]; //새로운 이름 만들기

				String path = sc.getRealPath("resources/img"); // 이미지 저장할 루트

				File saveImg = new File(path + "//" + newName + extension); //그래서 java에서 file 인식시키게 하기 (루트 + 새 이름 + 기존에 따온 확장자)

				mDTO.getPic().transferTo(saveImg); // 실제 업로드 코드
				mDTO.setUser_pic(newName + extension); //db에 넣는 이름
			}

			mDTO.setUser_email_auth("1");

			mDTO.setUser_phone(req.getParameter("phone_first") + "-" + req.getParameter("phone_second") + "-"
					+ req.getParameter("phone_third"));

			mDTO.setUser_location(req.getParameter("m_addr1") + "!" + req.getParameter("m_addr2") + "!"
					+ req.getParameter("m_addr3"));

			System.out.println(mDTO);

			if (ss.getMapper(MemberMapper.class).regAccount(mDTO) == 1) {

				System.out.println("등록 완료");
				req.setAttribute("loginfail", "회원가입이 완료되었습니다<br>다시 로그인해주세요");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("loginfail", "회원가입이 실패하였습니다<br>왤까요");

		}

	}

	public int emailcheck(HttpServletRequest req, MemberDTO mDTO) {

		return ss.getMapper(MemberMapper.class).checkEmail(mDTO);
	}

	public void pwchangego(HttpServletRequest req, MemberDTO mDTO) {

		req.setAttribute("info", ss.getMapper(MemberMapper.class).getUserEMail(mDTO));

	}

	public void pwchangedo(HttpServletRequest req, MemberDTO mDTO) {

		if (ss.getMapper(MemberMapper.class).updateUserPW(mDTO) == 1) {
			System.out.println("수정 완료");
			req.setAttribute("loginfail", "비밀번호가 변경되었습니다<br>다시 로그인해주세요");
		}
	}

	public int idcheck(HttpServletRequest req, MemberDTO mDTO) {

		return ss.getMapper(MemberMapper.class).checkid(mDTO);
	}

	public int emailusercheck(HttpServletRequest req, MemberDTO mDTO) {

		return ss.getMapper(MemberMapper.class).checkuserEMail(mDTO);
	}

	public String sendEmail(String user_email) {

		System.out.println("이메일 확인" + user_email);
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;

		/* 이메일 보내기 */
		String setFrom = "sold802sbt7@gmail.com";
		String toMail = user_email;
		String title = "회원가입 인증 이메일 입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 " + checkNum + "입니다." + "<br>"
				+ "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";

		try {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(Integer.toString(checkNum));
		return Integer.toString(checkNum);
	}

	public void regPetTaker(HttpServletRequest req, PetTakerDTO ptDTO) {

		try {
			String imgOrgName = ptDTO.getPt_Rfile().getOriginalFilename();
			long imgSize = ptDTO.getPt_Rfile().getSize();

			String extension = imgOrgName.substring(imgOrgName.lastIndexOf("."), imgOrgName.length());

			String newName = UUID.randomUUID().toString().split("-")[0];

			String path = sc.getRealPath("resources/img");

			File saveImg = new File(path + "//" + newName + extension);

			ptDTO.getPt_Rfile().transferTo(saveImg);
			ptDTO.setPt_file(newName + extension);
			
			MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
			ptDTO.setPt_id(mDTO.getUser_id());
			System.out.println(ptDTO);

			if (ss.getMapper(MemberMapper.class).regPTAccount(ptDTO) == 1) {

				System.out.println("등록 완료");
				mDTO.setPt_id(mDTO.getUser_id());
				req.getSession().setAttribute("userInfo", mDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
