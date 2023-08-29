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
		<div>
		이름		:	
		아이디 	:	${t.ms_id }
		
			<button></button>
		</div>
	</div>
</c:forEach>
</body>
</html>