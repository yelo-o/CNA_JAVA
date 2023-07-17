//const backURL ='/frontback'
$(() => {

    //--상품클릭할 때 할일 START-- $.deferred
    //  const divProductObj = $('div.product')
    //  console.log(divProductObj.length)

    //DOM 트리에는 아직 없지만 향후 추가될 객체들을 등록하려면
    //on('이벤트종류', '객체', '할 일') 함수를 써야 함
    $('div.product').click((e)=>{ 
        const prodNo = $(e.currentTarget).attr('class').split(" ")[1]
        alert(prodNo + ' clicked')
        $.ajax({
			url:`${backURL}/product`,
			method:'get',
			data: `prodNo=${prodNo}`,
			success: (responseData)=>{
				console.log("responseData : ",responseData)
				$('section').empty()
				//$('section').html(responseData)
				$('section').html(responseData)
			}, 
			error: (xhr)=>{
				alert("에러" + xhr.status)
			}
			
		})

        //sessionStorage.setItem("prodNo", prodNo)
        //$('section').load(`./product.html`) //get방식 요청은 load()를 쓸 것!
    })
     //--상품클릭할 때 할일 END--
	
	$('div.pagegroup>span').click((e)=>{
		const classValue = $(e.target).attr('class') //page3, page4, page7
		const pageNo = classValue.substring(4)
		//alert(pageNo + "페이지를 요청")
		location.href=`${backURL}/productlist?cp=${pageNo}`
	})


    
})

