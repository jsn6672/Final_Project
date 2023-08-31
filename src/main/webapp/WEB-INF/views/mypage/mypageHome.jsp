<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	$(
			function() {

				$("#dolbomPet").click(function() {
					console.log("aa");
					$("#dolbomPetModal").css("display", "flex");
				});

				$("#dolbomPetModal").click(function() {
					$("#dolbomPetModal").css("display", "none");
				})
				$("#dolbomCare").click(function() {
					console.log("aa");
					$("#dolbomCareModal").css("display", "flex");
				});

				$("#dolbomCareModal").click(function() {
					$("#dolbomCareModal").css("display", "none");
				})
				$("#dolbomMom").click(function() {
					console.log("aa");
					$("#dolbomMomModal").css("display", "flex");
				});

				$("#dolbomMomModal").click(function() {
					$("#dolbomMomModal").css("display", "none");
				})

				// 여기서부터 아래 코드를 추가합니다.
				var petbuttons = document.querySelectorAll(".petDolbomButton");
				petbuttons.forEach(function(button) {
					var statusInput = button.closest(".pet-info")
							.querySelector(".petDolbomStatus");
					console.log(statusInput.value);
					if (statusInput.value === "on") {
						button.innerHTML = "on"; // 버튼 텍스트 변경
					} else if (statusInput.value === "off") {
						button.innerHTML = "off"; // 버튼 텍스트 변경
					}
					button.addEventListener("click", function(event) {
						event.preventDefault();
						toggleStatus(statusInput, button);
					});
				});
				// 여기서부터 아래 코드를 추가합니다.
				var Carebuttons = document
						.querySelectorAll(".careDolbomButton");
				Carebuttons.forEach(function(button) {
					var statusInput = button.closest(".care-info")
							.querySelector(".careDolbomStatus");
					console.log(statusInput.value);
					if (statusInput.value === "on") {
						button.innerHTML = "on"; // 버튼 텍스트 변경
					} else if (statusInput.value === "off") {
						button.innerHTML = "off"; // 버튼 텍스트 변경
					}
					button.addEventListener("click", function(event) {
						event.preventDefault();
						toggleStatus(statusInput, button);
					});
				});
				// 여기서부터 아래 코드를 추가합니다.
				var mombuttons = document.querySelectorAll(".momDolbomButton");
				mombuttons.forEach(function(button) {
					var statusInput = button.closest(".mom-info")
							.querySelector(".momDolbomStatus");
					console.log(statusInput.value);
					if (statusInput.value === "on") {
						button.innerHTML = "on"; // 버튼 텍스트 변경
					} else if (statusInput.value === "off") {
						button.innerHTML = "off"; // 버튼 텍스트 변경
					}
					button.addEventListener("click", function(event) {
						event.preventDefault();
						toggleStatus(statusInput, button);
					});
				});

				function toggleStatus(statusInput, button) {
					var buttonText = button.innerHTML; // 현재 버튼의 내용

					if (statusInput.value === "on") {
						statusInput.value = "off";
						button.innerHTML = "on"; // 버튼 텍스트 변경
					} else if (statusInput.value === "off") {
						statusInput.value = "on";
						button.innerHTML = "off"; // 버튼 텍스트 변경
					}

					var form = statusInput.closest("form");
					form.submit();
				}

			})
</script>
<style type="text/css">
#dolbomPetModalContents {
	width: 400px;
	height: 600px;
	background: #fff;
	border-radius: 10px;
	position: relative;
	top: 20%;
	left: 50%;
	margin-top: -100px;
	margin-left: -200px;
	text-align: center;
	box-sizing: border-box;
	padding: 10px 0;
	line-height: 23px;
	cursor: pointer;
	background: #fff;
}

#dolbomCareModalContents {
	width: 400px;
	height: 600px;
	background: #fff;
	border-radius: 10px;
	position: relative;
	top: 20%;
	left: 50%;
	margin-top: -100px;
	margin-left: -200px;
	text-align: center;
	box-sizing: border-box;
	padding: 10px 0;
	line-height: 23px;
	cursor: pointer;
	background: #fff;
}

#dolbomMomModalContents {
	width: 400px;
	height: 600px;
	background: #fff;
	border-radius: 10px;
	position: relative;
	top: 20%;
	left: 50%;
	margin-top: -100px;
	margin-left: -200px;
	text-align: center;
	box-sizing: border-box;
	padding: 10px 0;
	line-height: 23px;
	cursor: pointer;
	background: #fff;
}
</style>
</head>
<body>
	<!-- 프로필 수정의 전체 컨테이너 -->
	<div class="mpP">
		<!-- 내용 부분 컨테이너 -->
		<div class="mpPDetailContainer">
			<div class="mpPWelcomeSpace">
				<br />
			</div>
			<div class="mpPWelcome">${memberProfile.user_name }님,환영합니다!</div>
			<!-- 프로필 부분 컨테이너 -->
			<div class="mpPProfile">
				<!-- 사진 및 사용 중인 서비스 -->
				<div class="mpPPicAndServ">
					<div class="mpPPicture">
						<img id="mpPPicture" alt=""
							src="resources/img/${sessionScope.userInfo.user_pic  } " />
					</div>
					<div class="mpPService">
						<span>현재 모두의 시터를 이렇게 이용하고 계세요!</span> <br />
						<div class="mpPService-state">
							<div class="mpPSitter">
								<!-- 모시 사용자 <br> -->
								<div class="mpPSitter-part">
									<div class="mpPSitter-part-name">맘시터&nbsp</div>
									<c:if test="${userInfo.user_ms_status eq 0 }">
										<div class="mpPSitter-part-state"
											style="background-color: #EEEEEE">
											<span onclick="location.href='mypage.sitterRegMom.go'">&nbsp&nbsp미등록&nbsp&nbsp</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_ms_status eq 1 }">
										<div class="mpPSitter-part-state"
											style="background-color: #EEEEEE">
											<span onclick="location.href='mypage.ticket.do'">이용권구매필요</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_ms_status eq 2 }">
										<div class="mpPSitter-part-state"
											style="background-color: #D9D9D9">
											<span>인증대기</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_ms_status eq 3 }">
										<div class="mpPSitter-part-state"
											style="background-color: #D9D9D9">
											<span onclick="location.href='ms.start.work'">인증완료(공고x)</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_ms_status eq 4 }">
										<div class="mpPSitter-part-state">
											<span onclick="location.href='ms.end.work'">공고중</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_ms_status eq 5 }">
										<div class="mpPSitter-part-state">
											<span>구직완료</span>
										</div>
									</c:if>
								</div>
								<div class="mpPSitter-part">
									<div class="mpPSitter-part-name">케어시터</div>
									<c:if test="${userInfo.user_cs_status eq 0 }">
										<div class="mpPSitter-part-state"
											style="background-color: #EEEEEE">
											<span onclick="location.href='mypage.sitterRegCare.go'">&nbsp&nbsp미등록&nbsp&nbsp</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_cs_status eq 1 }">
										<div class="mpPSitter-part-state"
											style="background-color: #EEEEEE">
											<span onclick="location.href='mypage.ticket.do'">이용권구매필요</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_cs_status eq 2 }">
										<div class="mpPSitter-part-state"
											style="background-color: #D9D9D9">
											<span>인증대기</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_cs_status eq 3 }">
										<div class="mpPSitter-part-state"
											style="background-color: #D9D9D9">
											<span onclick="location.href='cs.start.work'">인증완료(공고x)</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_cs_status eq 4 }">
										<div class="mpPSitter-part-state">
											<span onclick="location.href='cs.end.work'">공고중</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_cs_status eq 5 }">
										<div class="mpPSitter-part-state">
											<span>구직완료</span>
										</div>
									</c:if>
								</div>
								<div class="mpPSitter-part">
									<div class="mpPSitter-part-name">펫시터&nbsp</div>
									<c:if test="${userInfo.user_ps_status eq 0 }">
										<div class="mpPSitter-part-state"
											style="background-color: #EEEEEE">
											<span onclick="location.href='mypage.sitterRegPet.go'">&nbsp&nbsp미등록&nbsp&nbsp</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_ps_status eq 1 }">
										<div class="mpPSitter-part-state"
											style="background-color: #EEEEEE">
											<span onclick="location.href='mypage.ticket.do'">이용권구매필요</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_ps_status eq 2 }">
										<div class="mpPSitter-part-state"
											style="background-color: #D9D9D9">
											<span>인증대기</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_ps_status eq 3 }">
										<div class="mpPSitter-part-state"
											style="background-color: #D9D9D9">
											<span onclick="location.href='ps.start.work'">인증완료(공고x)</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_ps_status eq 4 }">
										<div class="mpPSitter-part-state">
											<span onclick="location.href='ps.end.work'">공고중</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_ps_status eq 5 }">
										<div class="mpPSitter-part-state">
											<span>구직완료</span>
										</div>
									</c:if>
								</div>
							</div>
							<div class="mpPSitterSpace"></div>
							<div class="mpPSitter">
								<!-- 시터사용자 <br> -->
								<div class="mpPSitter-part">
									<div class="mpPSitter-part-name">맘테이커</div>
									<c:if test="${userInfo.user_mt_status eq 0 }">
										<div class="mpPSitter-part-state"
											style="background-color: #EEEEEE">
											<span onclick="location.href='mypage.takerRegMom.go'">&nbsp&nbsp미등록&nbsp&nbsp</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_mt_status eq 1 }">
										<div class="mpPSitter-part-state"
											style="background-color: #D9D9D9;">인증대기</div>
									</c:if>
									<c:if test="${userInfo.user_mt_status eq 2 }">
										<div class="mpPSitter-part-state">
											<span id="dolbomMom">구인상황확인</span>
										</div>
									</c:if>
								</div>
								<div class="mpPSitter-part">
									<div class="mpPSitter-part-name">케어테이커</div>
									<c:if test="${userInfo.user_ct_status eq 0 }">
										<div class="mpPSitter-part-state"
											style="background-color: #EEEEEE">
											<span onclick="location.href='mypage.takerRegCare.go'">&nbsp&nbsp미등록&nbsp&nbsp</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_ct_status eq 1 }">
										<div class="mpPSitter-part-state"
											style="background-color: #D9D9D9;">인증대기</div>
									</c:if>
									<c:if test="${userInfo.user_ct_status eq 2 }">
										<div class="mpPSitter-part-state">
											<span id="dolbomCare">구인상황확인</span>
										</div>
									</c:if>
								</div>
								<div class="mpPSitter-part">
									<div class="mpPSitter-part-name">펫테이커</div>
									<c:if test="${userInfo.user_pt_status eq 0 }">
										<div class="mpPSitter-part-state"
											style="background-color: #EEEEEE">
											<span onclick="location.href='mypage.takerRegPet.go'">&nbsp&nbsp미등록&nbsp&nbsp</span>
										</div>
									</c:if>
									<c:if test="${userInfo.user_pt_status eq 1 }">
										<div class="mpPSitter-part-state"
											style="background-color: #D9D9D9;">인증대기</div>
									</c:if>
									<c:if test="${userInfo.user_pt_status eq 2 }">
										<div class="mpPSitter-part-state">
											<span id="dolbomPet">구인상황확인</span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- 정보 -->
			<div class="mpP-info">
				<div class="mpPAddr">
					<div class="mpPAddr-detail">등록한 메일주소</div>
					<div class="mpPAddr-detail-answer">
						&nbsp${sessionScope.userInfo.user_email }</div>
				</div>
				<div class="mpPAddr">
					<div class="mpPAddr-detail">주소</div>
					<div class="mpPAddr-detail-answer">
						우편번호 : ${memberProfile.m_addr3} / 주소 : ${memberProfile.m_addr1 }
						${memberProfile.m_addr2 } 
						<!--  <a href="count.tbl">testetst</a>-->
					</div>
				</div>
				<div class="mpPAddr">
					<div class="mpPAddr-detail">연락처</div>
					<div class="mpPAddr-detail-answer">
						&nbsp${sessionScope.userInfo.user_phone }</div>
				</div>
			</div>
			<!-- 프로필 부분 컨테이너 끝 -->
		</div>
	</div>
	<!-- 프로필 수정의 전체 컨테이너 끝 -->
	<div id="dolbomPetModal"
		style="display: none; width: 100%; height: 100%; background-color: rgba(0, 0, 0, 0.8); position: absolute; top: 0; left: 0">
		<div id="dolbomPetModalContents">
			<div>
				공고를 하시려면 on버튼을 눌러주세요 <br> 공고를 내리시려면 off버튼을 눌러주세요 <br> 내가
				불쌍해보인다면 돈을 주세요
			</div>
			<c:forEach items="${petDTO }" var="p">
				<div class="pet-info" style="display: flex;">
					<div>${p.d_name }</div>
					<div>
						<form action="notice.update">
							<input type="hidden" value="${p.d_onoff }"
								class="petDolbomStatus" name="d_onoff"> <input
								type="hidden" value="${p.d_no }" class="petDolbomNo" name="d_no">
							<button class="petDolbomButton"></button>
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div id="dolbomCareModal"
		style="display: none; width: 100%; height: 100%; background-color: rgba(0, 0, 0, 0.8); position: absolute; top: 0; left: 0">
		<div id="dolbomCareModalContents">
			<div>
				공고를 하시려면 on버튼을 눌러주세요 <br> 공고를 내리시려면 off버튼을 눌러주세요 <br> 내가
				불쌍해보인다면 돈을 주세요
			</div>
			<c:forEach items="${careDTO }" var="p">
				<div class="care-info" style="display: flex;">
					<div>${p.d_name }</div>
					<div>
						<form action="notice.update">
							<input type="hidden" value="${p.d_onoff }"
								class="careDolbomStatus" name="d_onoff"> <input
								type="hidden" value="${p.d_no }" class="careDolbomNo"
								name="d_no">
							<button class="careDolbomButton"></button>
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div id="dolbomMomModal"
		style="display: none; width: 100%; height: 100%; background-color: rgba(0, 0, 0, 0.8); position: absolute; top: 0; left: 0">
		<div id="dolbomMomModalContents">
			<div>
				공고를 하시려면 on버튼을 눌러주세요 <br> 공고를 내리시려면 off버튼을 눌러주세요 <br> 내가
				불쌍해보인다면 돈을 주세요
			</div>
			<c:forEach items="${momDTO }" var="p">
				<div class="mom-info" style="display: flex;">
					<div>${p.d_name }</div>
					<div>
						<form action="notice.update">
							<input type="hidden" value="${p.d_onoff }"
								class="momDolbomStatus" name="d_onoff"> <input
								type="hidden" value="${p.d_no }" class="momDolbomNo" name="d_no">
							<button class="momDolbomButton"></button>
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

</body>


</html>
