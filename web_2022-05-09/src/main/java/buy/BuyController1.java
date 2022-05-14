package buy;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao1.BuyListDao1;
import dao1.ProductListDao1;
import vo1.BuyInfo;
import vo1.ProductInfo;

@WebServlet("/buy1")
public class BuyController1 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(request.getParameter("userId") == null || request.getParameter("productId") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		String paymentMethod = request.getParameter("paymentMethod");
		int userId = Integer.parseInt(request.getParameter("userId"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		ProductListDao1 productInfoDao = new ProductListDao1();
		
		// 상품 정보를 가져오는 코드를 추가해서 재고가 있다면 밑의 코드를 실행하도록
		// 재고가 없다면 403을 반환하도록 한다
		ProductInfo productInfo = productInfoDao.selectProductInfoById(productId);
		if(productInfo.getStock() == 0) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		
		productInfoDao.decreaseStockById(productId);
		
		BuyInfo buyInfo = new BuyInfo(paymentMethod, userId, productId, LocalDateTime.now());
	
		BuyListDao1 buyListDao = new BuyListDao1();
		boolean result = buyListDao.insertBuyInfo(buyInfo);
		
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
