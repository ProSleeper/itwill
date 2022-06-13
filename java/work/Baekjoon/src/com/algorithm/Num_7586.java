package com.algorithm;

import java.util.Scanner;

public class Num_7586 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int inputCount = 0;
		int[][] people = null;

		inputCount = sc.nextInt();

		people = new int[inputCount][];

		for (int i = 0; i < inputCount; i++) {
			people[i] = new int[3];

			people[i][0] = sc.nextInt();
			people[i][1] = sc.nextInt();
			people[i][2] = 1;

			for (int j = i - 1; j >= 0; j--) {
				if(people[i][0] > people[j][0] && people[i][1] > people[j][1]) {//몸무게와 키가 모두 클때
					people[j][2]++;
				}
				else if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) {//몸무게와 키가 모두 작을 때
					people[i][2]++;
				}
			}
		}
		
		for (int i = 0; i < people.length; i++) {
			System.out.print(people[i][2] + " ");
		}
		
	}
}
