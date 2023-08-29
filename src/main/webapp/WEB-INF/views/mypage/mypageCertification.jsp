<<<<<<< HEAD
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
>>>>>>> 63a9c23f08aebf1682542465c224aabf6e07b28b
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${test }" var="t">
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
</c:forEach>
</body>
</html>