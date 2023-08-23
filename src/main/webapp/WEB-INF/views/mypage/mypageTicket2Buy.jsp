<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
$(document).ready(function() {
    $("form").submit(function(e) {
        e.preventDefault(); 

        $.ajax({
            type: "POST",
            url: "mypage.ticket.send",
            data: $(this).serialize(),
            success: function(response) {
            	console.log(response);
                if (response === "home") {
                    showAlert("거래가 성공하였습니다. 마이페이지로 이동합니다.");
                    location.href="mypage.go";
                } else {
                    showAlert("거래가 실패했습니다. 다시 시도해 주세요.");
                }
            },
            error: function() {
                showAlert("서버 에러");
            }
        });
    });
});

function showAlert(message) {
    alert(message);
}
</script>
</head>

<body>

		<!-- 이용권 구매 페이지의 전체 컨테이너 -->
		<div class="mpTBuy">
			
			<div>계좌번호	:	농협 930421-52-930421 모두의 시터</div>
			<div>입금액 	:	${param['monthTicketPrice']}</div>
			<div>계좌번호를 확인하시고 입금하실 분의 이름을 입력 후 확인을 눌러주세요!</div>	

			<div>
				<form action="mypage.ticket.send" method="post">
				<div><input name="mm_name"></div>
				<input name="mm_id" type="hidden" value="${sessionScope.userInfo.user_id }">
				<input name="mm_ticket" type="hidden" value="${param['monthTicket']}">
				<input name="mm_price" type="hidden" value="${param['monthTicketPrice']}">
				<input name="mm_state" type="hidden" value="신청완료">
				<input name="mm_date" type="hidden" value="${param['ticketMonth']}">
				<button>확인</button>
				</form>
			</div>			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		<!-- 이용권 페이지의 전체 컨테이너 끝 -->
		</div>

</body>
</html>