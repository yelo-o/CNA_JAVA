//DOM트리가 완성되고
//렌더링 준비가 되었을 때 window 객체의 load이벤트 발생한다
// window.addEventListener('load', ()=>{
    $(()=>{
        //DOM트리에서 form객체찾기
        // const formObj = document.querySelector('form.signup')
        const formObj = $('form.signup')
    
        //아이디입력란 객체찾기
        // const inputIdObj = document.querySelector('form.signup>input[type=text]')
        const inputIdObj = $('form.signup>input[name=id]')
    
        //아이디중복확인버튼 객체찾기
        // const btIdDupchk = document.querySelector('form.signup>button.dupchk')
        const btIdDupchk = $('form.signup>button.dupchk')
    
        //가입버튼 객체찾기
        // const btSignup = document.querySelector('form.signup>button.signup')
        const btSignup = $('form.signup>button.signup')
        
        //아이디중복확인버튼(일반버튼)
        btIdDupchk.click(()=>{
            /*if($(inputIdObj).val() =='id1'){ //아이디입력값이 'id1'인 경우
                alert('이미사용중인 아이디입니다') //'이미사용중인 아이디입니다' 경고창
            }else { //아이디입력값이 'id1'가 아닌 경우
                btSignup.show()//가입버튼 보여주기
            }*/
            $.ajax({
				url:`${backURL}/iddupchk`,
				method:'get',
				data : `id=${inputIdObj.val()}`,
				success: (responseData)=>{
					console.log(responseData)
					if(responseData.trim() == '0') {
						alert("이미 사용중인 아이디입니다.")
					}else {
						btSignup.show()
					}
				},
				error:(xhr)=>{
					alert("에러" + xhr.status)
				}
				
			})
        })
        //가입버튼(전송버튼) 클릭 -> 폼의 submit이벤트발생
        //--폼 submit이벤트 발생시 할 일 START--
        formObj.submit((e)=>{
			if(e.keycode === 13){
				return false;
			}
            //비밀번호1, 2가 일치 확인
            // const pwdObj = document.querySelector('form.signup>input[name=pwd]')
            const pwdObj = $('form.signup>input[name=pwd]')
    
            // const pwd1Obj = document.querySelector('form.signup>input#p1')
            const pwd1Obj = $('form.signup>input#p1')
            if(pwdObj.val() != pwd1Obj.val()) {
                alert("비밀번호가 일치하지 않습니다")
                pwdObj.focus()
                return false
            }
            $.ajax({
                url: `${backURL}/signup`,
                method: 'post',
                data:
                    formObj.serialize() //Post 방식으로 전달될 떄만 사용 가능
                //     id:inputIdObj.val(),
                //     pwd:pwdObj.val(),
                //     name : $('form.signup>input[name=name]').val()
                // },
                    //{id:'abc', pwd:'p1', name:'n1'}, //"id=abc@pwd=p1&name=n1",
                ,
                // success: (responseData) =>{
                    // const responseObj = JSON.parse(responseData) //json문자열을 js객체로 변환
                success: (responseData) =>{ //json문자열을 js객체로 변환
                	console.log(responseData)
                    if(responseData == 0){
                        //실패경우 할 일
                        alert("가입 실패!!!")
                    }else{
                        //성공경우 할 일
                        alert("가입이 완료되었습니다.")
                        location.href='layout.jsp'
                    }
                    // alert(responseData)
    
                },
                error: ()=>{ //404, 500번대, CORS 에러
    
                }
            })
            return false
            
            // e.preventDefault(); //back요청 막기
                
        })
        //--폼 submit이벤트 발생시 할 일 END--
    
        //--아이디 입력란에 'focus'이벤트발생시 할 일 START--
        //가입버튼 사라지기
        inputIdObj.focus(()=>{
            btSignup.hide()
        })
    
        //--아이디 입력란에 focus이벤트발생시 할 일 END--
    })
    