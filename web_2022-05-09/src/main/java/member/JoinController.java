package member;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.BadParameterException;
import util.Validator;
import vo.MemberInfo;

@WebServlet("/member/join1")
public class JoinController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String pwChk = request.getParameter("pwChk");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String addr = request.getParameter("addr");
	String email = request.getParameter("email");
	LocalDateTime joinDate = LocalDateTime.now();
	
	// 파라미터 검증
	Validator validator = new Validator();
	if(!validator.idValidator(id)) 				throw new BadParameterException();
	else if(!validator.pwValidator(pw)) 		throw new BadParameterException();
	else if(!pw.equals(pwChk)) 					throw new BadParameterException();
	else if(!validator.nameValidator(name)) 	throw new BadParameterException();
	else if(!validator.telvalidator(tel)) 		throw new BadParameterException();
	else if(!validator.addrValidator(addr)) 	throw new BadParameterException();
	else if(!validator.emailValidator(email))	throw new BadParameterException();
	
	System.out.println("id -> " + id);
	System.out.println("pw -> " + pw);
	System.out.println("pwChk -> " + pwChk);
	System.out.println("name -> " + name);
	System.out.println("tel -> " + tel);
	System.out.println("addr -> " + addr);
	System.out.println("email -> " + email);
	
	// 전달 받은 값 뭉치기
	MemberInfo memberInfo = new MemberInfo(id, pw, name, tel, addr, email, joinDate);
	
	MemberService service = new MemberService();
	int status = service.join(memberInfo);
	
	response.setStatus(status);
	
	}

}
