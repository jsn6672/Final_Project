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
	$(function() {

		var email_auth_cd = '';

		$('#email_auth').click(function() {
			console.log(email_auth_cd);
			var user_email = $(".user_email").val();

			if ($('#email_auth_key').val() != email_auth_cd) {
				alert("인증번호가 일치하지 않습니다.");
				return false;
			}
			console.log(user_email);
			location.href = 'pwchange.go?user_email=' + user_email;
		});

		$(".emailcheck").click(function() {
			var user_email = $(".user_email").val();
			$.ajax({
				type : "get",
				url : "email_check",
				data : {
					"user_email" : user_email
				},
				success : function(data) {
					if (data >= 1) {
						alert('오 이건 있는 이메일이네용 ㅊㅋ');
						document.getElementById('user_email').readOnly = true;
						console.log(user_email);
						successcall(user_email);
					} else {
						alert('입력하신 이메일은 없는 이메일입니다');
					}
				}

			}) // ajax 펑션
		}) // 이메일체크펑션

		function successcall(user_email) {

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
					$(".emailcheck_span").text("이메일로 받으신 인증번호를 입력해주세요");
						document.getElementById('email_auth').disabled = false;
				},
				error : function(request, status, error) {
					console.log("code:" + request.status + "\n" + "message:"
							+ request.responseText + "\n" + "error:" + error);
				}
			});

		}

	}) //레디 펑션
</script>
<style type="text/css">
body {
	background-color: #FFEBE4BD;
}

.emailcheck_body {
	height: 800px;
	text-align: center;
}

.div-brand-logo-img {
	text-align: center;
}

.brand-logo-img {
	width: 330px;
	margin-top: 246px;
}

span {
	font-size: 15pt;
	font-weight: 400;
}

.checkdiv {
	display: flex;
	justify-content: center;
}

input {
	width: 360px;
	height: 60px;
	font-size: 15pt;
	font-weight: 400;
	background-color: #D9D9D9;
	color: black;
	border-radius: 5%;
	border: none;
}

.blank-area {
	width: 0.5%;
}
</style>
</head>

<body>
	<div class="emailcheck_body">
		<div class="div-brand-logo-img">
			<a href="go.home" class="brand-logo"> <img class="brand-logo-img"
				src="resources/img/logo2.png" alt="Logo">
			</a>
		</div>
		<br> <span class="emailcheck_span">회원가입하실 때 입력하신 이메일을
			입력해주세요 </span>
			<div style="height: 15px;"></div>
		<div class="checkdiv">
			<div>
				<input name="user_email" class="user_email" id="user_email">
			</div>
			<div style="width: 15px;"></div>
			<div>
				<button class="emailcheck"
					style="width: 105px; height: 60px; border-radius: 15%; background-color: #E7B5AC; border: none;">
					이메일 <br> 확인
				</button>
			</div>
		</div>
		<div style="height: 15px;"></div>
		<div class="checkdiv">
			<input id="email_auth_key">
			<div style="width: 15px;"></div>
			<button id="email_auth" disabled="disabled"
				style="width: 105px; height: 60px; border-radius: 15%; background-color: #E7B5AC; border: none;">
				인증번호 <br> 확인
			</button>
		</div>
	</div>

</body>
</html>