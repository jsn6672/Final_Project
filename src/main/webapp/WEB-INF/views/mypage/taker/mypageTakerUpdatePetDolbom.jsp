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
		
		const d_monday = '${dolbomInfo.monday}';
		const d_tuesday = '${dolbomInfo.tuesday}';
		const d_wednesday = '${dolbomInfo.wednesday}';
		const d_thursday = '${dolbomInfo.thursday}';
		const d_friday = '${dolbomInfo.friday}';
		const d_saturday = '${dolbomInfo.saturday}';
		const d_sunday = '${dolbomInfo.sunday}';
		
		if (d_monday === 'monday') {
			$("#monday").attr('checked', true);
			document.getElementById('monday_start').disabled = false;
			document.getElementById('monday_end').disabled = false;
			$('#monday_start').val('${dolbomInfo.monday_start}');
			$('#monday_end').val('${dolbomInfo.monday_end}');
		}
		if (d_tuesday === 'tuesday') {
			$("#tuesday").attr('checked', true);
			document.getElementById('tuesday_start').disabled = false;
			document.getElementById('tuesday_end').disabled = false;
			$('#tuesday_start').val('${dolbomInfo.tuesday_start}');
			$('#tuesday_end').val('${dolbomInfo.tuesday_end}');
		}
		if (d_wednesday === 'wednesday') {
			$("#wednesday").attr('checked', true);
			document.getElementById('wednesday_start').disabled = false;
			document.getElementById('wednesday_end').disabled = false;
			$('#wednesday_start').val('${dolbomInfo.wednesday_start}');
			$('#wednesday_end').val('${dolbomInfo.wednesday_end}');
		}
		if (d_thursday === 'thursday') {
			$("#thursday").attr('checked', true);
			document.getElementById('thursday_start').disabled = false;
			document.getElementById('thursday_end').disabled = false;
			$('#thursday_start').val('${dolbomInfo.thursday_start}');
			$('#thursday_end').val('${dolbomInfo.thursday_end}');
		}
		if (d_friday === 'friday') {
			$("#friday").attr('checked', true);
			document.getElementById('friday_start').disabled = false;
			document.getElementById('friday_end').disabled = false;
			$('#friday_start').val('${dolbomInfo.friday_start}');
			$('#friday_end').val('${dolbomInfo.friday_end}');
		}
		if (d_saturday === 'saturday') {
			$("#saturday").attr('checked', true);
			document.getElementById('saturday_start').disabled = false;
			document.getElementById('saturday_end').disabled = false;
			$('#saturday_start').val('${dolbomInfo.saturday_start}');
			$('#saturday_end').val('${dolbomInfo.saturday_end}');
		}
		if (d_sunday === 'sunday') {
			$("#sunday").attr('checked', true);
			document.getElementById('sunday_start').disabled = false;
			document.getElementById('sunday_end').disabled = false;
			$('#sunday_start').val('${dolbomInfo.sunday_start}');
			$('#sunday_end').val('${dolbomInfo.sunday_end}');
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

		const gender = '${dolbomInfo.d_gender}';

		console.log(gender);
		if (gender === 'male') {
			$("#gender_male").attr('checked', true);
		} else if (gender === 'female') {
			$("#gender_female").attr('checked', true);
		} else {
			$("#gender_neut").attr('checked', true);
		}

		const d_check = '${dolbomInfo.d_check}';
		if (d_check === '1') {
			$("#d_check").attr('checked', true);
		}

		const d_cctv = '${dolbomInfo.d_cctv}';
		if (d_cctv === '1') {
			$("#d_cctv_on").attr('checked', true);
		} else {
			$("#d_cctv_off").attr('checked', true);
		}

		const d_term = '${dolbomInfo.d_term}';
		if (d_term === '1') {
			$("#d_term_long").attr('checked', true);
		} else {
			$("#d_term_short").attr('checked', true);
		}
		
		const d_act = '${dolbomInfo.d_can_do}';
		if (d_act % 2 === 0) {
			$("#d_act_1st").attr('checked', true);
		}
		if (d_act % 3 === 0) {
			$("#d_act_2nd").attr('checked', true);
		}
		if (d_act % 5 === 0) {
			$("#d_act_3rd").attr('checked', true);
		}
		if (d_act % 7 === 0) {
			$("#d_act_4th").attr('checked', true);
		}
		if (d_act % 11 === 0) {
			$("#d_act_5th").attr('checked', true);
		}
		if (d_act % 13 === 0) {
			$("#d_act_6th").attr('checked', true);
		}
		if (d_act % 17 === 0) {
			$("#d_act_7th").attr('checked', true);
		}
		if (d_act % 19 === 0) {
			$("#d_act_8th").attr('checked', true);
		}

		 // 하나 이상의 체크박스가 선택되었는지 확인하는 함수
	    function isAtLeastOneCheckboxChecked(checkboxes) {
	        for (let i = 0; i < checkboxes.length; i++) {
	            if (checkboxes[i].checked) {
	                return true;
	            }
	        }
	        return false;
	    }

	    // 폼 제출 전 유효성을 검사하는 함수
	    function validateForm() {
	    	console.log("일단 여기 오는지 확인");
	        const careActivityCheckboxes = document.querySelectorAll('input[name="dolbom_act"]');
	        
	        const isCareActivityChecked = isAtLeastOneCheckboxChecked(careActivityCheckboxes);

	        if (!isCareActivityChecked) {
	            alert("폼을 제출하기 전에 최소한 하나 이상의 활동을 선택해주세요.");
	            return false; // 폼 제출 방지
	        }

	        return true; // 폼 제출 허용
	    }

	    // 폼 제출 이벤트에 유효성 검사 함수를 연결합니다.
	    $('form').on('submit', validateForm);
	    
	    function validateActivityTime() {
	        const activityCheckboxes = document.querySelectorAll(
	            'input[name^="monday"], ' +
	            'input[name^="tuesday"], ' +
	            'input[name^="wednesday"], ' +
	            'input[name^="thursday"], ' +
	            'input[name^="friday"], ' +
	            'input[name^="saturday"], ' +
	            'input[name^="sunday"]'
	        );

	        for (let i = 0; i < activityCheckboxes.length; i++) {
	            if (activityCheckboxes[i].checked) {
	                return true;
	            }
	        }

	        return false;
	    }

	    $('form').on('submit', function(event) {
	        if (!validateActivityTime()) {
	            event.preventDefault();
	            alert('하나 이상의 요일을 선택해주세요');
	        }
	    });
		
		
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

	<form action="updatePetDolbom.do" method="post"
		enctype="multipart/form-data">

		<!-- 전체 컨테이너 -->
		<div class="mpS-pet">
			<!-- 내용의 전체 div -->
			<div class="mpS-pet-sub">
				<!-- 로고 -->
				<div class="mpS-logo">
					<img id="mpS-logo" alt="" src="resources/img/mypage/MOSI-logo.png">
				</div>

				<!-- 정보입력 -->
				<div class="mpS-pet-inform2"
					style="margin: 10px; text-align: center;">반려동물의 정보를 수정해주세요!</div>
				<div>반려동물의 이름을 입력해주세요</div>
				<input hidden="hidden" name="d_no" value="${dolbomInfo.d_no }">
				<div>
					<input placeholder="이름을 입력해주세요" name="d_name"
						value="${dolbomInfo.d_name }"
						style="border: none; border-radius: 10px;">
				</div>
				<input hidden="hidden" name="d_category" value="3">
				<div class="mpS-pet-birth">아이의 생년 / 월</div>
				<div>
					<input placeholder="아이가 태어난 해를 입력해주세요 (YYYY)" class="birth_input"
						value="${dolbomInfo.d_year}" name="d_year"> <input
						placeholder="아이가 태어난 달을 입력해주세요" class="birth_input" name="d_month"
						value="${dolbomInfo.d_month }">
				</div>
				<div class="mpS-pet-gender">
					<input type="radio" name="d_gender" value="male" id="gender_male">남아
					<input type="radio" name="d_gender" value="female"
						id="gender_female">여아 <input type="radio" name="d_gender"
						value="neut" id="gender_neut">중성화 완료
				</div>

				<div>
					<div style="display: flex;">
						<div class="join_column">주소</div>
						<div>
							<input type="checkbox" id="sameaddr"> 보호자의 주소와 같습니다
						</div>
					</div>
					<div>
						<input id="jm_addr3Input" readonly="readonly" name="m_addr3"
							class="normal_input" maxlength="5" autocomplete="off"
							value="${dolbomInfo.m_addr3 }" placeholder="우편번호"> <span
							id="addrSearchBtn">[검색]</span><br> <br> <input
							id="jm_addr1Input" readonly="readonly"
							value="${dolbomInfo.m_addr1 }" name="m_addr1" maxlength="30"
							autocomplete="off" placeholder="주소" class="normal_input"><br>
						<br> <input name="m_addr2" maxlength="30" autocomplete="off"
							class="normal_input" placeholder="상세주소" id="jm_addr2Input"
							value="${dolbomInfo.m_addr2 }">
					</div>
				</div>
				<div>
					<input type="checkbox" name="d_check" value="1" id="d_check">
					알러지 또는 주의할 점이 있어요!
				</div>
				<div>
					<input type="radio" name="d_cctv" value="1" id="d_cctv_on">
					cctv촬영이 필요해요 <input type="radio" name="d_cctv" value="2"
						id="d_cctv_off"> cctv촬영은 안할거에요
				</div>
				<div>
					<input type="radio" name="d_term" value="1" id="d_term_long">
					정기적 계약을 원해요 <input type="radio" name="d_term" value="2"
						id="d_term_short"> 단발성 계약을 원해요
				</div>
				<div>반려동물의 성격은 다음과 같아요</div>
				<div>
					<textarea rows="10" cols="50" name="d_personality"
						placeholder="성격을 간단히 입력해주세요(ex)사나움, 온순함, 사람을 무서워함, 사람을 너무 좋아함 등등)"
						style="width: 670px; border-radius: 10px; border: none"> ${dolbomInfo.d_personality}</textarea>
				</div>

				<div class="mpS-pet-inform1">반려동물에게 이런 활동이 필요해요!</div>

				<div class="mpS-pet-act">
					<div class="mpS-pet-act-bottom">
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/산책.png" style="width: 70px;">
							<div>
								<input type="checkbox" name="dolbom_act" value="2"
									id="d_act_1st">산책
							</div>
						</div>
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/목욕.png" style="width: 70px;">
							<div>
								<input type="checkbox" name="dolbom_act" value="3"
									id="d_act_2nd"> 목욕
							</div>
						</div>
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/사료.png" style="width: 70px;">
							<div>
								<input type="checkbox" name="dolbom_act" value="5"
									id="d_act_3rd"> 밥챙겨주기
							</div>
						</div>
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/호텔.png" style="width: 70px;">
							<div>
								<input type="checkbox" name="dolbom_act" value="7"
									id="d_act_4th"> 호텔링
							</div>
						</div>
					</div>
					<div class="mpS-pet-act-bottom">
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/배변훈련.png"
								style="width: 70px;">
							<div>
								<input type="checkbox" name="dolbom_act" value="11"
									id="d_act_5th"> 배변훈련
							</div>
						</div>
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/배변훈련.png"
								style="width: 70px;">
							<div>
								<input type="checkbox" name="dolbom_act" value="13"
									id="d_act_6th"> 놀이훈련
							</div>
						</div>
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/놀이훈련.png"
								style="width: 70px;">
							<div>
								<input type="checkbox" name="dolbom_act" value="17"
									id="d_act_7th"> 사회화훈련
							</div>
						</div>
						<div class="mpS-pet-act-detail">
							<img alt="" src="resources/img/logo/기타.png" style="width: 70px;">
							<div>
								<input type="checkbox" name="dolbom_act" value="19"
									id="d_act_8th"> 기타활동
							</div>
						</div>
					</div>
				</div>
				<div>
					<textarea rows="10" cols="50" placeholder="추가사항이 있다면 이곳에 적어주세요!"
						name="d_need"
						style="width: 670px; border-radius: 10px; border: none">${dolbomInfo.d_need}</textarea>
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
				<button style="margin: 20px;">수정 완료</button>
			</div>


			<!-- 전체 컨테이너 끝 -->
		</div>


	</form>



</body>
</html>