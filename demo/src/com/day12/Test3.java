package com.day12;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		//오늘을 기준으로 1일후 2022년 6월 15일 수요일
		//년도 ? 2022
		//월 ? 06
		//일 ? 14
		//며칠 후? 100
		//만난날 : 2022년 6월 14일 화요일
		//100일 후 : 2022년 9월 26일 월요일
		
		
		Calendar now = Calendar.getInstance();
		Calendar now1 = new GregorianCalendar();
		Scanner sc = new Scanner(System.in);
		
		int y = now.get(Calendar.YEAR);
		int m = now.get(Calendar.MONTH) + 1;
		int d = now.get(Calendar.DATE);
		int w = now.get(Calendar.DAY_OF_WEEK);
		
		String[] week = {"일", "월", "화", "수", "목", "금", "토"};
		
		int startDay = now.getActualMinimum(Calendar.DATE);
		int endDay = now.getActualMaximum(Calendar.DATE);
	
		System.out.println("년도?");
		int year = sc.nextInt();
		
		System.out.println("월?");
		int month = sc.nextInt();
		
		System.out.println("일?");
		int day = sc.nextInt();
		
//		int year = 2022;
//		int month = 5;
//		int day = 15;
//		int daysLater = 100;
		
		now.set(year, month, day);
		
		
		System.out.println("며칠 후?");
		int daysLater = sc.nextInt();
		
		System.out.print("만난 날: ");
		System.out.println(year + "년 " + month + "월 " + day + "일 " + week[w-1] + "요일");
		
		now.set(year, month, day + daysLater - 1);
		
		y = now.get(Calendar.YEAR);
		m = now.get(Calendar.MONTH);
		d = now.get(Calendar.DATE);
		w = now.get(Calendar.DAY_OF_WEEK);
		
		System.out.print("100일 후: ");
		System.out.println(year + "년 " + m + "월 " + d + "일 " + week[w-1] + "요일");
		
		
	

	}

}
