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

@WebServlet("/member1/update1")
public class UpdateController1 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String addr = request.getParameter("addr");
			String email = request.getParameter("email");
			
			Validator1 validator = new Validator1();
			if(!validator.pwValidator(pw)) 				throw new BadParameterException1();
			else if(!validator.nameValidator(name)) 	throw new BadParameterException1();
			else if(!validator.telvalidator(tel)) 		throw new BadParameterException1();
			else if(!validator.addrValidator(addr)) 	throw new BadParameterException1();
			else if(!validator.emailValidator(email))	throw new BadParameterException1();
			
			// session에 들어있는 로그인 정보에서 아이디를 꺼냄
			HttpSession session = request.getSession();
			MemberInfo loginInfo = (MemberInfo) session.getAttribute("loginUserInfo");
			String id = loginInfo.getId();
			
			MemberInfo memberInfo = new MemberInfo();
			memberInfo.setId(id);
			memberInfo.setPw(pw);
			memberInfo.setName(name);
			memberInfo.setTel(tel);
			memberInfo.setAddr(addr);
			memberInfo.setEmail(email);
			
			MemberService1 service = new MemberService1();
			service.updateMemberInfo(memberInfo);
			
			response.setStatus(HttpServletResponse.SC_OK);
		} catch(BadParameterException1 e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
	}

}
