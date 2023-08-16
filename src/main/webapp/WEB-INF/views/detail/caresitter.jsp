<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
							<span style="font-size: 14pt;">케어시터 ${caresitter.cs_id }</span>

							<span style="font-size: 10pt;">31살,여</span>

							<span style="font-size: 10pt;">cctv촬영 - ${caresitter.cs_cctv }</span>
						<div>희망 시급: ${mocsitter.cs_pay }</div>
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
			<div class="body-detail">
				<div>
					<div class="body-title-detail">인증</div>
					<div class="body-content-detail-cover">
					<div>
						<div class="body-content-detail">${caresitter.cs_certif }</div>
					</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">간단 자기소개</div>
					<div class="body-content-detail-cover">
					<div class="body-content-detail">${caresitter.cs_intro }</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">관련 경험</div>
					<div class="body-content-detail-cover">
					<div class="body-content-detail">${caresitter.cs_exp }</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">선호하는 돌봄 유형</div>
					<div class="body-content-detail-cover">
					<div class="body-content-detail">
					<div>실내놀이</div>
					<div>실내놀이</div>
					<div>실내놀이</div>
					<div>실내놀이</div>															
					${caresitter.cs_can_do }</div>
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
					<div class="body-title-detail">돌봄 가능 연령</div>
					<div class="body-content-detail-cover">
					<div class="body-content-detail">내용</div>
					</div>
				</div>
				<div>
					<div class="body-title-detail">리뷰</div>
					<div class="body-content-detail-cover">
					<div class="body-content-detail">내용</div>
					</div>
				</div>
				<c:if test="${caresitter.cs_id eq sessionScope.userInfo.user_id }">
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