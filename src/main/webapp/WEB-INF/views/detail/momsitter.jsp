<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
				<div class="body-content-detail-cover" style="width: 40%">
					<div class="header-img-detail"> 
						<img alt="" src="resources/img/${momsitter.mm.user_pic }" style="width: 100%; margin: auto; height: 100%;"> 
					</div>
				</div>
				<div class="header-data-detail">
					<div class="header-data1">
						<div style="margin: 5px;">
							<span style="font-size: 14pt;">맘시터 ${momsitter.mm.user_name }</span>
							<c:choose>
								<c:when test="${momsitter.mm.user_gender eq 'female'}">
									<span style="font-size: 10pt;;">여</span>
								</c:when>
								<c:otherwise>
									<span style="font-size: 10pt;">남</span>
								</c:otherwise>
							</c:choose>
							<span style="font-size: 10pt;">cctv촬영 - ${momsitter.ms_cctv }</span>
							<div style="display: flex;">
								<div>희망 시급: ${momsitter.ms_pay }</div>
								<div style="margin-left: 10px;">(${momsitter.ms_term })</div>
							</div>							
							<div style="display: flex;">
								<div>활동 가능 지역:</div>
								<div class="header-location">
									<div>${momsitter.ms_location1 }</div>
									<div>${momsitter.ms_location2 }</div>
									<div>${momsitter.ms_location3 }</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="body-detail">
				<div>
					<div class="body-title-detail">인증</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail">
							<div style="width: 30%; margin-top: auto; margin-bottom: auto; text-align: center;">
								<img alt="" src="resources/img/logo/인증.png" style="width: 100px; height: 100px;">
							</div>
							<div style="width: 70%; margin-top: auto; margin-bottom: auto;">주민등록등본이 인증된 회원입니다.</div>
						</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">간단 자기소개</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail">
							<div style="margin: 5px;">	${momsitter.ms_extra }</div>
						</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">관련 경험</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail">
							<div style="margin: 5px;">${momsitter.ms_exp }</div>	
						</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">선호하는 돌봄 유형</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail-center">
							<c:if test="${momsitter.ms_can_do %2 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/실내놀이.png">
									<div class="can-do-text">실내놀이</div>
								</div>
							</c:if>
							<c:if test="${momsitter.ms_can_do %3 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/야외놀이.png">
									<div class="can-do-text">야외놀이</div>
								</div>
							</c:if>
							<c:if test="${momsitter.ms_can_do %5 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/밥챙겨주기.png">
									<div class="can-do-text">밥챙겨주기</div>
								</div>
							</c:if>
							<c:if test="${momsitter.ms_can_do %7 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/등하원.png">
									<div class="can-do-text">등하원돕기</div>
								</div>
							</c:if>
							<c:if test="${momsitter.ms_can_do %11 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/영어.png">
									<div class="can-do-text">영어공부</div>
								</div>
							</c:if>
							<c:if test="${momsitter.ms_can_do %13 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/독서.png">
									<div class="can-do-text">한글공부</div>
								</div>
							</c:if>
							<c:if test="${momsitter.ms_can_do %17 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/똥.png">
									<div class="can-do-text">대소변</div>
								</div>
							</c:if>
							<c:if test="${momsitter.ms_can_do %19 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/기타.png">
									<div class="can-do-text">기타활동</div>
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
								<div style="font-weight: 600; font-size: 15pt;">평일</div>
								<div style="font-weight: 600; font-size: 15pt;">주말</div>
							</div>
							<div class="body-time-body">
								<div class="body-times">
									<div class="body-time-days">
										<c:choose>
											<c:when test="${momsitter.monday ne 'null' }">
												<div class="body-time-day">월요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${momsitter.monday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${momsitter.monday_end }" pattern="00"/>:00
												</div>
											</c:when>
											<c:otherwise>
												<div class="body-time-day" style="color: #8080805c;">월요일</div>
												<div class="body-time-day"></div>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="body-time-days">
										<c:choose>
											<c:when test="${momsitter.tuesday ne 'null' }">
												<div class="body-time-day">화요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${momsitter.tuesday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${momsitter.tuesday_end }" pattern="00"/>:00
												</div>
											</c:when>
											<c:otherwise>
												<div class="body-time-day" style="color: #8080805c;">화요일</div>
												<div class="body-time-day"></div>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="body-time-days">
										<c:choose>
											<c:when test="${momsitter.wednesday ne 'null' }">
												<div class="body-time-day">수요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${momsitter.wednesday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${momsitter.wednesday_end }" pattern="00"/>:00
												</div>
											</c:when>
											<c:otherwise>
												<div class="body-time-day" style="color: #8080805c;">수요일</div>
												<div class="body-time-day"></div>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="body-time-days">
										<c:choose>
											<c:when test="${momsitter.thursday ne 'null' }">
												<div class="body-time-day">목요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${momsitter.thursday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${momsitter.thursday_end }" pattern="00"/>:00
												</div>
											</c:when>
											<c:otherwise>
												<div class="body-time-day" style="color: #8080805c;">목요일</div>
												<div class="body-time-day"></div>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="body-time-days">
										<c:choose>
											<c:when test="${momsitter.friday ne 'null' }">
												<div class="body-time-day">금요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${momsitter.friday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${momsitter.friday_end }" pattern="00"/>:00 
												</div>
											</c:when>
											<c:otherwise>
												<div class="body-time-day" style="color: #8080805c;">금요일</div>
												<div class="body-time-day"></div>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
								<div class="body-times">
									<div class="body-time-days">
										<c:choose>
											<c:when test="${momsitter.saturday ne 'null' }">
												<div class="body-time-day">토요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${momsitter.saturday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${momsitter.saturday_end }" pattern="00"/>:00
												</div>
											</c:when>
											<c:otherwise>
												<div class="body-time-day" style="color: #8080805c;">토요일</div>
												<div class="body-time-day"></div>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="body-time-days">
										<c:choose>
											<c:when test="${momsitter.sunday ne 'null' }">
												<div class="body-time-day">일요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${momsitter.sunday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${momsitter.sunday_end }" pattern="00"/>:00
												</div>
											</c:when>
											<c:otherwise>
												<div class="body-time-day" style="color: #8080805c;">일요일</div>
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
					<div class="body-title-detail">돌봄 가능한 나이</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail-center">
							<c:if test="${momsitter.ms_can_type %2 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/신생아.png">
									<div class="can-do-text">신생아</div>
								</div>
							</c:if>
							<c:if test="${momsitter.ms_can_type %3 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/영아.png">
									<div class="can-do-text">영아</div>
								</div>
							</c:if>
							<c:if test="${momsitter.ms_can_type %5 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/유아.png">
									<div class="can-do-text">유아</div>
								</div>
							</c:if>
							<c:if test="${momsitter.ms_can_type %7 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/초등학생.png">
									<div class="can-do-text">초등학생</div>
								</div>
							</c:if>
						</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">리뷰</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail">
							<c:choose>
								<c:when test="${review ne 'none' }">
									<c:forEach var="r" items="${review }">
										<div>
										</div>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<div style="margin: auto;">
										아직 작성된 리뷰가 없습니다.
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				<c:if test="${momsitter.ms_id eq sessionScope.userInfo.user_id }">
					<div class="detail-btn">
						<c:choose>
							<c:when test="${momsitter.ms_notice == '1' }">
								<button onclick="location.href='momsitter.update.go?ms_id=${momsitter.ms_id}'">수정</button>
								<button onclick="location.href='momsitter.notice.up?ms_id=${momsitter.ms_id}'" style="margin-left: 10px;">공고 내리기</button>
								<button onclick="momsitterDelete(${momsitter.ms_id})" style="margin-left: 10px;">삭제</button>
							</c:when>
							<c:otherwise>
								<button onclick="location.href='momsitter.update.go?ms_id=${petsitter.ms_id}'">수정</button>
								<button onclick="location.href='momsitter.notice.up?ms_id=${petsitter.ms_id}'" style="margin-left: 10px;">공고 올리기</button>
								<button onclick="momsitterDelete(${momsitter.ms_id})" style="margin-left: 10px;">삭제</button>
							</c:otherwise>
						</c:choose>
					</div>
				</c:if>
			</div>
		</div>
		<div class="container-side"></div>
	</div>
</body>
</html>