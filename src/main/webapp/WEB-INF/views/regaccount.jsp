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
	$(function() {

		var email_auth_cd = '';

		$('#join').click(function() {

			if ($('#id').val() == "") {
				alert("아이디를 입력해주세요.");
				return false;
			}

			if ($('#nickname').val() == "") {
				alert("이름을 입력해주세요.");
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

			if ($('#email_auth_key').val() != email_auth_cd) {
				alert("인증번호가 일치하지 않습니다.");
				return false;
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
					});
				});

		$('#id').focusout(function() {
			var id = $('#id').val();

			$.ajax({
				type : "POST",
				url : "/idCheck",
				data : {
					id : id
				},
				success : function(data) {
					console.log(data);
					if (data == "Y") {
						$('#id_ck').removeClass("dpn");
					} else {
						$('#id_ck').addClass("dpn");
					}
				},
				error : function(data) {
				}
			});
		});

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
	font-size: 25px;
	font-weight: 400;
	text-align: left;
}

.normal_input {
	width: 680px;
	height: 60px;
	font-size: 15pt;
	font-weight: 400;
	background-color: #D9D9D9;
	color: black;
	border-radius: 5%;
	border: none;
}

.phone_input {
	width: 200px;
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
					action="regAccount.do">
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
							<div>
								<input type="password" placeholder="비밀번호" name="user_pw"
									class="normal_input" id="password">
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
							<div>
								<input name="user_gender" type="radio" checked="checked"
									value="male"> 남 <input name="user_gender" type="radio"
									value="female"> 여
							</div>
						</div>
						<br>
						<div>
							<div class="join_column">전화번호</div>
							<div>
								<input name="phone_first" class="phone_input"> - <input
									name="phone_second" class="phone_input"> - <input
									name="phone_third" class="phone_input">
							</div>
						</div>
						<br>
						<div>
							<div class="join_column">주소</div>
							<div>
								<input name="user_location" placeholder="주소"
									class="normal_input">
							</div>
						</div>
						<br>
						<div>
							<div class="join_column">프로필 사진</div>
							<div>
								<input type="file" name="pic">
							</div>
						</div>
						<br>
						<div class="email_auth">
							<div class="join_column">이메일</div>
							<div style="display: flex; justify-content: center;">
								<div>
									<input type="text" placeholder="이메일" name="user_email"
										id="user_email" class="email_input"> <br> <br>
									<input type="text" class="email_input" placeholder="인증번호 입력"
										id="email_auth_key" name="user_email_authkey">
								</div>
								<div class="blank-area"></div>
								<div>
									<button id="email_auth_btn" class="email_auth_btn" type="button"
										style="width: 105px; height: 148px; border-radius: 15%; background-color: #E7B5AC; border: none;">
										인증번호 <br> 받기
									</button>
								</div>
							</div>
						</div>
					</div>
					<br>
					<button id="join" class="join_btn"
						style="width: 100px; height: 50px; background-color: #E7B5AC; border: none; border-radius: 10px;">가입하기</button>
				</form>
			</div>
		</div>

	</div>


</body>


</html>