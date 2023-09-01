function petsitterDelete(ps_id) {
  let ok = confirm("삭제하시겠습니까?");

  if (ok) {
    location.href = "petsitter.delete.go?ps_id=" + ps_id;
    alert("삭제 되었습니다.");
  }
}

function petsitterNoticeUP(ps_id) {
  let ok = confirm("공고를 올리겠습니까?");

  if (ok) {
    location.href = "petsitter.notice.up?ps_id=" + ps_id;
    alert("공고가 올라갔습니다.");
  }
}

function petsitterNoticeDOWN(ps_id) {
  let ok = confirm("공고를 내리겠습니까?");

  if (ok) {
    location.href = "petsitter.notice.down?ps_id=" + ps_id;
    alert("공고가 내려갔습니다.");
  }
}

function caresitterDelete(cs_id) {
  let ok = confirm("삭제하시겠습니까?");

  if (ok) {
    location.href = "caresitter.delete.go?cs_id=" + cs_id;
    alert("삭제 되었습니다.");
  }
}

function caresitterNoticeUP(cs_id) {
  let ok = confirm("공고를 올리겠습니까?");

  if (ok) {
    location.href = "caresitter.notice.up?cs_id=" + cs_id;
    alert("공고가 올라갔습니다.");
  }
}

function caresitterNoticeDOWN(cs_id) {
  let ok = confirm("공고를 내리겠습니까?");

  if (ok) {
    location.href = "caresitter.notice.down?ps_id=" + cs_id;
    alert("공고가 내려갔습니다.");
  }
}

function momsitterDelete(ms_id) {
  let ok = confirm("삭제하시겠습니까?");

  if (ok) {
    location.href = "momsitter.delete.go?ms_id=" + ms_id;
    alert("삭제 되었습니다.");
  }
}

function momsitterNoticeUP(ms_id) {
  let ok = confirm("공고를 올리겠습니까?");

  if (ok) {
    location.href = "momsitter.notice.up?ms_id=" + ms_id;
    alert("공고가 올라갔습니다.");
  }
}

function momsitterNoticeDOWN(ms_id) {
  let ok = confirm("공고를 내리겠습니까?");

  if (ok) {
    location.href = "momsitter.notice.down?ms_id=" + ms_id;
    alert("공고가 내려갔습니다.");
  }
}

//caresitter
function caresitterContract(cs_id) {
  console.log("!!!!!");
  console.log(cs_id);
  // AJAX 요청을 통해 사용자 데이터를 가져옴
  $.ajax({
    url: "getUserDolbomDataCare",
    type: "GET",
    dataType: "json",
    //   data: { userId: userId },
    success: function (datas) {
      console.log(datas);
      console.log(222);
      console.log(datas.length);

      if (datas.length > 0) {
        let dom = "";

        for (let i = 0; i < datas.length; i++) {
          let d_name = datas[i].d_name;
          let d_no = datas[i].d_no;
          let age = datas[i].age;

          let agetype = datas[i].agetype;

          dom += `<div class="d-flex justify-contents-center align-items-center w-100 h-50 bg-red">
                	        <div class="flex-column justify-contents-center alignt-items-center w-50 h-100">
                    	        <span>${d_name}</span>
                        	    <span style="margin-left: 10px;">${age}</span>
								<span>${agetype}</span>
                        	</div>
                        	<div class="d-flex justify-contents-center alignt-items-center w-50 h-100 bg-green">
								<button onclick="caresitterContract3(${d_no},'${cs_id}')">신청</button>
                        	</div>
              		    </div>`;
        }
        console.log(dom);
        $(".dolbom-box").html(dom);
      } else {
        // 서버 응답이 비어있거나 실패한 경우 처리
        alert("돌보미를 등록해주세요");
      }
    }, // success end
  }); // ajax end;
  // 팝업 창 열기 코드 (예시: $('#popup').show();)
} // function momsitterContract end

// 앞으로 해야할 일
// List<DolbomDTO> 이거는 까보면 [DolbomDTO, DolbomDTO, DolbomDTO......]
// Json으로 받았을 때도  [DolbomDTO, DolbomDTO, DolbomDTO......] 이거일거다. = datas
// data = DolbomDTO.d_name (첫번째 DolbomDTO에 담긴 d_name) 표시해주겠다 뭐 해주겠다

function caresitterContract3(d_no, cs_id) {
  console.log("thisisno" + d_no);
  console.log("thisisid" + cs_id);
  let ok = confirm("신청하시겠습니까?");

  if (ok) {
    location.href = "caresitter.contract.do?d_no=" + d_no + "&cs_id=" + cs_id;
  }
}


// momsitter
function momsitterContract(ms_id) {
  console.log("!!!!!");
  console.log(ms_id);
  // AJAX 요청을 통해 사용자 데이터를 가져옴
  $.ajax({
    url: "getUserDolbomData",
    type: "GET",
    dataType: "json",
    //   data: { userId: userId },
    success: function (datas) {
      console.log(datas);
      console.log(222);
      console.log(datas.length);

       let dom = "";
      if (datas.length > 0) {

        for (let i = 0; i < datas.length; i++) {
          let d_name = datas[i].d_name;
          let d_no = datas[i].d_no;
          let age = datas[i].age;

          let agetype = datas[i].agetype;
          dom += `<div class="d-flex justify-contents-center align-items-center w-100 h-50 bg-red">
                	        <div class="flex-column justify-contents-center alignt-items-center w-50 h-100">
                    	        <span>${d_name}</span>
                        	    <span style="margin-left: 10px;">${age}</span>
								<span>${agetype}</span>
                        	</div>
                        	<div class="d-flex justify-contents-center alignt-items-center w-50 h-100 bg-green">
								<button onclick="momsitterContract2(${d_no},'${ms_id}')">신청</button>
                        	</div>
              		    </div>`;
			
		
        }
        console.log(dom);
        $(".dolbom-box").html(dom);
      } else {
        // 서버 응답이 비어있거나 실패한 경우 처리
        alert("돌보미를 등록해주세요");
      }
    }, // success end
  }); // ajax end;
  // 팝업 창 열기 코드 (예시: $('#popup').show();)
} // function momsitterContract end

// 앞으로 해야할 일
// List<DolbomDTO> 이거는 까보면 [DolbomDTO, DolbomDTO, DolbomDTO......]
// Json으로 받았을 때도  [DolbomDTO, DolbomDTO, DolbomDTO......] 이거일거다. = datas
// data = DolbomDTO.d_name (첫번째 DolbomDTO에 담긴 d_name) 표시해주겠다 뭐 해주겠다

function momsitterContract2(d_no, ms_id) {
  console.log("thisisno" + d_no);
  console.log("thisisid" + ms_id);
  let ok = confirm("신청하시겠습니까?");

  if (ok) {
    location.href = "momsitter.contract.do?d_no=" + d_no + "&ms_id=" + ms_id;
  }
}

// petsitter
function petsitterContract(ps_id) {
  console.log("!!!!!");
  console.log(ps_id);
  // AJAX 요청을 통해 사용자 데이터를 가져옴
  $.ajax({
    url: "getUserDolbomDataPet",
    type: "GET",
    dataType: "json",
    //   data: { userId: userId },
    success: function (datas) {
      console.log(datas);
      console.log(222);
      console.log(datas.length);

      if (datas.length > 0) {
        let dom = "";

        for (let i = 0; i < datas.length; i++) {
          let d_name = datas[i].d_name;
          let d_no = datas[i].d_no;
          let age = datas[i].age;

          let agetype = datas[i].agetype;

          dom += ` <div class="d-flex justify-contents-center align-items-center w-100 h-50 bg-red">
                            <div class="flex-column justify-contents-center alignt-items-center w-50 h-100">
                                <span>${d_name}</span>
                                <span style="margin-left: 10px;">${age}</span>
                                <span>${agetype}</span>
                            </div>
                            <div class="d-flex justify-contents-center alignt-items-center w-50 h-100 bg-green">
                                <button onclick="petsitterContract2(${d_no},'${ps_id}')">신청</button>
                            </div>
                          </div>`;
        }
        console.log(dom);
        $(".dolbom-box").html(dom);
      } else {
        // 서버 응답이 비어있거나 실패한 경우 처리
        alert("돌보미를 등록해주세요");
      }
    }, // success end
  }); // ajax end;
  // 팝업 창 열기 코드 (예시: $('#popup').show();)
} // function momsitterContract end

function petsitterContract2(d_no, ps_id) {
  console.log("thisisno" + d_no);
  console.log("thisisid" + ps_id);
  let ok = confirm("신청하시겠습니까?");

  if (ok) {
    location.href = "petsitter.contract.do?d_no=" + d_no + "&ps_id=" + ps_id;
  }
}

function drawTakeStar(target) {
  const starSpan = document.querySelector(".review_star span");
  if (starSpan) {
    const width = target.value * 10 + "%";
    starSpan.style.width = width;
    console.log(target.value);
    document.querySelector("#star_value").value = target.value;
  }
}

function drawStar2() {
  let starEls = document.querySelectorAll(".star_value");
  console.log(starEls + "----->>>");
  starEls.forEach(function (e) {
    console.log("dk");
    console.log(e.value);
    console.log(e.previousSibling.previousSibling);
    let psEl = e.previousSibling.previousSibling;
    let parentSpan = psEl.previousSibling.previousSibling;
    console.log(parentSpan);
    const width = e.value * 10 + "%";
    console.log(width);
    parentSpan.style.width = width;
  });
}

window.onload = () => {
  drawStar2();
};
