package com.day2;


public class Test2 {
	public static void main(String[] args) {
		
		
		//자료형 : int (정수)
		//num1 : 변수명
		int num1 = 20;
		int num2;
		num2 = 10;
		
		int num3;
		
		num3 = num1 + num2;
		
		System.out.print(num1);
		System.out.print(num3+"\n");
		System.out.print(num1 + "+" + num2 + "+" + num3 + '\n');
		
		
		num1 = 200;
		num2 = 100;
		System.out.print(num1 + "+" + num2 + "=" + num3);
		System.out.println();
		
		//format
		System.out.printf("%d+%d=%d", num1, num2, num3);
		System.out.printf("%d-%d=%d", num1, num2, num3);
		System.out.printf("%d+%d=%d", num1, num2, num3);
	
	}
	

}
