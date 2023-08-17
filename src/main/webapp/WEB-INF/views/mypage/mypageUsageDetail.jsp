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
	<!-- 이용내역 페이지의 전체 컨테이너 -->
	<div class="mpU">
		<h1>이용내역</h1>
	</div>
	<!-- 시터 등록 및 수정 페이지의 전체 컨테이너 -->
	<div class="mpS">
		<!-- <h1>시터 등록 및 수정</h1> -->
		<!-- 페이지 본문 컨테이너 -->
		<div id="Accordion_wrap">
			<c:forEach items="${s }" var="s">
			<div class="message">
				<span>님에게 신청이 들어왔습니다.</span>
			</div>
			<div class="messageans">
				<div onclick="location.href='detail.go?inquiry_no=${s.inquiry_no}'">이름:</div>
				<div>나이:</div>
				<div>시간대:</div>
				<div>활동:</div>
				<div style="display: flex;justify-content: flex-end; gap:10px;">
				<span>수락</span>
				<span>거절</span>
				<span>삭제</span>
				</div>
			</div>

			</c:forEach> 
		</div>
	</div>
</body>
</html>