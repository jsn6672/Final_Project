<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${loginfail }
	<form action="login.do">
		<div style="display: flex;">
			<div>
				<input name="user_id" placeholder="아이디를 입력하세요" style="background-color: #D9D9D9; color: black;"> <br> 
				<input name="user_pw" placeholder="비밀번호를 입력하세요">
			</div>
			<div>
				<button>로그인</button>
			</div>
		</div>
	</form>
	<a href="lost.id.pw">로그인 정보를 잊으셨나요?</a>
	<br>
	<a href="regAccount.go">회원가입</a>

</body>
</html>