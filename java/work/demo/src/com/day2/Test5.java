package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test5 {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name;
		int kor, eng, tot;
		
		System.out.print("�̸�?");
		name = br.readLine();
		
		System.out.print("����");
		kor = Integer.parseInt(br.readLine());
		
		System.out.print("����");
		eng = Integer.parseInt(br.readLine());
		
		tot = kor + eng;
		
		System.out.printf("%s�� ������ %d�Դϴ�.",name, tot  );
		
	}
}
