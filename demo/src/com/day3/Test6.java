package com.day3;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

//BufferedReader�� ���ڿ��� �ѹ��� �о��
//


//Scanner : �ܶ������� ������ ����� ����
//�⺻ �ܶ��� ����


public class Test6 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int kor, eng, mat;
		
		System.out.println("�̸� ���� ���� ����?");
	
		sc = new Scanner(sc.next()).useDelimiter("\\s*,\\s*");
		
		name = sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		System.out.println(name + ":" + (kor+eng+mat) + "��");
		
	}
}