package com.day5;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] weeks = {"��","��", "ȭ", "��", "��", "��", "��"};
		
		
		int y, m, d, nalsu, i, week;

		do {
			System.out.print("�⵵? ");
			y = sc.nextInt();

		}while(y < 1);

		do {

			System.out.print("��?");
			m = sc.nextInt();

		} while (m < 1 || m > 12);
		
		

		if(y % 4 == 0 && y % 100 != 0 || y % 400 == 400) {
			months[1] = 29;
		}
		
		do {

			System.out.print("��?");
			d = sc.nextInt();

		} while (d < 1 || d > months[m - 1]);

		nalsu = (y - 1) * 365 + (y-1)/4 - (y-1)/100 + (y-1)/400;

		for(i = 0; i < m-1;i++) {
			nalsu += months[i];
		}

		System.out.println(y + "�� " + m + "�� " + d + "�� "+ weeks[(nalsu + d) % 7] + "����");

	}
}
