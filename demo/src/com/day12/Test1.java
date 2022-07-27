package com.day12;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test1 {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		Calendar now1 = new GregorianCalendar();
		
		int y = now.get(Calendar.YEAR);
		int m = now.get(Calendar.MONTH) + 1;
		int d = now.get(Calendar.DATE);
		int w = now.get(Calendar.DAY_OF_WEEK);
		
		String[] week = {"일", "월", "화", "수", "목", "금", "토"};
		
		System.out.println(y + "-" + m + "-" + d + "-" + week[w-1]);
		
		int startDay = now.getActualMinimum(Calendar.DATE);
		int endDay = now.getActualMaximum(Calendar.DATE);
		
		System.out.println(startDay + ":" + endDay);
		
		System.out.printf("%tF\n", now);
		System.out.printf("%tT\n", now);
		
		
		System.out.printf("%1$tF %1$tT\n", now);
		
		now.set(2023, 10-1, 10);
		
		y = now.get(Calendar.YEAR);
		m = now.get(Calendar.MONTH) + 1;
		d = now.get(Calendar.DATE);
		w = now.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(y + "-" + m + "-" + d + "-" + week[w-1]);
	}
}
