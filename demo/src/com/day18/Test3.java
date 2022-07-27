package com.day18;

import java.io.InputStreamReader;
import java.io.Reader;

//InputStreamReader
//1byte stream을 2byte의 stream 변환


public class Test3 {

	public static void main(String[] args) throws Exception{
		int data;
		System.out.println("문자열 입력?");
		
		
		Reader rd = new InputStreamReader(System.in);
		
		while ((data = rd.read()) != -1) {
			char ch = (char)data;
			System.out.print(ch);
		}
		
		
		
	}
}
