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
	<div class="containar-detail-pet">
		<div class="container-side"></div>
		<div class="content-detail">
			<div class="header-detail">
				<div class="header-data-detail">
					<div class="header-data1">
						<div style="margin: 5px;">
							<span style="font-size: 14pt;">대상: ${dolbom.d_name }</span>
							<c:choose>
								<c:when test="${dolbom.d_gender eq 'female'}">
									<span style="font-size: 10pt;">여</span>
								</c:when>
								<c:otherwise>
									<span style="font-size: 10pt;">남</span>
								</c:otherwise>
							</c:choose>
							<span style="font-size: 10pt;"> cctv촬영 - <c:choose>
									<c:when test="${dolbom.d_cctv == 1}">
   									   가능
        							</c:when>
									<c:otherwise>
           							불가능
        							</c:otherwise>
								</c:choose>
							</span>
							<div style="display: flex;">
								<div>
									나이: <span id="age"></span>살
								</div>
							</div>
							<div style="display: flex;">
								<div>희망 시급: ${dolbom.d_pay }원</div>
							</div>
							<div style="display: flex;">
								<div>활동 가능 지역:</div>
								<div class="header-location">
									<div>${dolbom.location1 } ${dolbom.location2 } ${dolbom.location3 }</div>				
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="body-detail">
				<div>
					<div class="body-title-detail">어르신의 개성</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail">
							<div style="width: 70%; margin-top: auto; margin-bottom: auto;">${dolbom.d_personality }</div>
						</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">원하는 활동</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail-center">
							<c:if test="${dolbom.d_can_do %2 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/설거지.png">
									<div class="can-do-text">가사활동</div>
								</div>
							</c:if>
							<c:if test="${dolbom.d_can_do %3 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/신체활동.png">
									<div class="can-do-text">신체활동</div>
								</div>
							</c:if>
							<c:if test="${dolbom.d_can_do %5 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/인지활동.png">
									<div class="can-do-text">인지활동</div>
								</div>
							</c:if>
							<c:if test="${dolbom.d_can_do %19 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/기타.png">
									<div class="can-do-text">기타활동</div>
								</div>
							</c:if>
							<c:if test="${dolbom.d_can_do %7 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/식사활동.png">
									<div class="can-do-text">식사</div>
								</div>
							</c:if>
							<c:if test="${dolbom.d_can_do %11 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/기저귀.png">
									<div class="can-do-text">기저귀케어</div>
								</div>
							</c:if>
							<c:if test="${dolbom.d_can_do %13 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/목욕2.png">
									<div class="can-do-text">샤워</div>
								</div>
							</c:if>
							<c:if test="${dolbom.d_can_do %17 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/말벗.png">
									<div class="can-do-text">말벗</div>
								</div>
							</c:if>
						</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">활동 가능 시간</div>
					<div class="body-content-detail-cover">
						<div class="body-time">
							<div class="body-time-title">
								<div>평일</div>
								<div>주말</div>
							</div>
							<div class="body-time-body">
								<div class="body-times">
									<div class="body-time-days">
										<c:choose>
											<c:when test="${dolbom.monday ne 'null' }">
												<div class="body-time-day">월요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${dolbom.monday_start }"
														pattern="00" />
													:00 ~
													<fmt:formatNumber value="${dolbom.monday_end }"
														pattern="00" />
													:00
												</div>
											</c:when>
											<c:otherwise>
												<div class="body-time-day" style="color: gray;">월요일</div>
												<div class="body-time-day"></div>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="body-time-days">
										<c:choose>
											<c:when test="${dolbom.tuesday ne 'null' }">
												<div class="body-time-day">화요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${dolbom.tuesday_start }"
														pattern="00" />
													:00 ~
													<fmt:formatNumber value="${dolbom.tuesday_end }"
														pattern="00" />
													:00
												</div>
											</c:when>
											<c:otherwise>
												<div class="body-time-day" style="color: gray;">화요일</div>
												<div class="body-time-day"></div>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="body-time-days">
										<c:choose>
											<c:when test="${dolbom.wednesday ne 'null' }">
												<div class="body-time-day">수요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${dolbom.wednesday_start }"
														pattern="00" />
													:00 ~
													<fmt:formatNumber value="${dolbom.wednesday_end }"
														pattern="00" />
													:00
												</div>
											</c:when>
											<c:otherwise>
												<div class="body-time-day" style="color: gray;">수요일</div>
												<div class="body-time-day"></div>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="body-time-days">
										<c:choose>
											<c:when test="${dolbom.thursday ne 'null' }">
												<div class="body-time-day">목요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${dolbom.thursday_start }"
														pattern="00" />
													:00 ~
													<fmt:formatNumber value="${dolbom.thursday_end }"
														pattern="00" />
													:00
												</div>
											</c:when>
											<c:otherwise>
												<div class="body-time-day" style="color: gray;">목요일</div>
												<div class="body-time-day"></div>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="body-time-days">
										<c:choose>
											<c:when test="${dolbom.friday ne 'null' }">
												<div class="body-time-day">금요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${dolbom.friday_start }"
														pattern="00" />
													:00 ~
													<fmt:formatNumber value="${dolbom.friday_end }"
														pattern="00" />
													:00
												</div>
											</c:when>
											<c:otherwise>
												<div class="body-time-day" style="color: gray;">금요일</div>
												<div class="body-time-day"></div>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
								<div class="body-times">
									<div class="body-time-days">
										<c:choose>
											<c:when test="${dolbom.saturday ne 'null' }">
												<div class="body-time-day">토요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${dolbom.saturday_start }"
														pattern="00" />
													:00 ~
													<fmt:formatNumber value="${dolbom.saturday_end }"
														pattern="00" />
													:00
												</div>
											</c:when>
											<c:otherwise>
												<div class="body-time-day" style="color: gray;">토요일</div>
												<div class="body-time-day"></div>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="body-time-days">
										<c:choose>
											<c:when test="${dolbom.sunday ne 'null' }">
												<div class="body-time-day">일요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${dolbom.sunday_start }"
														pattern="00" />
													:00 ~
													<fmt:formatNumber value="${dolbom.sunday_end }"
														pattern="00" />
													:00
												</div>
											</c:when>
											<c:otherwise>
												<div class="body-time-day" style="color: gray;">일요일</div>
												<div class="body-time-day"></div>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">그 외 요청사항</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail">${dolbom.d_need }</div>
					</div>
				</div>
					<div class="detail-btn" style="padding-top: 20px;">
						<button onclick="caretakerContract('${dolbom.d_no}', '${sessionScope.userInfo.user_id }', '${userInfo.user_cs_status }')" style="margin-left: 10px;height: 65px;width: 140px;margin-top: 20px">신청하기</button>
					</div>
			</div>
		</div>
		<div class="container-side"></div>
	</div>
</body>

<script>
	const birthYear = ${dolbom.d_year};

	// 현재 연도 구하기
	const currentYear = new Date().getFullYear();

	// 나이 계산
	const age = currentYear - birthYear+1;

	// 결과를 화면에 표시
	const ageElement = document.getElementById("age");
	ageElement.textContent = age;
</script>

<script type="text/javascript">
function caretakerContract(d_no, user_id, user_status){
	// 시터쪽 구분자 = 미등록(이용권 구매x) 0/  이용권구매필요(등록o, 이용권 구매x, 인증x) 1/ 인증 대기(이용권 구매o, 인증x) 2/ 인증완료(공고off , 인증o) 3/ 구직중(공고 on) 4/ 구인완료 5/  기한 만료 ?/
	console.log("thisisno" + d_no);
	console.log(user_id);
	console.log(user_status);
	if (user_id == '') {
		alert('로그인 후 신청해주세요');
		location.href = 'login.go';
	}else if(user_status == 1){
		alert('시터 정보를 입력한 후 신청해주세요');
	}else if(user_status == 2){
		slert('이용권 구매와 필요서류를 등록 후 신청해주세요');
	}else{
		let ok = confirm('신청하시겠습니까?');
		if(ok){
			location.href = 'caretaker.contract.do?d_no=' + d_no;
		}
		
	}
}
</script>
</html>