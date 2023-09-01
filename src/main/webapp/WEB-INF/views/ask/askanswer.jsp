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
	<form action="askanswer.do">
		<input value="${s.inquiry_no }" type="hidden" name="inquiry_no">
		<div class="QnA-container">
			<div class="QnA-content">
				<div class="QnA-title-left">
					<div class="QnA-header">고객 게시판</div>
					<div class="QnA-left-lists">
						<div class="QnA-left-list highlightable" id="notice1"
							onclick="location.href='mainask.go?category=1'">공지사항</div>

						<div class="QnA-left-list highlightable" id="notice3"
							onclick="location.href='qanda.go?category=3'">문의하기</div>

						<div class="QnA-left-list highlightable" id="notice2"
							onclick="location.href='manyask.go?category=2'">자주묻는질문</div>
					</div>
				</div>
				<div class="QnA-body">
					<div class="QnA-body-title">
						<div class="QnA-header">답변페이지</div>
						<hr>
					</div>
					<div class="QnA-list-titles">
						<div class="QnA-list-title1">카테고리</div>
						<c:choose>
							<c:when test="${s.inquiry_category eq '3'}">
								<div class="QnA-list-title2">
									<div>문의하기</div>
								</div>
							</c:when>
							<c:when test="${s.inquiry_category eq '2'}">
								<div class="QnA-list-title2">
									<div>자주묻는질문</div>
								</div>
							</c:when>
							<c:when test="${s.inquiry_category eq '1'}">
								<div class="QnA-list-title2">
									<div>공지사항</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="QnA-list-title2">
									<div></div>
								</div>
							</c:otherwise>
						</c:choose>

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
									style="border: none;width: 100%" value="${s.inquiry_title }">
							</div>
						</div>
					</div>
					<div class="QnA-list-titles">
						<div class="QnA-list-title1">내용</div>
						<div class="QnA-list-title2">
							<div>
								<input name="inquiry_body" placeholder="${s.inquiry_body }"
									style="border: none;width: 100%" value="${s.inquiry_body }">
							</div>
						</div>
					</div>
					<div class="QnA-list-titles">
						<div class="QnA-list-title1">답변</div>
						<div class="QnA-list-title2">
							<div style="display: flex; justify-content: flex-end;">
								<textarea rows="" cols="" name="inquiry_encodingbody"
									style="border: none; height: 27px; width: 100%;"></textarea>
							</div>
						</div>
					</div>

					<div style="display: flex; justify-content: flex-end;">
					<input hidden="hidden" name="category" value="1">
						<button class="QnA-searchbutton">확인</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>