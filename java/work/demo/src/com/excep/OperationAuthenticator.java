package com.excep;

public class OperationAuthenticator {
	public void inputFormat(String pStr) throws AuthenticationException {
		String[] temp = pStr.split(",");
		
		if (temp.length != 2) {
			throw new AuthenticationException("숫자 입력 형식 오류: " + pStr);
		} 
	}
	

	public void number(String pStr) throws AuthenticationException {

		try {
			if(pStr.indexOf(".") != -1) {
				double num = Double.parseDouble(pStr);
			}
			else {
				int num = Integer.parseInt(pStr);
			}
			
		} catch (NumberFormatException e) {
			throw new AuthenticationException("숫자 변환 불가: " + pStr);
		}
	}
	

	public void operator(char pChar) throws AuthenticationException {
		switch (pChar) {
		case '+':
		case '-':
		case '*':
		case '/':
			return;
		default:
			throw new AuthenticationException("연산자 오류: " + pChar);
		}
	}
}
