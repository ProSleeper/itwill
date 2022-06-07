package com.day7;

import java.util.Scanner;

public class Rect {
	
	int w, h;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("가로?");
		w = sc.nextInt();
		
		System.out.println("세로?");
		h = sc.nextInt();
		
		
		
	}
	public int area() {
		int result;
		
		result = w * h;
		
		return result;
	}
	
	public int length() {
		
		//이건 |연산보다 << 연산이 더 먼저라서 오류
		return (w+h)<<1;
	}
	public void print(int a, int l) {
		System.out.println(a);
		System.out.println(l);
	}
	
	
}
