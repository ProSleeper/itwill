package com.day3;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int kor;
		
		System.out.println("이름?");
		name = sc.next();
		
		System.out.println("국어?");
		kor = sc.nextInt();
		
		String pan;
		
		if(kor >= 90) {
			pan =  "수";
		}
		else if(kor >= 80) {
			pan =  "우";	
		}
		else if(kor >= 70) {
			pan =  "미";	
		}
		else if(kor >= 60) {
			pan =  "양";	
		}
		else {
			pan =  "가";
		}
		
		System.out.println(name + "의 국어 점수는 "  + kor + "점 이고 " + "환산 점수는 " + pan + " 입니다.");
		
		
		sc.close();
	}
	
}
