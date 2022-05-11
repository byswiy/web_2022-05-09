package product;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao1.ProductInfoDao1;
import exception1.BadParameterException1;
import util1.ProdValidator1;
import vo1.ProductInfo;

@WebServlet("/product/add")
public class productAdd extends HttpServlet {
	private static final int MAXIUM_FILE_SIZE = 5 * 1024 * 1024; // 5MB
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRealPath("images/product");
		// 1. 전달 받은 값을 꺼낸다 (시작)
		
		// 첨부파일을 꺼내서 저장
		MultipartRequest mr= new MultipartRequest(request, path, MAXIUM_FILE_SIZE, "UTF-8", new DefaultFileRenamePolicy());
		
		String name = mr.getParameter("name");
		String category = mr.getParameter("category");
		
		if(mr.getParameter("stock") == null || mr.getParameter("price") == null) {
			throw new BadParameterException1();
//			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//			return;
		}
		
		int stock = Integer.parseInt(mr.getParameter("stock")); // stock을 전달하지 않으면 다음 코드는 실행되지 못하고 null을 반환한다
		int price = Integer.parseInt(mr.getParameter("price"));
		// img 파라미터에 담긴 파일을 저장했을 대 저장된 실제 파일의 이름
		String img = mr.getFilesystemName("img");
		LocalDateTime insertDate = LocalDateTime.now();
		
		// 1. 전달받은 값을 꺼낸다 (종료)
		
		// 전달 받은 값 검증
		ProdValidator1 validator = new ProdValidator1();
		
		// 2. 전달받은 값을 하나의 상품정보로 합친다
		ProductInfo productInfo = new ProductInfo(name, category, stock, price, img, insertDate);
		
		// 3. DB에 새로운 상품을 저장한다
		ProductInfoDao1 productInfodao = new ProductInfoDao1();
		
		productInfodao.insertProductinfo(productInfo);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
