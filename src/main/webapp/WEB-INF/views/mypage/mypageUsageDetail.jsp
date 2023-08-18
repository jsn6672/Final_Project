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
		<div>시터 요청</div>
		<!-- 페이지 본문 컨테이너 -->
		<div id="Accordion_wrap">
			<c:forEach items="${contractSitterInfo }" var="s">
			<div class="message">
				<c:if test="${s.cnt_type eq 3 }">
				<span>${s.cnt_memberDTO.user_name }님에게 펫시터가 되어달라는 신청이 들어왔습니다.</span>
				</c:if>
				<c:if test="${s.cnt_type eq 2 }">
				<span>${s.cnt_memberDTO.user_name }님에게 맘시터가 되어달라는 신청이 들어왔습니다.</span>
				</c:if>
				<c:if test="${s.cnt_type eq 1 }">
				<span>${s.cnt_memberDTO.user_name }님에게 요양시터가 되어달라는 신청이 들어왔습니다.</span>
				</c:if>
			</div>
			<div class="messageans">
				<div onclick="location.href='detail.go?inquiry_no=${s.cnt_dolbomdto.d_no}'">이름 : ${s.cnt_dolbomdto.d_name}</div>
				<div>나이 : ${s.age }${s.agetype }</div>
				<div>활동 : ${s.cnt_can_do }</div>
				<div style="display: flex;justify-content: flex-end; gap:10px;">
				<span>수락</span>
				<span>거절</span>
				<span>삭제</span>
				</div>
			</div>

			</c:forEach> 
		</div>
		<hr>
		<div>테이커 요청</div>
		<div id="Accordion_wrap">
			<c:forEach items="${contractSitterInfo }" var="s">
			<div class="message">
				<c:if test="${s.cnt_type eq 3 }">
				<span>${s.cnt_memberDTO.user_name }님에게 펫테이커가 되어달라는 신청이 들어왔습니다.</span>
				</c:if>
				<c:if test="${s.cnt_type eq 2 }">
				<span>${s.cnt_memberDTO.user_name }님에게 맘테이커가 되어달라는 신청이 들어왔습니다.</span>
				</c:if>
				<c:if test="${s.cnt_type eq 1 }">
				<span>${s.cnt_memberDTO.user_name }님에게 요양테이커가 되어달라는 신청이 들어왔습니다.</span>
				</c:if>
			</div>
			<div class="messageans">
				<div onclick="location.href='detail.go?inquiry_no=${s.cnt_dolbomdto.d_no}'">이름 : ${s.cnt_dolbomdto.d_name}</div>
				<div>나이 : ${s.age }${s.agetype }</div>
				<div>활동 : ${s.cnt_can_do }</div>
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