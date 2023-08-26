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
						<img alt="" src="resources/img/${caresitter.mm.user_pic }" style="width: 100%; margin: auto; height: 100%;"> 
					</div>
				</div>
				<div class="header-data-detail">
					<div class="header-data1">
						<div style="margin: 5px;">
							<span style="font-size: 14pt;">간병인 ${caresitter.mm.user_name }</span>
							<c:choose>
								<c:when test="${caresitter.mm.user_gender eq 'female'}">
									<span style="font-size: 10pt;;">여</span>
								</c:when>
								<c:otherwise>
									<span style="font-size: 10pt;">남</span>
								</c:otherwise>
							</c:choose>
							<span style="font-size: 10pt;">cctv촬영 - ${caresitter.cs_cctv }</span>
							<div style="display: flex;">
								<div>희망 시급: ${caresitter.cs_pay }</div>
								<div style="margin-left: 10px;">(${caresitter.cs_term })</div>
							</div>							
							<div style="display: flex;">
								<div>활동 가능 지역:</div>
								<div class="header-location">
									<div>${caresitter.cs_location1 }</div>
									<div>${caresitter.cs_location2 }</div>
									<div>${caresitter.cs_location3 }</div>
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
							<div style="margin: 5px;">	${caresitter.cs_extra }</div>
						</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">관련 경험</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail">
							<div style="margin: 5px;">${caresitter.cs_exp }</div>	
						</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">선호하는 돌봄 유형</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail-center">
							<c:if test="${caresitter.cs_can_do %2 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/설거지.png">
									<div class="can-do-text">가사활동</div>
								</div>
							</c:if>
							<c:if test="${caresitter.cs_can_do %3 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/신체활동.png">
									<div class="can-do-text">신체활동</div>
								</div>
							</c:if>
							<c:if test="${caresitter.cs_can_do %5 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/인지활동.png">
									<div class="can-do-text">인지활동</div>
								</div>
							</c:if>
							<c:if test="${caresitter.cs_can_do %7 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/식사활동.png">
									<div class="can-do-text">식사</div>
								</div>
							</c:if>
							<c:if test="${caresitter.cs_can_do %11 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/기저귀.png">
									<div class="can-do-text">기저귀케어</div>
								</div>
							</c:if>
							<c:if test="${caresitter.cs_can_do %13 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/목욕2.png">
									<div class="can-do-text">샤워</div>
								</div>
							</c:if>
							<c:if test="${caresitter.cs_can_do %17 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/말벗.png">
									<div class="can-do-text">말벗</div>
								</div>
							</c:if>
							<c:if test="${caresitter.cs_can_do %19 == 0 }">
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
											<c:when test="${caresitter.monday ne 'null' }">
												<div class="body-time-day">월요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${caresitter.monday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${caresitter.monday_end }" pattern="00"/>:00
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
											<c:when test="${caresitter.tuesday ne 'null' }">
												<div class="body-time-day">화요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${caresitter.tuesday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${caresitter.tuesday_end }" pattern="00"/>:00
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
											<c:when test="${caresitter.wednesday ne 'null' }">
												<div class="body-time-day">수요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${caresitter.wednesday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${caresitter.wednesday_end }" pattern="00"/>:00
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
											<c:when test="${caresitter.thursday ne 'null' }">
												<div class="body-time-day">목요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${caresitter.thursday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${caresitter.thursday_end }" pattern="00"/>:00
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
											<c:when test="${caresitter.friday ne 'null' }">
												<div class="body-time-day">금요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${caresitter.friday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${caresitter.friday_end }" pattern="00"/>:00 
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
											<c:when test="${caresitter.saturday ne 'null' }">
												<div class="body-time-day">토요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${caresitter.saturday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${caresitter.saturday_end }" pattern="00"/>:00
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
											<c:when test="${caresitter.sunday ne 'null' }">
												<div class="body-time-day">일요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${caresitter.sunday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${caresitter.sunday_end }" pattern="00"/>:00
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
				<c:if test="${caresitter.cs_id eq sessionScope.userInfo.user_id }">
					<div class="detail-btn">
						<c:choose>
							<c:when test="${caresitter.cs_notice == '1' }">
								<button onclick="location.href='caresitter.update.go?cs_id=${caresitter.cs_id}'">수정</button>
								<button onclick="location.href='caresitter.notice.up?cs_id=${caresitter.cs_id}'" style="margin-left: 10px;">공고 올리기</button>
								<button onclick="caresitterDelete(${caresitter.cs_id})" style="margin-left: 10px;">삭제</button>
							</c:when>
							<c:otherwise>
								<button onclick="location.href='caresitter.update.go?cs_id=${caresitter.cs_id}'">수정</button>
								<button onclick="location.href='caresitter.notice.up?cs_id=${caresitter.cs_id}'" style="margin-left: 10px;">공고 올리기</button>
								<button onclick="caresitterDelete(${caresitter.cs_id})" style="margin-left: 10px;">삭제</button>
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