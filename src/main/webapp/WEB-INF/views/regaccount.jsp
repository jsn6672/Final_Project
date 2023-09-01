<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>

<script type="text/javascript" src="resources/js/member/validCheck.js"></script>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	/**
	 *  회원가입 관련 처리
	 */
<%-- 
	function fn_join() {
		var f = $('#join_frm');
		var formData = f.serialize();

		$.ajax({
			type : "POST",
			url : "/join",
			data : formData,
			success : function(data) {
				if (data == "Y") {
					alert("회원가입이 완료되었습니다.");
					location.href = "/"
				} else {
					alert("회원가입에 실패하였습니다.");
				}
			},
			error : function(data) {
				alert("회원가입 에러 발생!");
				console.log(data);
			}
		});
	}
	--%>
	function connectAddrSearchEvent() {
		$("#addrSearchBtn").click(function() {
			new daum.Postcode({
				oncomplete : function(data) {
					$("#jm_addr3Input").val(data.zonecode);
					$("#jm_addr1Input").val(data.roadAddress);
				}
			}).open();
		});
	}

	$(function() {

		connectAddrSearchEvent();
		$("#openeye").show();
		$("#closeeye").hide();

		$("#openeye").click(function() {
			$("#openeye").hide();
			$("#closeeye").show();
			$('#password').attr("type", "text");
			$('#password_ck').attr("type", "text");
		})
		$("#closeeye").click(function() {
			$("#openeye").show();
			$("#closeeye").hide();
			$('#password').attr("type", "password");
			$('#password_ck').attr("type", "password");
		})

		var email_auth_cd = '';

		$('#join')
				.click(
						function() {

							if ($('#nickname').val() == "") {
								alert("이름을 입력해주세요.");
								return false;
							}
							var userAge = parseInt($('#user_age').val(), 10); // 문자열을 정수로 변환
							console.log(userAge);
							if (isNaN(userAge) || userAge < 10000000) {
							    alert("생년월일 8자리(예시)20020717)를 입력해주세요.");
							    return false;
							}

							if ($('#password').val() == "") {
								alert("비밀번호를 입력해주세요.");
								return false;
							}

							if ($('#password').val() != $('#password_ck').val()) {
								alert("비밀번호가 일치하지 않습니다.");
								return false;
							}

							if ($('#phone_first').val() == ""
									|| $('#phone_second').val() == ""
									|| $('#phone_third').val() == "") {
								alert("전화번호를 입력해주세요.");
								return false;
							}

							if ($('#email_auth_key').val() != email_auth_cd
									|| $('#email_auth_key').val() == "") {
								alert("인증번호가 일치하지 않습니다.");
								return false;
							}

							if ($("#id_ck").css("color") === "rgb(255, 0, 0)") {
								alert("아이디를 확인해주세요.");
								return false;
							}

							if ($("#user_pic").val() != "") {
								var ext = $('#user_pic').val().split('.').pop()
										.toLowerCase();
								if ($.inArray(ext, [ 'gif', 'png', 'jpg',
										'jpeg' ]) == -1) {
									alert('등록 할수 없는 파일명입니다.');
									$("#user_pic").val(""); // input file 파일명을 다시 지워준다.
									return false;
								}
							}
<%--
			fn_join();
			--%>
	});

		$(".email_auth_btn").click(
				function() {
					var user_email = $('#user_email').val();

					if (user_email == '') {
						alert("이메일을 입력해주세요.");
						return false;
					}

					console.log(user_email);
					$.ajax({
						type : "POST",
						url : "emailAuth",
						data : {
							"user_email" : user_email
						},
						success : function(data) {
							alert("인증번호가 발송되었습니다.");
							console.log(data);
							email_auth_cd = data;
						},
						error : function(request, status, error) {
							console.log("code:" + request.status + "\n"
									+ "message:" + request.responseText + "\n"
									+ "error:" + error);
						}
					}); //이메일인증 ajax
				}); //인증버튼 클릭

		$('#user_email')
				.blur(
						function() {
							$("#email_ck").text("");
							$("#email_ck").css("color", "blue");
							var user_email2 = document.join_member.user_email;
							var user_email = $('#user_email').val();
							console.log(user_email);

							console.log('이건 empty ' + isEmpty(user_email2));
							console.log('이건 한글탐지 ' + containsHS(user_email2));

							if (isEmpty(user_email2)) {
								$("#email_ck").text("이메일은 필수로 입력해주셔야 합니다");
								$("#email_ck").css("color", "red");
								$('#user_email').focus();
								return false;
							}

							$
									.ajax({
										type : "POST",
										url : "emailCheck",
										data : {
											"user_email" : user_email
										},
										success : function(data) {
											console.log(data);
											if (data == "1") {
												$("#email_ck").text(
														"이 이메일은 있는 이메일입니다");
												$("#email_ck").css("color",
														"red");
												document
														.getElementById('email_auth_btn').disabled = true;
											} else {
												$("#email_ck").text(
														"사용가능한 이메일입니다");
												document
														.getElementById('email_auth_btn').disabled = false;
											}
										},
										error : function(data) {
											console.log('여기는 이메일, 여기서 에러가 나네용')
										}
									}); //emailcheck ajax
						}); //email blur

		$('#id').blur(function() {
			$("#id_ck").text("");
			$("#id_ck").css("color", "blue");
			var user_id2 = document.join_member.user_id;
			var user_id = $('#id').val();
			console.log(user_id);

			console.log('이건 empty ' + isEmpty(user_id2));
			console.log('이건 한글탐지 ' + containsHS(user_id2));

			if (isEmpty(user_id2) || containsHS(user_id2)) {
				$("#id_ck").text("아이디는 영어, 숫자로만 만들어야 합니다");
				$("#id_ck").css("color", "red");
				$('#id').focus();
				return false;
			}

			$.ajax({
				type : "POST",
				url : "idCheck",
				data : {
					"user_id" : user_id
				},
				success : function(data) {
					console.log(data);
					if (data == "1") {
						$("#id_ck").text("이 아이디는 있는 아이디입니다");
						$("#id_ck").css("color", "red");
					} else {
						$("#id_ck").text("사용가능한 아이디입니다");
					}
				},
				error : function(data) {
					console.log('여기서 에러가 나네용')
				}
			}); //idcheck ajax
		}); //id blur

	}); // 레디 펑션
</script>

<style type="text/css">
body {
	background-color: #FFEBE4BD;
	font-size: 15pt;
}

.content {
	height: 2000px;
	text-align: center;
}

.div-brand-logo-img {
	text-align: center;
}

.brand-logo-img {
	width: 330px;
	margin-top: 5%;
}

.join_content {
	display: flex;
	justify-content: center;
}

.join_wrap {
	width: 700px;
	text-align: center;
}

.join_box {
	
}

.join_column {
	font-size: 15px;
	font-weight: 400;
	text-align: left;
}

.normal_input {
	width: 680px;
	height: 60px;
	font-size: 11pt;
	font-weight: 400;
	background-color: #D9D9D9;
	color: black;
	border: none;
}

#passworddiv {
	position: relative;
}

#openeyediv {
	position: absolute;
	right: 20px;
	top: 0;
}

#openeye {
	width: 60px;
}

#closeeye {
	width: 60px;
}

#closeeyediv {
	position: absolute;
	right: 20px;
	top: 0;
}

.gender_input {
	width: 1.25em;
	height: 1.25em;
}

.phone_input {
	width: 220px;
	height: 60px;
	font-size: 15pt;
	font-weight: 400;
	background-color: #D9D9D9;
	color: black;
	border-radius: 5%;
	border: none;
}

.email_input {
	width: 550px;
	height: 60px;
	font-size: 15pt;
	font-weight: 400;
	background-color: #D9D9D9;
	color: black;
	border-radius: 5%;
	border: none;
}

.blank-area {
	width: 2%;
}
</style>
</head>
<body>
	<div class="content">
		<div class="div-brand-logo-img">
			<a href="go.home" class="brand-logo"> <img class="brand-logo-img"
				src="resources/img/logo2.png" alt="Logo">
			</a>
		</div>
		<div class="join_content">
			<div class="join_wrap">
				<form id="join_frm" method="post" enctype="multipart/form-data"
					action="regAccount.do" name="join_member">
					<div class="join_title" style="font-size: 35pt; font-weight: 400">회원가입</div>
					<br>
					<div class="join_box">
						<div>
							<div class="join_column">아이디</div>
							<div>
								<input type="text" placeholder="아이디" name="user_id" id="id"
									class="normal_input"> <span id="id_ck"></span>
							</div>
						</div>
						<br>
						<div>
							<div class="join_column">이름</div>
							<div>
								<input type="text" placeholder="이름" name="user_name"
									class="normal_input">
							</div>
						</div>
						<br>
						<div>
							<div class="join_column">비밀번호</div>
							<div id="passworddiv">
								<input type="password" placeholder="비밀번호" name="user_pw"
									class="normal_input" id="password">
								<div id="openeyediv">
									<img src="resources/img/openeye.png" id="openeye">
								</div>
								<div id="closeeyediv">
									<img src="resources/img/closeeye.png" id="closeeye">
								</div>
							</div>
						</div>
						<br>
						<div>
							<div class="join_column">비밀번호 확인</div>
							<div>
								<input type="password" placeholder="비밀번호  확인" id="password_ck"
									class="normal_input">
							</div>
						</div>
						<br>
						<div>
							<div class="join_column">성별</div>
							<div style="display: flex; justify-content: space-evenly;">
								<div>
									<input name="user_gender" type="radio" checked="checked"
										value="male" class="gender_input"> 남
								</div>
								<div>
									<input name="user_gender" type="radio" value="female"
										class="gender_input"> 여
								</div>
							</div>
						</div>
						<br>
						<div>
							<div class="join_column">나이</div>
							<div>
								<input placeholder="생년월일 8자리를 입력해주세요 (YYYYMMDD)" name="user_age" id="user_age"
									class="normal_input">
							</div>
						</div>
						<br>
						<div>
							<div class="join_column">전화번호</div>
							<div>
								<input name="phone_first" class="phone_input" id="phone_first">
								- <input name="phone_second" class="phone_input"
									id="phone_second"> - <input name="phone_third"
									class="phone_input" id="phone_third">
							</div>
						</div>
						<br>
						<div>
							<div class="join_column">주소</div>
							<div>
								<input id="jm_addr3Input" readonly="readonly" name="m_addr3"
									class="normal_input" maxlength="5" autocomplete="off"
									style="width: 620px;" placeholder="우편번호"> <span
									id="addrSearchBtn">[검색]</span><br> <br> <input
									id="jm_addr1Input" readonly="readonly" name="m_addr1"
									maxlength="30" autocomplete="off" placeholder="주소"
									class="normal_input"><br> <br> <input 
									name="m_addr2" maxlength="30" autocomplete="off"
									class="normal_input" placeholder="상세주소" id="jm_addr2Input">

							</div>
						</div>
						<br>
						<div>
							<div class="join_column">프로필 사진</div>
							<div>
								<input type="file" name="pic" accept="image/*" id="user_pic">
							</div>
						</div>
						<br>
						<div class="email_auth">
							<div class="join_column">이메일</div>
							<div style="display: flex; justify-content: center;">
								<div>
									<input type="text" placeholder="이메일" name="user_email"
										id="user_email" class="email_input"> <br> <span
										id="email_ck"></span> <br> <input type="text"
										class="email_input" placeholder="인증번호 입력" id="email_auth_key"
										name="user_email_authkey">
								</div>
								<div class="blank-area"></div>
								<div>
									<button id="email_auth_btn" class="email_auth_btn"
										type="button" disabled="disabled"
										style="width: 105px; height: 148px; border-radius: 15%; background-color: #E7B5AC; border: none;">
										인증번호 <br> 받기
									</button>
								</div>
							</div>
						</div>
					</div>
					<br>
					<button id="join" class="join_btn"
						style="width: 120px; height: 50px; background-color: #E7B5AC; border: none; border-radius: 10px;">가입하기</button>
				</form>
			</div>
		</div>

	</div>


</body>


</html>