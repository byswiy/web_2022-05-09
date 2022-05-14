package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao1.ProductListDao1;
import vo1.ProductInfo;

@WebServlet("/product1/list1")
public class ProductListController1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}

		// Dao를 사용해서 전체 상품의 수를 가져온다
		ProductListDao1 dao = new ProductListDao1();
		int amountOfProductInfo  = dao.getCount();
		
		// pageNumber와 amoutOfProductInfo 사용해서 없는 페이지 번호라면이라는 조건
		int startIndex = (pageNumber-1) * 10;
		if(startIndex >= amountOfProductInfo) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			return;
		}
		// arrayList를 상요해서 상품을 하나로 묶어준다
		List<ProductInfo> productInfoList = dao.selectAll(pageNumber);
		
		// 불러온 공지사항 목록을 JSON으로 구성한다.
		// JSON 데이터를 구성한다
		// for문을 사용해서 json데이터를 꺼내온다
		String data = "{\"amount\" : " + amountOfProductInfo + ",";
		data += "\"list\":[";
		
		for(ProductInfo productInfo : productInfoList) {
			String name = productInfo.getName();
			String category = productInfo.getCategory();
			int price = productInfo.getPrice();
			String img = productInfo.getImg();
			
			String productJson = "{\"name\" : \"" + name + "\",\"category\" : \"" + category + "\",\"price\" : " + price + ",\"img\" : \"" + img + "\"}";
			data += productJson;
		}
		
		data += "]}";

		// json 데이터를 보낸다
		response.setContentType("application/json;charset=UTF-8");

		PrintWriter out = response.getWriter();

		out.print(data);

		out.close();
		
	}
}
