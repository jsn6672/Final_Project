<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<c:forEach items="${DolbomList }" var="s">
			<div><span onclick="location.href='mypage.takerUpdateAnotherMomDolbom.go?d_no=${s.d_no}'">${s.d_name }, ${s.age }${s.agetype }</span></div>
		</c:forEach>
	<div><span onclick="location.href='mypage.takerRegAnotherMomDolbom.go'"> + 새로운 돌보미를 입력해주세요</span></div>
	</div>
</body>
</html>