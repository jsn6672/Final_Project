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
	<form action="update">
		<input value="${s.inquiry_no }" type="hidden" name="inquiry_no">
		<div class="QnA-container">
			<div class="QnA-content">
				<div class="QnA-title-left">
					<div class="QnA-header">고객 게시판</div>
					<div class="QnA-left-lists">
						<div class="QnA-left-list" id="notice1"
							onclick="location.href='mainask.go'">공지사항</div>
						<div class="QnA-left-list" id="notice2"
							onclick="location.href='manyask.go'">문의하기</div>
						<div class="QnA-left-list" id="notice3"
							onclick="location.href='qanda'">자주 묻는 질문</div>
					</div>
				</div>
				<div class="QnA-body">
					<div class="QnA-body-title">
						<div class="QnA-header">상세페이지</div>
						<hr>
					</div>
					<div class="QnA-list-titles">
						<div class="QnA-list-title1">카테고리</div>
						<div class="QnA-list-title2">
							<div>${s.inquiry_category }</div>
						</div>
						<div class="QnA-list-title1">유형</div>
						<div class="QnA-list-title2">
							<select name="inquiry_type" style="width: 100%; border: none;">
								<option value="caresitter">간병인시터 관련 문의</option>
								<option value="momsitter">맘시터 관련 문의</option>
								<option value="petsitter">펫시터 관련 문의</option>
								<option value="caretaker">간병인가족 관련 문의</option>
								<option value="momstaker">맘가족 관련 문의</option>
								<option value="pettakeer">펫가족 관련 문의</option>
							</select>
						</div>
					</div>
					<div class="QnA-list-titles">
						<div class="QnA-list-title1">제목</div>
						<div class="QnA-list-title2">
							<div>
								<input name="inquiry_title" placeholder="${s.inquiry_title }"
									style="border: none">
							</div>
						</div>
					</div>
					<div class="QnA-list-titles">
						<div class="QnA-list-title1">내용</div>
						<div class="QnA-list-title2">
							<div>
								<input name="inquiry_body" placeholder="${s.inquiry_body }"
									style="border: none">
							</div>
						</div>
					</div>
					<c:if test="${sessionScope.userInfo.user_id eq 'admin'}">
						<div style="display: flex; justify-content: flex-end;">
							<textarea rows="" cols="" name="inquiry_encoding" style="width: 100% ; border: none;">
							.
							</textarea>
						</div>
					</c:if>
					<div style="display: flex; justify-content: flex-end;">
						<button class="QnA-searchbutton">확인</button>
					</div> 
				</div>
			</div>
		</div>
	</form>
</body>
</html>