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
	<form action="QnAInsert.do">
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
						<div class="QnA-header">작성페이지</div>
						<hr>
					</div>
					<div class="QnA-list-titles">
							<div class="QnA-list-title1">카테고리</div>
							<select name="inquiry_category" style="width:100%; border: none;">
									<option value="공지사항">공지사항</option>
									<option value="문의하기">문의하기</option>																	
									<option value="자주묻는질문">자주 묻는 질문</option>							
							</select> 
						</div>	
					<div class="QnA-body-list">
						<div class="QnA-list-titles">
							<div class="QnA-list-title1">유형</div>
							<div class="QnA-list-title2">
								<select name="inquiry_type" style="width:100%; border: none;">
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
								<input style="width: 100%; border: none;"
									placeholder="제목을 입력해주세요." name="inquiry_title">
							</div>
						</div>
						<div class="QnA-list-titles">
							<div class="QnA-list-title1">내용</div>
							<div class="QnA-list-title2">
								<textarea style="width: 100%; height: 400px; border: none;"
									rows="" cols="" placeholder="1:1 문의 작성 전 확인해주세요!"
									name="inquiry_body"></textarea>
							</div>
						</div>
						<div style="display: flex; justify-content: flex-end;">
							<button class="QnA-searchbutton">등록</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>