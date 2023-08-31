<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<script>
    function prepareSelectedIds() {
        var selectedIds = [];
        var checkboxes = document.getElementsByName('selectedIds');
        
        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].checked) {
                selectedIds.push(checkboxes[i].value);
            }
        }
        
        document.getElementById('selectedIdsInput').value = selectedIds.join(',');
        
        // 선택된 아이디 중 첫 번째 아이디를 cp_id 필드에 넣음
        if (selectedIds.length > 0) {
            document.getElementsByName('cp_id')[0].value = selectedIds[0];
        }
    }
</script>
</head>
<body>
	<!-- 전체 div -->
	<div>
		<!-- 포인트 순으로 정렬 div-->
		<div class="pointLanking">
			
			<div class="ms-point">
				<c:forEach var="msP" items="${momP }">
					<input type="checkbox" name="selectedIds" value="${msP.ms_id}">
					<div>USER ID : ${msP.ms_id }</div>
					<div>POINT : ${msP.ms_point }</div>
				</c:forEach>
			</div>
			
			<div class="ps-point">
				<c:forEach var="psP" items="${petP }">
					<input type="checkbox" name="selectedIds" value="${psP.ps_id}">
					<div>USER ID : ${psP.ps_id }</div>
					<div>POINT : ${psP.ps_point }</div>
				</c:forEach>
			</div>
			
			<div class="cs-point">
				<c:forEach var="csP" items="${careP }">
					<input type="checkbox" name="selectedIds" value="${csP.cs_id}">
					<div>USER ID : ${csP.cs_id }</div>
					<div>POINT : ${csP.cs_id }</div>
				</c:forEach>
			</div>
		<!-- 포인트 순으로 정렬 div 끝-->
		</div>
	
	
	
		<div>
		
		
			<form action="mypage.coupon.give">
			<div>이용자 ID	:	<input name="cp_id"></div>
			<div>쿠폰일수		:	<input name="cp_date">일</div>
			<div>사유		:	<input name="cp_txt"></div>
			 <button onclick="prepareSelectedIds()">쿠폰 발행</button>
			</form>
		</div>
	
	
	</div>

</body>
</html>