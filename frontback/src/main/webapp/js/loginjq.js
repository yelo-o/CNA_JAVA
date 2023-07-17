$( ()=>{
    //로그인 폼
    const formObj = $('form.login')

    const cbObj = formObj.find("input[type=checkbox]") //아이디저장 체크박스
    const savedId = localStorage.getItem("savedId")
    if(savedId != null) {
        formObj.find("input[name=id]").val(savedId)
    }

    //--폼 submit이벤트 발생시 할 일 START--
    formObj.submit((e)=>{

        if(cbObj.prop('checked')) { //체크된 경우
            const idValue = formObj.find('input[name=id]').val()
            localStorage.setItem("savedId", idValue)
        }else { //체크해제된 경우
            localStorage.removeItem("savedId")
        }


        $.ajax({
            url: '/frontback/login',
            method: 'post',
            data: formObj.serialize(), //Post 방식으로 전달될 떄만 사용 가능
            success:(responseData)=>{
                if(responseData == 0){//실패경우 할 일
                    alert("로그인 실패" )
                    $('form.login>input[name=id]').focus()
                }else{ //성공경우 할 일
                    location.href='layout.jsp'
                }
            },
            error: (xhr)=>{ //404, 500번대, CORS 에러
            	alert("에러" + xhr.status)
            }
        })
        return false
        
        // e.preventDefault(); //back요청 막기
            
    })
    //--폼 submit이벤트 발생시 할 일 END--

})
