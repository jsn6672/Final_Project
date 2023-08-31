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

	<div class="QnA-container">
		<div class="QnA-content">
			<div class="QnA-title-left">
				<div class="QnA-header">고객 게시판</div>
				<div class="QnA-left-lists">
					<div class="QnA-left-list highlightable" id="notice1"
						onmouseover="changeColorOnMouseOver('notice1')"
						onmouseout="changeColorOnMouseOut('notice1')"
						onclick="location.href='mainask.go?categor	y=1'">공지사항</div>

					<div class="QnA-left-list highlightable" id="notice3"
						onmouseover="changeColorOnMouseOver('notice3')"
						onmouseout="changeColorOnMouseOut('notice3')"
						onclick="location.href='qanda.go?category=3'">문의하기</div>

					<div class="QnA-left-list highlightable" id="notice2"
						onmouseover="changeColorOnMouseOver('notice2')"
						onmouseout="changeColorOnMouseOut('notice2')"
						onclick="location.href='manyask.go?category=2'">자주묻는질문</div>
				</div>
			</div>
			<div class="QnA-body">
				<div class="QnA-body-title">
					<div class="QnA-header">상세페이지</div>
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
						<div>${s.inquiry_type }</div>
					</div>
				</div>
				<div class="QnA-list-titles">
					<div class="QnA-list-title1">아이디</div>
					<div class="QnA-list-title2">
						<div>${s.inquiry_id }</div>
					</div>
					<div class="QnA-list-title1">작성일자</div>
					<div class="QnA-list-title2">
						<div>
							<fmt:formatDate value="${s.inquiry_question_day }" />
						</div>
					</div>
				</div>
				<div class="QnA-list-titles">
					<div class="QnA-list-title1">제목</div>
					<div class="QnA-list-title2">
						<div>${s.inquiry_title }</div>
					</div>
				</div>
				<div class="QnA-list-titles">
					<div class="QnA-list-title1">내용</div>
					<div class="QnA-list-title2" style="height: 400px;">
						<div>${s.inquiry_body }</div>
					</div>
				</div>
				<c:if test="${sessionScope.userInfo.user_id eq 'admin'}">
				<div class="QnA-list-titles">
					<div class="QnA-list-title1">답변</div>
					<div class="QnA-list-title2">
						<div>${s.inquiry_encodingbody }</div>
					</div>
				</div>
				</c:if>
				<c:if
					test="${sessionScope.userInfo.user_id eq 'admin' ||sessionScope.userInfo.user_id eq s.inquiry_id}">
					<div style="display: flex; justify-content: flex-end;">
										<c:if test="${sessionScope.userInfo.user_id eq 'admin'}">
						<button class="QnA-searchbutton"
							onclick="location.href='askanswer.go?inquiry_no=${s.inquiry_no}'">답변</button>
					</c:if>
						<button class="QnA-searchbutton"
							onclick="location.href='delete?inquiry_no=${s.inquiry_no}'">삭제</button>
						<button class="QnA-searchbutton"
							onclick="location.href='update.go?inquiry_no=${s.inquiry_no}'">수정</button>
					</div>
				</c:if>
			</div>
		</div>
	</div>


</body>
</html>