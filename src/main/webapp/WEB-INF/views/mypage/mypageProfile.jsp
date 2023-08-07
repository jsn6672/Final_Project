<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 프로필 수정의 전체 컨테이너 -->
		<div class="mpP">
			<!-- 내용 부분 컨테이너 -->
			<div class="mpPDetailContainer">
			<span id="mpPName"><h1>손흥민님, 환영합니다!</h1></span>
				<!-- 프로필 부분 컨테이너 -->
				<div class="mpPProfile">
					<!-- 사진 및 사용 중인 서비스 -->
					<div class="mpPPicAndServ">
						<div id="mpPPicture"></div>
						<div class="mpPService">
							<div class="mpPService-state">
								<!-- <span>현재 모두의 시터를 이렇게 이용하고 계세요!</span>
								<br> -->
								<div class="mpPSitter">모시 사용자 <br>
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
								<div class="mpPSitter">시터사용자 <br>
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
					<div>
						<div class="mpPPWUpdate">
							<div class="mpPPW">
								비밀번호 <br>
								<input class="mpPPWInput" placeholder="변경하실 비밀번호를 입력해 주세요">
							</div>
							<div id="mpPPWSpace"></div>
							<div class="mpPPW">
								비밀번호 확인 <br>
								<input class="mpPPWInput" placeholder="다시 한 번 입력해 주세요.">
							</div>
						</div>
						<div class="mpPAddr">
							주소 <br>
							<input class="mpPInput" placeholder="변경 전 주소">
						</div>
						<div class="mpPAddr">
							연락처 <br>
							<input class="mpPInput" placeholder="변경 전 전화번호">
						</div>
					</div>
					<br>
					<div>
						<button id="mpP-btn">수정하기</button>
					</div>
				</div> <!-- 프로필 부분 컨테이너 끝 -->							
			</div>
		</div> <!-- 프로필 수정의 전체 컨테이너 끝 -->

</body>
</html>