package product;

import dao1.ProductListDao1;
import vo1.ProductInfo;

public class ProductService1 {
	public String loadNoticeInfoToJson(int productInfo) {
		// 공지사항의 상세 정보를 DB에서 불러온다
		ProductListDao1 dao = new ProductListDao1();
		ProductInfo noticeInfo = dao.selectProductInfoById(productInfo);
		
		// 불러온 상세 정보를 클라이언트에게 전달하기 위해 JSON으로 구성한다
		String data = null;
		
		// 공지사항을 잘 가져왔는지 검증
		if(noticeInfo != null) {
			data = "{\"name\": " + noticeInfo.getName() + ", \"category\": \"" + noticeInfo.getCategory() + "\",\"stock\":\""+ noticeInfo.getStock() 
			      + "\", \"price\": \"" + noticeInfo.getPrice() + "\", \"img\": \"" + noticeInfo.getImg() + "\"}";
		}
		return data;
	}
}
