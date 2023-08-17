<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <!-- 프로필 수정의 전체 컨테이너 -->
    <div class="mpP">
      <form
        action="mypage.profile.do"
        method="post"
        enctype="multipart/form-data"
      >
        <!-- 내용 부분 컨테이너 -->
        <div class="mpPDetailContainer">
          <div class="mpPWelcomeSpace">
            <br />
          </div>
          <div class="mpPWelcome">
            ${sessionScope.userInfo.user_name }님,환영합니다!
          </div>
          <!-- 프로필 부분 컨테이너 -->
          <div class="mpPProfile">
            <!-- 사진 및 사용 중인 서비스 -->
            <div class="mpPPicAndServ">
              <div class="mpPPicture">
                <img
                  id="mpPPicture"
                  alt=""
                  src="resources/img/${sessionScope.userInfo.user_pic  } "
                />
                <input class="mpPInputPic" type="file" name="pic" />
                <input
                  hidden="hidden"
                  name="org_pic"
                  value="${memberProfile.user_pic }"
                />
              </div>
              <div class="mpPService">
                <span>현재 모두의 시터를 이렇게 이용하고 계세요!</span> <br />
                <div class="mpPService-state">
                  <div class="mpPSitter">
                    <!-- 모시 사용자 <br> -->
                    <div class="mpPSitter-part">
                      <div class="mpPSitter-part-name">맘시터</div>
                      <div class="mpPSitter-part-state">이용상황</div>
                    </div>
                    <div class="mpPSitter-part">
                      <div class="mpPSitter-part-name">케어시터</div>
                      <div class="mpPSitter-part-state">이용상황</div>
                    </div>
                    <div class="mpPSitter-part">
                      <div class="mpPSitter-part-name">펫시터</div>
                      <div class="mpPSitter-part-state">이용상황</div>
                    </div>
                  </div>
                  <div class="mpPSitter">
                    <!-- 시터사용자 <br> -->
                    <div class="mpPSitter-part">
                      <div class="mpPSitter-part-name">맘시터</div>
                      <div class="mpPSitter-part-state">이용상황</div>
                    </div>
                    <div class="mpPSitter-part">
                      <div class="mpPSitter-part-name">케어시터</div>
                      <div class="mpPSitter-part-state">이용상황</div>
                    </div>
                    <div class="mpPSitter-part">
                      <div class="mpPSitter-part-name">펫시터</div>
                      <div class="mpPSitter-part-state">이용상황</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- 정보 -->
            <div class="mpP-info">
              <!-- <div class="mpPPWUpdate">
						<div class="mpPPW">
							비밀번호 <br> <input class="mpPPWInput"
								placeholder="변경하실 비밀번호를 입력해 주세요">
						</div>
						<div id="mpPPWSpace"></div>
						<div class="mpPPW">
							비밀번호 확인 <br> <input class="mpPPWInput"
								placeholder="다시 한 번 입력해 주세요.">
						</div>
					</div> -->

              <button id="openModalBtn" type="button">비밀번호 수정</button>

              <input
                name="user_id"
                type="hidden"
                value="${sessionScope.userInfo.user_id}"
              />
              <!-- 	<div id="mpPPicInput">
							<input name="user_pic" type="file">
						</div> -->
              <div class="mpPAddr">
                <div class="mpPAddr-span">주소</br></div>
                <input
                  id="jm_addr3Input"
                  readonly="readonly"
                  name="m_addr3"
                  class="normal_input"
                  maxlength="5"
                  autocomplete="off"
                  style="width: 620px"
                  placeholder="우편번호"
                  value="${memberProfile.m_addr3 }"
                />
                <span id="addrSearchBtn">[검색]</span><br />
                <br />
                <input
                  id="jm_addr1Input"
                  readonly="readonly"
                  name="m_addr1"
                  maxlength="30"
                  autocomplete="off"
                  placeholder="주소"
                  value="${memberProfile.m_addr1 }"
                  class="normal_input"
                /><br />
                <br />
                <input
                  name="m_addr2"
                  maxlength="30"
                  autocomplete="off"
                  class="normal_input"
                  placeholder="상세주소"
                  id="jm_addr2Input"
                  value="${memberProfile.m_addr2 }"
                />
              </div>
              <div class="mpPAddr">
                <div class="mpPAddr-span">연락처</br></div>
                <input
                  name="phone_first"
                  class="user_phone"
                  placeholder="전화번호를 입력해주세요"
                  value="${memberProfile.phone_first }"
                  
                />
                -
                <input
                  name="phone_second"
                  class="user_phone"
                  placeholder="전화번호를 입력해주세요"
                  value="${memberProfile.phone_second }"
                  
                />
                -
                <input
                  name="phone_third"
                  class="user_phone"
                  placeholder="전화번호를 입력해주세요"
                  value="${memberProfile.phone_third }"
                  
                />
              </div>
              <br />
              <div>
                <button id="mpP-btn">수정하기</button>
              </div>
              <!-- 프로필 부분 컨테이너 끝 -->
            </div>
          </div>
          <!-- 프로필 수정의 전체 컨테이너 끝 -->
        </div>
      </form>
    </div>
    <div id="myModal" class="modal">
      <div class="modal-content">
        <span class="close">&times;</span>
        <form action="mypage.pw.do">
          <div class="mpPPWUpdate">
            <div class="mpPPWFail">${wrongMessage }</div>
            <input
              name="user_id"
              type="hidden"
              value="${sessionScope.userInfo.user_id }"
              
            />
            <div class="mpPPW">
              비밀번호 <br />
              <input
                name="user_pw"
                class="mpPPWInput"
                placeholder="변경하실 비밀번호를 입력해 주세요"
              />
            </div>
            <div id="mpPPWSpace"></div>
            <div class="mpPPW">
              비밀번호 확인 <br />
              <input
                name="mpPPWInputCheck"
                class="mpPPWInputCheck"
                placeholder="다시 한 번 입력해 주세요."
              />
            </div>
          </div>
          <button id="mpP-btn">수정하기</button>
        </form>
      </div>
    </div>
  </body>
</html>
