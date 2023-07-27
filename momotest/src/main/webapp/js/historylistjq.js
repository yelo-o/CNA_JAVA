$(()=>{
    //--히스토리 조회 버튼 이벤트 발생 시 할 일 START--
    const btSignup = $('button.history')

    btSignup.click(()=>{
        $.ajax({
            url: `/momotest/historylist`,
            method: 'post',
            data:
                //{id : "id2"}
                btSignup.serialize() //Post 방식으로 전달될 때만 사용 가능
            ,
            success: (responseData) =>{ 
                //console.log('상품 목록 클릭');
                //location.href = `/momotest/productlist` //상품리스트 페이지 이동
                $('section').empty()
				$('section').html(responseData)
            },
            error: (xhr)=>{ //404, 500번대, CORS 에러
                alert("에러 : "+ xhr.status)
            }
        })
        return false
            
    })
    //--히스토리 조회 버튼 이벤트 발생 시 할 일 END--

})
