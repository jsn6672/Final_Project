<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<!-- 이용권 구매 페이지의 전체 컨테이너 -->
		<div class="mpTBuy">
			
			<div>상품	:	${param['monthTicket']}</div>
			<div>가격	:	${param['monthTicketPrice']}</div>
			
			<div>선택하신 이용권이 맞다면 아래 입금자명을 입력하고 다음 버튼을 눌러주세요.</div>	

			<div>
				<form action="mypage.ticket.sendMoney" method="post">
				<div><input name="customerName"></div>
				<input name="choiceTicket" type="hidden" value="${param['monthTicket']}">
				<input name="choiceTicketPrice" type="hidden" value="${param['monthTicketPrice']}">
				<button>다음</button>
				</form>
			</div>			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		<!-- 이용권 페이지의 전체 컨테이너 끝 -->
		</div>

</body>
</html>