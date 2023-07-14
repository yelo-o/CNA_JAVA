<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=2.0">
        <link rel="stylesheet" href="../css/login.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="../js/loginjq.js"></script>
    </head>

    <body>
        <form class="login">
            <label for="id">아이디</label>
            <input name="id" 
                   id="id"       
                   placeholder="아이디를 입력하세요">

            <label for="pwd">비밀번호</label>
            <input name="pwd"
                   id="pwd"
                   type="password">
            <span>
                <input            type="checkbox" checked>아이디저장
            </span>
            <button>로그인</button>
        </form>

    </body>
<!-- name : 서버 전송 위한 이름 -->

</html>