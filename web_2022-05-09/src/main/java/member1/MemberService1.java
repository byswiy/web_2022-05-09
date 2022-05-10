package member1;

import javax.servlet.http.HttpServletResponse;

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
	
	public boolean isLogin(MemberInfo loginInfo) {
		MemberInfoDao1 dao = new MemberInfoDao1();
		
		MemberInfo memberInfo = dao.selectById(loginInfo.getId());
		
		if(memberInfo == null) {
			return false;
		} else {
			if(loginInfo.getPw().equals(memberInfo.getPw())) {
				return false;
			} else {
				return true;
			}
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
	private boolean isAlreadyId(String id) {
		MemberInfoDao1 dao = new MemberInfoDao1();
		
		MemberInfo memberInfo = dao.selectById(id);
		
		if(memberInfo == null) {
			return false;
		} else {
			return true;
		}
	}
	
	// 연락처가 사용 중인지 여부를 확인하는 메서드
	private boolean isAlreadyTel(String tel) {
		MemberInfoDao1 dao = new MemberInfoDao1();
		
		MemberInfo memberInfo = dao.selectByTel(tel);
		
		if(memberInfo == null) {
			return false;
		} else {
			return true;
		}
	}
	
	// 이메일이 사용 중인지 여부를 확인하는 메서드
	private boolean isAlreadyEmail(String email) {
		MemberInfoDao1 dao = new MemberInfoDao1();

		MemberInfo memberInfo = dao.selectByEmail(email);

		if (memberInfo == null) {
			return false;
		} else {
			return true;
		}
	}
	
	// 아이디, 연락처, 이메일 여부를 하나로 묶은 메서드
	public boolean isAlreadyIdOrTelOrEmail(MemberInfo memberInfo) {
		String id = memberInfo.getId();
		String tel = memberInfo.getTel();
		String email = memberInfo.getEmail();
		
		if(isAlreadyId(id)) {
			return true;
		}
		
		if(isAlreadyTel(tel)) {
			return true;
		}
		
		if(isAlreadyEmail(email)) {
			return true;
		}
		return false;
	}
}
