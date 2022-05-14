package product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao1.ProductListDao1;
import exception1.BadParameterException1;
import vo1.ProductInfo;
@WebServlet("/product1/detail1")
public class ProductDetailController1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if(request.getParameter("productId") == null) {
				throw new BadParameterException1();
			}
			
			int productId = Integer.parseInt(request.getParameter("productId"));
			
			// 존재하지 않는 경우 : 입력한 productId와 DB에 있는 idx를 비교해서
			ProductListDao1 dao = new ProductListDao1();
			ProductInfo productInfo = dao.selectProductInfoById(productId);
			
			if(productInfo == null) {
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
				return;
			}
			
			String data = "{\"name\":\"(1)\",\"category\":\"(2)\",\"stock\":\"(3)\",\"price\":\"(4)\",\"img\":\"(5)\"";
			
			data = data.replace("(1)", productInfo.getName());
			data = data.replace("(2)", productInfo.getCategory());
			data = data.replace("(3)", String.valueOf(productInfo.getStock()));
			data = data.replace("(4)", productInfo.getPrice() + "");
			data = data.replace("(5)", productInfo.getImg());
			
			response.setContentType("applicaion/json;charset=UTF-8");

			PrintWriter out = response.getWriter();
			
			out.print(data);
			
			out.close();
		} catch(BadParameterException1 e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
