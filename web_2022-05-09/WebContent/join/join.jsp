<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../includes/URLs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/join.css">
    <link href="../css/logo.css" rel="stylesheet" />
</head>
<body class="text-center">
    
  <main class="form-signin">
    <form action="${JOIN_SERVLET }" method="POST">
      <h1 class="h3 mb-3 fw-normal">
    	<i class="bi bi-hand-index-thumb" id="rightHandLogo"></i>
        <i class="bi bi-hand-index-thumb" id="leftHandLogo"></i>
        두두몰
      </h1>
  
      <div class="form-floating">
        <input type="email" class="form-control" id="floatingInput" placeholder="Id" name="id">
        <label for="floatingInput">아이디</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="pw">
        <label for="floatingPassword">비밀번호</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="pwChk">
        <label for="floatingPassword">비밀번호 확인</label>
      </div>
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingName" placeholder="Name" name="name">
        <label for="floatingName">이름</label>
      </div>
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingTel" placeholder="Tel" name="tel">
        <label for="floatingTel">연락처</label>
      </div>
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingAddr" placeholder="Addr" name="addr">
        <label for="floatingAddr">주소</label>
      </div>
      <div class="form-floating">
        <input type="email" class="form-control" id="floatingEmail" placeholder="Email" name="email">
        <label for="floatingEmail">이메일</label>
      </div>
      
      <div class="form-floating">
        <ul class="list-group">
          <li class="list-group-item">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="term1">
              <label class="form-check-label" for="term1">
                모든 약관 동의
              </label>
            </div>
          </li>
          <li class="list-group-item">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="term2">
              <label class="form-check-label" for="term2">
                이용 약관 동의
              </label>
            </div>
            <div class="terms">
              천하를 주는 반짝이는 착목한는 보이는 얼마나 설레는 때까지 품고 피다. 살 얼음에 공자는 무한한 있으며, 찾아 쓸쓸한 보내는 부패뿐이다. 그러므로 지혜는 보내는 그들은 운다. 우리는 하였으며, 작고 있는 얼마나 우리 같은 것은 살았으며, 끓는다. 그들은 보이는 그러므로 하는 인도하겠다는 보는 피부가 돋고, 웅대한 말이다. 열락의 대고, 가슴이 있는 돋고, 불어 부패뿐이다. 오직 천지는 바이며, 보배를 노년에게서 고행을 이는 행복스럽고 이상의 봄바람이다. 날카로우나 낙원을 희망의 끝에 아니더면, 사라지지 밥을 같이, 설레는 피다. 그들을 무엇을 따뜻한 갑 인생에 희망의 꽃 것이다.

              그들에게 커다란 열락의 풍부하게 스며들어 것이다. 설산에서 꾸며 남는 위하여서. 않는 열매를 끓는 같으며, 지혜는 것이다. 뜨고, 구하기 못할 그리하였는가? 굳세게 고동을 돋고, 끓는 있는가? 남는 아니더면, 뼈 이 같이, 석가는 이성은 그들은 것이다. 어디 주는 그림자는 실현에 평화스러운 장식하는 인도하겠다는 아니다. 우리 생의 풀밭에 얼마나 것이다. 있는 속잎나고, 못할 거친 튼튼하며, 것은 되는 있다. 인생을 따뜻한 천지는 인간의 뛰노는 이상이 날카로우나 눈에 봄바람이다. 오직 붙잡아 심장의 열락의 싹이 트고, 두손을 위하여 것이 있다.

              것은 미묘한 길을 크고 있으며, 커다란 풍부하게 있는가? 바로 그러므로 이는 그것은 못할 평화스러운 황금시대다. 그들은 그들을 예가 때까지 구할 무엇을 그들은 고동을 보라. 같이 그들은 풀이 대고, 끝까지 아니다. 그것은 인생의 트고, 전인 찬미를 무엇을 청춘 있다. 소금이라 사는가 우리 그들의 옷을 온갖 대한 힘있다. 그들은 그들의 품으며, 피고, 그들의 이것이다. 트고, 인생의 품에 심장의 있음으로써 인생에 가치를 것이다. 거선의 가는 현저하게 그들의 있는 위하여, 인류의 피다.
            </div>
          </li>
          <li class="list-group-item">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="term3">
              <label class="form-check-label" for="term3">
                개인정보 수집 및 이용 동의
              </label>
            </div>
            <div class="terms">
              천하를 주는 반짝이는 착목한는 보이는 얼마나 설레는 때까지 품고 피다. 살 얼음에 공자는 무한한 있으며, 찾아 쓸쓸한 보내는 부패뿐이다. 그러므로 지혜는 보내는 그들은 운다. 우리는 하였으며, 작고 있는 얼마나 우리 같은 것은 살았으며, 끓는다. 그들은 보이는 그러므로 하는 인도하겠다는 보는 피부가 돋고, 웅대한 말이다. 열락의 대고, 가슴이 있는 돋고, 불어 부패뿐이다. 오직 천지는 바이며, 보배를 노년에게서 고행을 이는 행복스럽고 이상의 봄바람이다. 날카로우나 낙원을 희망의 끝에 아니더면, 사라지지 밥을 같이, 설레는 피다. 그들을 무엇을 따뜻한 갑 인생에 희망의 꽃 것이다.

              그들에게 커다란 열락의 풍부하게 스며들어 것이다. 설산에서 꾸며 남는 위하여서. 않는 열매를 끓는 같으며, 지혜는 것이다. 뜨고, 구하기 못할 그리하였는가? 굳세게 고동을 돋고, 끓는 있는가? 남는 아니더면, 뼈 이 같이, 석가는 이성은 그들은 것이다. 어디 주는 그림자는 실현에 평화스러운 장식하는 인도하겠다는 아니다. 우리 생의 풀밭에 얼마나 것이다. 있는 속잎나고, 못할 거친 튼튼하며, 것은 되는 있다. 인생을 따뜻한 천지는 인간의 뛰노는 이상이 날카로우나 눈에 봄바람이다. 오직 붙잡아 심장의 열락의 싹이 트고, 두손을 위하여 것이 있다.

              것은 미묘한 길을 크고 있으며, 커다란 풍부하게 있는가? 바로 그러므로 이는 그것은 못할 평화스러운 황금시대다. 그들은 그들을 예가 때까지 구할 무엇을 그들은 고동을 보라. 같이 그들은 풀이 대고, 끝까지 아니다. 그것은 인생의 트고, 전인 찬미를 무엇을 청춘 있다. 소금이라 사는가 우리 그들의 옷을 온갖 대한 힘있다. 그들은 그들의 품으며, 피고, 그들의 이것이다. 트고, 인생의 품에 심장의 있음으로써 인생에 가치를 것이다. 거선의 가는 현저하게 그들의 있는 위하여, 인류의 피다.
            </div>
          </li>
        </ul>
      </div>

      <button class="w-100 btn btn-lg btn-secondary" type="submit">회원가입</button>
    </form>
  </main>
  
  <script src="../js/jquery-3.6.0.min.js"></script>
  <script>
  	$("intput[id=term1]").on("click", function() {
  		
  	})
  	
  	// 아무것도 입력하지 않고 회원가입 버튼을 누르거나
  	// 잘못된 값을 입력하고 회원 가입 버튼을 누를 수도 있으므로
  	// 회원 가입 버튼을 눌렀을 때 자바스트립트에서 올바를 값을 입력했는지 아닌지
  	//									(입력값 검증)
  	// 를 체크해서 올바른 값을 입력했을 경우에만 회원 가입 서블릿으로 데이터를 전달해줘야함
  	
  	// a 태그나 submit 버튼의 경우에는 기본적으로 클릭 했을 때 
  	// 행동하는 기본 이벤트가 부여되어 있다
  	// a 태그 -> 텍스트나 img을 클릭하면 해당하는 URL로 페이지를 이동한다
  	// submit 태그 -> submit을 누르면 각 데이터들이 name이라는 속성의 값에 담겨서 form 태그의 action 속성에 있는 경로로 데이터를 보낸다
  	
  	// 회원 가입 버튼을 눌렀을 때 submit 버튼에 부여된 기본 클리 이벤트를 무시하고
  	// 사용자가 입력한 값을 검증한 뒤에
  	// 사용자가 모두 올마른 값을 입력했을 때만
  	// submit 버튼에 부여도니 기본 클릭 이벤트가 동작하도록 한다
  </script>
  </body>
</html>


