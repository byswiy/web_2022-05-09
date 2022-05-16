package dao1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import util1.Database;
import vo1.ProductInfo;

public class ProductListDao1 {	
	public int getCount() {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS amount FROM product_info";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			count = rs.getInt("amount");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return count;
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
	
	public void decreaseStockById(int productId) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE product_info SET stock = stock - 1 WHERE idx = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, productId);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
	
	}
	
	public List<ProductInfo> selectAll(int pageNumber) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProductInfo> productInfoList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM product_info LIMIT ?, 8";
			
			// 8이 의미하는 것은 한 페이지에 보여줘야할 상품의 수 1번 페이지라면 1-1 = 0 0*10 => 0
			int startIndex = (pageNumber - 1) * 8;

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startIndex);
			
			rs = pstmt.executeQuery();
			
			// 결과가 있을 수도 있고 없을 수도 있기 때문에
			// while을 사용해서 결과가 있을 때까지 동작하도록 한다
			while(rs.next()) {
				int nthIdx = rs.getInt("idx");
				String name = rs.getString("name");
				String category = rs.getString("category");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String img = rs.getString("img");
				String t_insertDate = rs.getString("insertDate");
				t_insertDate = t_insertDate.substring(0, t_insertDate.indexOf('.'));
				t_insertDate = t_insertDate.replace(' ', 'T');
				LocalDateTime insertDate = LocalDateTime.parse(t_insertDate);
				
				ProductInfo nthProductInfo = new ProductInfo(nthIdx, name, category, stock, price, img, insertDate);
				
				productInfoList.add(nthProductInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		
		return productInfoList;
	}
}
