package com.day6;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		//10명 이내의 이름과 점수를 입력 받아
		//점수가 높은 사람 순으로 출력
		
		Scanner sc = new Scanner(System.in);
		
		
		String[] name;
		int[] score;
		int peopleCount = 0;
		
		
		do {
			System.out.print("인원수?[1~10]");
			peopleCount = sc.nextInt();
			
		} while (peopleCount < 0);
		
		
		name = new String[peopleCount];
		score = new int[peopleCount];
		
		
		for (int i = 0; i < peopleCount; i++) {
			System.out.print((i + 1)+ "번째 이름?");
			name[i] = sc.next();
			System.out.print((i + 1) + "점수?");
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
