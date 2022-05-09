package member;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	}

}
