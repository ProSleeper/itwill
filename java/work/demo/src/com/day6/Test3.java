package com.day6;
import java.util.Random;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args){
Scanner sc = new Scanner(System.in);
		
		
		String[] name;
		int[] score;
		int peopleCount = 5;
		int[] rank = null;
		
		
//		do {
//			System.out.print("인원수?[1~10]");
//			peopleCount = sc.nextInt();
//			
//		} while (peopleCount < 0);
		
		
//		name = new String[peopleCount];
//		score = new int[peopleCount];
//		rank = new int[peopleCount];
		
		name = new String[5];
		score = new int[5];
		rank = new int[5];
		
		name[0] = "suji";
		name[1] = "jon";
		name[2] = "park";
		name[3] = "kim";
		name[4] = "lee";
		
		score[0] = 100;
		score[1] = 20;
		score[2] = 31;
		score[3] = 30;
		score[4] = 40;
		
		rank[0] = 1;
		rank[1] = 1;
		rank[2] = 1;
		rank[3] = 1;
		rank[4] = 1;
		
		
		
//		for (int i = 0; i < peopleCount; i++) {
//			System.out.print((i + 1)+ "번째 이름?");
//			name[i] = sc.next();
//			System.out.print((i + 1) + "점수?");
//			score[i] = sc.nextInt();
//			rank[i] = 1;
//		}
		
		
		
		
		
		for (int i = 0; i < peopleCount - 1; i++) {
			for (int j = i + 1; j < peopleCount; j++) {
				if(score[i] < score[j]) {
					rank[i]++;
				}
				else if(score[i] > score[j]) {
					rank[j]++;
				}
			}
		}
		
		for (int i = 0; i < peopleCount; i++) {
			System.out.printf("%6s %4d %3d\n", name[i], score[i], rank[i]);
		}
	}

}
