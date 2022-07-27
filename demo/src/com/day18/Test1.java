package com.day18;

//Steam
//데이터 입출력시 모든 데이터의 형태와는 관계없이
//단방향 흐름으로 데이터를 전송하는 클래스이다.


//in.read out.print 

//in : 기본 입력 스트림(byte stream)

public class Test1 {
	
	public static void main(String[] args) throws Exception{
		int data;
		
		System.out.println("문자열?");
		while ((data = System.in.read()) != -1) {
			
			char ch = (char)data;
			System.out.println(ch);
			
			
		}
		
	}

}
