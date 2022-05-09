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
	
	public int selectService(MemberInfo memberInfo) {
		MemberInfoDao1 dao = new MemberInfoDao1();
		boolean exist = dao.select(memberInfo);
		
		if(exist) {
			return 409;
		}
		
		return 200;
	}
}
