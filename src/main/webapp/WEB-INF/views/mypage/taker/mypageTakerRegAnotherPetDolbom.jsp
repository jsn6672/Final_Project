<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		function validateForm() {
			console.log("check");
			var ptRfileInput = document.getElementById("pt_Rfile");
			if (ptRfileInput.value === "") {
				alert("파일을 선택해주세요.");
				return false; // 제출 방지
			}
			return true; // 제출 허용
		}
	}) //레디펑션
</script>
</head>
<body>
	<div class="mpS-pet-2">
		<c:forEach items="${DolbomList }" var="s">
			<div class="body-content-another">
				<div>
					<span
						onclick="location.href='mypage.takerUpdateAnotherPetDolbom.go?d_no=${s.d_no}'">유저명:
						${s.d_name }</span>
				</div>
				<div>
					<span>나이: ${s.age }${s.agetype }</span>
				</div>
				<div>
					<span
						onclick="location.href='mypage.takerUpdateAnotherPetDolbom.go?d_no=${s.d_no}'">수정하기</span>

				</div>
			</div>

		</c:forEach>
		<div class="body-content-another">
			<span onclick="location.href='mypage.takerRegAnotherPetDolbom.go'">
				+ 새로운 돌보미를 입력해주세요</span>
		</div>
	</div>
	<div class="mpS-pet-3">
		<div>
			<form action="pettaker.update" method="post"
				enctype="multipart/form-data" onsubmit="return validateForm()">
				<div class="mpS-pet-4" style="height: 200px;">
					등록된 서류를 수정하고 싶으시면 파일을 입력 후 수정해주세요 <input type="file"
						name="pt_Rfile" id="pt_Rfile">
					<button>수정</button>
				</div>
			</form>
			<div class="mpS-pet-4">
				수정하기버튼을 클릭해보세요. <br> 추가와 수정이 가능합니다.
			</div>
		</div>
	</div>
</body>
</html>