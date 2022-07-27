package com.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num;
		String str;
		
		System.out.println("수 입력?");
		num = Integer.parseInt(br.readLine());
		
		if(num % 2 == 0) {
			str = "짝수";
		}
		else{
			str = "홀수";
		}
		
		System.out.println(num + ":" + str);

		
	}

}
