const frontURL = 'http://localhost:5500/html'
const backURL = '/frontback'

//ajax 요청 함수 생성
function showAjax(targetUrl, targetObj) {
    targetObj.load(targetUrl)
}

// window.addEventListener('load', () => {
$(() => {
    const menuObjs = $('header>nav>ul>li>a')
    const sectionObj = $('section')

    //--메뉴 클릭될때 할 일 START--
    menuObjs.click((e) => {
        console.log($(e.target).attr('href'))
        
        switch ( $(e.target).attr('href') ) {
            case `/frontback/jsp/login.jsp`://로그인 메뉴
                console.log('로그인 클릭')
                showAjax($(e.target).attr('href'), sectionObj)
                break
                
            case 'logout': //로그아웃 메뉴
				$.ajax({
					url:`${backURL}/logout`,
					success: ()=>{
						location.href=`${backURL}/jsp/layout.jsp`
					}
				})
				break
            
            case `/frontback/jsp/signup.jsp`: //가입 메뉴
                console.log('회원가입 클릭')
                showAjax($(e.target).attr('href'), sectionObj)
                break

            case `productlist`: //상품 목록
                console.log('상품 목록 클릭');
                location.href = `${backURL}/productlist` //상품리스트 페이지 이동
                break
            case `cartlist`: //상품 목록
                console.log('장바구니목록 클릭');
                showAjax($(e.target).attr('href'), sectionObj)
                //location.href = `${backURL}/cartlist` //상품리스트 페이지 이동
                break
            case `orderlist`: //주문 목록
                console.log('주문목록 클릭');
                //showAjax($(e.target).attr('href'), sectionObj)
                location.href = `${backURL}/orderlist` //상품리스트 페이지 이동
                break
        }
        return false;
    })
    //--메뉴 클릭될때 할 일 END--
})