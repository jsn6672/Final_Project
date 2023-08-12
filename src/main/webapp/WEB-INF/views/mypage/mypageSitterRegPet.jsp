<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: #FFEBE4BD;
	font-size: 15pt;
}

.birth_input {
	width: 400px;
	height: 60px;
	font-size: 15pt;
	font-weight: 400;
	background-color: #D9D9D9;
	color: black;
	border-radius: 5%;
	border: none;
}
</style>

</head>
<body>

	<form action="mypage.sitterRegPet.do" method="post" enctype="multipart/form-data">

		<!-- 전체 컨테이너 -->
		<div class="mpS-pet">
			<!-- 내용의 전체 div -->
			<div class="mpS-pet-sub">
				<!-- 로고 -->
				<div class="mpS-logo">
					<img id="mpS-logo" alt="" src="resources/img/mypage/MOSI-logo.png">
				</div>

				<div>${userInfo.user_name}님의정보를입력해주세요</div>
				<div>필요한 서류를 등록해주세요</div>
				<div>
					<input type="file" name="pt_file">
				</div>
				<div>
				
				
				
				</div>

				<div class="mpS-pet-inform1">반려동물에게 이런 활동이 필요해요!</div>
				<div class="mpS-pet-act">
					<div class="mpS-pet-act-bottom">
						<div class="mpS-pet-act-detail"><input type="checkbox" name="dolbom_act" value="2"> 산책</div>
						<div class="mpS-pet-act-detail"><input type="checkbox" name="dolbom_act" value="3"> 목욕</div>
						<div class="mpS-pet-act-detail"><input type="checkbox" name="dolbom_act" value="5"> 밥챙겨주기</div>
						<div class="mpS-pet-act-detail"><input type="checkbox" name="dolbom_act" value="7"> 호텔링</div>
					</div>
					<div class="mpS-pet-act-bottom">
						<div class="mpS-pet-act-detail"><input type="checkbox" name="dolbom_act" value="11"> 배변훈련</div>
						<div class="mpS-pet-act-detail"><input type="checkbox" name="dolbom_act" value="13"> 놀이훈련</div>
						<div class="mpS-pet-act-detail"><input type="checkbox" name="dolbom_act" value="17"> 사회화훈련</div>
						<div class="mpS-pet-act-detail"><input type="checkbox" name="dolbom_act" value="19"> 기타활동</div>
					</div>
				</div>
				<!-- 정보입력 -->
				<div class="mpS-pet-inform2">반려동물의 정보를 입력해 주세요!</div>
				<div class="mpS-pet-birth">아이의 생년 / 월</div>
				<div> <input placeholder="아이가 태어난 해를 입력해주세요 (YYYY)" class="birth_input" name="d_year"> 
					<input placeholder="아이가 태어난 달을 입력해주세요" class="birth_input" name="d_month">
				</div>
				<div class="mpS-pet-gender">
					<input type="radio" name="d_gender" value="male">남아 <input
						type="radio" name="d_gender" value="female">여아 <input
						type="radio" name="d_gender" value="neut">중성화 완료
				</div>
				<div>
					<input type="checkbox" name="d_check" value="1"> 알러지 또는 주의할 점이 있어요!
				</div>
				<div>
					<textarea rows="10" cols="50" placeholder="추가사항이 있다면 이곳에 적어주세요!" name="d_addnotice"></textarea>
				</div>
			</div>

			<!-- 전체 컨테이너 끝 -->
		</div>


	</form>



</body>
</html>