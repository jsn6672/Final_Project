<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var div2 = document.getElementsByClassName("mpMenu-part");

	function handleClick(event) {
		console.log(event.target);
		// console.log(this);
		// 콘솔창을 보면 둘다 동일한 값이 나온다

		console.log(event.target.classList);

		if (event.target.classList[1] === "clicked") {
			event.target.classList.remove("clicked");
		} else {
			for (var i = 0; i < div2.length; i++) {
				div2[i].classList.remove("clicked");
			}

			event.target.classList.add("clicked");
		}
	}

	function init() {
		for (var i = 0; i < div2.length; i++) {
			div2[i].addEventListener("click", handleClick);
		}
	}

	init();
</script>
</head>
<body>

	<!-- 전체 컨테이너 -->
	<div class="mpMainContainer">
		<!-- 상단 (마이페이지&메뉴) 컨테이너 -->
		<div class="mpSubContainer">
			<div id="mpName">
				<a href="mypage.go">마이페이지</a>
			</div>

			<!-- 메뉴 컨테이너 -->
			<div class="mpMenu">
				<c:choose>
					<c:when test="${userInfo.user_email_auth ne 2 }">
						<div class="mpMenu-part" id="mpMenu-part1"
							onmouseover="changeColor('mpMenu-part1')"
							onmouseout="restoreColor('mpMenu-part1')">
							<a href="mypage.profile.go">프로필 수정</a>
						</div>
						<div class="mpMenu-part" id="mpMenu-part2"
							onmouseover="changeColor('mpMenu-part2')"
							onmouseout="restoreColor('mpMenu-part2')">
							<a href="mypage.sitterReg.go">시터 등록 및 수정</a>
						</div>
						<div class="mpMenu-part" id="mpMenu-part3"
							onmouseover="changeColor('mpMenu-part3')"
							onmouseout="restoreColor('mpMenu-part3')">
							<a href="mypage.usage.go">메세지함</a>
						</div>
						<div class="mpMenu-part" id="mpMenu-part4"
							onmouseover="changeColor('mpMenu-part4')"
							onmouseout="restoreColor('mpMenu-part4')">
							<a href="mypage.regReview.go">리뷰작성 및 확인</a>
						</div>
						<div class="mpMenu-part" id="mpMenu-part5"
							onmouseover="changeColor('mpMenu-part5')"
							onmouseout="restoreColor('mpMenu-part5')">
							<a
								href="mypage.ticketthatihave.go?user_id=${sessionScope.userInfo.user_id}">이용권확인</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="mpMenu-part" id="mpMenu-part1"
							onmouseover="changeColor('mpMenu-part1')"
							onmouseout="restoreColor('mpMenu-part1')">
							<a href="mypage.certif.confirm">인증 확인 및 거절</a>
						</div>
						<div class="mpMenu-part" id="mpMenu-part2"
							onmouseover="changeColor('mpMenu-part2')"
							onmouseout="restoreColor('mpMenu-part2')">
							<a href="mypage.ticket.check">이용권</a>
						</div>
						<div class="mpMenu-part" id="mpMenu-part3"
							onmouseover="changeColor('mpMenu-part3')"
							onmouseout="restoreColor('mpMenu-part3')">
							<a href="mypage.usage.go">혹시 몰라서 남겨둔 칸1</a>
						</div>
						<div class="mpMenu-part" id="mpMenu-part4"
							onmouseover="changeColor('mpMenu-part4')"
							onmouseout="restoreColor('mpMenu-part4')">
							<a href="mypage.regReview.go">혹시 몰라서 남겨둔 칸2</a>
						</div>
						<div class="mpMenu-part" id="mpMenu-part5"
							onmouseover="changeColor('mpMenu-part5')"
							onmouseout="restoreColor('mpMenu-part5')">
							<a
								href="mypage.ticketthatihave.go?user_id=${sessionScope.userInfo.user_id}">혹시 몰라서 남겨둔 칸3</a>
						</div>

						<div class="mpMenu-part" id="mpMenu-part6"
							onmouseover="changeColor('mpMenu-part6')"
							onmouseout="restoreColor('mpMenu-part6')">
							<a href="mypage.regReview.go">혹시 몰라서 남겨둔 칸4</a>
						</div>
					</c:otherwise>
				</c:choose>
			</div>

		</div>
		<div>
			<jsp:include page="${mypageContentPage }"></jsp:include>
		</div>
	</div>

</body>
<script>
	var div2 = document.getElementsByClassName("mpMenu-part");

	function handleClick(event) {
		console.log(event.target);
		// console.log(this);
		// 콘솔창을 보면 둘다 동일한 값이 나온다

		console.log(event.target.classList);

		if (event.target.classList[1] === "clicked") {
			event.target.classList.remove("clicked");
		} else {
			for (var i = 0; i < div2.length; i++) {
				div2[i].classList.remove("clicked");
			}

			event.target.classList.add("clicked");
		}
	}

	function init() {
		for (var i = 0; i < div2.length; i++) {
			div2[i].addEventListener("click", handleClick);
		}
	}

	init();

	function changeColor(id) {
		var element = document.getElementById(id);
		element.style.backgroundColor = '#FFEBE4';
	}

	function restoreColor(id) {
		var element = document.getElementById(id);
		element.style.backgroundColor = ''; // 기존 배경색으로 복원
	}
</script>
</html>
