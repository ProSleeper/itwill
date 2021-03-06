package com.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int su;
		
		System.out.print("수 입력?");
		su = Integer.parseInt(br.readLine());
		
		String str;
		
		str = su % 2 > 0 ? "양수" : "음수";
		
		//A && B (A and B) : A,B 둘다 true일 때 true
		//A || B (A or B) : A 또는 B 둘 중 하나만 true이면 true;
		
		str = su % 4 == 0 && su % 100 !=0 || su % 400 == 0 ? "윤년" : "평년";
		
		System.out.println(su + ":" + str);
		
	}
	
}
