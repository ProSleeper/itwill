package com.day7;

import java.util.Scanner;

public class Rect {
	
	int w, h;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("����?");
		w = sc.nextInt();
		
		System.out.println("����?");
		h = sc.nextInt();
		
		
		
	}
	public int area() {
		int result;
		
		result = w * h;
		
		return result;
	}
	
	public int length() {
		
		//�̰� |���꺸�� << ������ �� ������ ����
		return (w+h)<<1;
	}
	public void print(int a, int l) {
		System.out.println(a);
		System.out.println(l);
	}
	
	
}
