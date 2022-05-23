<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>두두몰</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="../assets/favicon.ico" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css" />
    <link rel="stylesheet" href="../css/login.css" />
    <link rel="stylesheet" href="../css/logo.css" />
</head>
<body class="text-center">
    
  <main class="form-signin">
    <form action="#" method="POST">
      <h1 class="h3 mb-3 fw-normal">
        <i class="bi bi-hand-index-thumb" id="rightHandLogo"></i>
        <i class="bi bi-hand-index-thumb" id="leftHandLogo"></i>
        두두몰
      </h1>
  
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingInput" placeholder="아이디" name="id">
        <label for="floatingInput">아이디</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="pw">
        <label for="floatingPassword">비밀번호</label>
      </div>
  
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> 아이디 기억하기
        </label>
      </div>
      <button class="w-100 btn btn-lg btn-primary" id="login_btn" type="submit">로그인</button>
      <button class="w-100 btn btn-lg btn-secondary" type="submit" id="join_btn">회원가입</button>
    </form>
  </main>
  <script src="../js/jquery-3.6.0.min.js"></script>
  <script>
  	// 로그인 서비스를 연결하는 ajax
  	$("#login_btn").on("click", function(event) {
		event.preventDefault();
		
		let $id = $("#floatingInput");
		let $pw = $("#floatingPassword");
	
		let id = $id.val();
		let pw = $pw.val();

		$.ajax({
			url: "/shopping/member1/login1",
			type: "POST",
			data: "id="+id+"&pw="+pw,
			success: function() {
				alert("로그인에 성공했습니다");
				location.href="/shopping/index1.jsp";
			},
			error: function() {
				// 파라미터에 맞지 않을 때 400 반환
				if(location.status == 400) {
					alert("정보를 입력해주세요.");
				} else if(location.status == 401) {
					// 아이디, 비밀번호를 틀렸을 때
					alert("아이디, 비밀번호를 정확히 입력해주세요");
				}
			}
		});
	});
  	
	//회원가입 버튼을 눌렀을 떄
	$("#join_btn").on("click", function() {
		location.href="/shopping/join/join1.jsp";
	});
  </script>
  </body>
</html>


