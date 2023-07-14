
$(()=>{
    // const prodNo = location.search.substring(1).split('=')[1] //product.html?prodNo=C0001
    //                                             // ==> search 결과: ?prodNo=C0001
    //                                             // ==> substring(1) 결과: prodNo=C0001
    //                                             // ==> split('=') 결과: [0]는 prodNo [1]는 C0001
    
    //상품번호
    const prodNo = sessionStorage.getItem('prodNo')
    $.ajax({
        url:'http://localhost:8888/back/product',
        method:'get',
        data:`prodNo=${prodNo}`, //전달데이터
        success:(responseObj)=>{ //{"prodNo":"C0001", "prodName":"아메리카노", "prodPrice":1000}
            console.log(responseObj, ' <- 요거는 응답 객체')
            
                const prodName = responseObj.prodName
                const prodPrice = responseObj.prodPrice

                console.log(prodName +' <- 요거는 상품이름')
                
                $('span.ko').html(prodName)
                $('span.price').html(prodPrice)
        },
        error: (xhr)=>{
            alert("에러")
        }
    })
    //상품이미지는 상품번호로 변경
    $('div.product_view_pic>img').attr('src', `../images/${prodNo}.jpg`)

})