package util1;

public class Validator1 {
	public boolean idValidator(String id) {
		// 아이디 길이
		boolean correctId = false;
		correctId = id.length() >= 4 && id.length() <= 10;
		
		if(!correctId) {
			return false;
		}
		// 아이디 영문(대소문자), 숫자만 가능
		correctId = id.matches("^[a-zA-Z0-9]+$");
		
		if(!correctId) {
			return false;
		}
		
		// 소문자 포함 여부
		for(int i=0; i<id.length(); i++) {
			char ch = id.charAt(i);
			
			correctId = ch >= 'a' && ch <= 'z';
			
			if(correctId) {
				break;
			}
		}
		
		if(!correctId) {
			return false;
		}
		
		// 대문자 포함 여부
		for (int i = 0; i < id.length(); i++) {
			char ch = id.charAt(i);

			correctId = ch >= 'A' && ch <= 'Z';

			if (correctId) {
				break;
			}
		}

		if(!correctId) {
			return false;
		}
				
		// 숫자 포함 여부
		for (int i = 0; i < id.length(); i++) {
			char ch = id.charAt(i);

			correctId = ch >= '0' && ch <= '9';

			if (correctId) {
				break;
			}
		}

		if(!correctId) {
			return false;
		}
				
		return correctId;
	}
	
	public boolean pwValidator(String pw) {
		// 비밀번호 길이
		boolean correctPw = false;
		correctPw = pw.length() >= 6 && pw.length() <= 16;

		if (!correctPw) {
			return false;
		}
		// 비밀번호 영문(대소문자), 숫자만 가능
		correctPw = pw.matches("^[a-zA-Z0-9]+$");

		if (!correctPw) {
			return false;
		}

		// 소문자 포함 여부
		for (int i = 0; i < pw.length(); i++) {
			char ch = pw.charAt(i);

			correctPw = ch >= 'a' && ch <= 'z';

			if (correctPw) {
				break;
			}
		}

		if (!correctPw) {
			return false;
		}

		// 대문자 포함 여부
		for (int i = 0; i < pw.length(); i++) {
			char ch = pw.charAt(i);

			correctPw = ch >= 'A' && ch <= 'Z';

			if (correctPw) {
				break;
			}
		}

		if (!correctPw) {
			return false;
		}

		// 숫자 포함 여부
		for (int i = 0; i < pw.length(); i++) {
			char ch = pw.charAt(i);

			correctPw = ch >= '0' && ch <= '9';

			if (correctPw) {
				break;
			}
		}

		if (!correctPw) {
			return false;
		}

		return correctPw;
	}
	
	public boolean nameValidator(String name) {
		boolean correctName = false;
		
		correctName = name.length() == 3;
		
		if(!correctName) {
			return false;
		}
		
		correctName = name.matches("^[가-힣]+$");
		
		if(!correctName) {
			return false;
		}
		return correctName;
	}
	
	public boolean telvalidator(String tel) {
		String[] tels = tel.split("-");
		
		if(tels.length == 3) {
		} else if(tels[0].length() == 3) {
			return false;
		} else if(tels[1].length() == 4 || tels[2].length() == 4) {
			return false;
		}
		
		return true;
	}
	
	public boolean addrValidator(String addr) {
		String[] city = {"서울특별시", "부산광역시", "대구광역시", "인천광역시", "광주광역시", "대전광역시", "울산광역시", "세종툭별자치시", 
		         "경기도", "강원도", "충청북도", "충청남도", "전라북도", "전라남도", "경상북도", "경상남도", "제주특별자치도"};
		
		for(String region : city) {
			if(region.equals(addr)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean emailValidator(String email) {
		return email.contains("@");
	}
}
