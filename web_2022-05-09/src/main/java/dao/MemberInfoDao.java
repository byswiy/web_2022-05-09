package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.Database;
import vo.MemberInfo;

public class MemberInfoDao {
	public boolean insert(MemberInfo memberInfo) {
		Database db = new Database();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO member_info(id, pw, name, tel, addr, email, joinDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(2, memberInfo.getPw());
			pstmt.setString(3, memberInfo.getName());
			pstmt.setString(4, memberInfo.getTel());
			pstmt.setString(5, memberInfo.getAddr());
			pstmt.setString(6, memberInfo.getEmail());
			pstmt.setString(7, memberInfo.getJoinDate().toString());
			
			int count = pstmt.executeUpdate();
			
			return count == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		
	}
}
