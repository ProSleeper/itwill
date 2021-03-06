package com.day3;

import java.util.Scanner;


public class HomeWork {
	
	static void evenOrOdd() {
		Scanner sc = new Scanner(System.in);
		int inputNumber;
		
		System.out.println("정수를 입력하세요.");
		inputNumber = sc.nextInt();
		System.out.println(inputNumber % 2 == 0 ? "짝수" : "홀수");
		
		
	};
	static void largestNumber() {
		Scanner sc = new Scanner(System.in);
		int inputNumber1;
		int inputNumber2;
		
		System.out.println("두 정수를 입력하세요.");
		inputNumber1 = sc.nextInt();
		inputNumber2 = sc.nextInt();
		if(inputNumber1 < inputNumber2) {
			int temp = inputNumber1;
			inputNumber1 = inputNumber2;
			inputNumber2 = temp;
		}
		System.out.printf("제일 큰 숫자 %d, 제일 작은 숫자 %d", inputNumber1, inputNumber2);
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
		
		System.out.println("네개의 정수를 입력하세요.");
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
		
		System.out.printf("제일 큰 숫자 %d, 제일 작은 숫자 %d", biggest, smallest);
		System.out.println();
	};
	static void leapYear() {
		Scanner sc = new Scanner(System.in);
		int inputYear;
		
		System.out.println("년도를 입력하세요.");
		inputYear = sc.nextInt();
		System.out.println((inputYear % 4 == 0) && (inputYear % 100 != 0) || (inputYear % 400 == 0)? "윤년" : "안윤년");
	};
	static void discountRate() {
		Scanner sc = new Scanner(System.in);
		int inputNumber;
		int price = 15800;
		float result;
		
		System.out.println("구입 갯수 입력하세요.");
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
		
		System.out.printf("구입수량: %d개,  판매 총 금액: %.0f원", inputNumber, result);
		System.out.println();
		
	};
	static void passOrNonpass() {
		Scanner sc = new Scanner(System.in);
		String inputName;
		String passOrNonpass = "합격";
		int kor, eng, mat;
		int price = 15800;
		float result;
		
		System.out.println("이름을 입력하세요.");
		inputName = sc.next();
		System.out.println("세 과목의 점수를 입력하세요.");
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		
		if((kor < 40) || (eng < 40) || (mat < 40) || ((kor + eng + mat) / 3 < 60)) {
			passOrNonpass = "불합격";
		}
		
		
		
		System.out.printf("이름: " + inputName + "\n총점: " + (kor + eng + mat) + ", 평균: " + ((kor + eng + mat) / 3.0f) + ",판정: " + passOrNonpass);
		System.out.println();
	};
	
	public static void main(String[] args) {

		boolean exit = true;
		Scanner sc = new Scanner(System.in);
		int inputNumber;

		while(exit) {

			System.out.println("원하는 문제의 번호를 입력하세요 1~6번(종료 7번)");

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
