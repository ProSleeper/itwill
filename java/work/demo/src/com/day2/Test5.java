package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test5 {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name;
		int kor, eng, tot;
		
		System.out.print("이름?");
		name = br.readLine();
		
		System.out.print("국어");
		kor = Integer.parseInt(br.readLine());
		
		System.out.print("영어");
		eng = Integer.parseInt(br.readLine());
		
		tot = kor + eng;
		
		System.out.printf("%s의 총점은 %d입니다.",name, tot  );
		
	}
}
