<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: #FFEBE4BD;
}

.login-body {
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

a {
	font-size: 15pt;
	font-weight: 400;
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

	<div class="login-body">
		<div class="div-brand-logo-img">
			<a href="go.home" class="brand-logo"> <img class="brand-logo-img"
				src="resources/img/logo2.png" alt="Logo">
			</a>
		</div>
		<div style="font-size: 20pt; text-align: center">당신의 아이디는
			${info.user_id}입니다</div>
		<form action="pwchange.do" method="post" onsubmit="return pwcheck();">
			<div style="display: flex; justify-content: center;">
				<div>
					<input name="user_id" value="${info.user_id }" hidden="hidden">
					<input name="user_pw" id="user_pw" placeholder="새로운 비밀번호를 입력해주세요">
					<br> <br> <input id="user_pw_check"
						placeholder="비밀번호를 한번 더 입력해주세요">
				</div>
				<div class="blank-area"></div>
				<div>
					<button
						style="width: 105px; height: 148px; border-radius: 15%; background-color: #E7B5AC; border: none;">비밀번호 <br> 변경 </button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	function pwcheck() {
		if ($('#user_pw').val() == "") {
			alert("비밀번호를 입력해주세요.");
			return false;
		}
		if ($('#user_pw').val() != $('#user_pw_check').val()) {
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}

		return true;
	}
</script>
</html>