package com.day4;

import java.io.IOException;
import java.util.Scanner;

public class Test8 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int num1, num2;
		char oper;
		
		System.out.println("ù ��°��?");
		num1 = sc.nextInt();
		
		System.out.println("�� ��°��?");
		num2 = sc.nextInt();
		
		System.out.println("������[+,-,*,/]?");
		oper = (char)System.in.read();
		
		switch (oper) {
		case '+':
			System.out.println("�� ���� ��: " + (num1 + num2));
			break;
		case '-':
			System.out.println("�� ���� ��: " + (num1 - num2));
			break;
		case '*':
			System.out.println("�� ���� ��: " + num1 * num2);
			break;
		case '/':
			System.out.println("�� ���� ����: " + num1 / num2);
			break;
			
		default:
			System.out.println("�ȹٷ� �Է���");
			break;
		}
		
		
		
	}
}
