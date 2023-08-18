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

		<!-- 이용권 페이지의 전체 컨테이너 -->
		<div class="mpT">
			<h1>이용권 </h1>
			
			
			<div>
				<form action="mypage.ticket.buy" method="post">
				<div>1개월 이용권<input name="monthTicket" type="hidden" value="1개월이용권"> </div>
				<div>11900원 <input name="monthTicketPrice" type="hidden" value="11900"></div>
				<button>구매하기</button>
				</form>
			</div>
			<div>
				<form action="mypage.ticket.buy" method="post">
				<div>3개월 이용권<input name="monthTicket" type="hidden" value="3개월이용권"> </div>
				<div>29900원 <input name="monthTicketPrice" type="hidden" value="29900"></div>
			
				<button>구매하기</button>
				</form>
			</div>
			<div>
				<form action="mypage.ticket.buy" method="post">
				<div>6개월 이용권<input name="monthTicket" type="hidden" value="6개월이용권"> </div>
				<div>59900원 <input name="monthTicketPrice" type="hidden" value="59900"></div>
				
				<button>구매하기</button>
				</form>
			</div>
			<div>
				<form action="mypage.ticket.buy" method="post">
				<div>12개월 이용권<input name="monthTicket" type="hidden" value="6개월이용권"> </div>
				<div>89900원 <input name="monthTicketPrice" type="hidden" value="89900"></div>
				
				<button>구매하기</button>
				</form>
			</div>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		<!-- 이용권 페이지의 전체 컨테이너 끝 -->
		</div>

</body>
</html>