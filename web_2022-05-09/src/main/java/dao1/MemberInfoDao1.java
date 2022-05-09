package dao1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util1.Database;
import vo1.MemberInfo;

public class MemberInfoDao1 {
	public boolean insert(MemberInfo memberInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
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
	
	public boolean select(MemberInfo memberInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean exist = false;
		
		try {
			String sql = "SELECT * FROM member_info WHERE id = ? AND tel = ? AND email = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(2, memberInfo.getTel());
			pstmt.setString(3, memberInfo.getEmail());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("id");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				
				memberInfo = new MemberInfo(id, tel, email);
				
				if(memberInfo != null) {
					exist = true;
				} 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return exist;
	}
}
