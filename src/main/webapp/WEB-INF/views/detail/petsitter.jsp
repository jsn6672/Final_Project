<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
      $(function() {

    	const review_create_at = $('#review_create_at').text();
    	
    	console.log(review_create_at);
    	console.log(new Date(review_create_at));
        
        
      	const test = $(".date").text(elapsedTime(review_create_at));
		console.log(test);


      }) //레디펑션

      const TIME_ZONE = 3240 * 10000;

      function elapsedTime(date) {
    	  console.log(date);
        const start = new Date(date);
        console.log(start);
        console.log('-----------')
        const end = new Date(new Date().getTime() + TIME_ZONE); // 현재 날짜

        const diff = (end - start) / 1000; // 경과시간
        console.log(start);
        console.log(end);
        console.log(diff);

        const times = [
          { name: '년', milliSeconds: 60 * 60 * 24 * 365 },
          { name: '개월', milliSeconds: 60 * 60 * 24 * 30 },
          { name: '일', milliSeconds: 60 * 60 * 24 },
          { name: '시간', milliSeconds: 60 * 60 },
          { name: '분', milliSeconds: 60 },
        ];

        // 년 단위부터 알맞는 단위 찾기
        for (const value of times) {
          const betweenTime = Math.floor(diff / value.milliSeconds);

          console.log(betweenTime);
          const namevalue = value.name;
          console.log(namevalue);

          // 큰 단위는 0보다 작은 소수 단위 나옴
          if (betweenTime > 0) {
          	console.log(namevalue);
          	return betweenTime + namevalue + "전";
          }
        }

        // 모든 단위가 맞지 않을 시
        return "방금 전";
      }
    </script>
</head>
<body>
	<div class="containar-detail-pet">
		<div class="container-side"></div>
		<div class="content-detail">
			<div class="header-detail">
				<div class="body-content-detail-cover" style="width: 40%">
					<div class="header-img-detail"> 
						<img alt="" src="resources/img/${petsitter.mm.user_pic }" style="width: 100%; margin: auto; height: 100%;"> 
					</div>
				</div>
				<div class="header-data-detail">
					<div class="header-data1">
						<div style="margin: 5px;">
							<span style="font-size: 14pt;">펫시터 ${petsitter.mm.user_name }</span>
							<span>${petsitter.mm.user_age }세</span>
							<c:choose>
								<c:when test="${petsitter.mm.user_gender eq 'female'}">
									<span style="font-size: 10pt;;">여</span>
								</c:when>
								<c:otherwise>
									<span style="font-size: 10pt;">남</span>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${petsitter.ps_cctv == 1 }">
									<span style="font-size: 10pt;">CCTV촬영 - 가능</span>
								</c:when>
								<c:otherwise>
									<span style="font-size: 10pt;">CCTV촬영 - 불가능</span>
								</c:otherwise>
							</c:choose>
							<div style="display: flex;">
								<div>희망 시급: ${petsitter.ps_pay }</div>
								<div style="margin-left: 10px;">
									<c:choose>
										<c:when test="${petsitter.ps_term  == 1}">
											<div style="margin-left: 10px;">(정기)</div>
										</c:when>
										<c:otherwise>
											<div style="margin-left: 10px;">(단기)</div>
										</c:otherwise>
									</c:choose>
								</div>
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
								<div style="font-weight: 600; font-size: 15pt;">평일</div>
								<div style="font-weight: 600; font-size: 15pt;">주말</div>
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
												<div class="body-time-day" style="color: #8080805c;">월요일</div>
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
												<div class="body-time-day" style="color: #8080805c;">화요일</div>
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
												<div class="body-time-day" style="color: #8080805c;">수요일</div>
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
												<div class="body-time-day" style="color: #8080805c;">목요일</div>
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
												<div class="body-time-day" style="color: #8080805c;">금요일</div>
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
												<div class="body-time-day" style="color: #8080805c;">토요일</div>
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
						<div class="body-content-detail-review">
							<c:choose>
								<c:when test="${review ne 'none'}">
									<c:forEach var="r" items="${review }">
										<div>
											<div style="display: flex;">
												<div>
													<span style="font-size: 15pt; font-weight: 500;">${r.memberDTO.user_name }님</span>
													<span id="review_create_at">
													<fmt:formatDate	value="${r.review_create_at}" type="date" pattern="yyyy. MM. dd" />
													</span> <span class="date" id="write-date-placeholder"></span>
												</div>
												<div style="margin-left: 30px; margin-top: -11px;">
													<span class="review_star"> ★★★★★ <span>★★★★★</span>
														<input type="range" class="s" step="1" min="0" max="10">
														<input type="text" class="star_value" name="star_value"	value="${r.review_point}">
													</span>
												</div>
											</div>
											<div class="balloon">
												${r.review_txt }
											</div>
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
					<div class="detail-btn">
						<c:choose>
							<c:when test="${petsitter.ps_id eq sessionScope.userInfo.user_id }">
								<c:choose>
									<c:when test="${sessionScope.userInfo.user_ps_status == 3 }">
										<button onclick="location.href='mypage.sitterRegPet.go?user_id=${sessionScope.userInfo.user_id}'"style="margin-left: 10px;height: 65px;width: 140px;margin-top: 20px;">수정</button>
										<button onclick="petsitterNoticeUP('${petsitter.ps_id}')" style="margin-left: 10px;height: 65px;width: 140px;margin-top: 20px;">공고 올리기</button>
										<button onclick="petsitterDelete('${petsitter.ps_id}')" style="margin-left: 10px;height: 65px;width: 140px;margin-top: 20px;">삭제</button>
									</c:when>
									<c:when test="${sessionScope.userInfo.user_ps_status == 4 }">
										<button onclick="location.href='mypage.sitterRegPet.go?user_id=${sessionScope.userInfo.user_id}'" style="margin-left: 10px;height: 65px;width: 140px;margin-top: 20px;">수정</button>
										<button onclick="petsitterNoticeDOWN('${petsitter.ps_id}')" style="margin-left: 10px;height: 65px;width: 140px;margin-top: 20px;">공고 내리기</button>
										<button onclick="petsitterDelete('${petsitter.ps_id}')" style="margin-left: 10px;height: 65px;width: 140px;margin-top: 20px;;">삭제</button>
									</c:when>
								</c:choose>
							</c:when>
							<c:when test="${sessionScope.userInfo.user_id ne null }">
								<button class="open-btn" onclick="petsitterContract('${petsitter.ps_id}')" style="margin-left: 10px;height: 65px;width: 140px;margin-top: 20px;">신청하기</button>
							</c:when>
						</c:choose>
					</div>
			</div>
		</div>
		<div class="container-side"></div>
	</div>
<dialog class="mymodal w-25 h-25 bg-white border-0">
		<!-- 모달 전체 div -->
		<div class="container-fluid d-flex justify-content-center align-items-center w-100 h-100 bg-transparent ">
		
		<!-- 유저 정보 및 돌보미 담는 곳 -->
		<div class="d-flex flex-column bg-white w-100 h-100">
			
			<!-- 안내멘트 담는 div -->
			<div class="d-flex justify-content-center align-items-center w-100 h-25 bg-blue">
				<span>돌보미를 선택해주세요</span>
				<form method="dialog">
					<button>close</button>
				</form>
			</div>
			
			<!-- 유저의 돌봄정보 전체를 담는 div -->
		<!--  	<div class="dolbom-box d-flex flex-column justify-content-center align-items-center w-100 h-75 bg-light">-->
		<div class="dolbom-box h-75">
				
				<!-- 유저의 돌봄정보를 각각 담는 div  -->
				
				<!-- <div class="d-flex justify-contents-start align-items-center w-100 h-25 bg-red">
					<div class="d-flex flex-column justify-contents-center alignt-items-center w-25 h-100">
						<span>돌보미 이름</span>
						<span>돌보미 나이</span>
					</div>
					<div class="d-flex justify-contents-center alignt-items-center w-75 h-100 bg-green">
						<span>돌보미 상세설명</span>
					</div>
				</div>		 -->		

			</div>
		</div>
		</div>
		
		
	</dialog>
</body>

<script type="text/javascript">
let open_btn = document.querySelector('.open-btn');
let modal = document.querySelector('.mymodal');

open_btn.addEventListener('click', function(){
	modal.showModal();
	console.log(111);
	
});

</script>
</html>