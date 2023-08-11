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
	<div class="mpS-pet">
		<!-- 내용의 전체 div -->
		<div class="mpS-pet-sub">
			<!-- 로고 -->
			<div class="mpS-logo">
				<img id="mpS-logo" alt="" src="resources/img/mypage/MOSI-logo.png">
			</div>
			<div class="mpS-pet-inform1">반려동물에게 이런 활동이 필요해요!</div>
			<div class="mpS-pet-act">
				<div class="mpS-pet-act-bottom">
					<div class="mpS-pet-act-detail">산책</div>
					<div class="mpS-pet-act-detail">목욕</div>
					<div class="mpS-pet-act-detail">밥챙겨주기</div>
					<div class="mpS-pet-act-detail">호텔링</div>
				</div>
				<div class="mpS-pet-act-bottom">
					<div class="mpS-pet-act-detail">배변훈련</div>
					<div class="mpS-pet-act-detail">놀이훈련</div>
					<div class="mpS-pet-act-detail">사회화훈련</div>
					<div class="mpS-pet-act-detail">기타활동</div>
				</div>
			</div>
			<!-- 정보입력 -->
			<div class="mpS-pet-inform2">반려동물의 정보를 입력해 주세요!</div>
			<div class="mpS-pet-birth"></div>
			<div class="mpS-pet-gender"> 
				<input type="radio" name="mpSPetGender" value="male">남아
				<input type="radio" name="mpSPetGender" value="female">여아
				<input type="radio" name="mpSPetGender" value="neut">중성화 완료
			</div>
			<div><input type="checkbox"> 알러지 또는 주의할 점이 있어요!</div>
			<div><textarea rows="10" cols="50" placeholder="추가사항이 있다면 이곳에 적어주세요!"></textarea> </div>
		</div>

		<!-- 전체 컨테이너 끝 -->
	</div>

</body>
</html>