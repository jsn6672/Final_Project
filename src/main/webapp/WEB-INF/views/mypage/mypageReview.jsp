<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="display: flex; width: 250%;" class="babo_container">
		<div> 
			<h1>내가 써야 할 리뷰</h1>
			<c:forEach items="${NotReview}" var="r">
				<div class="message">${r.d_name }
					<c:if test="${r.cntDTOMessage eq '1' }">
						<span style="color: red"> ● </span>
					</c:if>
				</div>
				<div class="messageans">
					<c:choose>
						<c:when test="${r.cntDTOMessage eq '1' }">
							<c:forEach items="${r.cntDTOs }" var="rr">
								<div>시터 이름 : ${rr.cnt_memberDTO.user_name }</div>
								<div>시터 나이 : ${rr.age }</div>
								<div>
									<form action="">
										<input name="review_taker_id" value="${userInfo.user_id }" hidden="hidden">
										<input name="review_sitter_id"
											value="${rr.cnt_memberDTO.user_id }" hidden="hidden"> <input
											name="review_dolbom_no" value="${rr.cnt_dolbom_no }" hidden="hidden">
										<input name="review_txt">
										<button>등록</button>
									</form>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div>${r.cntDTOMessage }</div>
						</c:otherwise>
					</c:choose>
				</div>
				<hr>
			</c:forEach>
		</div>
			<div class="babo" style="width: 50%; background-color: skyblue;">
				내가 받은 리뷰
			</div>

	</div>
	※ 내가 쓴 리뷰는 시간 남으면 ^^


</body>
</html>