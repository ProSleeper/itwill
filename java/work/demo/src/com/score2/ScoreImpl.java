package com.score2;

import java.util.Scanner;

public class ScoreImpl implements Score {

	private int inwon;

	private Record[] rec;

	Scanner sc = new Scanner(System.in);



	@Override
	public void set() {

//		do {
//			System.out.println("�ο���?");
//			inwon = sc.nextInt();
//
//
//
//		} while (inwon < 1 || inwon > 10);
//
//		rec = new Record[inwon];
		
		inwon = 5;
		
		String[] sNum = {"55555", "88888", "11111", "99999", "66666"};
		String[] sName = {"����", "�¾�", "�뼺", "ž", "WIN"};
		
		int[] kor = {55, 66, 22, 100, 99};
		
		int[] eng = {88, 77, 43, 21, 50};
		
		int[] math = {67, 34, 21, 67, 89};
		
		rec = new Record[inwon];
		
		for (int i = 0; i < inwon; i++) {
			rec[i] = new Record();
			rec[i].hak = sNum[i];
			rec[i].name = sName[i];
			rec[i].kor = kor[i];
			rec[i].eng = eng[i];
			rec[i].mat = math[i];
		}

	}

	@Override
	public void input() {

		for (int i = 0; i < inwon; i++) {

//			rec[i] = new Record();
//
//			System.out.println("�й�?");
//			rec[i].hak = sc.next();
//
//			System.out.println("�̸�?");
//			rec[i].name = sc.next();
//
//			System.out.println("����?");
//			rec[i].kor = sc.nextInt();
//
//			System.out.println("����?");
//			rec[i].eng = sc.nextInt();
//
//			System.out.println("����?");
//			rec[i].mat = sc.nextInt();

			rec[i].tot = rec[i].kor + rec[i].eng + rec[i].mat;

			rec[i].ave = rec[i].tot / 3;

		}

	}

	private String panjung(int score) {
		String pan = "";

		

		if(score >= 90) {
			pan =  "��";
		}
		else if(score >= 80) {
			pan =  "��";	
		}
		else if(score >= 70) {
			pan =  "��";	
		}
		else if(score >= 60) {
			pan =  "��";	
		}
		else {
			pan =  "��";
		}

		return pan;
	}

	@Override
	public void print() {

		for (int i = 0; i < inwon; i++) {
			 System.out.printf("%6s %6s %4d(%s) %4d(%s) %4d(%s) %4d\n",rec[i].hak, rec[i].name, rec[i].kor, panjung(rec[i].kor), rec[i].eng, panjung(rec[i].eng), rec[i].mat, panjung(rec[i].mat), rec[i].ave);
		}
	}

}
