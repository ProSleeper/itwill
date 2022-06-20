package com.day16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num1, num2, result;

		String oper;

		try {
			System.out.println("두 개의 수?");

			num1 = sc.nextInt();
			num2 = sc.nextInt();

			System.out.println("연산자?");
			oper = sc.next();

			result = 0;
			if (oper.equals("+")) {
				result = num1 + num2;
			}
			else if (oper.equals("-")) {
				result = num1 - num2;
			}
			else if (oper.equals("*")) {
				result = num1 * num2;
			}
			else if (oper.equals("/")) {
				result = num1 / num2;
			}

			System.out.printf("%d %s %d = %d\n", num1, oper, num2, result);

		}
		catch (InputMismatchException e) {
			System.out.println("정수를 입력하세요.");
		}
		catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (Exception e) {
			System.out.println("안경 쓸까요?");
			e.printStackTrace();
		}
	}
}
