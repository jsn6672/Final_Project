function petsitterDelete(ps_id){
	let ok = confirm('삭제하시겠습니까?');
	
	if (ok){
		location.href = 'petsitter.delete.go?ps_id=' + ps_id;
		alert('삭제 되었습니다.');
	}
};

function petsitterNoticeUP(ps_id){
	let ok = confirm('공고를 올리겠습니까?');
	
	if (ok){
		location.href = 'petsitter.notice.up?ps_id=' + ps_id;
		alert('공고가 올라갔습니다.');
	}
};

function petsitterNoticeDOWN(ps_id){
	let ok = confirm('공고를 내리겠습니까?');
	
	if (ok){
		location.href = 'petsitter.notice.down?ps_id=' + ps_id;
		alert('공고가 내려갔습니다.');
	}
};

function caresitterDelete(cs_id){
	let ok = confirm('삭제하시겠습니까?');
	
	if (ok){
		location.href = 'caresitter.delete.go?cs_id=' + cs_id;
		alert('삭제 되었습니다.');
	}
};

function caresitterNoticeUP(cs_id){
	let ok = confirm('공고를 올리겠습니까?');
	
	if (ok){
		location.href = 'caresitter.notice.up?cs_id=' + cs_id;
		alert('공고가 올라갔습니다.');
	}
};

function caresitterNoticeDOWN(cs_id){
	let ok = confirm('공고를 내리겠습니까?');
	
	if (ok){
		location.href = 'caresitter.notice.down?ps_id=' + cs_id;
		alert('공고가 내려갔습니다.');
	}
};

function momsitterDelete(ms_id){
	let ok = confirm('삭제하시겠습니까?');
	
	if (ok){
		location.href = 'momsitter.delete.go?ms_id=' + ms_id;
		alert('삭제 되었습니다.');
	}
};

function momsitterNoticeUP(ms_id){
	let ok = confirm('공고를 올리겠습니까?');
	
	if (ok){
		location.href = 'momsitter.notice.up?ms_id=' + ms_id;
		alert('공고가 올라갔습니다.');
	}
};

function momsitterNoticeDOWN(ms_id){
	let ok = confirm('공고를 내리겠습니까?');
	
	if (ok){
		location.href = 'momsitter.notice.down?ms_id=' + ms_id;
		alert('공고가 내려갔습니다.');
	}
};

function momsitterContract(ms_id){
	console.log("!!!!!");
	const userId = ms_id;
    // AJAX 요청을 통해 사용자 데이터를 가져옴
    $.ajax({
        url: '/getUserDolbomData',
        type: 'GET',
        data: { userId: userId },
        success: function(datas) {
			console.log(datas);
            // 데이터를 팝업 창에 표시하는 로직 실행
            // 예: document.getElementById('popupField').value = data.fieldValue;
            // 팝업 창 열기 코드도 여기에서 실행 가능
			datas.forEach(function(data){
				console.log(11);
			});
//				$(".dolbomName").text(${d.d_name})	
				
			}	
        }); // ajax end;
    // 팝업 창 열기 코드 (예시: $('#popup').show();)

}; // function momsitterContract end

// 앞으로 해야할 일
// List<DolbomDTO> 이거는 까보면 [DolbomDTO, DolbomDTO, DolbomDTO......]
// Json으로 받았을 때도  [DolbomDTO, DolbomDTO, DolbomDTO......] 이거일거다. = datas
// data = DolbomDTO.d_name (첫번째 DolbomDTO에 담긴 d_name) 표시해주겠다 뭐 해주겠다


function drawStar(target) {
		  const starSpan = document.querySelector('.review_star span');
		  if (starSpan) {
		    const width = target.value * 10 + '%';
		    starSpan.style.width = width;
		    console.log(target.value);
		    document.querySelector("#star_value").value = target.value;
		  }
		};


		function drawStar2() {
			let starEls = document.querySelectorAll('.star_value');
			console.log(starEls + "----->>>");
			starEls.forEach(function(e) {
				console.log('dk')
				console.log(e.value);
				console.log(e.previousSibling.previousSibling)	
				let psEl = e.previousSibling.previousSibling;
				let parentSpan = psEl.previousSibling.previousSibling;
				console.log(parentSpan);
				const width = e.value * 10 + '%';
				console.log(width);
				parentSpan.style.width = width;	
			});

		};
		
window.onload =() =>{
	drawStar2();
}