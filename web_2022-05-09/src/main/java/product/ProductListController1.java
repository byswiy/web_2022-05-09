package product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao1.ProductListDao1;

@WebServlet("/ProductInfoController1")
public class ProductListController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNumber = 1;
		if(request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		
		// Dao를 사용해서 전체 상품의 수를 가져온다
		ProductListDao1 dao = new ProductListDao1();
		int amount = dao.
		
		// arrayList를 상요해서 상품을 하나로 묶어준다
		
		// JSOㅜ 데이터를 구성한다
		
		// for문을 사용해서 json데이터를 꺼내온다
		
		// 
		int amount = 
		String json = "{\"amount\": " + amount +  \"list\":[{\"name\":\"상품이름\", \"category\" : \"상품카테고리\","
				      + "\"price\": " + price + ""\img\" : }";
	}
}
