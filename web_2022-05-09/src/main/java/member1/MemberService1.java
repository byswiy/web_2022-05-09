package member1;

import dao1.MemberInfoDao1;
import vo1.MemberInfo;

public class MemberService1 {
	public int join(MemberInfo memberInfo) {
		MemberInfoDao1 dao = new MemberInfoDao1();
		boolean result = dao.insert(memberInfo);
		
		if(result) {
			return 200;
		} else {
			return 400;
		}
	}
	
//	public int selectService(MemberInfo memberInfo) {
//		MemberInfoDao1 dao = new MemberInfoDao1();
//		boolean exist = dao.select(memberInfo);
//		
//		if(exist) {
//			return 409;
//		}
//		
//		return 200;
//	}
	
	// 아이디가 사용 중인지 여부를 확인하는 메서드
	public boolean isAlreadyId(String id) {
		MemberInfoDao1 dao = new MemberInfoDao1();
		
		MemberInfo memberInfo = dao.selectById(id);
		
		if(memberInfo == null) {
			return false;
		} else {
			return true;
		}
	}
	
	// 연
	public boolean isAlreadyTel(String tel) {
		MemberInfoDao1 dao = new MemberInfoDao1();
		
		MemberInfo memberInfo = dao.selectByTel(tel);
		
		if(memberInfo == null) {
			return false;
		} else {
			return true;
		}
	}
	
	// 연
		public boolean isAlreadyEmail(String email) {
			MemberInfoDao1 dao = new MemberInfoDao1();
			
			MemberInfo memberInfo = dao.selectByEmail(email);
			
			if(memberInfo == null) {
				return false;
			} else {
				return true;
			}
		}
}
