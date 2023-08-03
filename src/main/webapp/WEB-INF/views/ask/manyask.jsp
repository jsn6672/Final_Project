<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<title>WoOx Travel Bootstrap 5 Theme</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/rbootstrap.min.css" rel="stylesheet">

<!-- Additional CSS Files -->
<link rel="stylesheet" href="resources/css/fontawesome.css">
<link rel="stylesheet" href="resources/css/templatemo-woox-travel.css">
<link rel="stylesheet" href="resources/css/owl.css">
<link rel="stylesheet" href="resources/css/animate.css">
<link rel="stylesheet"
	href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
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
						onclick="location.href='qanda.go'">자주 묻는 질문</div>
				</div>
			</div>
			<div class="QnA-body">
				<div class="QnA-body-title">
					<c:choose>
						<c:when test="${param.category == 2}">
							<div class="QnA-header">문의하기</div>
						</c:when>
						<c:when test="${param.category == 3 }">
							<div class="QnA-header">자주 묻는 질문</div>
						</c:when>
						<c:otherwise>
							<div class="QnA-header">공지사항</div>
						</c:otherwise>
					</c:choose>
					<form action="QnASearchC">
						<div>
							<input class="QnA-search" type="text" name="keyword"
								value="${keyword }" placeholder="검색어를 입력해주세요."> <input
								type="hidden" name="p" value="1">
							<button class="QnA-searchbutton" type="submit">검색</button>
						</div>
					</form>
					<div>
						<button class="QnA-searchbutton"
							onclick="QnAloginCheck('${sessionScope.account.user_id}')">작성</button>
					</div>
				</div>
				<div class="QnA-body-list">
					<div class="QnA-list-titles">
						<div class="QnA-list-title1">카테고리</div>
						<div class="QnA-list-title2">제목</div>
						<div class="QnA-list-title3">아이디</div>
						<div class="QnA-list-title4">날짜</div>
						<div class="QnA-list-title3">공개여부</div>
						<div class="QnA-list-title5">상태</div>
					</div>
				</div>
				<div class="QnA-body-list-FAQ"></div>
				<div class="QnA-lists">
					<div class="QnA-list1"> </div>
					<div class="QnA-list2"
						onclick="QnADetail('${QnA.inquiry_encoding}', '${sessionScope.account.user_id }', '${QnA.inquiry_user_id }', '${QnA.inquiry_no }')">
						<span class="leftToRight">${QnA.inquiry_title }</span>
					</div>
					<div class="QnA-list2"></div>
					<div class="QnA-list3">${QnA.inquiry_user_name }</div>
					<div class="QnA-list4">${QnA.inquiry_question_day }</div>
					<div class="QnA-list3">${QnA.inquiry_encoding }</div>
					<div class="QnA-list5">미답변</div>
					<div class="QnA-list3">${QnA.inquiry_encoding }</div>
					<div class="QnA-list5">답변완료</div>
				</div>
			</div>
		</div>
		</div>
</body>

</html>