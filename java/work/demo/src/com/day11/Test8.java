package com.day11;

import java.util.Scanner;

class Sum{
	protected int num1, num2, result;
	protected String oper;
	
	
	public void write() {
		System.out.printf("%d %s %d = %d", num1, oper, num2, result);
	}
}

class Calc extends Sum{
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		oper = sc.next();
		oper = oper.replaceAll("\\s", "");
	}
	
	public void calculate()
	{
		for(String op : new String[]{"+", "-", "*","/"}) {
			if (oper.indexOf(op) > -1) {
				num1 = Integer.parseInt(oper.substring(0, oper.indexOf(op)));
				num2 = Integer.parseInt(oper.substring(oper.indexOf(op) + 1));
				
				switch (oper.charAt(oper.indexOf(op))) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				default:
					break;
				}
				oper = op;
			}
		}
		
	}
}

public class Test8 {
	public static void main(String[] args) {
		Calc calculator = new Calc();
		calculator.input();
		calculator.calculate();
		calculator.write();
		
	}
}
