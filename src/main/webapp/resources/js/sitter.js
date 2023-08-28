function petsitterDelete(ps_id){
	let ok = confirm('삭제하시겠습니까?');
	
	if (ok){
		location.href = 'petsitter.delete.go?ps_id=' + ps_id;
		alert('삭제 되었습니다.');
	}
}

function petsitterNoticeUP(ps_id){
	let ok = confirm('공고를 올리겠습니까?');
	
	if (ok){
		location.href = 'petsitter.notice.up?ps_id=' + ps_id;
		alert('공고가 올라갔습니다.');
	}
}

function petsitterNoticeDOWN(ps_id){
	let ok = confirm('공고를 내리겠습니까?');
	
	if (ok){
		location.href = 'petsitter.notice.down?ps_id=' + ps_id;
		alert('공고가 내려갔습니다.');
	}
}

function caresitterDelete(cs_id){
	let ok = confirm('삭제하시겠습니까?');
	
	if (ok){
		location.href = 'caresitter.delete.go?cs_id=' + cs_id;
		alert('삭제 되었습니다.');
	}
}

function caresitterNoticeUP(cs_id){
	let ok = confirm('공고를 올리겠습니까?');
	
	if (ok){
		location.href = 'caresitter.notice.up?cs_id=' + cs_id;
		alert('공고가 올라갔습니다.');
	}
}

function caresitterNoticeDOWN(cs_id){
	let ok = confirm('공고를 내리겠습니까?');
	
	if (ok){
		location.href = 'caresitter.notice.down?ps_id=' + cs_id;
		alert('공고가 내려갔습니다.');
	}
}
function momsitterDelete(ms_id){
	let ok = confirm('삭제하시겠습니까?');
	
	if (ok){
		location.href = 'momsitter.delete.go?ms_id=' + ms_id;
		alert('삭제 되었습니다.');
	}
}

function momsitterNoticeUP(ms_id){
	let ok = confirm('공고를 올리겠습니까?');
	
	if (ok){
		location.href = 'momsitter.notice.up?ms_id=' + ms_id;
		alert('공고가 올라갔습니다.');
	}
}

function momsitterNoticeDOWN(ms_id){
	let ok = confirm('공고를 내리겠습니까?');
	
	if (ok){
		location.href = 'momsitter.notice.down?ms_id=' + ms_id;
		alert('공고가 내려갔습니다.');
	}
}

function drawStar(target) {
		  const starSpan = document.querySelector('.review_star span');
		  if (starSpan) {
		    const width = target.value * 10 + '%';
		    starSpan.style.width = width;
		    console.log(target.value);
		    document.querySelector("#star_value").value = target.value;
		  }
		}


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

		}
		
window.onload =() =>{
	drawStar2();
}