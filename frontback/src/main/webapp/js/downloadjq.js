$(()=>{
	
	$("a.txt").click((e)=>{
		const urlTxt = '/frontback/download?filename=a.txt'
		$(e.target).attr('href', urlTxt)
		//return false가 없기 떄문에 기본 이벤트처리(url 요청)를 하러감
	})
	$("a.img").click((e)=>{
		const urlImg = '/frontback/download?filename=B0002.jpg'
		$.ajax({
			url: urlImg,
			processData: false,
			contentType: false,
			xhrFields:{
                responseType: 'blob'
            },
			success: (responseData)=>{
				 var imageUrl = URL.createObjectURL(responseData)
				 console.log(imageUrl)
				$('img').attr('src',  imageUrl)
			}
		})
		return false
	})
})