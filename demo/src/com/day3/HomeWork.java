package com.day3;

import java.util.Scanner;


public class HomeWork {
	
	static void evenOrOdd() {
		Scanner sc = new Scanner(System.in);
		int inputNumber;
		
		System.out.println("������ �Է��ϼ���.");
		inputNumber = sc.nextInt();
		System.out.println(inputNumber % 2 == 0 ? "¦��" : "Ȧ��");
		
		
	};
	static void largestNumber() {
		Scanner sc = new Scanner(System.in);
		int inputNumber1;
		int inputNumber2;
		
		System.out.println("�� ������ �Է��ϼ���.");
		inputNumber1 = sc.nextInt();
		inputNumber2 = sc.nextInt();
		if(inputNumber1 < inputNumber2) {
			int temp = inputNumber1;
			inputNumber1 = inputNumber2;
			inputNumber2 = temp;
		}
		System.out.printf("���� ū ���� %d, ���� ���� ���� %d", inputNumber1, inputNumber2);
		System.out.println();
		
	};
	static void largestAnsSmallest() {
		Scanner sc = new Scanner(System.in);
		int inputNumber1;
		int inputNumber2;
		int inputNumber3;
		int inputNumber4;
		int biggest;
		int smallest;
		
		System.out.println("�װ��� ������ �Է��ϼ���.");
		inputNumber1 = sc.nextInt();
		inputNumber2 = sc.nextInt();
		inputNumber3 = sc.nextInt();
		inputNumber4 = sc.nextInt();
		
		biggest = inputNumber1;
		if(biggest < inputNumber2) {
			biggest = inputNumber2;
		}
		if(biggest < inputNumber3) {
			biggest = inputNumber3;
		}
		if(biggest < inputNumber4) {
			biggest = inputNumber4;
		}
		
		smallest = inputNumber1;
		if(smallest > inputNumber2) {
			smallest = inputNumber2;
		}
		if(smallest > inputNumber3) {
			smallest = inputNumber3;
		}
		if(smallest > inputNumber4) {
			smallest = inputNumber4;
		}
		
		System.out.printf("���� ū ���� %d, ���� ���� ���� %d", biggest, smallest);
		System.out.println();
	};
	static void leapYear() {
		Scanner sc = new Scanner(System.in);
		int inputYear;
		
		System.out.println("�⵵�� �Է��ϼ���.");
		inputYear = sc.nextInt();
		System.out.println((inputYear % 4 == 0) && (inputYear % 100 != 0) || (inputYear % 400 == 0)? "����" : "������");
	};
	static void discountRate() {
		Scanner sc = new Scanner(System.in);
		int inputNumber;
		int price = 15800;
		float result;
		
		System.out.println("���� ���� �Է��ϼ���.");
		inputNumber = sc.nextInt();
		
		result = price * inputNumber;
		if(inputNumber < 20 && inputNumber >= 10) {
			result *= 0.9f;
		}
		else if(inputNumber < 30 && inputNumber >= 20) {
			result *= 0.85f;
		}
		else if(inputNumber >= 30) {
			result *= 0.80f;
		}
		
		System.out.printf("���Լ���: %d��,  �Ǹ� �� �ݾ�: %.0f��", inputNumber, result);
		System.out.println();
		
	};
	static void passOrNonpass() {
		Scanner sc = new Scanner(System.in);
		String inputName;
		String passOrNonpass = "�հ�";
		int kor, eng, mat;
		int price = 15800;
		float result;
		
		System.out.println("�̸��� �Է��ϼ���.");
		inputName = sc.next();
		System.out.println("�� ������ ������ �Է��ϼ���.");
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		
		if((kor < 40) || (eng < 40) || (mat < 40) || ((kor + eng + mat) / 3 < 60)) {
			passOrNonpass = "���հ�";
		}
		
		
		
		System.out.printf("�̸�: " + inputName + "\n����: " + (kor + eng + mat) + ", ���: " + ((kor + eng + mat) / 3.0f) + ",����: " + passOrNonpass);
		System.out.println();
	};
	
	public static void main(String[] args) {

		boolean exit = true;
		Scanner sc = new Scanner(System.in);
		int inputNumber;

		while(exit) {

			System.out.println("���ϴ� ������ ��ȣ�� �Է��ϼ��� 1~6��(���� 7��)");

			inputNumber = sc.nextInt();

			switch (inputNumber) {
			case 1:
				evenOrOdd();
				break;
			case 2:
				largestNumber();
				break;
			case 3:
				largestAnsSmallest();
				break;
			case 4:
				leapYear();
				break;
			case 5:
				discountRate();
				break;
			case 6:
				passOrNonpass();
				break;
			default:
				exit = false;
				break;

			}
		}
		sc.close();
	}
}