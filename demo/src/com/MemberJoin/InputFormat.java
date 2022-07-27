package com.MemberJoin;

public class InputFormat {
	public void idCheck(String str) throws Exception{
		if (str.length() < 8 || str.length() > 15) {
			throw new Exception("문자열의 길이는 8~15자 입니다.");
		}

		if(str.replaceAll("[a-zA-Z]", "").equals("") || str.replaceAll("[0-9]", "").equals("")) {
			throw new Exception("영문과 숫자를 혼용해주세요.");
		}
	}
	
	public void pwCheck(String pw1, String pw2) throws Exception{


		if (!(pw1.equals(pw2))) {
			throw new Exception("입력한 비밀번호가 서로 다릅니다.");
		}
	}

}