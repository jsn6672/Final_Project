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

		<!-- 프로필 수정의 전체 컨테이너 -->
		<div class="mpP">
			<!-- 내용 부분 컨테이너 -->
			<div class="mpPDetailContainer">
			<span id="mpPName"><h1>손흥민님, 환영합니다!</h1></span>
				<!-- 프로필 부분 컨테이너 -->
				<div class="mpPProfile">
					<!-- 사진 및 사용 중인 서비스 -->
					<div class="mpPPicAndServ">
						<div class="mpPPicture">사진</div>
						<div class="mpPService">이용중인 서비스</div>
					</div>
					<!-- 정보 -->
					<div>
						<div id="mpPAddr">주소 보여라</div>
						<div id="mpPPhoneNo">전화번호 보여라</div>
					</div>
				</div>
							
			</div>
		</div> <!-- 프로필 수정의 전체 컨테이너 끝 -->

</body>
</html>