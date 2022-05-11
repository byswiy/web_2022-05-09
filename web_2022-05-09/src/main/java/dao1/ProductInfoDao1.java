package dao1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util1.Database;
import vo1.ProductInfo;

public class ProductInfoDao1 {
	public boolean insertProductinfo(ProductInfo productInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO product_info(name, category, stock, price, img, insertDate) VALUES (?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productInfo.getName());
			pstmt.setString(2, productInfo.getCategory());
			pstmt.setInt(3, productInfo.getStock());
			pstmt.setInt(4, productInfo.getPrice());
			pstmt.setString(5, productInfo.getImg());
			pstmt.setString(6, productInfo.getInsertDate().toString());
			
			int count = pstmt.executeUpdate();
			
			return count == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return false;
	}
	
	public void updateProduct(int productId) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		 try {
			 String sql = "SELET * FROM product_info WHERE productId = ?";
			 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
	}
	
	public void deleteMemberInfoById(int productId) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM product_info WHERE productId = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
	}
}
