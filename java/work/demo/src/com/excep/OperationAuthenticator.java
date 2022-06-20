package com.excep;

public class OperationAuthenticator {
	public void inputFormat(String pStr) throws AuthenticationException {
		String[] temp = pStr.split(",");
		
		if (temp.length != 2) {
			throw new AuthenticationException("���� �Է� ���� ����: " + pStr);
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
			throw new AuthenticationException("���� ��ȯ �Ұ�: " + pStr);
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
			throw new AuthenticationException("������ ����: " + pChar);
		}
	}
}
