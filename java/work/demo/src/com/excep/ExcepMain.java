package com.excep;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExcepMain {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		double num1;
		double num2;
		double result;
		
		OperationAuthenticator auth = new OperationAuthenticator();
		
		try {
			System.out.println("두개의 수를 입력하세요.[a,b]");
			str = br.readLine();
			
			
			auth.inputFormat(str);
			
			String[] temp = str.split(",");
			auth.number(temp[0]);
			num1 = Double.parseDouble(temp[0]);
			
			auth.number(temp[1]);
			num2 = Double.parseDouble(temp[1]);
			
			System.out.println("연산자를 입력하세요.");
			str = br.readLine();
			
			auth.operator(str.charAt(0));
			
			char ch = str.charAt(0);
			
			result = 0;
			if (ch == '+') {
				result = num1 + num2;
			}
			else if (ch == '-') {
				result = num1 - num2;
			}
			else if (ch == '*') {
				result = num1 * num2;
			}
			else if (ch == '/') {
				result = num1 / num2;
			}

			System.out.printf("%g %c %g = %.1g\n", num1, ch, num2, result);
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		
		
	}

}
