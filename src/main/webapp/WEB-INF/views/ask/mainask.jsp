<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
						onmouseover="changeColorOnMouseOver('notice1')"
						onmouseout="changeColorOnMouseOut('notice1')"
						onclick="location.href='mainask.go'">공지사항</div>

					<div class="QnA-left-list" id="notice2"
						onmouseover="changeColorOnMouseOver('notice2')"
						onmouseout="changeColorOnMouseOut('notice2')"
						onclick="location.href='manyask.go'">문의하기</div>

					<div class="QnA-left-list" id="notice3"
						onmouseover="changeColorOnMouseOver('notice3')"
						onmouseout="changeColorOnMouseOut('notice3')"
						onclick="location.href='qanda'">자주 묻는 질문</div>

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
					<form action="page.change">
						<div>
							<input class="QnA-search" type="text" name="a_search"
								value="${param.a_search}" placeholder="검색어를 입력해주세요."> <input
								type="hidden" name="p" value="1">
							<button class="QnA-searchbutton" type="submit">검색</button>
						</div>
					</form>
					<div>
						<button id="writeButton" class="QnA-searchbutton"
							onclick="location.href='regask.go'">작성</button>
					</div>
				</div>
				<div class="QnA-body-list">
					<div class="QnA-list-titles">
						<div class="QnA-list-title1">유형</div>
						<div class="QnA-list-title2" style="background-color: #E8F5E9">제목</div>
						<div class="QnA-list-title3">아이디</div>
						<div class="QnA-list-title4">날짜</div>
						<div class="QnA-list-title3">공개여부</div>
						<div class="QnA-list-title5">상태</div>
					</div>
				</div>
				<div class="QnA-body-list-FAQ"></div>
				<c:forEach items="${s}" var="s">
					<div class="QnA-lists">
						<div class="QnA-list1">${s.inquiry_category }</div>
						<div class="QnA-list2"
							onclick="location.href='detail.go?inquiry_no=${s.inquiry_no}'">
							<span class="leftToRight">${s.inquiry_title }</span>
						</div>
						<div class="QnA-list2"></div>
						<div class="QnA-list3">${s.inquiry_id}</div>
						<div class="QnA-list4">
							<fmt:formatDate value="${s.inquiry_question_day }" />
						</div>
						<div class="QnA-list3">${s.inquiry_encoding }</div>
						<div class="QnA-list5">미답변</div>
						<!-- 							<div class="QnA-list5">답변완료</div> -->
					</div>
				</c:forEach>
				<%-- 					<div id="Accordion_wrap">
						<c:forEach items="${s }" var="s">
							<div class="que">
								<span>${s.inquiry_title }</span>
							</div>
							<div class="anw">
								<span>${s.inquiry_answer }</span>
							</div>
						</c:forEach>
					</div> --%>
				<div class="row mt-5">
					<div class="col text-center">
						<div class="text-start py-4"
							style="display: flex; justify-content: center;">
							<div class="custom-pagination">
								<c:if test="${curPage != 1 }">
									<a href="page.change?p=${curPage - 1}&a_search=${asksearch.a_search}" class="prev">Previous</a>
								</c:if>
								<c:forEach begin="${startPage}" end="${endPage}"
									varStatus="loop">
									<c:choose>
										<c:when test="${curPage == loop.index}">
											<a href="page.change?p=${loop.index}&a_search=${asksearch.a_search}" class="active">${loop.index}</a>
										</c:when>
										<c:otherwise>
											<a href="page.change?p=${loop.index}&a_search=${asksearch.a_search}">${loop.index}</a>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:if test="${curPage != pageCount }">
									<a href="page.change?p=${curPage + 1}&a_search=${asksearch.a_search}" class="prev">Next</a>
								</c:if>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
<script>
	// 마우스 오버 시 색깔 변경
	function changeColorOnMouseOver(elementId) {
		document.getElementById(elementId).classList.add("highlight");
	}

	// 마우스 아웃 시 색깔 원래대로
	function changeColorOnMouseOut(elementId) {
		document.getElementById(elementId).classList.remove("highlight");
	}

	// 페이지가 로드될 때 실행되는 함수
	window.onload = function() {
		// 현재 로그인한 사용자의 id를 얻어온다 (여기에서는 임의로 "admin"이라고 가정)
		var currentUserId = "admin"; // 실제 사용자 id 값을 얻어와야 합니다

		// 작성 버튼을 가져온다
		var writeButton = document.getElementById("writeButton");

		// 조건에 따라 버튼을 활성화/비활성화 한다
		if (currentUserId === "admin") {
			writeButton.disabled = false; // 버튼 활성화
		} else {
			writeButton.disabled = true; // 버튼 비활성화
		}
	}
</script>
</html>