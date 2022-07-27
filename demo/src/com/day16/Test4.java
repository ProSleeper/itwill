package com.day16;

import java.util.Scanner;

class MyAuthen{
	public void inputFormat(String str) throws Exception{
		
		
		if (str.length() < 1 || str.length() > 10) {
			throw new Exception("문자열의 길이는 5~10자 입니다.");
		}
		
//		if(!str.replaceAll("[a-zA-Z]", "").equals("")) {
//			throw new Exception("영문자만 가능합니다.");
//		}
		
		if(str.replaceAll("[a-zA-Z]", "").equals("") || str.replaceAll("[0-9]", "").equals("")) {
			throw new Exception("영문과 숫자를 혼용해주세요.");
		}
		
		//1. 5~10자 이내의 문자열
		//문자열의 길이는 5~10자 입니다.
		
		
		//2. 영문자만 입력
		// 영문자만 가능합니다.
	}
}


public class Test4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str;
		
		MyAuthen auth = new MyAuthen();
		
		try {
			
			System.out.println("문자열?");
			str = sc.next();
			
			auth.inputFormat(str);
			System.out.println(str);
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
}
