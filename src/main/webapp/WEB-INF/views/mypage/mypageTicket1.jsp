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
			<div><br><br></div>
			<div class="mpT-mention1">
				<div class="mpT-mention1-1">지금 바로 모두의 시터 이용권을 구매하세요!</div>
				<div class="mpT-mention1-2">신규 오픈 기념 최대 <span id="mention1-1span">70%</span> 할인중!</div>
			</div>

		<div class="mpT-mention2">
			<div class="mpT-mention2-1">프리미엄 이용권</div>
			<div class="mpT-mention2-2">무제한 지원 + 무제한 수락 가능</div>
		</div>
		
		<div class="mpT-mention3">
				<img class="soupRice" alt="" src="resources/img/rice.png">
				국밥 한 그릇으로 손쉬운 시터 구직부터 구인까지! 모두의 시터에서 한 번에 해결하세요!</div>
		<form action="mypage.ticket.buy" method="post">
			<div class="buy1month">
				<img class="ticketImg" src="resources/img/1.png">
				<div class="month-name"><input name="monthTicket" type="hidden" value="1개월이용권">
				</div>
				<div class="month-price"><input name="monthTicketPrice" type="hidden" value="11900">
				</div>
				<input name="ticketMonth" type="hidden" value="1">
				<button class="buyTicket-btn">구매하기</button>
			</div>
		</form>

		<form action="mypage.ticket.buy" method="post">
			<div class="buy1month">
				<div><img class="ticketImg" src="resources/img/3month.png"><input name="monthTicket" type="hidden" value="3개월이용권">
				</div>
				<div><input name="monthTicketPrice" type="hidden" value="29900">
				</div>
				<input name="ticketMonth" type="hidden" value="3">

				<button class="buyTicket-btn">구매하기</button>
			</div>
		</form>
		<form action="mypage.ticket.buy" method="post">
			<div class="buy1month">
				<div><img class="ticketImg" src="resources/img/6month.png"><input name="monthTicket" type="hidden" value="6개월이용권">
				</div>
				<div><input name="monthTicketPrice" type="hidden" value="59900">
				</div>
				<input name="ticketMonth" type="hidden" value="6">
				<button class="buyTicket-btn">구매하기</button>
			</div>
		</form>
		<form action="mypage.ticket.buy" method="post">
			<div class="buy1month">
				<div><img class="ticketImg12" src="resources/img/12month.png"><input name="monthTicket" type="hidden" value="12개월이용권">
				</div>
				<div><input name="monthTicketPrice" type="hidden" value="89900">
				</div>
				<input name="ticketMonth" type="hidden" value="12">


				<button class="buyTicket-btn">구매하기</button>
			</div>
		</form>


















		<!-- 이용권 페이지의 전체 컨테이너 끝 -->
		</div>

</body>
</html>