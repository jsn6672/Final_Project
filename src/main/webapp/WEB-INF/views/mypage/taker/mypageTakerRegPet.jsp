<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	let disableConnectAddrSearch = false; // 이벤트 발동을 제어할 변수
	function connectAddrSearchEvent() {
		$("#addrSearchBtn").click(function() {
			console.log(disableConnectAddrSearch);
			if (!disableConnectAddrSearch) { // disableConnectAddrSearch 변수의 값에 따라 이벤트 발동 여부 결정
				new daum.Postcode({
					oncomplete : function(data) {
						$("#jm_addr3Input").val(data.zonecode);
						$("#jm_addr1Input").val(data.roadAddress);
					}
				}).open();
			}
		});
	}
	$(function() {

		const addr = '${userInfo.user_location}';
		console.log(addr);
		const arr = addr.split('!');
		$("#sameaddr").on("change", function() {
			if (this.checked) {
				disableConnectAddrSearch = true; // 체크되었을 때 connectAddrSearchEvent() 비활성화
				document.getElementById('jm_addr1Input').value = arr[0];
				document.getElementById('jm_addr2Input').value = arr[1];
				document.getElementById('jm_addr3Input').value = arr[2];
				$("#jm_addr2Input").prop("readonly", true); // 상세주소에 readonly 붙이기
			} else {
				disableConnectAddrSearch = false; // 체크 해제되었을 때 connectAddrSearchEvent() 활성화
				document.getElementById('jm_addr1Input').value = '';
				document.getElementById('jm_addr2Input').value = '';
				document.getElementById('jm_addr3Input').value = '';
				$("#jm_addr2Input").prop("readonly", false); // 상세주소에 readonly 떨어트리기
			}

		})
		connectAddrSearchEvent();

		$("#monday").on("change", function() {
			if (this.checked) {
				document.getElementById('monday_start').disabled = false;
				document.getElementById('monday_end').disabled = false;
			} else {
				document.getElementById('monday_start').disabled = true;
				document.getElementById('monday_end').disabled = true;
			}

		})
		$("#tuesday").on("change", function() {
			if (this.checked) {
				document.getElementById('tuesday_start').disabled = false;
				document.getElementById('tuesday_end').disabled = false;
			} else {
				document.getElementById('tuesday_start').disabled = true;
				document.getElementById('tuesday_end').disabled = true;
			}

		})
		$("#wednesday").on("change", function() {
			if (this.checked) {
				document.getElementById('wednesday_start').disabled = false;
				document.getElementById('wednesday_end').disabled = false;
			} else {
				document.getElementById('wednesday_start').disabled = true;
				document.getElementById('wednesday_end').disabled = true;
			}

		})
		$("#thursday").on("change", function() {
			if (this.checked) {
				document.getElementById('thursday_start').disabled = false;
				document.getElementById('thursday_end').disabled = false;
			} else {
				document.getElementById('thursday_start').disabled = true;
				document.getElementById('thursday_end').disabled = true;
			}

		})
		$("#friday").on("change", function() {
			if (this.checked) {
				document.getElementById('friday_start').disabled = false;
				document.getElementById('friday_end').disabled = false;
			} else {
				document.getElementById('friday_start').disabled = true;
				document.getElementById('friday_end').disabled = true;
			}

		})
		$("#saturday").on("change", function() {
			if (this.checked) {
				document.getElementById('saturday_start').disabled = false;
				document.getElementById('saturday_end').disabled = false;
			} else {
				document.getElementById('saturday_start').disabled = true;
				document.getElementById('saturday_end').disabled = true;
			}

		})
		$("#sunday").on("change", function() {
			if (this.checked) {
				document.getElementById('sunday_start').disabled = false;
				document.getElementById('sunday_end').disabled = false;
			} else {
				document.getElementById('sunday_start').disabled = true;
				document.getElementById('sunday_end').disabled = true;
			}

		})

	}) // 레디펑션
</script>

<style type="text/css">
body {
	font-size: 12pt;
}

.birth_input {
	width: 300px;
	height: 45px;
	font-size: 12pt;
	font-weight: 400;
	background-color: #D9D9D9;
	color: black;
	border-radius: 5%;
	border: none;
}

.mpS-pet-sub div {
	margin: 7px;
}
</style>

</head>
<body>

	<form action="petsitter.be" method="post" enctype="multipart/form-data">

		<!-- 전체 컨테이너 -->
		<div class="mpS-pet">
			<!-- 내용의 전체 div -->
			<div class="mpS-pet-sub">
				<!-- 로고 -->
				<div class="mpS-logo">
					<img id="mpS-logo" alt="" src="resources/img/mypage/MOSI-logo.png">
				</div>

				<div>${userInfo.user_name}님의정보를입력해주세요</div>
				<div>필요한 서류를 등록해주세요</div>
				<div>
					<input type="file" name="ps_Rfile"  style="background-color: #D9D9D9; color: black; border: none; border-radius: 5px; padding: 5px; width: 225px;">
				</div>

				<!-- 정보입력 -->
				<div class="mpS-pet-inform2">할 수 있는 케어 종류를 선택해주세요</div>
				<div style="text-align: center;">
					희망 지역1은 필수입력입니다
					<div>
						희망지역 1 <input name="ps_location1" style="width: 300px;border: none; border-radius: 10px;">
					</div>
					<div>
						희망지역 2 <input name="ps_location2" style="width: 300px;border: none; border-radius: 10px;">
					</div>
					<div>
						희망지역 3 <input name="ps_location3" style="width: 300px;border: none; border-radius: 10px;">
					</div>
				</div>
				<div>
					<input type="radio" name="ps_cctv" value="1" checked="checked">
					cctv촬영도 괜찮아요 <input type="radio" name="ps_cctv" value="2">
					cctv촬영 없는 곳을 원해요
				</div>
				<div>
					<input type="radio" name="ps_term" value="1" checked="checked">
					정기적 계약을 원해요 <input type="radio" name="ps_term" value="2">
					단발성 계약을 원해요
				</div>
				<div>원하시는 시급을 입력해주세요</div>
				<div>
					<input name="ps_pay" style="width: 200px;border: none; border-radius: 10px;">
				</div>

				<div>
					<textarea rows="" cols="" name="ps_exp" placeholder="관련 경험을 적어주세요" style="width: 620px; height: 300px; border: none; border-radius: 10px;"></textarea>
				</div>

				<div class="mpS-pet-inform1">이런 반려동물에게 도움을 줄 수 있어요!</div>
				<div class="mpS-pet-act">
					<div class="mpS-pet-act-bottom">
						<div class="mpS-pet-act-detail">
						<img alt="" src="resources/img/logo/강아지.png" style="width: 70px; height: 80px;">
						<div>
							<input type="checkbox" name="ps_type" value="2"> 강아지
						</div>
						</div>
						<div class="mpS-pet-act-detail">
						<img alt="" src="resources/img/logo/고양이.png" style="width: 70px; height: 80px;">
						<div>
							<input type="checkbox" name="ps_type" value="3"> 고양이
						</div>	
						</div>
						<div class="mpS-pet-act-detail">
						<img alt="" src="resources/img/logo/조류.png" style="width: 70px; height: 80px;">
						<div>
							<input type="checkbox" name="ps_type" value="5"> 조류
						</div>	
						</div>
						<div class="mpS-pet-act-detail">
						<img alt="" src="resources/img/logo/기타2.png" style="width: 70px; height: 80px;">
						<div>
							<input type="checkbox" name="ps_type" value="7"> 기타
						</div>	
						</div>
					</div>
				</div>


				<div class="mpS-pet-inform1">반려동물에게 이런 활동을 시켜줄 수 있어요!</div>
				<div class="mpS-pet-act">
					<div class="mpS-pet-act-bottom">
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/산책.png" style="width: 70px;">
							<div>
							<input type="checkbox" name="petsitter_act" value="2"> 산책
							</div>
						</div>				
						<div class="mpS-pet-act-detail">
						<img alt="" src="resources/img/logo/목욕.png" style="width: 70px;">
						<div>
							<input type="checkbox" name="petsitter_act" value="3"> 목욕
						</div>	
						</div>
						<div class="mpS-pet-act-detail">
						<img alt="" src="resources/img/logo/사료.png" style="width: 70px;">
						<div>
							<input type="checkbox" name="petsitter_act" value="5"> 밥챙겨주기
						</div>
						</div>
						<div class="mpS-pet-act-detail">
						<img alt="" src="resources/img/logo/호텔.png" style="width: 70px;">
						<div>
							<input type="checkbox" name="petsitter_act" value="7"> 호텔링
						</div>	
						</div>
					</div>
					<div class="mpS-pet-act-bottom">
						<div class="mpS-pet-act-detail">
						<img alt="" src="resources/img/logo/배변훈련.png" style="width: 70px;">
						<div>
							<input type="checkbox" name="petsitter_act" value="11"> 배변훈련
						</div>	
						</div>
						<div class="mpS-pet-act-detail">
						<img alt="" src="resources/img/logo/배변훈련.png" style="width: 70px;">
						<div>
							<input type="checkbox" name="petsitter_act" value="13"> 놀이훈련
						</div>	
						</div>
						<div class="mpS-pet-act-detail">
						<img alt="" src="resources/img/logo/놀이훈련.png" style="width: 70px;">
						<div>
							<input type="checkbox" name="petsitter_act" value="17"> 사회화훈련
						</div>	
						</div>
						<div class="mpS-pet-act-detail">
						<img alt="" src="resources/img/logo/기타.png" style="width: 70px;">
						<div>
							<input type="checkbox" name="petsitter_act" value="19"> 기타활동
						</div>	
						</div>
					</div>
				</div>
				<div>
					<textarea rows="10" cols="50" placeholder="추가사항이 있다면 이곳에 적어주세요!"
						name="ps_extra" style="width: 620px; border: none; border-radius: 10px;"></textarea>
				</div>

				<div style="width: 75%;">
					<div class="body-title-detail">활동 필요 시간</div>
					<div class="body-time">
						<div class="body-time-title">
							<div>평일</div>
							<div>주말</div>
						</div>
						<div class="body-time-body">
							<div class="body-times">
								<div class="body-time-days">
									<div class="body-time-day">
										<input type="checkbox" name="monday" id="monday"
											value="monday"> 월요일
									</div>
									<div class="body-time-day">
										<select disabled="disabled" id="monday_start"
											name="monday_start">
											<option value="" selected disabled>선택해주세요.</option>
											<c:forEach var="r" begin="1" end="24">
												<option value="${r}">${r }시</option>
											</c:forEach>
										</select> ~ <select disabled="disabled" id="monday_end"
											name="monday_end">
											<option value="" selected disabled>선택해주세요.</option>
											<c:forEach var="r" begin="1" end="24">
												<option value="${r}">${r }시</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="body-time-days">
									<div class="body-time-day">
										<input type="checkbox" name="tuesday" id="tuesday"
											value="tuesday"> 화요일
									</div>
									<div class="body-time-day">
										<select disabled="disabled" id="tuesday_start"
											name="tuesday_start">
											<option value="" selected disabled>선택해주세요.</option>
											<c:forEach var="r" begin="1" end="24">
												<option value="${r}">${r }시</option>
											</c:forEach>
										</select> ~ <select disabled="disabled" id="tuesday_end"
											name="tuesday_end">
											<option value="" selected disabled>선택해주세요.</option>
											<c:forEach var="r" begin="1" end="24">
												<option value="${r}">${r }시</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="body-time-days">
									<div class="body-time-day">
										<input type="checkbox" name="wednesday" id="wednesday"
											value="wednesday"> 수요일
									</div>
									<div class="body-time-day">
										<select disabled="disabled" id="wednesday_start"
											name="wednesday_start">
											<option value="" selected disabled>선택해주세요.</option>
											<c:forEach var="r" begin="1" end="24">
												<option value="${r}">${r }시</option>
											</c:forEach>
										</select> ~ <select disabled="disabled" id="wednesday_end"
											name="wednesday_end">
											<option value="" selected disabled>선택해주세요.</option>
											<c:forEach var="r" begin="1" end="24">
												<option value="${r}">${r }시</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="body-time-days">
									<div class="body-time-day">
										<input type="checkbox" name="thursday" id="thursday"
											value="thursday"> 목요일
									</div>
									<div class="body-time-day">
										<select disabled="disabled" id="thursday_start"
											name="thursday_start">
											<option value="" selected disabled>선택해주세요.</option>
											<c:forEach var="r" begin="1" end="24">
												<option value="${r}">${r }시</option>
											</c:forEach>
										</select> ~ <select disabled="disabled" id="thursday_end"
											name="thursday_end">
											<option value="" selected disabled>선택해주세요.</option>
											<c:forEach var="r" begin="1" end="24">
												<option value="${r}">${r }시</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="body-time-days">
									<div class="body-time-day">
										<input type="checkbox" name="friday" id="friday"
											value="friday"> 금요일
									</div>
									<div class="body-time-day">
										<select disabled="disabled" id="friday_start"
											name="friday_start">
											<option value="" selected disabled>선택해주세요.</option>
											<c:forEach var="r" begin="1" end="24">
												<option value="${r}">${r }시</option>
											</c:forEach>
										</select> ~ <select disabled="disabled" id="friday_end"
											name="friday_end">
											<option value="" selected disabled>선택해주세요.</option>
											<c:forEach var="r" begin="1" end="24">
												<option value="${r}">${r }시</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="body-times">
								<div class="body-time-days">
									<div class="body-time-day">
										<input type="checkbox" name="saturday" id="saturday"
											value="saturday"> 토요일
									</div>
									<div class="body-time-day">
										<select disabled="disabled" id="saturday_start"
											name="saturday_start">
											<option value="" selected disabled>선택해주세요.</option>
											<c:forEach var="r" begin="1" end="24">
												<option value="${r}">${r }시</option>
											</c:forEach>
										</select> ~ <select disabled="disabled" id="saturday_end"
											name="saturday_end">
											<option value="" selected disabled>선택해주세요.</option>
											<c:forEach var="r" begin="1" end="24">
												<option value="${r}">${r }시</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="body-time-days">
									<div class="body-time-day">
										<input type="checkbox" name="sunday" id="sunday"
											value="sunday"> 일요일
									</div>
									<div class="body-time-day">
										<select disabled="disabled" id="sunday_start"
											name="sunday_start">
											<option value="" selected disabled>선택해주세요.</option>
											<c:forEach var="r" begin="1" end="24">
												<option value="${r}">${r }시</option>
											</c:forEach>
										</select> ~ <select disabled="disabled" id="sunday_end"
											name="sunday_end">
											<option value="" selected disabled>선택해주세요.</option>
											<c:forEach var="r" begin="1" end="24">
												<option value="${r}">${r }시</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<button>등록 완료</button>
			</div>


			<!-- 전체 컨테이너 끝 -->
		</div>


	</form>

</body>
</html>