<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>

	<!-- 전체 컨테이너 -->
	<div>
		<!-- 현재 가지고 있는 티켓에 대한 정보 -->
		<div>
			<div>현재 이용중</div>
			<c:forEach items="${moneyList2}" var="money">
				<div>티켓이름 ${money.mm_ticket}</div>
				<div>결제일 ${money.mm_start_date}</div>
			</c:forEach>
			<c:forEach var="tp" items="${ticketPeriod }">
				<div>유효기간 ${tp.ms_ticket_start }~${tp.ms_ticket_end }</div>				
			</c:forEach>
		
		
		<!-- 현재 가지고 있는 티켓에 대한 정보 끝 -->
		</div>
			<table>
				<tr>
					<td>이용날짜</td>
					<td>이용내역</td>
				</tr>
				<tr>
					<td>2023.08.25</td>
					<td>1개월 구매 </td>
				</tr>
			</table>
		<!-- 과거 티켓 관련 이력에 대한 정보 -->
		<div>
		
		<!-- 과거 티켓 관련 이력에 대한 정보 끝-->
		</div>	
	
	
	<!-- 전체 컨테이너 끝 -->
	</div>

</body>
</html>
