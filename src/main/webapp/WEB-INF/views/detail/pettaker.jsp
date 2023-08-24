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
				<div class="body-content-detail-cover" style="width: 40%">
					<div class="header-img-detail">사진</div>
				</div>

				<div class="header-data-detail">
					<div class="header-data1">
						<div style="margin: 5px;">
							<span style="font-size: 14pt;">펫시터 ${dolbom.d_id }</span>
							<c:choose>
								<c:when test="${petsitter.mm.user_gender eq 'female'}">
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
								<div>희망 시급: ${dolbom.d_pay }</div>
								<div style="margin-left: 10px;">(${dolbom.d_term })</div>
							</div>
							<div style="display: flex;">
								<div>활동 가능 지역:</div>
								<div class="header-location">
									<div>${dolbom.d_location }</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="body-detail">
				<div>
					<div class="body-title-detail">아이성격</div>
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
									<img alt="" src="resources/img/logo/산책.png">
									<div class="can-do-text">산책</div>
								</div>
							</c:if>
							<c:if test="${dolbom.d_can_do %3 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/목욕.png">
									<div class="can-do-text">목욕</div>
								</div>
							</c:if>
							<c:if test="${dolbom.d_can_do %5 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/사료.png">
									<div class="can-do-text">밥챙겨주기</div>
								</div>
							</c:if>
							<c:if test="${dolbom.d_can_do %19 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/호텔.png">
									<div class="can-do-text">호텔링</div>
								</div>
							</c:if>
							<c:if test="${dolbom.d_can_do %7 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/배변훈련.png">
									<div class="can-do-text">배변훈련</div>
								</div>
							</c:if>
							<c:if test="${dolbom.d_can_do %11 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/놀이훈련.png">
									<div class="can-do-text">놀이훈련</div>
								</div>
							</c:if>
							<c:if test="${dolbom.d_can_do %13 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/.png">
									<div class="can-do-text">사회화훈련</div>
								</div>
							</c:if>
							<c:if test="${dolbom.d_can_do %17 == 0 }">
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
					<div class="body-title-detail">원하는 시터 나이</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail">${dolbom.d_need }</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">그 외 요청사항</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail">${dolbom.d_need }</div>
					</div>
				</div>
				<c:if test="${dolbom.d_id eq sessionScope.userInfo.user_id }">
					<div class="detail-btn">
	<%-- 					<c:choose>
							<c:when test="${dolbom.d_notice == '1' }">
								<button
									onclick="location.href='pettaker.update.go?d_id=${dolbom.d_id}'">수정</button>
								<button
									onclick="location.href='pettaker.notice.up?d_id=${dolbom.d_id}'"
									style="margin-left: 10px;">공고 올리기</button>
								<button onclick="pettakerDelete(${dolbom.d_id})"
									style="margin-left: 10px;">삭제</button>
							</c:when>
							<c:otherwise>
								<button
									onclick="location.href='pettaker.update.go?d_id=${dolbom.d_id}'">수정</button>
								<button
									onclick="location.href='pettaker.notice.up?d_id=${dolbom.d_id}'"
									style="margin-left: 10px;">공고 올리기</button>
								<button onclick="pettakerDelete(${dolbom.d_id})"
									style="margin-left: 10px;">삭제</button>
							</c:otherwise>
						</c:choose> --%>
					</div>
				</c:if>
			</div>
		</div>
		<div class="container-side"></div>
	</div>
</body>
</html>