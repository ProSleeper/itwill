package com.Score3;

import java.util.Scanner;

public class ScoreMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Score ob = new ScoreImpl();


		String �й� = "1��";
		String ���ڿ��̸� = "�迵��";
		
		char char�̸� = ���ڿ��̸�.charAt(0);
		
		char �⿪ = '��';
		
		int int�̸� = char�̸�;
		int int�⿪ = �⿪ +1;
		char �ٽ����⿪ = (char)int�⿪;
		int int���� = �⿪ - 1;
		
		int �����й� = 0;
		try {
			�����й� = Integer.parseInt(�й�);
		} catch (Exception NumberFormatException) {
			System.out.println("��ȯ ����");
		}
		
		System.out.println(�����й�);

		int ch;
		while(true) {
			do {
				System.out.print("1. �Է� 2. ��� 3. �й������������� 4. ���������������� 5. ����: ");
				ch = sc.nextInt();
			}while(ch<1);
			switch(ch) {
			case 1:
				ob.input(); 
				break;
			case 2:
				ob.print(); 
				break;
			case 3:
				ob.ascSortHak(); 
				
				break;
			case 4:
				ob.descSortTot(); 
				break;
			default:
				System.exit(0);			        		
			}
		}
	}
}
