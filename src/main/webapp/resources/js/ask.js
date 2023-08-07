 function selectMenu(element) {
            // 모든 mpMenu-part 요소에서 selected 클래스 제거
            var allMenuParts = document.querySelectorAll('.mpMenu-part');
            allMenuParts.forEach(menuPart => {
                menuPart.classList.remove('selected');
            });

            // 클릭한 요소에 selected 클래스 추가
            element.classList.add('selected');
        }function selectMenu() {
    var targetDiv = document.getElementById('targetDiv');
    targetDiv.style.backgroundColor = '#FFEBE4';
}
