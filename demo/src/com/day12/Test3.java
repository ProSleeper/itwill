package com.day12;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		//������ �������� 1���� 2022�� 6�� 15�� ������
		//�⵵ ? 2022
		//�� ? 06
		//�� ? 14
		//��ĥ ��? 100
		//������ : 2022�� 6�� 14�� ȭ����
		//100�� �� : 2022�� 9�� 26�� ������
		
		
		Calendar now = Calendar.getInstance();
		Calendar now1 = new GregorianCalendar();
		Scanner sc = new Scanner(System.in);
		
		int y = now.get(Calendar.YEAR);
		int m = now.get(Calendar.MONTH) + 1;
		int d = now.get(Calendar.DATE);
		int w = now.get(Calendar.DAY_OF_WEEK);
		
		String[] week = {"��", "��", "ȭ", "��", "��", "��", "��"};
		
		int startDay = now.getActualMinimum(Calendar.DATE);
		int endDay = now.getActualMaximum(Calendar.DATE);
	
		System.out.println("�⵵?");
		int year = sc.nextInt();
		
		System.out.println("��?");
		int month = sc.nextInt();
		
		System.out.println("��?");
		int day = sc.nextInt();
		
//		int year = 2022;
//		int month = 5;
//		int day = 15;
//		int daysLater = 100;
		
		now.set(year, month, day);
		
		
		System.out.println("��ĥ ��?");
		int daysLater = sc.nextInt();
		
		System.out.print("���� ��: ");
		System.out.println(year + "�� " + month + "�� " + day + "�� " + week[w-1] + "����");
		
		now.set(year, month, day + daysLater - 1);
		
		y = now.get(Calendar.YEAR);
		m = now.get(Calendar.MONTH);
		d = now.get(Calendar.DATE);
		w = now.get(Calendar.DAY_OF_WEEK);
		
		System.out.print("100�� ��: ");
		System.out.println(year + "�� " + m + "�� " + d + "�� " + week[w-1] + "����");
		
		
	

	}

}
