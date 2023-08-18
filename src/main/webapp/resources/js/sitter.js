function petsitterDelete(ps_id){
	let ok = confirm('삭제하시겠습니까?')
	
	if (ok){
		location.href = 'petsitter.delete.go?ps_id' + ps_id
	}
}