package com.day16;

import java.util.Scanner;

class MyAuthen{
	public void inputFormat(String str) throws Exception{
		
		
		if (str.length() < 1 || str.length() > 10) {
			throw new Exception("���ڿ��� ���̴� 5~10�� �Դϴ�.");
		}
		
//		if(!str.replaceAll("[a-zA-Z]", "").equals("")) {
//			throw new Exception("�����ڸ� �����մϴ�.");
//		}
		
		if(str.replaceAll("[a-zA-Z]", "").equals("") || str.replaceAll("[0-9]", "").equals("")) {
			throw new Exception("������ ���ڸ� ȥ�����ּ���.");
		}
		
		//1. 5~10�� �̳��� ���ڿ�
		//���ڿ��� ���̴� 5~10�� �Դϴ�.
		
		
		//2. �����ڸ� �Է�
		// �����ڸ� �����մϴ�.
	}
}


public class Test4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str;
		
		MyAuthen auth = new MyAuthen();
		
		try {
			
			System.out.println("���ڿ�?");
			str = sc.next();
			
			auth.inputFormat(str);
			System.out.println(str);
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
}
