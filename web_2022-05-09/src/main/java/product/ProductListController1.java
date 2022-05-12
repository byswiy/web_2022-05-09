package product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao1.ProductListDao1;
import vo1.ProductInfo;

@WebServlet("/poduct1/list1")
public class ProductListController1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}

		// Dao를 사용해서 전체 상품의 수를 가져온다
		ProductListDao1 dao = new ProductListDao1();
		int amountOfProductIndo = dao.getAmount1();
		
		// pageNumber와 amoutOfProductInfo 사용해서 없는 페이지 번호라면이라는 조건
		int startIndex = (pageNumber-1) * 10;
		if(startIndex >= amountOfProductIndo) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}
		// arrayList를 상요해서 상품을 하나로 묶어준다
		List<ProductInfo> productInfoList = dao.getAmount(pageNumber);
		
		// 불러온 공지사항 목록을 JSON으로 구성한다.
		// JSON 데이터를 구성한다
		// for문을 사용해서 json데이터를 꺼내온다
		String data = "{\"amount\" : " + amountOfProductIndo + ",";
		data += "\"list\":[";
		
		for (ProductInfo productInfo : productInfoList) {
			String name = productInfo.getName();
			data = data + "{\"list\": " + productInfo.getList() + ", \"category\": \"" + productInfo.getCategory()
					+ "\",\"price\":\"" + productInfo.getPrice() + "\", \"img\":\"" + productInfo.getImg() + "\"},";
		}
		data = data.substring(0, data.length() - 1);
		data = data + "]}";

		
		
	}
}
