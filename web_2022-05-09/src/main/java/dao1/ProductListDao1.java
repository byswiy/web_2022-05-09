package dao1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util1.Database;
import vo.NoticeInfo;
import vo1.ProductInfo;

public class ProductListDao1 {
	
	public List<ProductInfo> getAmount(int pageNumber) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProductInfo> noticeInfoList = new ArrayList<>();

		try {
			String sql = "SELECT * FROM product_info ORDER BY id DESC LIMIT ?, 5 ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,	(pageNumber - 1) * 5);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				
				ProductInfo nthNotice = new ProductInfo();
				
				noticeInfoList.add(nthNotice);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return noticeInfoList;
	}
	
	public int getAmount1() {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int amount = 0;
		
		String sql = "SELECT COUNT(*) AS amount FROM product_info";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 공지사항의 갯수의 return 되는 결과가 무조건 있기 때문에
			rs.next();
			
			amount = rs.getInt("amount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return amount;
	}
	
	public ProductInfo selectProductInfoById(int productId) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ProductInfo noticeInfo = null;

		try {
			String sql = "SELECT * FROM product_info WHERE idx = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,	productId);

			rs = pstmt.executeQuery();
			
			// id로 전달받은 공지사항이 있다면
			if (rs.next()) {
				String name = rs.getString("name");
				String category = rs.getString("category");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String img = rs.getString("img");
				
				noticeInfo = new ProductInfo(productId, name, category, stock, price, img);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return noticeInfo;
	}
}
