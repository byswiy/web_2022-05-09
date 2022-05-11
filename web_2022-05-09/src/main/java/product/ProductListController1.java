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

@WebServlet("/ProductInfoController1")
public class ProductListController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}

		// Dao를 사용해서 전체 상품의 수를 가져온다
		ProductListDao1 dao = new ProductListDao1();
		int amount = dao.getAmount1();

		// arrayList를 상요해서 상품을 하나로 묶어준다
		List<ProductInfo> noticeInfoList = dao.getAmount(pageNumber);

		amount = dao.getAmountOfNotice();

		// 불러온 공지사항 목록을 JSON으로 구성한다.
		// JSON 데이터를 구성한다
		// for문을 사용해서 json데이터를 꺼내온다
		String data = "{\"amount\" : " + amount + ",";
		data += "\"noticeList\":[";
		for (ProductInfo productInfo : noticeInfoList) {
			data = data + "{\"list\": " + productInfo.getList() + ", \"category\": \"" + productInfo.getCategory()
					+ "\",\"price\":\"" + productInfo.getPrice() + "\", \"img\":\"" + productInfo.getImg() + "\"},";
		}
		data = data.substring(0, data.length() - 1);
		data = data + "]}";

	}
}
