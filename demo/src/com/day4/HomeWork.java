package com.day4;

import java.util.Iterator;
import java.util.Scanner;

public class HomeWork {
	
	static void one() {
		
		int sum = 0;
		
		for (int i = 1; i <= 10; i++) {
			System.out.print("(");
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
				if(i > 1 && i != j) {
					System.out.print("+");
				}
				
				sum += j;
			}
			System.out.print(")");
			if(i != 10) {
				System.out.print("+");
			}
			System.out.println();		//개행해서 보여줄지 말지 선택
		}
		
		System.out.println("결과: " + sum);
		
		
	}
	static void two() {
			int sumOdd = 0;
			int sumEven = 0;
			
			for(int i = 1; i <= 100; i++) {
				
				if((i & 1) != 1) {
					sumEven += i;
				}
				else {
					sumOdd += i;
				}
			}
			
			System.out.println("1에서 100까지 수의 홀수의 합, 짝수의 합, 전체의 합");
			System.out.println("짝수 합: " + sumEven);
			System.out.println("홀수 합: " + sumOdd);
			System.out.println("합: " + (sumOdd + sumEven));
			
			
	}
	static void three() {
		
		int sum = 0;
		
		for(int i = 1; i <= 10; i++) {
			sum += ((i & 1) == 1) ? i : i * -1;
			
			if(i != 1) {
				System.out.print(((i & 1) == 1) ? "+" + i : i * -1);
			}
			else {
				System.out.print(1);
			}
			
		}
		System.out.println();
		System.out.println("결과: " + sum);
		
		
	}
	static void four() {
		int sum = 0;
		
		for (int i = 1; i <= 100; i++) {
			if(i % 3 ==0) {
				sum++;
			}
		}
		System.out.println("1에서 100까지의 수중 3의 배수의 갯수");
		
		System.out.println("3의 배수의 개수: " + sum);
		
		
	}
	static void five() {
		Scanner sc = new Scanner(System.in);
		int inputNumber1, inputNumber2;
		int sum = 0;
		
		
		System.out.println("두 수를 입력하세요.");
		
		inputNumber1 = sc.nextInt();
		inputNumber2 = sc.nextInt();
		
		if(inputNumber1 > inputNumber2) {
			int temp = inputNumber1;
			inputNumber1 = inputNumber2;
			inputNumber2 = temp;
		}
		
		for(int i = inputNumber1; i <= inputNumber2; i++) {
			sum += i;
		}
		
		System.out.println(inputNumber1 + " ~ " + inputNumber2 + " 까지의 합: " + sum);
		
		
		
		
	}
//	static void six() {
//		
//		//이중 for문으로 풀긴 풀었는데
//		//내 방식이 좀 괜찮은거라면...
//		//안쓰고 그냥 3중 for문으로 푸는 게 코드 적으로 훨씬 나을듯
//		
//		
//		int not = 5;
//		int not2 = 2;
//		
//		for(int i = 1; i <= 9; i++) {
//			for(int j = not2; j <= not; j++) {
//				
//				System.out.printf("%d x %d = %d   ", j , i , i * j);
//				if( j == 5 && i == 9) {
//					not = 9;
//					not2 = 6;
//					i = 1;
//					System.out.println();
//					System.out.println();
//				}
//			}
//			System.out.println();
//		}
//		
//	}
	
	static void six()
	{
		for (int k = 0; k < 2; k++) {
			for(int i = 1; i <= 9; i++) {
				for(int j = 2 + (k*4); j <= 5 + (k*4); j++) {
					
					System.out.printf("%d x %d = %d   ", j , i , i * j);
					
				}
				System.out.println();
				
			}
			System.out.println();
			System.out.println();
		}
	}

	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int inputNumber;
		
		do
		{
			System.out.println();
			System.out.println("보고 싶은 문제 번호 입력하세요.(1~6)");
			inputNumber = sc.nextInt();
			
			switch(inputNumber) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			default:
				
				break;
				
			}
			
		}while(inputNumber > 0 && inputNumber < 7 );
		
		
		
	}
}
