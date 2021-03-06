package member1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo1.MemberInfo;

@WebServlet("/member1/delete1")
public class DeleteController1 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션에 저장된 로그인 정보에서 id를 꺼낸다
		HttpSession session = request.getSession();
		
		MemberInfo memberInfo = (MemberInfo) session.getAttribute("loginUserInfo");
		String id = memberInfo.getId();
		
		// 회원 탈퇴
		MemberService1 service = new MemberService1();
		service.deleteMemberInfo(id);
		
		// 회원 탈퇴
		session.invalidate();
		
		// 상태코드 200 번환
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
