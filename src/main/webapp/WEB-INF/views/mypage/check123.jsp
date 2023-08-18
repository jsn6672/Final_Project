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
testtestestestestestest

<c:forEach items="${contractSitterInfo }" var="r">
${r.cnt_sitter_id }

돌봄 주소 : ${r.cnt_dolbomdto.d_location }

</c:forEach>
<c:forEach items="${contractDolbomInfo }" var="r">
${r.cnt_dolbom_no }

시터 경험 : ${r.cnt_petdto.ps_exp }

</c:forEach>


</body>
</html>