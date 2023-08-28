<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/mypage/starpoint.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>

<style type="text/css">
.star {
	position: relative;
	font-size: 32px;
	color: #ddd;
}

.star input {
	width: 100%;
	height: 100%;
	position: absolute;
	left: 0;
	opacity: 0;
}

.star span {
	width: 0;
	position: absolute;
	left: 0;
	color: red;
	overflow: hidden;
	pointer-events: none;
}
</style>
</head>
<body>
	<div style="display: flex; width: 250%;" class="babo_container">
		<div class="babo" style="width: 50%; background-color: skyblue;">
			<div>내가 받은 리뷰</div>
			<c:forEach items="${review }" var="rw">
				<div>${rw.r_dolbomDTO.d_name }님께서남기신 댓글입니다</div>
				<div>평점 : ${rw.review_point }</div>
				<div>내용 : ${rw.review_txt }</div>
			</c:forEach>
		</div>
		<div>
			<h1>내가 써야 할 리뷰</h1>
			<c:forEach items="${NotReview}" var="r">
				<div>${r.d_name }
					<c:if test="${r.cntDTOMessage eq '1' }">
						<span style="color: red"> ● </span>
					</c:if>
				</div>
				<div>
					<c:choose>
						<c:when test="${r.cntDTOMessage eq '1' }">
							<c:forEach items="${r.cntDTOs }" var="rr">
								<div>시터 이름 : ${rr.cnt_memberDTO.user_name }</div>
								<div>시터 나이 : ${rr.age }</div>
								<div style="display: flex;">
									<form action="regReview">
										<div>
											<input name="review_taker_id" value="${userInfo.user_id }"
												hidden="hidden"> <input name="review_sitter_id"
												value="${rr.cnt_memberDTO.user_id }" hidden="hidden">
											<input name="review_dolbom_no" value="${rr.cnt_dolbom_no }"
												hidden="hidden"> <input name="review_cont_no"
												value="${rr.cnt_no }" hidden="hidden"> <input
												name="review_category" value="${r.d_category }"
												hidden="hidden">
										</div>
										<div>
											<span class="star"> ★★★★★ <span>★★★★★</span> <input
												name="review_point" type="range" oninput="drawStar(this)"
												value="1" step="1" min="0" max="10">
											</span>
										</div>
										<div>
											<input name="review_txt">
										</div>
										<div>
											<button>등록</button>
										</div>
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


	</div>
	※ 내가 쓴 리뷰는 시간 남으면 ^^

</body>


</html>