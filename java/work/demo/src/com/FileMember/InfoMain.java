package com.FileMember;

import java.util.Scanner;


public class InfoMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Info info = new InfoImpl();
		
		int ch;
		while(true) {
			do {
				System.out.print("1.입력 2.출력 3.종료 =>");
				ch = sc.nextInt();
			}while(ch<1);
			switch(ch) {
			case 1:
				info.inputData(); 
				break;
			case 2:
				info.outputData(); 
				break;
			case 3:
				info.saveData();
			default:
				System.exit(0);			        		
			}
		}
	}
}
