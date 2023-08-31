/**
 * 
 */

function validateForm() {
			console.log("check");
			var ptRfileInput = document.getElementById("pt_Rfile");
			if (ptRfileInput.value === "") {
				alert("파일을 선택해주세요.");
				return false; // 제출 방지
			}
			return true; // 제출 허용
		}
