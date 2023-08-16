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
	<div class="containar-detail">
		<div class="container-side"></div>
		<div class="content-detail">
			<div class="header-detail">
			<div class="body-content-detail-cover" style="width: 40%">
				<div class="header-img-detail">
				사진
				</div>
				</div>
				<div class="header-data-detail">
	
					<div class="header-data1">
						<div>
							<span style="font-size: 14pt;">맘시터 ${momsitter.ms_id }</span>

							<span style="font-size: 10pt;">31살,여</span>

							<span style="font-size: 10pt;">cctv촬영 - ${momsitter.ms_cctv }</span>
						<div>희망 시급: ${momsitter.ms_pay }</div>
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
			<div class="body-detail">
				<div>
					<div class="body-title-detail">아이성격</div>
					<div class="body-content-detail-cover">
					<div>
						<div class="body-content-detail">${momsitter.ms_certif }</div>
					</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">원하는 활동</div>
					<div class="body-content-detail-cover">
					<div class="body-content-detail">${momsitter.ms_intro }</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">원하는 시간</div>
					<div class="body-content-detail-cover">
					<div class="body-time">
						<div class="body-time-title">
							<div>평일</div>
							<div>주말</div>
						</div>
						<div class="body-time-body">
							<div class="body-times">
								<div class="body-time-days">
									<div class="body-time-day">월요일</div>
									<div class="body-time-day">09:00 ~ 12:00</div>
								</div>
								<div class="body-time-days">
									<div class="body-time-day">화요일</div>
									<div class="body-time-day">시간</div>
								</div>
								<div class="body-time-days">
									<div class="body-time-day">수요일</div>
									<div class="body-time-day">시간</div>
								</div>
								<div class="body-time-days">
									<div class="body-time-day">목요일</div>
									<div class="body-time-day">시간</div>
								</div>
								<div class="body-time-days">
									<div class="body-time-day">금요일</div>
									<div class="body-time-day">시간</div>
								</div>
							</div>
							<div class="body-times">
								<div class="body-time-days">
									<div class="body-time-day">토요일</div>
									<div class="body-time-day">시간</div>
								</div>
								<div class="body-time-days">
									<div class="body-time-day">일요일</div>
									<div class="body-time-day">시간</div>
								</div>
							</div>
						</div>
						</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">원하는 시터나이</div>
					<div class="body-content-detail-cover">
					<div class="body-content-detail">내용</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">그 외 요청사항</div>
					<div class="body-content-detail-cover">
					<div class="body-content-detail">공주는 그런거 몰라</div>
					</div>
				</div>
				<c:if test="${momsitter.ms_id eq sessionScope.userInfo.user_id }">
				<div class="detail-btn">
					<button>수정</button>
					<button style="margin-left: 10px;">삭제</button>
				</div>
				</c:if>
			</div>
		</div>
		<div class="container-side"></div>
	</div>
</body>
</html>