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

		$('.email_auth').click(function() {
			console.log(email_auth_cd);
			var user_email = $(".user_email").val();

			if ($('#email_auth_key').val() != email_auth_cd) {
				alert("인증번호가 일치하지 않습니다.");
				return false;
			}
			console.log(user_email);
			location.href = 'pwchange.go?user_email='+user_email;
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
			},
			error : function(request, status, error) {
				console.log("code:" + request.status + "\n" + "message:"
						+ request.responseText + "\n" + "error:" + error);
			}
		});

	}
		
		

	}) //레디 펑션
</script>
</head>

<body>

	회원가입하실 때 입력하신 이메일을 입력해주세요
	<input name="user_email" class="user_email" id="user_email">
	<button class="emailcheck">확인</button>
	<input id="email_auth_key">
	<button class="email_auth">인증번호 확인</button>



</body>
</html>