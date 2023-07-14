$(() => {
    //--상품목록 얻기 START--

    //요청URL : http://localhost:8888/back/productlist
    //요청방식 : GET
    //요청전달데이터 없음

    //응답형식 : JSON
    //응답성공 데이터는 js객체
    $.ajax({
        url: 'http://localhost:8888/back/productlist',
        method: 'get',
        success: (responseObj) => { //자바스크립트 객체
            console.log(responseObj)
        
            const productOriginObj = $('div.productlist>div.product').first() //원본
            responseObj.forEach((r) => {
                let productCloneObj = productOriginObj.clone() //복제

                productCloneObj.addClass(r.prodNo) //복제본 클래스속성값 추가
                productOriginObj.parent().append(productCloneObj) //복제본 추가
        
                productCloneObj.find('img').attr('src', `../images/${r.prodNo}.jpg`).attr('alt', r.prodNo) //'ul>li>img' 찾는것과 같음
                productCloneObj.find('ul>li>span').html(r.prodName) //복제본 상품명
                productOriginObj.parent().append(productCloneObj) //복제본 추가
        
            })
            productOriginObj.hide()
        }
    })

    //front와 back간의 서로 응답형식에 대해 약속해야 함
    // const responseObj = [
    //     { prodNo: 'C0001', prodName: '아이스 아메리카노', prodPrice: 2000 },
    //     { prodNo: 'C0002', prodName: '따뜻한 아메리카노', prodPrice: 1500 },
    //     { prodNo: 'C0003', prodName: '사케라또 아포가토', prodPrice: 3000 }
    // ]

    // const productOriginObj = $('div.productlist>div.product').first() //원본

    // // let productCloneObj = productOriginObj.clone() //복제
    // responseObj.forEach((r) => {

    //     let productCloneObj = productOriginObj.clone() //복제
    //     productCloneObj.addClass(r.prodNo) //복제본 클래스속성값 추가
    //     productOriginObj.parent().append(productCloneObj) //복제본 추가

    //     productCloneObj.find('img').attr('src', `../images/${r.prodNo}.jpg`).attr('alt', 'r.prodNo') //'ul>li>img' 찾는것과 같음
    //     productCloneObj.find('ul>li>span').html(r.prodName) //복제본 상품명
    //     productOriginObj.parent().append(productCloneObj) //복제본 추가

    // })

    // productOriginObj.hide()

    // productCloneObj.addClass(responseObj[0].prodNo) //복제본 클래스속성값 추가
    // productOriginObj.parent().append(productCloneObj) //복제본 추가

    // productCloneObj.find('img').attr('src', `../images/${responseObj[0].prodNo}.jpg`).attr('alt','responseObj[0].prodNo') //'ul>li>img' 찾는것과 같음
    // productCloneObj.find('ul>li>span').html(responseObj[0].prodName) //복제본 상품명
    // productOriginObj.parent().append(productCloneObj) //복제본 추가

    //--상품목록 얻기 END--

    //--상품클릭할 때 할일 START-- $.deferred
    //  const divProductObj = $('div.product')
    //  console.log(divProductObj.length)

    //DOM 트리에는 아직 없지만 향후 추가될 객체들을 등록하려면
    //on('이벤트종류', '객체', '할 일') 함수를 써야 함
    $('div.productlist').on('click', 'div.product', (e)=>{ 
        alert($(e.currentTarget).attr('class') + ' clicked') //현재 e.target이 없기 때문에 e.currentTarget을 써줘야 함

        const prodNo = $(e.currentTarget).attr('class').split(" ")[1]
        alert(prodNo + ' clicked')

        //--WB에는 Storage가 제공됨 : localStorage(영구 저장소),
        //                           sessionStorage(탭단위 저장소)
        //--setItem(), getItem(), removeItem()
        sessionStorage.setItem("prodNo", prodNo)
        $('section').load(`./product.html`) //get방식 요청은 load()를 쓸 것!
    })
     //--상품클릭할 때 할일 END--

    
})

