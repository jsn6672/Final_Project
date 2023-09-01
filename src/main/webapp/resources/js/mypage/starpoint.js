/**
 * 
 */

 
const drawStar = (target) => {
    document.querySelector(`.star span`).style.width = `${target.value * 10}%`;
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