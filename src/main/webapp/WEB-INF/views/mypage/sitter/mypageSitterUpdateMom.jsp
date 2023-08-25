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

		const ms_monday = '${msInfo.monday}';
		const ms_tuesday = '${msInfo.tuesday}';
		const ms_wednesday = '${msInfo.wednesday}';
		const ms_thursday = '${msInfo.thursday}';
		const ms_friday = '${msInfo.friday}';
		const ms_saturday = '${msInfo.saturday}';
		const ms_sunday = '${msInfo.sunday}';

		if (ms_monday === 'monday') {
			$("#monday").attr('checked', true);
			document.getElementById('monday_start').disabled = false;
			document.getElementById('monday_end').disabled = false;
			$('#monday_start').val('${msInfo.monday_start}');
			$('#monday_end').val('${msInfo.monday_end}');
		}
		if (ms_tuesday === 'tuesday') {
			$("#tuesday").attr('checked', true);
			document.getElementById('tuesday_start').disabled = false;
			document.getElementById('tuesday_end').disabled = false;
			$('#tuesday_start').val('${msInfo.tuesday_start}');
			$('#tuesday_end').val('${msInfo.tuesday_end}');
		}
		if (ms_wednesday === 'wednesday') {
			$("#wednesday").attr('checked', true);
			document.getElementById('wednesday_start').disabled = false;
			document.getElementById('wednesday_end').disabled = false;
			$('#wednesday_start').val('${msInfo.wednesday_start}');
			$('#wednesday_end').val('${msInfo.wednesday_end}');
		}
		if (ms_thursday === 'thursday') {
			$("#thursday").attr('checked', true);
			document.getElementById('thursday_start').disabled = false;
			document.getElementById('thursday_end').disabled = false;
			$('#thursday_start').val('${msInfo.thursday_start}');
			$('#thursday_end').val('${msInfo.thursday_end}');
		}
		if (ms_friday === 'friday') {
			$("#friday").attr('checked', true);
			document.getElementById('friday_start').disabled = false;
			document.getElementById('friday_end').disabled = false;
			$('#friday_start').val('${msInfo.friday_start}');
			$('#friday_end').val('${msInfo.friday_end}');
		}
		if (ms_saturday === 'saturday') {
			$("#saturday").attr('checked', true);
			document.getElementById('saturday_start').disabled = false;
			document.getElementById('saturday_end').disabled = false;
			$('#saturday_start').val('${msInfo.saturday_start}');
			$('#saturday_end').val('${msInfo.saturday_end}');
		}
		if (ms_sunday === 'sunday') {
			$("#sunday").attr('checked', true);
			document.getElementById('sunday_start').disabled = false;
			document.getElementById('sunday_end').disabled = false;
			$('#sunday_start').val('${msInfo.sunday_start}');
			$('#sunday_end').val('${msInfo.sunday_end}');
		}

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

		const ms_cctv = '${msInfo.ms_cctv}';
		if (ms_cctv === '1') {
			$("#ms_cctv_on").attr('checked', true);
		} else {
			$("#ms_cctv_off").attr('checked', true);
		}

		const ms_term = '${msInfo.ms_term}';
		if (ms_term === '1') {
			$("#ms_term_long").attr('checked', true);
		} else {
			$("#ms_term_short").attr('checked', true);
		}

		const ms_act = '${msInfo.ms_can_do}';
		if (ms_act % 2 === 0) {
			$("#ms_act_1st").attr('checked', true);
		}
		if (ms_act % 3 === 0) {
			$("#ms_act_2nd").attr('checked', true);
		}
		if (ms_act % 5 === 0) {
			$("#ms_act_3rd").attr('checked', true);
		}
		if (ms_act % 7 === 0) {
			$("#ms_act_4th").attr('checked', true);
		}
		if (ms_act % 11 === 0) {
			$("#ms_act_5th").attr('checked', true);
		}
		if (ms_act % 13 === 0) {
			$("#ms_act_6th").attr('checked', true);
		}
		if (ms_act % 17 === 0) {
			$("#ms_act_7th").attr('checked', true);
		}
		if (ms_act % 19 === 0) {
			$("#ms_act_8th").attr('checked', true);
		}

		const ms_type = '${msInfo.ms_can_type}';
		if (ms_type % 2 === 0) {
			$("#ms_type_1st").attr('checked', true);
		}
		if (ms_type % 3 === 0) {
			$("#ms_type_2nd").attr('checked', true);
		}
		if (ms_type % 5 === 0) {
			$("#ms_type_3rd").attr('checked', true);
		}
		if (ms_type % 7 === 0) {
			$("#ms_type_4th").attr('checked', true);
		}

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

	<form action="momsitter.update" method="post" enctype="multipart/form-data">

		<!-- 전체 컨테이너 -->
		<div class="mpS-pet">
			<!-- 내용의 전체 div -->
			<div class="mpS-pet-sub">
				<!-- 로고 -->
				<div class="mpS-logo">
					<img id="mpS-logo" alt="" src="resources/img/mypage/MOSI-logo.png">
				</div>

				<div>${userInfo.user_name}님의 정보를 수정해주세요</div>
				<div>필요한 서류를 등록해주세요</div>
				<div>필요하시다면 서류를 다시 등록해주세요 ※인증이 완료되신 경우에도 서류를 다시 제출하시면 다시 인증절차를
					밟게 됩니다 참고바랍니다</div>
				<div>
					<input type="file" name="ms_Rfile"
						style="background-color: #D9D9D9; color: black; border: none; border-radius: 5px; padding: 5px; width: 225px;">
					<input hidden="hidden" name="ms_file" value="${msInfo.ms_file }">
					<input hidden="hidden" name="ms_confirm"
						value="${msInfo.ms_confirm }"> <input hidden="hidden"
						name="ms_confirm_answer" value="${msInfo.ms_confirm_answer }">
				</div>

				<!-- 정보입력 -->
				<div class="mpS-pet-inform2">할 수 있는 케어 종류를 선택해주세요</div>
				<div style="text-align: center;">
					희망 지역1은 필수입력입니다
					<div>
						희망지역 1 <input name="ms_location1"
							style="width: 300px; border: none; border-radius: 10px;" value="${msInfo.ms_location1 }">
					</div>
					<div>
						희망지역 2 <input name="ms_location2"
							style="width: 300px; border: none; border-radius: 10px;" value="${msInfo.ms_location2 }">
					</div>
					<div>
						희망지역 3 <input name="ms_location3"
							style="width: 300px; border: none; border-radius: 10px;" value="${msInfo.ms_location3 }">
					</div>
				</div>
				<div>
					<input type="radio" name="ms_cctv" value="1" id="ms_cctv_on">
					cctv촬영도 괜찮아요 <input type="radio" name="ps_cctv" value="2" id="ms_cctv_off">
					cctv촬영 없는 곳을 원해요
				</div>
				<div>
					<input type="radio" name="ms_term" value="1" id="ms_term_long" >
					정기적 계약을 원해요 <input type="radio" name="ps_term" value="2" id="ms_term_short">
					단발성 계약을 원해요
				</div>
				<div>원하시는 시급을 입력해주세요</div>
				<div>
					<input name="ms_pay" value="${msInfo.ms_pay }"
						style="width: 200px; border: none; border-radius: 10px;">
				</div>

				<div>
					<textarea rows="" cols="" name="ms_exp" placeholder="관련 경험을 적어주세요"
						style="width: 620px; height: 300px; border: none; border-radius: 10px;">${msInfo.ms_exp}</textarea>
				</div>

				<div class="mpS-pet-inform1">이런 아이에게 도움을 줄 수 있어요!</div>
				<div class="mpS-pet-act">
					<div class="mpS-pet-act-bottom">
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/신생아.png"
								style="width: 70px; height: 80px;">
							<div>
								<input type="checkbox" name="ms_type" value="2" id="ms_type_1st"> 신생아
							</div>
						</div>
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/영아.png"
								style="width: 70px; height: 80px;">
							<div>
								<input type="checkbox" name="ms_type" value="3"id="ms_type_2nd"> 영아
							</div>
						</div>
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/유아.png"
								style="width: 70px; height: 80px;">
							<div>
								<input type="checkbox" name="ms_type" value="5"id="ms_type_3rd"> 유아
							</div>
						</div>
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/초등학생.png"
								style="width: 70px; height: 80px;">
							<div>
								<input type="checkbox" name="ms_type" value="7" id="ms_type_4th"> 초등학생
							</div>
						</div>
					</div>
				</div>


				<div class="mpS-pet-inform1">아이에게 이런 활동을 시켜줄 수 있어요!</div>
				<div class="mpS-pet-act">
					<div class="mpS-pet-act-bottom">
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/실내놀이.png"
								style="width: 70px;">
							<div>
								<input type="checkbox" name="momsitter_act" value="2" id="ms_act_1st">
								실내놀이
							</div>
						</div>
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/야외놀이.png"
								style="width: 70px;">
							<div>
								<input type="checkbox" name="momsitter_act" value="3" id="ms_act_2nd">
								야외놀이
							</div>
						</div>
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/밥챙겨주기.png"
								style="width: 70px;">
							<div>
								<input type="checkbox" name="momsitter_act" value="5" id="ms_act_3rd">
								밥챙겨주기
							</div>
						</div>
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/등하원.png" style="width: 70px;">
							<div>
								<input type="checkbox" name="momsitter_act" value="7" id="ms_act_4th">
								등하원돕기
							</div>
						</div>
					</div>
					<div class="mpS-pet-act-bottom">
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/영어.png" style="width: 70px;">
							<div>
								<input type="checkbox" name="momsitter_act" value="11" id="ms_act_5th">
								영어공부
							</div>
						</div>
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/독서.png" style="width: 70px;">
							<div>
								<input type="checkbox" name="momsitter_act" value="13" id="ms_act_6th">
								한글공부
							</div>
						</div>
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/똥.png" style="width: 70px;">
							<div>
								<input type="checkbox" name="momsitter_act" value="17" id="ms_act_7th">
								대소변
							</div>
						</div>
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/기타.png" style="width: 70px;">
							<div>
								<input type="checkbox" name="momsitter_act" value="19" id="ms_act_8th">
								기타활동
							</div>
						</div>
					</div>
				</div>
				<div>
					<textarea rows="10" cols="50" placeholder="추가사항이 있다면 이곳에 적어주세요!"
						name="ms_extra"
						style="width: 620px; border: none; border-radius: 10px;">${msInfo.ms_extra}</textarea>
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
				<button>수정 완료</button>
			</div>


			<!-- 전체 컨테이너 끝 -->
		</div>


	</form>

</body>
</html>