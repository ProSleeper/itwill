package com.MemberJoin;

public class InputFormat {
	public void idCheck(String str) throws Exception{
		if (str.length() < 8 || str.length() > 15) {
			throw new Exception("���ڿ��� ���̴� 8~15�� �Դϴ�.");
		}

		if(str.replaceAll("[a-zA-Z]", "").equals("") || str.replaceAll("[0-9]", "").equals("")) {
			throw new Exception("������ ���ڸ� ȥ�����ּ���.");
		}
	}
	
	public void pwCheck(String pw1, String pw2) throws Exception{


		if (!(pw1.equals(pw2))) {
			throw new Exception("�Է��� ��й�ȣ�� ���� �ٸ��ϴ�.");
		}
	}

}