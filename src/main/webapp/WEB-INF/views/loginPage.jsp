<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	background-color: #FFEBE4BD;
}

.login-body {
	height: 100vh;
	text-align: center;
}

.div-brand-logo-img {
	text-align: center;
}

.brand-logo-img {
	width: 220px;
	margin-top: 200px;
}

a {
	font-size: 13pt;
	font-weight: 400;
}

input {
	width: 360px;
	height: 60px;
	font-size: 15pt;
	font-weight: 400;
	background-color: #D9D9D9;
	color: black;
	border-radius: 3%;
	border: none;	
}

.blank-area{
	width: 0.5%;
}

.login-mention {
	font-size: 14pt;
	margin-top: 0.5%;
}
</style>
</head>
<body>
	<div class="login-body">
		<div class="div-brand-logo-img">
			<a href="go.home" class="brand-logo"> <img class="brand-logo-img"
				src="resources/img/logo2.png" alt="Logo">
			</a>
		</div>
		<div style="font-size: 20pt; text-align: center">${loginfail }</div>
		<form action="login.do" method="post">
			<div style="display: flex; justify-content: center;">
				<div>
					<input name="user_id" placeholder="아이디를 입력하세요"> <br><br>
					<input name="user_pw" placeholder="비밀번호를 입력하세요" type="password">
				</div>
				<div class="blank-area"></div>
				<div>
					<button style="width: 105px; height: 148px; border-radius: 15%; background-color: #E7B5AC; border: none;">로그인</button>
				</div>
			</div>
		</form>
		<div class="login-mention">
		<a href="lost.id.pw.go">로그인 정보를 잊으셨나요?</a> <br> <a
			href="regAccount.go">회원가입</a>
		</div>
	</div>
</body>
</html>