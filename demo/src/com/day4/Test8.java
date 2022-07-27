package com.day4;

import java.io.IOException;
import java.util.Scanner;

public class Test8 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int num1, num2;
		char oper;
		
		System.out.println("첫 번째수?");
		num1 = sc.nextInt();
		
		System.out.println("두 번째수?");
		num2 = sc.nextInt();
		
		System.out.println("연산자[+,-,*,/]?");
		oper = (char)System.in.read();
		
		switch (oper) {
		case '+':
			System.out.println("두 수의 합: " + (num1 + num2));
			break;
		case '-':
			System.out.println("두 수의 차: " + (num1 - num2));
			break;
		case '*':
			System.out.println("두 수의 곱: " + num1 * num2);
			break;
		case '/':
			System.out.println("두 수의 나눔: " + num1 / num2);
			break;
			
		default:
			System.out.println("똑바로 입력해");
			break;
		}
		
		
		
	}
}
