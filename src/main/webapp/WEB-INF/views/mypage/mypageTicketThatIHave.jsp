<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<!-- <script>
	function toggleButton() {
		const button = document.getElementById("cp-btn");
		const columnValue = 1; // 여기에 데이터베이스에서 받아온 값 설정

		if (columnValue === 1) {
			button.style.display = "block"; // 버튼을 보이도록 설정
		} else {
			button.style.display = "none"; // 버튼을 숨기도록 설정
		}
	}
</script> -->
</head>
<body>

	<!-- 전체 컨테이너 -->
	<div class="TTIHContainer">
		<!-- 현재 가지고 있는 티켓에 대한 정보 -->
		<div class="TTIHUsing">
			<div>${sessionScope.userInfo.user_name }님의 이용권 확인페이지입니다.</div>
			<c:forEach items="${moneyList2}" var="money">
				<div>티켓이름 ${money.mm_ticket}</div>
				<div>결제일 <fmt:formatDate value="${money.mm_start_date}" pattern="yy/MM/dd" /></div>
			</c:forEach>
			<c:forEach var="tp" items="${ticketPeriod }">
				 <div>유효기간 <fmt:formatDate value="${tp.ms_ticket_start}" pattern="yy/MM/dd" /> ~ <fmt:formatDate value="${tp.ms_ticket_end}" pattern="yy/MM/dd" /></div>				
			</c:forEach>
		<!-- 현재 가지고 있는 티켓에 대한 정보 끝 -->
		</div>

		<!-- 과거 티켓 관련 이력에 대한 정보 -->
		<div class="couponList">
			<table>
				<tr>
					<td>이용날짜</td>
					<td>이용내역</td>
				</tr>
				<tr>
					<td>2023.08.25</td>
					<td>1개월 구매</td>
				</tr>
				<c:forEach var="cpl" items="${couponList }">
					<tr>
						<td>${cpl.cp_date }</td>
						<td>${cpl.cp_txt }</td>
						<td>  <button id="cp-btn">use!</button></td>
						<!-- <script>
							toggleButton();
						</script> -->
					</tr>
				</c:forEach>
			</table>
			<!-- 과거 티켓 관련 이력에 대한 정보 끝-->
		</div>


		<!-- 전체 컨테이너 끝 -->
	</div>

</body>
</html>
