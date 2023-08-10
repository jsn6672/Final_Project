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
			<div class="mpS-pet-inform1">반려동물에게 이런 활동이 가능해요!</div>
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
			<div class="mpS-pet-inform2">시터님의 정보를 입력해 주세요!</div>
			<div class="mpS-pet-certif"><input type="file"></div>
			<div class="mpS-pet-gender"> 
				<input type="radio" name="mpSPetGender" value="male">남아
				<input type="radio" name="mpSPetGender" value="female">여아
				<input type="radio" name="mpSPetGender" value="neut">중성화 완료
			</div>
			<div><input type="checkbox">근무 중 돌봄대상의 보호를 위한 CCTV 촬영이 가능합니다.</div>
			<div><input type="checkbox">근무 중 돌봄대상의 보호를 위한 CCTV 촬영이 불가능합니다.</div>
			<div><textarea rows="10" cols="50" placeholder="간단한 자기소개를 입력해 주세요."></textarea> </div>
			<div><textarea rows="10" cols="50" placeholder="날짜와 함께 관련 경력을 입력해 주세요!"></textarea> </div>
			<div>돌봄 가능한 연령대를 선택해 주세요!</div>
			<div>희망급여를 선택해 주세요!</div>
		
		<!-- 내용 컨테이너 끝  -->	
		</div>

	<!-- 전체 컨테이너 끝 -->
	</div>

</body>
</html>