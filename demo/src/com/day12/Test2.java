package com.day12;

import java.util.Calendar;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		//����޷�
		Calendar cal = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		
		int y,m,i,week;
		
		do { 
			System.out.println("�⵵?");
			y = sc.nextInt();
		} while(y<1);
		
		do {
			System.out.println("��?");
			m = sc.nextInt();
		} while(m<1 || m>12);
		
		cal.set(y,m-1,1);
		
		week = cal.get(Calendar.DAY_OF_WEEK);
		
		//System.out.println(week);
		
		//���
		
		
		
		int startDay = cal.getActualMinimum(Calendar.DATE);
		int endDay = cal.getActualMaximum(Calendar.DATE);
		
		
		
		System.out.printf("\t\t%d�� %d�� ",y, m);
		System.out.println();
		
		
		String[] weekArr = {"��", "��", "ȭ", "��", "��", "��", "��"};
		
		for (int j = 0; j < weekArr.length; j++) {
			
			System.out.printf("%3s\t", weekArr[j]);
		}
		System.out.println();
		
		for (int j = 1; j < week; j++) {
			System.out.print("\t");
		}
		
		
		for (int j = startDay; j <= endDay; j++) {
			if ((week + j - 2) % 7 == 0) {
				System.out.println();
			}
			System.out.printf("% 3d\t", j);
		}
		
				
		//System.out.println(y+ "-" +m+ "-" );
		

	}

}