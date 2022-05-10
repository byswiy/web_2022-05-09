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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			Validator1 validator = new Validator1();
			
			if(!validator.idValidator(id)) throw new BadParameterException1();
			else if(!validator.pwValidator(pw))  throw new BadParameterException1();
			
			MemberInfo loginInfo = new MemberInfo();
			loginInfo.setId(id);
			loginInfo.setPw(pw);
			
			MemberService1 service = new MemberService1();
			if(service.isLogin(loginInfo)) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUserInfo", loginInfo);
				
				response.setStatus(HttpServletResponse.SC_OK);
			} else {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		} catch(BadParameterException1 e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	
	}

}
