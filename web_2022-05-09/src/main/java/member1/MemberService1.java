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
	
	public void updateMemberInfo(MemberInfo memberInfo) {
		MemberInfoDao1 dao = new MemberInfoDao1();
		
		dao.updateMById(memberInfo);
	}
	
	public void deleteMemberInfo(String id) {
		MemberInfoDao1 dao = new MemberInfoDao1();
		dao.deleteMemberInfoById(id);
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
	
	public boolean isAlreadyTelOrEmail(String id, String tel, String email) {
		// 1. 로그인 한 회원 정보에 들어있는 id를 사용해서 회원 정보를 조회
		MemberInfoDao1 dao = new MemberInfoDao1();
		MemberInfo oldMemberInfo = dao.selectById(id);
		
		// 2. 회원 정보를 수정할 때 이메일을 바꾼다면 이메일 중복 여부 확인
		//   (1)에서 조회한 회원 정보의 이메일과 email로 전달 받은 이메일이 다르다면 이메일을 수정한다
		String oldEmail = oldMemberInfo.getEmail();
		if(!oldEmail.equals(email)) {
			// email로 전달받은 이메일을 사용해서 회원 정보를 조회한다
			MemberInfo memberInfo = dao.selectByEmail(email);
			
			if(memberInfo != null) {
				 // 조회가 됐다면 이메일 중복
				return true;
			} else {
				// 조회되지 않았다면 이메일 중복 아님
				return false;
			}
		}
		// 3. 회원 정보를 수정할 때 연락처를 바꾼다면 연락처 중복 여부를 확인
		String oldTel = oldMemberInfo.getTel();
		if (!oldTel.equals(tel)) {
			MemberInfo memberInfo = dao.selectByTel(tel);

			if (memberInfo != null) {
				// 연락처 중복
				return true;
			} else {
				// 연락처 중복 아님
				return false;
			}
		}
		// 이메일이나 연락처를 바꾸지 않는 상황이라면 이 return을 만나
		// false를 반환하도록 함
		return false;
	}
}
