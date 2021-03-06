package dao1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import util1.Database;
import vo1.MemberInfo;

public class MemberInfoDao1 {
	public boolean insert(MemberInfo memberInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO member_info(id, pw, name, tel, addr, email, joinDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
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
	
	public MemberInfo selectById(String id) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberInfo memberInfo = null;
		
		try {
			String sql = "SELECT * FROM member_info WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int idx = rs.getInt("idx");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				String email = rs.getString("email");
				
				String t_joinDate = rs.getString("joinDate");
				// parse() ???????????? ???????????? ?????? ???????????? ?????? ???????????? ?????? ??????(LocalDateTime)?????? ????????? ??? ?????????
				// ?????? ???????????? ?????? ???????????? yyyy-MM-ddTHH:mm:ss ??? ?????? ??????????????????
				
				// t_joinDate??? ???????????? ???????????? ?????? -> 1000??? ?????????????
				t_joinDate = t_joinDate.substring(0,19);
				
				// t_joinDate??? ????????? ???????????? ??????????????? T??? ?????????
				t_joinDate = t_joinDate.replace(' ', 'T');
				
				LocalDateTime joinDateTime = LocalDateTime.parse(t_joinDate);
				
				memberInfo = new MemberInfo(idx, id, pw, name, tel, addr, email, joinDateTime);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return memberInfo;
	}
	
	public MemberInfo selectByTel(String tel) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberInfo memberInfo = null;
		
		try {
			String sql = "SELECT * FROM member_info WHERE tel = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tel);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int idx = rs.getInt("idx");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String email = rs.getString("email");
				
				String t_joinDate = rs.getString("joinDate");
				t_joinDate = t_joinDate.substring(0, 19);
				t_joinDate = t_joinDate.replace(' ', 'T');
				
				LocalDateTime joinDateTime = LocalDateTime.parse(t_joinDate);
				
				memberInfo = new MemberInfo(idx, id, pw, name, tel, addr, email, joinDateTime);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return memberInfo;
	}
	
	public MemberInfo selectByEmail(String email) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberInfo memberInfo = null;
		
		try {
			String sql = "SELECT * FROM member_info WHERE email = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int idx = rs.getInt("idx");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				
				String t_joinDate = rs.getString("joinDate");
				t_joinDate = t_joinDate.substring(0, 19);
				t_joinDate = t_joinDate.replace(' ', 'T');
				
				LocalDateTime joinDateTime = LocalDateTime.parse(t_joinDate);
				
				memberInfo = new MemberInfo(idx, id, pw, name, tel, addr, email, joinDateTime);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return memberInfo;
		
	}
	
	public void updateMById(MemberInfo memberInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE member_info SET pw = ?, name = ?, tel = ?, addr = ?, email = ? WHERE id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getPw());
			pstmt.setString(2, memberInfo.getName());
			pstmt.setString(3, memberInfo.getTel());
			pstmt.setString(4, memberInfo.getAddr());
			pstmt.setString(5, memberInfo.getEmail());
			pstmt.setString(6, memberInfo.getId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
	}
	
	public void deleteMemberInfoById(String id) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM member_info WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
	}
}
