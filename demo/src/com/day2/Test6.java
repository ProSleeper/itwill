package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6 {

	public static void main(String[] args)  throws IOException  {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		float width, height;
		
		
		System.out.println("밑변과 높이를 입력해서 삼각형의 넓이를 구합니다.");

		System.out.print("밑변(w)을 입력해주세요?");
		width = Float.parseFloat(br.readLine());
		
		System.out.print("높이(h)을 입력해주세요?");
		height = Float.parseFloat(br.readLine());

		System.out.printf("넓이는 %.2f입니다.", width * height / 2);
	}
}
