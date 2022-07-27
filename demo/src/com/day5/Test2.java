package com.day5;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int y, m, nalsu, i, week;
	
		do {
			System.out.print("년도? ");
			y = sc.nextInt();
			
		}while(y < 1);
		
		do {
			
			System.out.print("월?");
			m = sc.nextInt();
			
		} while (m < 1 || m > 12);
		
		if(y % 4 == 0 && y % 100 != 0 || y % 400 == 400) {
			months[1] = 29;
		}
		
		nalsu = (y - 1) * 365 + (y-1)/4 - (y-1)/100 + (y-1)/400;
		
		for(i = 0; i < m-1;i++) {
			nalsu += months[i];
		}
		
		//System.out.println(nalsu);
		nalsu += 1;
		
		week = nalsu % 7;
		
		//System.out.println(week);
		
		System.out.println("\n  일  월  화  수  목  금  토");
		System.out.println("\n  --------------------------");
		for(i = 0; i < week; i++) {
			System.out.print("    ");
		}
		
		for(i=1; i <= months[m-1];i++) {
			System.out.printf("%4d", i);
			
			week++;
			
			if(week%7 == 0) {
				System.out.println();
			}
		}
		
		if(week%7 != 0) {
			System.out.println();
		}
		
		System.out.println("\n  --------------------------");
		
	}
}
