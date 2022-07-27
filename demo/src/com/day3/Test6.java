package com.day3;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

//BufferedReader는 문자열을 한번에 읽어옴
//


//Scanner : 단락문자의 패턴을 사용해 구분
//기본 단락은 공백


public class Test6 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int kor, eng, mat;
		
		System.out.println("이름 국어 영어 수학?");
	
		sc = new Scanner(sc.next()).useDelimiter("\\s*,\\s*");
		
		name = sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		System.out.println(name + ":" + (kor+eng+mat) + "점");
		
	}
}
