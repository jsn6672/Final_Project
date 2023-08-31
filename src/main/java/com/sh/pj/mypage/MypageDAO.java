package com.sh.pj.mypage;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.channels.Selector;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import com.sh.pj.ReviewDTO;
import com.sh.pj.account.DolbomDTO;
import com.sh.pj.account.MemberDTO;
import com.sh.pj.account.MemberMapper;
import com.sh.pj.care.CareDTO;
import com.sh.pj.care.CareMapper;
import com.sh.pj.care.CareTakerDTO;
import com.sh.pj.mom.MomDTO;
import com.sh.pj.mom.MomMapper;
import com.sh.pj.mom.MomTakerDTO;
import com.sh.pj.pet.PetDTO;
import com.sh.pj.pet.PetMapper;
import com.sh.pj.pet.PetTakerDTO;

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

			System.out.println("수정 직전 확인용 mdto" + mDTO);

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

		List<DolbomDTO> momDTOs = ss.getMapper(MypageMapper.class).getMomDolbomList(mDTO);
		List<DolbomDTO> careDTOs = ss.getMapper(MypageMapper.class).getCareDolbomList(mDTO);
		List<DolbomDTO> petDTOs = ss.getMapper(MypageMapper.class).getPetDolbomList(mDTO);

		req.setAttribute("momDTO", momDTOs);
		req.setAttribute("careDTO", careDTOs);
		req.setAttribute("petDTO", petDTOs);

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

			if ((year * 12) + month >= 36) {
				contractDTO.setAge(year + 1);
				contractDTO.setAgetype("살");
			} else {
				contractDTO.setAge((year * 12) + month + 1);
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
			} else if (contractDTO.getCnt_type() == 2) {
				if (can_do % 2 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 실내놀이");
				}
				if (can_do % 3 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 야외놀이");
				}
				if (can_do % 5 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 밥챙겨주기");
				}
				if (can_do % 7 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 등하원돕기");
				}
				if (can_do % 11 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 영어공부");
				}
				if (can_do % 13 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 한글공부");
				}
				if (can_do % 17 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 대소변");
				}
				if (can_do % 19 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 기타활동");
				}
			} else {
				if (can_do % 2 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 가사활동");
				}
				if (can_do % 3 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 신체활동");
				}
				if (can_do % 5 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 인지활동");
				}
				if (can_do % 7 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 식사");
				}
				if (can_do % 11 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 기저귀케어");
				}
				if (can_do % 13 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 샤워");
				}
				if (can_do % 17 == 0) {
					contractDTO.setCnt_can_do(contractDTO.getCnt_can_do() + " , 말벗");
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
		int mm_date = Integer.parseInt(req.getParameter("mm_date"));
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
		req.setAttribute("money", mm);

		if (ss.getMapper(MypageMapper.class).insertmoney(mm) == 1) {
			System.out.println("거래성공");
			req.setAttribute("result", "성공");

		} else {
			req.setAttribute("result", "실패");
		}
	}

	public void getbuylist(HttpServletRequest req, MoneyDTO mm) {
		List<MoneyDTO> moneyList = ss.getMapper(MypageMapper.class).getbuylist();
		req.setAttribute("moneyList", moneyList);
		System.out.println("이밑에 리스트");
		System.out.println(moneyList);
		System.out.println();
	}

	public void countSitterCont(HttpServletRequest req, ContractDTO cntDTO) {

		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		cntDTO.setCnt_sitter_id(mDTO.getUser_id());

		if (mDTO.getUser_ms_status() == 0 && mDTO.getUser_cs_status() == 0 && mDTO.getUser_ps_status() == 0) {
			req.setAttribute("SitterNotice", "아직 시터 등록을 안하셨습니다 <br> 시터 등록을 하시고 우리의 가족이 되어주세요!!");
		} else {
			if (ss.getMapper(MypageMapper.class).countSitterCont(cntDTO) == 0) {
				req.setAttribute("SitterNotice", "아직 시터가 되어달라는 요청이 없습니다");
			}

		}

	}

	public void countTakerCont(HttpServletRequest req, ContractDTO cntDTO) {

		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");

		if (mDTO.getUser_mt_status() == 0 && mDTO.getUser_ct_status() == 0 && mDTO.getUser_pt_status() == 0) {
			req.setAttribute("TakerNotice", "아직 돌보미 등록을 안하셨습니다 <br> 돌보미 등록을 하시고 시터분들의 가족이 되어주세요!!");
		}

	}

	public void getTakerAllCont(HttpServletRequest req) {

		// 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
		LocalDate now = LocalDate.now();

		// 연도, 월(문자열, 숫자), 일, 일(year 기준), 요일(문자열, 숫자)
		int nowyear = now.getYear();

		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");

		List<DolbomDTO> dDTOs = ss.getMapper(MypageMapper.class).getDolbomList(mDTO);

		ContractDTO cntDTO = new ContractDTO();

		for (DolbomDTO dolbomDTO : dDTOs) {
			cntDTO.setCnt_dolbom_no(Integer.toString(dolbomDTO.getD_no()));

			if (ss.getMapper(MypageMapper.class).countDolbomCont(cntDTO) == 0) {
				dolbomDTO.setCntDTOMessage("아직 돌보미에게 도움을 줄 시터가 신청을 안했습니다");
			} else {

				List<ContractDTO> cntDTOs = ss.getMapper(MypageMapper.class).getAllDolbomCont(cntDTO);

				for (ContractDTO cntDTO2 : cntDTOs) {

					MemberDTO sitterDTO = ss.getMapper(MypageMapper.class).getUserID(cntDTO2);

					cntDTO2.setCnt_memberDTO(sitterDTO);

					int age = nowyear - (Integer.parseInt(sitterDTO.getUser_age()) / 10000) + 1;
					cntDTO2.setAge(age);

					cntDTO2.setCnt_petdto(ss.getMapper(MypageMapper.class).getPetSitter(sitterDTO));

					int can_do = Integer.parseInt(cntDTO2.getCnt_petdto().getPs_can_do());
					cntDTO2.setCnt_can_do("");
					if (cntDTO2.getCnt_type() == 3) {

						if (can_do % 2 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 산책");
						}
						if (can_do % 3 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 목욕");
						}
						if (can_do % 5 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 밥챙겨주기");
						}
						if (can_do % 7 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 호텔링");
						}
						if (can_do % 11 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 배변훈련");
						}
						if (can_do % 13 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 놀이훈련");
						}
						if (can_do % 17 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 사회화훈련");
						}
						if (can_do % 19 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 기타활동");
						}
					} else if (cntDTO2.getCnt_type() == 2) {
						if (can_do % 2 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 실내놀이");
						}
						if (can_do % 3 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 야외놀이");
						}
						if (can_do % 5 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 밥챙겨주기");
						}
						if (can_do % 7 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 등하원돕기");
						}
						if (can_do % 11 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 영어공부");
						}
						if (can_do % 13 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 한글공부");
						}
						if (can_do % 17 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 대소변");
						}
						if (can_do % 19 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 기타활동");
						}
					} else {
						if (can_do % 2 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 가사활동");
						}
						if (can_do % 3 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 신체활동");
						}
						if (can_do % 5 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 인지활동");
						}
						if (can_do % 7 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 식사");
						}
						if (can_do % 11 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 기저귀케어");
						}
						if (can_do % 13 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 샤워");
						}
						if (can_do % 17 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 말벗");
						}
						if (can_do % 19 == 0) {
							cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do() + " , 기타활동");
						}
					}

					cntDTO2.setCnt_can_do(cntDTO2.getCnt_can_do().substring(3));

				}

				dolbomDTO.setCntDTOs(cntDTOs);
				dolbomDTO.setCntDTOMessage("1");
			}

		}

		req.setAttribute("contractTakerInfo", dDTOs);
	}

	public void confirmticket(HttpServletRequest req, MoneyDTO mm) {

		int mm_no = Integer.parseInt(req.getParameter("mm_no"));
		String mm_state = req.getParameter("mm_state");
		String mm_id = req.getParameter("mm_id");

		System.out.println("이밑으로 컨펌티켓");
		System.out.println(mm_no);
		System.out.println(mm_state);
		System.out.println(mm_id);

		mm.setMm_no(mm_no);
		mm.setMm_state(mm_state);
		mm.setMm_id(mm_id);

		/*
		 * if ("1개월".equals(mm_ticket)) { if
		 * (ss.getMapper(MypageMapper.class).confirmdate1(mm) == 1) {
		 * System.out.println("날짜 수정 완료"); if
		 * (ss.getMapper(MypageMapper.class).confirmticket(mm) == 1) {
		 * System.out.println("결제상태 수정 완료"); } else { System.out.println("결제상태 수정 실패");
		 * } } else { System.out.println("날짜 수정 실패"); } }
		 */
		String mm_date = req.getParameter("mm_date");

		if (mm_date != null) {
			int months = Integer.parseInt(mm_date);

			int confirmResult = -1;
			int ticketResult = -1;

			int confirmResultPet = -1;
			int ticketResultPet = -1;

			int confirmResultCare = -1;
			int ticketResultCare = -1;

			switch (months) {
			case 1:
				confirmResult = ss.getMapper(MypageMapper.class).confirmdate1(mm);
				confirmResultPet = ss.getMapper(MypageMapper.class).confirmdatePet1(mm);
				confirmResultCare = ss.getMapper(MypageMapper.class).confirmdateCare1(mm);
				break;
			case 3:
				confirmResult = ss.getMapper(MypageMapper.class).confirmdate3(mm);
				confirmResultPet = ss.getMapper(MypageMapper.class).confirmdatePet3(mm);
				confirmResultCare = ss.getMapper(MypageMapper.class).confirmdateCare3(mm);
				break;
			case 6:
				confirmResult = ss.getMapper(MypageMapper.class).confirmdate6(mm);
				confirmResultPet = ss.getMapper(MypageMapper.class).confirmdatePet6(mm);
				confirmResultCare = ss.getMapper(MypageMapper.class).confirmdateCare6(mm);
				break;
			case 12:
				confirmResult = ss.getMapper(MypageMapper.class).confirmdate12(mm);
				confirmResultPet = ss.getMapper(MypageMapper.class).confirmdatePet12(mm);
				confirmResultCare = ss.getMapper(MypageMapper.class).confirmdateCare12(mm);
				break;
			default:
				break;
			}

			if (confirmResult == 1) {
				System.out.println("이용기간 수정 완료");
				ticketResult = ss.getMapper(MypageMapper.class).confirmticket(mm);
				if (ticketResult == 1) {
					System.out.println("결제상태 수정 완료");
				} else {
					System.out.println("결제상태 수정 실패");
				}
			} else {
				System.out.println("이용기간 수정 실패");
			}
		}

		/*
		 * String mm_start_date = req.getParameter("mm_start_date");
		 * System.out.println(mm_start_date);
		 */

		/*
		 * if(ss.getMapper(MypageMapper.class).startSitter(mm) == 1) {
		 * System.out.println("시터 수정 완"); }
		 */

	}

	public void getListOfPetDolbom(HttpServletRequest req) {
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		// 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
		LocalDate now = LocalDate.now();

		// 연도, 월(문자열, 숫자), 일, 일(year 기준), 요일(문자열, 숫자)
		int nowyear = now.getYear();
		int nowmonthValue = now.getMonthValue();

		List<DolbomDTO> dDTOs = ss.getMapper(MypageMapper.class).getPetDolbomList(mDTO);
		for (DolbomDTO dolbomDTO : dDTOs) {

			int year = nowyear - dolbomDTO.getD_year();
			int month = nowmonthValue - dolbomDTO.getD_month();

			if ((year * 12) + month >= 36) {
				dolbomDTO.setAge(year + 1);
				dolbomDTO.setAgetype("살");
			} else {
				dolbomDTO.setAge((year * 12) + month + 1);
				dolbomDTO.setAgetype("개월");
			}
		}

		req.setAttribute("DolbomList", dDTOs);

	}

	public void getDolbomInfo(HttpServletRequest req, DolbomDTO dDTO) {

		DolbomDTO newdDTO = ss.getMapper(MypageMapper.class).getDolbomInfo(dDTO);

		String[] dolbom_hour = newdDTO.getD_hour().split("!");

		newdDTO.setMonday_start(Integer.parseInt(dolbom_hour[0]));
		newdDTO.setMonday_end(Integer.parseInt(dolbom_hour[1]));
		newdDTO.setTuesday_start(Integer.parseInt(dolbom_hour[2]));
		newdDTO.setTuesday_end(Integer.parseInt(dolbom_hour[3]));
		newdDTO.setWednesday_start(Integer.parseInt(dolbom_hour[4]));
		newdDTO.setWednesday_end(Integer.parseInt(dolbom_hour[5]));
		newdDTO.setThursday_start(Integer.parseInt(dolbom_hour[6]));
		newdDTO.setThursday_end(Integer.parseInt(dolbom_hour[7]));
		newdDTO.setFriday_start(Integer.parseInt(dolbom_hour[8]));
		newdDTO.setFriday_end(Integer.parseInt(dolbom_hour[9]));
		newdDTO.setSaturday_start(Integer.parseInt(dolbom_hour[10]));
		newdDTO.setSaturday_end(Integer.parseInt(dolbom_hour[11]));
		newdDTO.setSunday_start(Integer.parseInt(dolbom_hour[12]));
		newdDTO.setSunday_end(Integer.parseInt(dolbom_hour[13]));

		String[] dolbom_day = newdDTO.getD_day().split("!");

		newdDTO.setMonday(dolbom_day[0]);
		newdDTO.setTuesday(dolbom_day[1]);
		newdDTO.setWednesday(dolbom_day[2]);
		newdDTO.setThursday(dolbom_day[3]);
		newdDTO.setFriday(dolbom_day[4]);
		newdDTO.setSaturday(dolbom_day[5]);
		newdDTO.setSunday(dolbom_day[6]);

		String[] dolbom_addr = newdDTO.getD_location().split("!");
		newdDTO.setM_addr1(dolbom_addr[0]);
		newdDTO.setM_addr2(dolbom_addr[1]);
		newdDTO.setM_addr3(dolbom_addr[2]);

		req.setAttribute("dolbomInfo", newdDTO);
	}

	public void updateCntSitter(HttpServletRequest req, ContractDTO cntDTO) {
		if (ss.getMapper(MypageMapper.class).updateCntSitter(cntDTO) == 1) {
			System.out.println("번호 바뀜2");
		}
	}

	public void updateCntSitterNope(HttpServletRequest req, ContractDTO cntDTO) {
		if (ss.getMapper(MypageMapper.class).updateCntSitterNope(cntDTO) == 1) {
			System.out.println("번호 바뀜0");
		}
	}

	public void updateCntDolbom(HttpServletRequest req, ContractDTO cntDTO) {
		if (ss.getMapper(MypageMapper.class).updateCntDolbom(cntDTO) == 1) {
			System.out.println("번호 바뀜2");
		}
	}

	public void updateCntDolbomNope(HttpServletRequest req, ContractDTO cntDTO) {
		if (ss.getMapper(MypageMapper.class).updateCntDolbomNope(cntDTO) == 1) {
			System.out.println("번호 바뀜0");
		}
	}

	public void getcertiflist(HttpServletRequest req, MoneyDTO mm) {
		List<MoneyDTO> certifList = ss.getMapper(MypageMapper.class).getcertiflist();
		req.setAttribute("certifList", certifList);
		System.out.println("이밑에 인증 리스트");
		System.out.println(certifList);
		System.out.println();

	}

	public void ticketthatihave(HttpServletRequest req, String user_id, MoneyDTO mm, MomDTO mDTO) {
		System.out.println("아이디 확인2222222222");
		System.out.println(user_id);
		List<MoneyDTO> moneyList2 = ss.getMapper(MypageMapper.class).getbuypersonallist(user_id);
		req.setAttribute("moneyList2", moneyList2);
		List<MomDTO> ticketPeriod = ss.getMapper(MypageMapper.class).getperiod(user_id);
		req.setAttribute("ticketPeriod", ticketPeriod);
	}

	public void getListOfMomDolbom(HttpServletRequest req) {
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		// 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
		LocalDate now = LocalDate.now();

		// 연도, 월(문자열, 숫자), 일, 일(year 기준), 요일(문자열, 숫자)
		int nowyear = now.getYear();
		int nowmonthValue = now.getMonthValue();

		List<DolbomDTO> dDTOs = ss.getMapper(MypageMapper.class).getMomDolbomList(mDTO);
		for (DolbomDTO dolbomDTO : dDTOs) {

			int year = nowyear - dolbomDTO.getD_year();
			int month = nowmonthValue - dolbomDTO.getD_month();

			if ((year * 12) + month >= 36) {
				dolbomDTO.setAge(year + 1);
				dolbomDTO.setAgetype("살");
			} else {
				dolbomDTO.setAge((year * 12) + month + 1);
				dolbomDTO.setAgetype("개월");
			}
		}

		req.setAttribute("DolbomList", dDTOs);

	}

	public void getListOfCareDolbom(HttpServletRequest req) {
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		// 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
		LocalDate now = LocalDate.now();

		// 연도, 월(문자열, 숫자), 일, 일(year 기준), 요일(문자열, 숫자)
		int nowyear = now.getYear();
		int nowmonthValue = now.getMonthValue();

		List<DolbomDTO> dDTOs = ss.getMapper(MypageMapper.class).getCareDolbomList(mDTO);
		for (DolbomDTO dolbomDTO : dDTOs) {

			int year = nowyear - dolbomDTO.getD_year();
			int month = nowmonthValue - dolbomDTO.getD_month();

			if ((year * 12) + month >= 36) {
				dolbomDTO.setAge(year + 1);
				dolbomDTO.setAgetype("살");
			} else {
				dolbomDTO.setAge((year * 12) + month + 1);
				dolbomDTO.setAgetype("개월");
			}
		}

		req.setAttribute("DolbomList", dDTOs);

	}

	public void regReview(HttpServletRequest req, ReviewDTO rDTO) {
		System.out.println("REVIEWDTO임" + rDTO);
		if (ss.getMapper(MypageMapper.class).regReview(rDTO) == 1) {
			int a = ss.getMapper(MemberMapper.class).updateReviewStatus(rDTO);
			int category = Integer.parseInt(rDTO.getReview_category());
			if (category == 1) {
				CareDTO c = ss.getMapper(CareMapper.class).getCareSitterPoint(rDTO);
//				기존 평균점수
				BigDecimal point = c.getCs_point();
//				기존 카운트
				int count = c.getCs_count();
//				기존 토탈점수
				BigDecimal totalpoint = point.multiply(BigDecimal.valueOf(count));
//				이번에 리뷰에서 받은 점수
				int newpoint = rDTO.getReview_point();
//				저장해야할 평균점수
				BigDecimal newtotalpoint = totalpoint.add(BigDecimal.valueOf(newpoint))
						.divide(BigDecimal.valueOf(count + 1), 2, RoundingMode.HALF_UP);
				c.setCs_point(newtotalpoint);
				int b = ss.getMapper(CareMapper.class).updateCareSitterPoint(c);
			} else if (category == 2) {
				MomDTO c = ss.getMapper(MomMapper.class).getMomSitterPoint(rDTO);
//				기존 평균점수
				BigDecimal point = c.getMs_point();
//				기존 카운트
				int count = c.getMs_count();
//				기존 토탈점수
				BigDecimal totalpoint = point.multiply(BigDecimal.valueOf(count));
//				이번에 리뷰에서 받은 점수
				int newpoint = rDTO.getReview_point();
//				저장해야할 평균점수
				BigDecimal newtotalpoint = totalpoint.add(BigDecimal.valueOf(newpoint))
						.divide(BigDecimal.valueOf(count + 1), 2, RoundingMode.HALF_UP);
				c.setMs_point(newtotalpoint);
				int b = ss.getMapper(MomMapper.class).updateMomSitterPoint(c);
			} else if(category == 3) {
				System.out.println("여기서는 잘들어왔나 확인용" + rDTO);
				PetDTO c = ss.getMapper(PetMapper.class).getPetSitterPoint(rDTO);
				System.out.println(c);
//				기존 평균점수
				BigDecimal point = c.getPs_point();
//				기존 카운트
				int count = c.getPs_count();
//				기존 토탈점수
				BigDecimal totalpoint = point.multiply(BigDecimal.valueOf(count));
//				이번에 리뷰에서 받은 점수
				int newpoint = rDTO.getReview_point();
//				저장해야할 평균점수
				BigDecimal newtotalpoint = totalpoint.add(BigDecimal.valueOf(newpoint))
						.divide(BigDecimal.valueOf(count + 1), 2, RoundingMode.HALF_UP);
				c.setPs_point(newtotalpoint);
				int b = ss.getMapper(PetMapper.class).updatePetSitterPoint(c);
			}
		}

	}

	public void getAllReview_take(HttpServletRequest req) {
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");

		List<ReviewDTO> rDTO = ss.getMapper(MypageMapper.class).getAllReview(mDTO);

		for (ReviewDTO rr : rDTO) {
			rr.setR_dolbomDTO(ss.getMapper(MypageMapper.class).getDolbomReviewInfo(rr));
		}
		req.setAttribute("review", rDTO);
	}

	public void couponCheck(HttpServletRequest req, String user_id, CouponDTO cp, MomDTO mDTO) {
		List<CouponDTO> couponList = ss.getMapper(MypageMapper.class).couponlist(user_id);
		req.setAttribute("couponList", couponList);
	}

	public void regcoupon(HttpServletRequest req, CouponDTO cp) {
		String cp_date_string = req.getParameter("cp_date");
		int cp_date = Integer.parseInt(cp_date_string);
		int cp_no = Integer.parseInt(req.getParameter("cp_no"));
		String cp_id = req.getParameter("cp_id");
		int cp_used = Integer.parseInt(req.getParameter("cp_used"));

		System.out.println("쿠폰확인용");
		System.out.println(cp_date);
		System.out.println(cp_no);
		System.out.println(cp_id);
		System.out.println(cp_used);

		if (ss.getMapper(MypageMapper.class).usecoupon(cp) == 1) {
			System.out.println("쿠폰 등록 성공");

		} else {
			System.out.println("쿠폰 등록 실패");
		}
	}

	public void msStartToWork(HttpServletRequest req) {
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		if (ss.getMapper(MypageMapper.class).updateMsStatusUp(mDTO) == 1) {
			mDTO.setUser_ms_status(4);
			req.getSession().setAttribute("userInfo", mDTO);
		}
	}
	public void msEndToWork(HttpServletRequest req) {
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		if (ss.getMapper(MypageMapper.class).updateMsStatusDown(mDTO) == 1) {
			mDTO.setUser_ms_status(3);
			req.getSession().setAttribute("userInfo", mDTO);
		}
	}
	public void csStartToWork(HttpServletRequest req) {
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		if (ss.getMapper(MypageMapper.class).updateCsStatusUp(mDTO) == 1) {
			mDTO.setUser_cs_status(4);
			req.getSession().setAttribute("userInfo", mDTO);
		}
	}
	public void csEndToWork(HttpServletRequest req) {
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		if (ss.getMapper(MypageMapper.class).updateCsStatusDown(mDTO) == 1) {
			mDTO.setUser_cs_status(3);
			req.getSession().setAttribute("userInfo", mDTO);
		}
	}
	public void psStartToWork(HttpServletRequest req) {
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		if (ss.getMapper(MypageMapper.class).updatePsStatusUp(mDTO) == 1) {
			mDTO.setUser_ps_status(4);
			req.getSession().setAttribute("userInfo", mDTO);
		}
	}
	public void psEndToWork(HttpServletRequest req) {
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("userInfo");
		if (ss.getMapper(MypageMapper.class).updatePsStatusDown(mDTO) == 1) {
			mDTO.setUser_ps_status(3);
			req.getSession().setAttribute("userInfo", mDTO);
		}
	}



	public void giveCoupon(HttpServletRequest req, CouponDTO cp) {
		String cp_id = req.getParameter("cp_id");
		int cp_date = Integer.parseInt(req.getParameter("cp_date"));
		String cp_txt = req.getParameter("cp_txt");
		System.out.println(cp_id);
		System.out.println(cp_date);
		System.out.println(cp_txt);
		cp.setCp_id(cp_id);
		cp.setCp_date(cp_date);
		cp.setCp_txt(cp_txt);
		
		if (ss.getMapper(MypageMapper.class).givecoupon(cp) == 1) {
			System.out.println("쿠폰 등록 완료");
			req.setAttribute("couponResult", "성공");
		} else {
			req.setAttribute("couponResult", "실패");
			System.out.println("쿠폰 등록 실패");
		}
	}
	
	public void getMSConfirm(HttpServletRequest req) {
		List<MomDTO> msconfirm = ss.getMapper(MypageMapper.class).getmsconfirm();
		
		for (MomDTO mmm : msconfirm) {
			mmm.setMm(ss.getMapper(MypageMapper.class).getMSuserinfo(mmm));
		}
		
		req.setAttribute("msconfirm", msconfirm);
		
	}
	
	public void getPSConfirm(HttpServletRequest req) {
		List<PetDTO> psconfirm = ss.getMapper(MypageMapper.class).getpsconfirm();
		
		for (PetDTO mmm : psconfirm) {
			mmm.setMm(ss.getMapper(MypageMapper.class).getPSuserinfo(mmm));
			System.out.println(mmm);
		}
		
		req.setAttribute("psconfirm", psconfirm);
		
	}

	public void getCSConfirm(HttpServletRequest req) {
		List<CareDTO> csconfirm = ss.getMapper(MypageMapper.class).getcsconfirm();
		for (CareDTO mmm : csconfirm) {
			mmm.setMm(ss.getMapper(MypageMapper.class).getCSuserinfo(mmm));
		}
		req.setAttribute("csconfirm", csconfirm);

	}
	public void getMTConfirm(HttpServletRequest req) {
		List<MomTakerDTO> mtconfirm = ss.getMapper(MypageMapper.class).getmtconfirm();
		
		for (MomTakerDTO mmm : mtconfirm) {
			mmm.setMm(ss.getMapper(MypageMapper.class).getMTuserinfo(mmm));
		}
		
		req.setAttribute("msconfirm", mtconfirm);
		
	}
	
	public void getPTConfirm(HttpServletRequest req) {
		List<PetTakerDTO> ptconfirm = ss.getMapper(MypageMapper.class).getptconfirm();
		
		for (PetTakerDTO mmm : ptconfirm) {
			mmm.setMm(ss.getMapper(MypageMapper.class).getPTuserinfo(mmm));
			System.out.println(mmm);
		}
		
		req.setAttribute("psconfirm", ptconfirm);
		
	}
	
	public void getCTConfirm(HttpServletRequest req) {
		List<CareTakerDTO> ctconfirm = ss.getMapper(MypageMapper.class).getctconfirm();
		for (CareTakerDTO mmm : ctconfirm) {
			mmm.setMm(ss.getMapper(MypageMapper.class).getCTuserinfo(mmm));
		}
		req.setAttribute("csconfirm", ctconfirm);
		
	}

}
