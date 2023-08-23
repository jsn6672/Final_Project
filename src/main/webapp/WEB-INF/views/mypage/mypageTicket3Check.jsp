<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function confirmPayment(mmNo, mmState) {
            $.ajax({
                type: "POST",
                url: "mypage.ticket.confirm", 
                data: {
                    mm_no: mmNo,
                    mm_state: mmState
                },
                success: function(response) {
                    if (response.status === "success") {
                        alert("완료");
                        req.setAttribute("contentPage", "mypage/mypage.jsp");
                		req.setAttribute("mypageContentPage", "mypageTicket3Check.jsp");
                    } else {
                       
                        alert(response.message);
                    }
                },
                error: function() {
                    alert("오류가 발생했습니다.");
                }
            });
        }
    </script>
<body>

	<!-- admin 계정 이용권 구매리스트 확인페이지 전체 div -->
	<div>
		이용권확인
		<div>신청대기 총 ${moneyList.size() }건</div>
		<c:forEach var="ml" items="${moneyList}">
			<div class="moneyList-1">
				<div>주문번호 : ${ml.mm_no }</div>
				<div>입금자명 : ${ml.mm_name }</div>
				<div>금액 : ${ml.mm_price }</div>
				<div>내역 : ${ml.mm_state }</div>
				<div>신청일자 : ${ml.mm_date }</div>
				<div>이용권 : ${ml.mm_ticket }</div>
				<div>이용ID : ${ml.mm_id }</div>
				<form action="mypage.ticket.confirm" method="post">
					<input name="mm_no" type="hidden" value="${ml.mm_no }"> <input
						name="mm_state" type="hidden" value="${ml.mm_state }">
					<button>입금확인</button>
				</form>
				 <button onclick="confirmPayment(${ml.mm_no}, '${ml.mm_state}')">입금확인</button>


				<br>
			</div>
		</c:forEach>











		<!-- admin 계정 이용권 구매리스트 확인페이지 전체 div -->
	</div>












</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Money Page</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<div>
    이용권확인
    <div>신청대기 총 ${moneyList.size() }건</div>
    <c:forEach var="ml" items="${moneyList}">
        <div class="moneyList-1">
            <div>주문번호 : ${ml.mm_no }</div>
            <div>입금자명 : ${ml.mm_name }</div>
            <div>금액 : ${ml.mm_price }</div>
            <div>내역 : ${ml.mm_state }</div>
            <div>신청일자 : ${ml.mm_date }</div>
            <div>이용권 : ${ml.mm_ticket }</div>
            <div>이용ID : ${ml.mm_id }</div>
            <form action="mypage.ticket.confirm" method="post">
            	<input name="mm_no" type="hidden" value="${ml.mm_no }">
            	<input name="mm_state" type="hidden" value="${ml.mm_state }" >
            	<input name="mm_id" type="hidden" value="${ml.mm_id }" >
                <button>입금확인</button>
            </form>
            <br>
        </div>
    </c:forEach>
</div>
</body>
</html>
