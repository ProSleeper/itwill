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
				System.out.println("�� �Է�?");
				su = Integer.parseInt(br.readLine());
			}while(su < 1 || su > 5000);
			
			for(int i = 1; i <= su; i++) {
				sum = sum + i;
			}
			
			System.out.println("1~" + su + "������ ��:" + sum);
			sum = 0;
			
			System.out.println("��� �ҷ�?[Y/N]");
			
			ch = (char)System.in.read();
			
			//���ǹ����� ������ 2���� �Ѵ� �����϶��� ����� &&�� �ؾ��Ѵ�.
			if(ch != 'y' && ch != 'Y') {
				System.out.println("���α׷� ����!!");
				break;
			}
			System.in.skip(2);
		}
	}
}