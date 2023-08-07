<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 전체 컨테이너 -->
<div class="mpMainContainer">
	<!-- 상단 (마이페이지&메뉴) 컨테이너 -->
	<div class="mpSubContainer">
		<div id="mpName"><a href="mypage.go">마이페이지</a></div>
		<!-- 메뉴 컨테이너 -->
		<div class="mpMenu">
			<div class="mpMenu-part" onclick="selectMenu(this)">
				<a href="mypage.profile.go">프로필 수정</a>	
			</div>
			<div class="mpMenu-part" onclick="selectMenu(this)">
				<a href="mypage.sitterReg.go">시터 등록 및 수정</a>	
			</div>
			<div class="mpMenu-part" onclick="selectMenu(this)">
				<a href="mypage.ticket.go">이용권</a>	
			</div>
			<div class="mpMenu-part" onclick="selectMenu(this)">
				<a href="mypage.usage.go">이용내역 및 리뷰작성</a>	
			</div>
		</div>
	</div>
	<div>
		<jsp:include page="${mypageContentPage }"></jsp:include>
	</div>
</div>

</body>
</html>