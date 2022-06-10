package com.day10;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int sum = 2;
		int iter = 0;
		int inputNumber = 0;

		inputNumber = sc.nextInt();

		while(true){
			sum += (6 * iter++);
			if(inputNumber < sum){
				break;
			}
		}
		
		System.out.print(iter);
	}
}
