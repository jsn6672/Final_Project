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
					<div class="header-img-detail">사진</div>
				</div>
				<div class="header-data-detail">
					<div class="header-data1">
						<div style="margin: 5px;">
							<span style="font-size: 14pt;">펫시터 ${petsitter.mm.user_name }</span>
							<c:choose>
								<c:when test="${petsitter.mm.user_gender eq 'female'}">
									<span style="font-size: 10pt;;">여</span>
								</c:when>
								<c:otherwise>
									<span style="font-size: 10pt;">남</span>
								</c:otherwise>
							</c:choose>
							<span style="font-size: 10pt;">cctv촬영 - ${petsitter.ps_cctv }</span>
							<div style="display: flex;">
								<div>희망 시급: ${petsitter.ps_pay }</div>
								<div style="margin-left: 10px;">(${petsitter.ps_term })</div>
							</div>							
							<div style="display: flex;">
								<div>활동 가능 지역:</div>
								<div class="header-location">
									<div>${petsitter.ps_location1 }</div>
									<div>${petsitter.ps_location2 }</div>
									<div>${petsitter.ps_location3 }</div>
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
							<div style="margin: 5px;">	${petsitter.ps_extra }</div>
						</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">관련 경험</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail">
							<div style="margin: 5px;">${petsitter.ps_exp }</div>	
						</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">선호하는 돌봄 유형</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail-center">
							<c:if test="${petsitter.ps_can_do %2 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/산책.png">
									<div class="can-do-text">산책</div>
								</div>
							</c:if>
							<c:if test="${petsitter.ps_can_do %3 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/목욕.png">
									<div class="can-do-text">목욕</div>
								</div>
							</c:if>
							<c:if test="${petsitter.ps_can_do %5 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/사료.png">
									<div class="can-do-text">밥챙겨주기</div>
								</div>
							</c:if>
							<c:if test="${petsitter.ps_can_do %19 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/호텔.png">
									<div class="can-do-text">호텔링</div>
								</div>
							</c:if>
							<c:if test="${petsitter.ps_can_do %7 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/배변훈련.png">
									<div class="can-do-text">배변훈련</div>
								</div>
							</c:if>
							<c:if test="${petsitter.ps_can_do %11 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/놀이훈련.png">
									<div class="can-do-text">놀이훈련</div>
								</div>
							</c:if>
							<c:if test="${petsitter.ps_can_do %13 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/.png">
									<div class="can-do-text">사회화훈련</div>
								</div>
							</c:if>
							<c:if test="${petsitter.ps_can_do %17 == 0 }">
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
											<c:when test="${petsitter.monday ne 'null' }">
												<div class="body-time-day">월요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${petsitter.monday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${petsitter.monday_end }" pattern="00"/>:00
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
											<c:when test="${petsitter.tuesday ne 'null' }">
												<div class="body-time-day">화요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${petsitter.tuesday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${petsitter.tuesday_end }" pattern="00"/>:00
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
											<c:when test="${petsitter.wednesday ne 'null' }">
												<div class="body-time-day">수요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${petsitter.wednesday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${petsitter.wednesday_end }" pattern="00"/>:00
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
											<c:when test="${petsitter.thursday ne 'null' }">
												<div class="body-time-day">목요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${petsitter.thursday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${petsitter.thursday_end }" pattern="00"/>:00
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
											<c:when test="${petsitter.friday ne 'null' }">
												<div class="body-time-day">금요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${petsitter.friday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${petsitter.friday_end }" pattern="00"/>:00 
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
											<c:when test="${petsitter.saturday ne 'null' }">
												<div class="body-time-day">토요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${petsitter.saturday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${petsitter.saturday_end }" pattern="00"/>:00
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
											<c:when test="${petsitter.sunday ne 'null' }">
												<div class="body-time-day">일요일</div>
												<div class="body-time-day">
													<fmt:formatNumber value="${petsitter.sunday_start }" pattern="00"/>:00 ~ 
													<fmt:formatNumber value="${petsitter.sunday_end }" pattern="00"/>:00
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
					<div class="body-title-detail">돌봄 가능한 펫</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail-center">
							<c:if test="${petsitter.ps_can_type %2 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/강아지.png">
									<div class="can-do-text">강아지</div>
								</div>
							</c:if>
							<c:if test="${petsitter.ps_can_type %3 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/고양이.png">
									<div class="can-do-text">고양이</div>
								</div>
							</c:if>
							<c:if test="${petsitter.ps_can_type %5 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/조류.png">
									<div class="can-do-text">조류</div>
								</div>
							</c:if>
							<c:if test="${petsitter.ps_can_type %7 == 0 }">
								<div class="can-do-img">
									<img alt="" src="resources/img/logo/타입 기타.png">
									<div class="can-do-text">기타</div>
								</div>
							</c:if>
						</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">리뷰</div>
					<div class="body-content-detail-cover">
						<div class="body-content-detail">
							<c:forEach var="r" items="${reviews }">
								<div> ${r }	</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<c:if test="${petsitter.ps_id eq sessionScope.userInfo.user_id }">
					<div class="detail-btn">
						<c:choose>
							<c:when test="${petsitter.ps_notice == '1' }">
								<button onclick="location.href='petsitter.update.go?ps_id=${petsitter.ps_id}'">수정</button>
								<button onclick="location.href='petsitter.notice.up?ps_id=${petsitter.ps_id}'" style="margin-left: 10px;">공고 올리기</button>
								<button onclick="petsitterDelete(${petsitter.ps_id})" style="margin-left: 10px;">삭제</button>
							</c:when>
							<c:otherwise>
								<button onclick="location.href='petsitter.update.go?ps_id=${petsitter.ps_id}'">수정</button>
								<button onclick="location.href='petsitter.notice.up?ps_id=${petsitter.ps_id}'" style="margin-left: 10px;">공고 올리기</button>
								<button onclick="petsitterDelete(${petsitter.ps_id})" style="margin-left: 10px;">삭제</button>
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