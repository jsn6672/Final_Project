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

		$(".email_auth_btn").click(function() {
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
				   error:function(request,status,error){
				        console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
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

		$('#nickname').focusout(function() {
			var nickname = $('#nickname').val();

			$.ajax({
				type : "POST",
				url : "/nicknameCheck",
				data : {
					nickname : nickname
				},
				success : function(data) {
					if (data == "Y") {
						$('#nickname_ck').removeClass("dpn");
					} else {
						$('#nickname_ck').addClass("dpn");
					}
				},
				error : function(data) {
				}
			});
		});
	});
</script>

<style type="text/css">
#container {width: 100%; height: 100%; position: relative;}


.dpn {display: none !important;}
.join_wrap {width:550px; margin: 0 auto; border: 1px solid #dadada; padding: 24px; border-radius: 5px;}
.join_title {width:100%; height:35px; font-size: 19px; font-weight: bold; padding-left: 10px; padding: 0 0 10px 10px;}

.join_box {width: 100%;}
.join_box input {width: 100%; height: 50px; border: 1px solid #dadada;padding: 17px; border-radius: 5px; margin-top: 20px;}
.join_box span {display: inline-block; color: red; font-size: 12px; padding-left: 1px; padding-top: 8px;}

.email_auth {width: 100%; margin-top: 10px;}
.email_auth input {display:inline-block; width: calc(100% - 121px); vertical-align: top; margin: 0;}
.email_auth_btn{
	display: inline-block;
    width: 115px;
    height: 50px;
    padding: 17px 0 15px;
    border-radius: 6px;
    border: solid 1px rgba(0,0,0,.15);
    background-color: #03c75a;
    color: white;
    font-size: 17px;
    font-weight: bold;
    line-height: 1;
}

.join_btn {    
	display: block;
    width: 100%;
    padding: 17px 0 15px;
    border-radius: 6px;
    border: solid 1px rgba(0,0,0,.15);
    background-color: #03c75a;
    color: white;
    font-size: 19px;
    font-weight: bold;
    margin-top: 20px;
}
</style>
</head>
<body>

	<div id="container" class="container">
		<div class="content">
			<div class="join_wrap">
				<form id="join_frm" method="post" enctype="multipart/form-data" action="regAccount.do">
					<div class="join_title">회원가입</div>
					<div class="join_box">
						<input type="text" placeholder="아이디" name="user_id" id="id" style="margin: 0;"> 
						<%-- 
						<span id="id_ck" class="dpn">이미 사용중인 아이디입니다.</span> 
						--%>
						<input type="text" placeholder="이름" name="user_name" id="nickname"> 
						<%--
						<span id="nickname_ck" class="dpn">이미 사용중인 닉네임입니다.</span> 
						 --%>
						<input type="password" placeholder="비밀번호" name="user_pw" id="password"> 
						<input type="password" placeholder="비밀번호  확인" id="password_ck">
						<input placeholder="성별" name="user_gender">
						<input name="user_location" placeholder="주소">
						<input type="file" name="pic">
						<div class="email_auth">
							<input type="text" placeholder="이메일" name="user_email" id="user_email" class="email">
							<button type="button" id="email_auth_btn" class="email_auth_btn">인증번호 받기</button>
						</div>
						<input type="text" placeholder="인증번호 입력" id="email_auth_key">
					</div>
					<button id="join" class="join_btn">가입하기</button>
				</form>
			</div>
		</div>
	</div>



</body>


</html>