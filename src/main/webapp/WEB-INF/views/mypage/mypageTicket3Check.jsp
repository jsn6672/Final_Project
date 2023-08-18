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
	
	<!-- admin 계정 이용권 구매리스트 확인페이지 전체 div -->
	<div>
		이용권확인
		<c:forEach var="ml" items="${moneyList}">
			<div>
				입금자명	: ${ml.mm_name }
			</div> 			
			<div>
				금액		: ${ml.mm_price }
			</div> 
			<div>
				내역		: ${ml.mm_state }
			</div> 
			<div>
				신청일자 	: ${ml.mm_date }
			</div> 
			<div>
				이용권	: ${ml.mm_ticket }
			</div> 
			<div>
				이용ID 	: ${ml.mm_id }
			</div> 
			<div>--------------------------------</div>
		</c:forEach>
		
	
	
	
	
	
	
	
	
	
	
	<!-- admin 계정 이용권 구매리스트 확인페이지 전체 div -->
	</div>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	

</body>
</html>