package product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao1.ProductInfoDao1;
import util1.ProdValidator1;
import vo1.ProductInfo;

// 상품 정보 추가, 수정과 같이 클라이언트가 multipart.form-data로 파라미터를 보내면
// request로 파라미터를 꺼낼 수 없음
// request를 MultipartRequest로 변환 헤야함

// 상품 정보를 수정할 때 이미지 파일은 그대로이고
// 상품 이름, 카테고리, 재고, 가격을 수정하는 상황에서는
// img 파라미터를 보내지 않기 때문에
// DB의 상품 정보에 이미지 파일이 NULL이 된다
// 해결 방법 : 이와 같은 상황에서는 img 파라미터에 기존의 이미지 파일명을 담아서 보내도록
//           postman을 사용해서 이와 같이 해결하는건 쉬움 그러나 HTML/CSS/JS를 사용해서 이와 같이 처리하는 건 어려을 수 있음

@WebServlet("/product1/update1")
public class ProductInfoUpdateController1 extends HttpServlet {
	private static final int MAXIUM_FILE_SIZE = 5 * 1024 * 1024;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getRealPath("images/product");
		
		MultipartRequest mr= new MultipartRequest(request, path, MAXIUM_FILE_SIZE, "UTF-8", new DefaultFileRenamePolicy());
		
		if(mr.getParameter("productId") == null || mr.getParameter("stock") == null || mr.getParameter("price") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		int ProductId = Integer.parseInt(mr.getParameter("productId"));
		String name = mr.getParameter("name");
		String category = mr.getParameter("category");
		int stock = Integer.parseInt(mr.getParameter("stock")); // stock을 전달하지 않으면 다음 코드는 실행되지 못하고 null을 반환한다
		int price = Integer.parseInt(mr.getParameter("price"));
		// img 파라미터에 담긴 파일을 저장했을 대 저장된 실제 파일의 이름
		// getFileSystemName() : DefaultFileRenamePolicy 떄문에 클라이엍트가 전달한 파일의 이름 그대로 저장되지 않을 수 있음
		// 						 getFileSystemName() 를 사용하면 인자로 넣은 이름으로 전달된 파일이
		//						 저장된 실제 이름을 반환
		String img = mr.getFilesystemName("img");
		// if문으로 처리하지 않고 Dao에서도 처리할 수 있지만 조금 복잡함
		if(img == null) {
			img = mr.getParameter("img");
		}
		
		// 전달 받은 값 검증
		ProdValidator1 validator = new ProdValidator1();
		
		// 전달 받은 값을 하나의 정보로 합침
		ProductInfo productInfo = new ProductInfo();
		productInfo.setidx(ProductId);
		productInfo.setName(name);
		productInfo.setCategory(name);
		productInfo.setStock(stock);
		productInfo.setPrice(price);
		productInfo.setImg(img);
		
		ProductInfoDao1 dao = new ProductInfoDao1();
		dao.updateProductInfo(productInfo);
		
	}
}
