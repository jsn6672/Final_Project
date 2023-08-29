<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
    var couponResult = "${couponResult}"; // 컨트롤러에서 전달된 결과 값
    console.log(couponResult);
    
    if (couponResult === "성공") {
        alert("쿠폰 등록 완료");
    } else if (couponResult === "실패") {
        alert("쿠폰 등록 실패");
    }
</script>
</head>
<body>

	<div>
	
		<div>
			<form action="mypage.coupon.give">
			<div>이용자 ID	:	<input name="cp_id"></div>
			<div>쿠폰일수		:	<input name="cp_date">일</div>
			<div>사유		:	<input name="cp_txt"></div>
			<button>쿠폰 발행</button>
			</form>
		</div>
	
	
	</div>

</body>
</html>