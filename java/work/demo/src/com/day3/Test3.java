package com.day3;

import java.io.IOException;

public class Test3 {
	public static void main(String[] args) throws IOException {
		
		char ch;
		char result = ' ';
		
		ch = 'a';
		//ch = '가';
		
		//System.out.println(Integer.toString(ch));
		
		System.out.println("한개의 문자?");
		ch = (char)System.in.read();
		
		
		
//		result = ch >= 65 && ch <= 90 ? (char)(ch+32)
//				:(ch >= 'a' && ch <= 'z' ? (char)(ch-32):ch);
		
		if(ch >= 65 && ch < 90) {
			result = (char)(ch+32);
		}
		else if(ch >= 97 && ch <= 122) {
			result = (char)(ch-32);
		}
		
		
		System.out.println(ch + ":" + result);
	
	}

}
