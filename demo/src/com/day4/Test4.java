package com.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int su, sum = 0;
		char ch;
		
	while(true) {	
			do {
				System.out.println("수 입력?");
				su = Integer.parseInt(br.readLine());
			}while(su < 1 || su > 5000);
			
			for(int i = 1; i <= su; i++) {
				sum = sum + i;
			}
			
			System.out.println("1~" + su + "까지의 합:" + sum);
			sum = 0;
			
			System.out.println("계속 할래?[Y/N]");
			
			ch = (char)System.in.read();
			
			//조건문에서 조건이 2개가 둘다 부정일때는 가운데는 &&를 해야한다.
			if(ch != 'y' && ch != 'Y') {
				System.out.println("프로그램 종료!!");
				break;
			}
			System.in.skip(2);
		}
	}
}
