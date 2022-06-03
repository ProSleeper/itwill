package com.day3;

import java.util.Scanner;


public class Test7 {
	static void SwapNumber(int[] arr, int lNum, int rNum) {
		Integer temp;
		if(arr[lNum] > arr[rNum]) {
			temp = arr[lNum];
			arr[lNum] = arr[rNum];
			arr[rNum] = temp;
		}

	}

	public static void main(String[] args) {

		//3개의 수를 입력받아 작은 수에서 큰수 순으로 정렬


		Scanner sc = new Scanner(System.in);

		int[] arr = new int[3];

		System.out.println("숫자 3개를 입력하세요");

		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();

		SwapNumber(arr, 0, 1);
		SwapNumber(arr, 1, 2);
		SwapNumber(arr, 0, 1);

		System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);

	}

}
