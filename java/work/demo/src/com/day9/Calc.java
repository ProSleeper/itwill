package com.day9;

import java.io.IOException;
import java.util.Scanner;

public class Calc {

	private int num1, num2, sum;
	private char oper;
	
	public boolean input() throws IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두개의 수?");
		
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		System.out.println("연산자?");
		oper = (char)System.in.read();
		
		
		if(oper != '+' && oper != '-' && oper != '*' && oper != '/') {
			return false;
		}
		return true;
	}
	
	public int result() {
		switch (oper) {
			case '+':
				sum = num1 + num2;
				break;
			case '-':
				sum = num1 - num2;
				break;
			case '*':
				sum = num1 * num2;
				break;
			case '/':
				sum = num1 / num2;
				break;
			default:
				break;
		}
		return sum;
	}
	
	public void print(int r) {
		System.out.println(num1 + " " + oper + " " + num2 +  " = " + sum);
	}
	
	public static void main(String[] args) throws IOException {
		
		Calc ob = new Calc();
		
		if(!ob.input()) {
			System.out.println("연산자 오류");
			return;
		}
		ob.print(ob.result());
	}
}



