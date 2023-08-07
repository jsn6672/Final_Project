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
							<div>${s.inquiry_no}</div> 
							<div class="QnA-list-title1">카테고리</div>
							<div class="QnA-list-title2">
							<div>${s.inquiry_category }</div>
							</div>
						</div>	
					<div class="QnA-body-list">
						<div class="QnA-list-titles">
							<div class="QnA-list-title1">유형</div>
							<div class="QnA-list-title2">
							<div>${s.inquiry_type }</div>
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
							<div class="QnA-list-title2">
							<div>${s.inquiry_body }</div>
							</div>
						</div>
						<div style="display: flex; justify-content: flex-end;">
							<button class="QnA-searchbutton" onclick="location.href='delete?inquiry_no=${s.inquiry_no}'">삭제</button>
							<button class="QnA-searchbutton" onclick="location.href='upadte?inquiry_no=${s.inquiry_no}'">수정</button>							
						</div>
					</div>
				</div>
			</div>
		</div>

</body>
</html>