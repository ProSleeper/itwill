package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6 {

	public static void main(String[] args)  throws IOException  {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		float width, height;
		
		
		System.out.println("�غ��� ���̸� �Է��ؼ� �ﰢ���� ���̸� ���մϴ�.");

		System.out.print("�غ�(w)�� �Է����ּ���?");
		width = Float.parseFloat(br.readLine());
		
		System.out.print("����(h)�� �Է����ּ���?");
		height = Float.parseFloat(br.readLine());

		System.out.printf("���̴� %.2f�Դϴ�.", width * height / 2);
	}
}
