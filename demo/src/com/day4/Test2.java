package com.day4;

import java.io.IOException;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int su, sum = 0;
		char ch;
		
	while(true) {	
			do {
				System.out.println("�� �Է�?");
				su = sc.nextInt();
			}while(su < 1 || su > 5000);
			
			for(int i = 1; i <= su; i++) {
				sum = sum + i;
			}
			
			System.out.println("1~" + su + "������ ��:" + sum);
			
			System.out.println("��� �ҷ�?[Y/N]");
			
			ch = (char)System.in.read();
			
			//���ǹ����� ������ 2���� �Ѵ� �����϶��� ����� &&�� �ؾ��Ѵ�.
			if(ch != 'y' && ch != 'Y') {
				break;
			}
		}
	}
}
