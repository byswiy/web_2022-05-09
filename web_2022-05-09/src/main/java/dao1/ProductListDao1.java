package dao1;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util1.Database;

public class ProductListDao1 {
	public void amount(int pageNumber) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM product_info WHERE pageNumber = ? LIMIT = 5";
	}
}
