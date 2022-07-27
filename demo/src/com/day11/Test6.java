package com.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6 {
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("¼ö½Ä[3+5]?");
		String str = br.readLine();
		
		str = str.replaceAll("\\s", "");
		
//		String[] op = {"+", "-", "*","/"};
		
		for(String op : new String[]{"+", "-", "*","/"}) {
			int pos = str.indexOf(op);
			
			if (pos > -1) {
				int num1 = Integer.parseInt(str.substring(0, pos));
				int num2 = Integer.parseInt(str.substring(pos + 1));
				
				int result = 0;
				char oper = str.charAt(pos);
				
				switch (oper) {
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
				
				System.out.printf("%d %c %d = %d", num1, oper, num2, result);
				
			}
			
			
			
		}
		
		
	}
}
