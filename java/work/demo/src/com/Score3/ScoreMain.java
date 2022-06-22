package com.Score3;

import java.util.Scanner;

public class ScoreMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Score ob = new ScoreImpl();


		String 학번 = "1번";
		String 문자열이름 = "김영운";
		
		char char이름 = 문자열이름.charAt(0);
		
		char 기역 = '가';
		
		int int이름 = char이름;
		int int기역 = 기역 +1;
		char 다시차기역 = (char)int기역;
		int int니은 = 기역 - 1;
		
		int 정수학번 = 0;
		try {
			정수학번 = Integer.parseInt(학번);
		} catch (Exception NumberFormatException) {
			System.out.println("변환 오류");
		}
		
		System.out.println(정수학번);

		int ch;
		while(true) {
			do {
				System.out.print("1. 입력 2. 출력 3. 학번오름차순정렬 4. 총점내림차순정렬 5. 학번삭제 6. 이름삭제 7. 종료: ");
				ch = sc.nextInt();
			}while(ch<1);
			switch(ch) {
			case 1:
				ob.input(); 
				break;
			case 2:
				ob.print(); 
				break;
			case 3:
				ob.ascSortHak(); 
				
				break;
			case 4:
				ob.descSortTot(); 
				break;
			case 5:
				ob.deleteHak(); 
				break;
			case 6:
				ob.deleteName(); 
				break;
			default:
				System.exit(0);			        		
			}
		}
	}
}
