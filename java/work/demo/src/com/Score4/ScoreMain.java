package com.Score4;

import java.util.Scanner;

public class ScoreMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Score ob = new ScoreImpl();
		
		int ch;
		while(true) {
			do {
				System.out.print("1. �Է� 2. ��� 3. ���� 4. ���� 5. ã�� 7. ����: ");
				ch = sc.nextInt();
			}while(ch<1);
			switch(ch) {
			case 1:
				ob.inputData(); 
				break;
			case 2:
				ob.print(); 
				break;
			case 3:
				ob.delete();
				break;
			case 4:
				ob.update();
				break;
			case 5:
				ob.find();
				break;
			default:
				System.exit(0);			        		
			}
		}
	}
}
