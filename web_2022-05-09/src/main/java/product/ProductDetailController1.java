package product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao1.ProductListDao1;
import vo1.ProductInfo;
@WebServlet("/product1/detail1")
public class ProductDetailController1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		ProductListDao1 dao = new ProductListDao1();
		
		ProductInfo productInfo = dao.selectProductInfoById(pageNumber);
		
		ProductService1 service = new ProductService1();
		String data = service.loadNoticeInfoToJson(pageNumber);
		
		// 불러온 상세 정보를 클라이언트에게 전달하기 위해 JSON으로 구성한다
		
		// 공지사항을 잘 가져왔는지 검증
	}
}
