package member1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception1.BadParameterException1;
import util1.Validator1;
import vo1.MemberInfo;

@WebServlet("/member1/login1")
public class loginController1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그 아웃 처리
		HttpSession session = req.getSession();
		session.removeAttribute("loginUserInfo");

		resp.sendRedirect("/shopping/index1.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 아이디와 비밀번호의 파라미터 값을 꺼내온다
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			// 각 파라미터마다의 유효성 검사를 하는 클래스를 가져온다
			Validator1 validator = new Validator1();
			
			// 만약 아이디 유효성 검사가 맞지 않다면 BadParameterException1 예외를 발생시킨다
			// 마찬가지로 비밀번호 유효성 검사가 맞지 않다면 BadParameterException1 예외를 발생시킨다
			if(!validator.idValidator(id)) throw new BadParameterException1();
			else if(!validator.pwValidator(pw))  throw new BadParameterException1();
			
			// 로그인할 아이디와 비밀번호를 저장할 MemberInfo 클래스를 가져와서
			// 아이디와 비밀번호를 직접 저장한다 -> 전달받은 값을 합친다
			MemberInfo loginInfo = new MemberInfo();
			loginInfo.setId(id);
			loginInfo.setPw(pw);
			
			// 로그인할 서비스를 가져온다
			MemberService1 service = new MemberService1();
			// 만약 로그인 메서드가 잘 동작한다면(로그인에 성공했다면)
			if(service.isLogin(loginInfo)) {
				// 세션을 만들어 세션값을 저장하고 200번대 코드를 반환한다
				HttpSession session = request.getSession();
				session.setAttribute("loginUserInfo", loginInfo);
				
				response.setStatus(HttpServletResponse.SC_OK);
			} else {
				// 메서드가 제대로 동작하지 못했다면(로그인에 실패했다면) 400코드를 반환한다 -> 전달 받은 값이 규칙에 맞지 않을 때
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		} catch(BadParameterException1 e) {
			// 예외가 발생했다면 409 코드를 반환한다 -> 아이디 또는 비밀번호가 틀렸을 때
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	
	}

}
