package com.day4;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		
		//반복문
		
		Scanner sc = new Scanner(System.in);
		
		int dan;
		
		System.out.println("단 입력?");
		dan = sc.nextInt();
	
		for(int i = 0; i < 9; i++) {
			System.out.println(dan + " * " + (i+1) + " = " + dan * (i+1));
		}
		
	}

}
