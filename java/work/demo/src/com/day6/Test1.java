package com.day6;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		//10�� �̳��� �̸��� ������ �Է� �޾�
		//������ ���� ��� ������ ���
		
		Scanner sc = new Scanner(System.in);
		
		
		String[] name;
		int[] score;
		int peopleCount = 0;
		
		
		do {
			System.out.print("�ο���?[1~10]");
			peopleCount = sc.nextInt();
			
		} while (peopleCount < 0);
		
		
		name = new String[peopleCount];
		score = new int[peopleCount];
		
		
		for (int i = 0; i < peopleCount; i++) {
			System.out.print((i + 1)+ "��° �̸�?");
			name[i] = sc.next();
			System.out.print((i + 1) + "����?");
			score[i] = sc.nextInt();
		}
		
		
		
		for (int i = 0; i < peopleCount - 1; i++) {
			for (int j = i + 1; j < peopleCount; j++) {
				if(score[i] < score[j]) {
					int temp = score[i];
					score[i] = score[j];
					score[j] = temp;
					
					String tempStr = name[i];
					name[j] = name[j];
					name[j] = tempStr;
				}
			}
		}
		
		for (int i = 0; i < peopleCount; i++) {
			System.out.printf("%6s %4d\n", name[i], score[i]);
		}
	}
}
