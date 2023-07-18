$(()=>{
	//const buttonObj = $('button.addtocart')
	const formObj = $('form.cart')
	formObj.submit(()=>{
		const prodNo = $('span.no').html()
		const qt = $('input[name=qt]').val()
		$.ajax({
			url: `${backURL}/addtocart`,
			data: `prodNo=${prodNo}&qt=${qt}`,
			success: ()=>{
				location.href = `${backURL}/productlist`
			}
		})
	})
})