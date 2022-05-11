package product;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao1.ProductInfoDao1;
import vo1.ProductInfo;

@WebServlet("/product1/delete1")
public class ProductInfoDeleteController1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("productId") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		int productId = Integer.parseInt(request.getParameter("productId")); 
		
		// 첨뷰파일이 있는 공지사항을 삭제하는 과정을 다시 떠올려보기
		
		
		
		ProductInfoDao1 dao = new ProductInfoDao1();
		// 이미지를 가지고 있는 상품 정보는 이미지를 삭제해준다		
		ProductInfo productInfo = dao.selectByIdx(productId);
		
		if(productInfo.getImg() == null) {
			// 파일 삭제
			String img = productInfo.getImg();
			String path = request.getRealPath("images/product");
			
			File file = new File(path, "/" + img);
			file.delete();
		}
		
		// DB에서 상품 정보를 삭제한다
		dao.deleteById(productId);
		
		// 상태코드 200 번환
		response.setStatus(HttpServletResponse.SC_OK);
	}
}
