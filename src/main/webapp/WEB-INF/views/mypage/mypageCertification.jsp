<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<div name="msc"> 맘시터
		<c:forEach var="mc" items="${msconfirm }">
		이름		:	${mc.mm.user_name }
		아이디 	:	${mc.ms_id }
		<div><img src="../resource/img/${mc.ms_file }.jpg"> </div>
			<form action="mypage.accept.go">
				<input name="ms_id" value="${mc.ms_id }">
				<button>accept</button>
			</form>
			
			<form action="mypage.reject.go">
				<input name="ms_id" value="${mc.ms_id }">
				<button>reject</button>
			</form>
	
		</c:forEach>
		</div>
	</div>

</body>
</html>