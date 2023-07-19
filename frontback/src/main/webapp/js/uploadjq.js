$(()=>{
	$('form').submit(()=>{
		let formData = new FormData($('form')[0])
		formData.forEach((value, key)=>{
			console.log(key)
			console.log(value)
			console.log('-------')
		})
		$.ajax({
			url:'/frontback/upload',
			method:'post',
			data: formData,
			processData: false,
			contentType: false,
			success:()=>{
				alert("첨부성공")
			}
		})
		return false
	})
})