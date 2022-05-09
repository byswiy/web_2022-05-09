package member1;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception1.BadParameterException1;
import util1.Validator1;
import vo1.MemberInfo;

@WebServlet("/member1/join1")
public class JoinController1 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pwChk = request.getParameter("pwChk");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
		LocalDateTime joinDate = LocalDateTime.now();
		
		// 파라미터 검증
		Validator1 validator = new Validator1();
		if(!validator.idValidator(id)) 				throw new BadParameterException1();
		else if(!validator.pwValidator(pw)) 		throw new BadParameterException1();
		else if(!pw.equals(pwChk)) 					throw new BadParameterException1();
		else if(!validator.nameValidator(name)) 	throw new BadParameterException1();
		else if(!validator.telvalidator(tel)) 		throw new BadParameterException1();
		else if(!validator.addrValidator(addr)) 	throw new BadParameterException1();
		else if(!validator.emailValidator(email))	throw new BadParameterException1();
		
		System.out.println("id -> " + id);
		System.out.println("pw -> " + pw);
		System.out.println("pwChk -> " + pwChk);
		System.out.println("name -> " + name);
		System.out.println("tel -> " + tel);
		System.out.println("addr -> " + addr);
		System.out.println("email -> " + email);
		
		// 전달 받은 값 뭉치기
		MemberInfo memberInfo = new MemberInfo(id, pw, name, tel, addr, email, joinDate);
		
		MemberService1 service = new MemberService1();
		int status = service.join(memberInfo);
		
		response.setStatus(status);
		
		} catch(BadParameterException1 e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
