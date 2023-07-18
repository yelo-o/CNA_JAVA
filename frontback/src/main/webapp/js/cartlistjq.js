$(()=>{
	$('div.cartlist+button').click(()=>{
		$.ajax({
			url: `${backURL}/addorder`,
			success: (responseData)=>{
				if(responseData.trim() == '1'){
					alert('주문성공')
					location.href=`${backURL}/orderlist`
				}else if(responseData.trim() == '0'){
					alert('주문실패')
				}else{
					alert(responseData.trim())
				}
			}
		})
	})
})