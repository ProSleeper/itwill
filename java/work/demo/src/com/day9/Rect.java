package com.day9;

public class Rect {
	public Rect() {
		System.out.println("기본 생성자");
	}
	
	public Rect(int aa) {
		System.out.println("정수 생성자");
	}
	
	public static void main(String[] args) {
		
		Rect rt = new Rect();
	}
}