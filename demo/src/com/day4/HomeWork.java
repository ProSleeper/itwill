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
			System.out.println();		//�����ؼ� �������� ���� ����
		}
		
		System.out.println("���: " + sum);
		
		
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
			
			System.out.println("1���� 100���� ���� Ȧ���� ��, ¦���� ��, ��ü�� ��");
			System.out.println("¦�� ��: " + sumEven);
			System.out.println("Ȧ�� ��: " + sumOdd);
			System.out.println("��: " + (sumOdd + sumEven));
			
			
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
		System.out.println("���: " + sum);
		
		
	}
	static void four() {
		int sum = 0;
		
		for (int i = 1; i <= 100; i++) {
			if(i % 3 ==0) {
				sum++;
			}
		}
		System.out.println("1���� 100������ ���� 3�� ����� ����");
		
		System.out.println("3�� ����� ����: " + sum);
		
		
	}
	static void five() {
		Scanner sc = new Scanner(System.in);
		int inputNumber1, inputNumber2;
		int sum = 0;
		
		
		System.out.println("�� ���� �Է��ϼ���.");
		
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
		
		System.out.println(inputNumber1 + " ~ " + inputNumber2 + " ������ ��: " + sum);
		
		
		
		
	}
//	static void six() {
//		
//		//���� for������ Ǯ�� Ǯ���µ�
//		//�� ����� �� �������Ŷ��...
//		//�Ⱦ��� �׳� 3�� for������ Ǫ�� �� �ڵ� ������ �ξ� ������
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
			System.out.println("���� ���� ���� ��ȣ �Է��ϼ���.(1~6)");
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