package com.day16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num1, num2, result;

		String oper;

		try {
			System.out.println("�� ���� ��?");

			num1 = sc.nextInt();
			num2 = sc.nextInt();

			System.out.println("������?");
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
			System.out.println("������ �Է��ϼ���.");
		}
		catch (ArithmeticException e) {
			System.out.println("0���� ���� �� �����ϴ�.");
		} catch (Exception e) {
			System.out.println("�Ȱ� �����?");
			e.printStackTrace();
		}
	}
}
