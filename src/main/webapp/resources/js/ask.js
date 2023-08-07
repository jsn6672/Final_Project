function deleteQnA(no) {
	let ok = confirm('삭제하시겠습니까?')

	if (ok) {
		location.href = 'QnADelC?pkno=' + no;
	}
}

function QnAloginCheck(id) {
	let loginCheck = id;
	console.log(loginCheck);
	if (loginCheck == '') {
		alert('로그인 후 이용해주세요.');
		location.href = 'regask.go';
	} else {
		location.href = 'regask.go?id=' + id;
	}
}



function QnADetail(encoding, sessionId, inquiryId, no) {
	let ok = encoding;
	let id = sessionId;
	let id2 = inquiryId;
	console.log(ok);
	console.log(id);
	console.log(id2);

	if (ok == '비공개') {
		if (id == id2 || id == 'lhgsky100@naver.com') {
			location.href = 'QnADetailC?no=' + no
		} else {
			alert("비공개 게시물 입니다.");
		}

	} else {
		location.href = 'QnADetailC?no=' + no
	}

}

function isEmpty(input) {
	return !input.value;
}

function isTextareaEmpty(textarea) {
  return !textarea.value
}

function call() {
	let titleInput = document.querySelector("input[name='inquiry_title']");
	let bodytxt = document.querySelector("textarea[name='inquiry_body']");

	console.log(titleInput);
	console.log(bodytxt);


	if (isEmpty(titleInput)) {
		alert('제목을 입력해주세요.');
		titleInput.focus();
		return false;
	} 

	if (isTextareaEmpty(bodytxt)){
		alert('내용을 입력해주세요.');
		bodytxt.focus();
		return false;
		
	}

}


 // 현재 URL에서 카테고리 값을 가져옴 (예: QnAC?category=1)
const urlParams = new URLSearchParams(window.location.search);
const category = urlParams.get('category');

// 카테고리가 1일 경우 공지사항 요소에 highlight 클래스 추가
if (category === '1') {
	console.log(category);
	const noticeElement = document.getElementById('notice1');
	console.log(noticeElement);
	noticeElement.classList.add('highlighted');
} else if (category === '2') {
	const noticeElement = document.getElementById('notice2');
	noticeElement.classList.add('highlighted');

} else if (category === '3') {
	const noticeElement = document.getElementById('notice3');
	noticeElement.classList.add('highlighted');
}

// 자주 묻는 질문
$(".que").click(function() {
   $(this).next(".anw").stop().slideToggle(300);
  $(this).toggleClass('on').siblings().removeClass('on');
  $(this).next(".anw").siblings(".anw").slideUp(300); // 1개씩 펼치기
});


	// 마우스 오버 시 색깔 변경
	function changeColorOnMouseOver(elementId) {
		document.getElementById(elementId).classList.add("highlight");
	};

	// 마우스 아웃 시 색깔 원래대로
	function changeColorOnMouseOut(elementId) {
		document.getElementById(elementId).classList.remove("highlight");
	};

















