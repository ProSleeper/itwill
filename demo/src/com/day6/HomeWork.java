package com.day6;

import java.util.Scanner;
import java.util.Random;

public class HomeWork {

	public static void valueOfMin_Max(){
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int max, min;

		System.out.println("���ڸ� 5�� �Է��ϼ���.");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		max = min = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}

			if(min > arr[i]) {
				min = arr[i];
			}
		}

		System.out.println("���� ū ����: " + max + "\n���� ���� ����: " + min);
		System.out.print("");
	}


//	public static void threeOutGame() {
//
//		Scanner sc = new Scanner(System.in);
//		Random rd = new Random();
//		int com, people;
//		boolean yesOrNo = true;
//		String buttonY = "";
//		String print = "";
//		
//		
//		boolean[] yesNo = new boolean[10] ;
//		
//		System.out.println("��ǻ�Ͱ� ����� �����Ϸ� �մϴ�.");
//		System.out.println("3�� �ȿ� 1~10 ���� �� �ϳ��� ���缭 ���߰� �ؾ� �մϴ�.");
//
//		while(yesOrNo) {
//			System.out.println("���ڸ� �Է��ϼ���.");
//			com = rd.nextInt(10) + 1;
//			yesNo[com - 1] = true;
//			for (int i = 0; i < 3; i++) {
//				
//				people = sc.nextInt();
//				if(yesNo[people - 1]) {
//					System.out.println("�¾Ҿ��");
//					break;
//				}
//				System.out.println("Ʋ�Ⱦ��");
//				
//			}
//			System.out.println("����ҷ�?[Y/N]");
//			buttonY = sc.next();
//			yesOrNo = (buttonY.equals("Y") || buttonY.equals("y")) ? true : false;
//		}
//	}

		public static void threeOutGame() {
			
			Scanner sc = new Scanner(System.in);
			Random rd = new Random();
			int com, people;
			boolean yesOrNo = true;
			String buttonY = "";
			String print = "";
			com = rd.nextInt(10) + 1;
			
			System.out.println("��ǻ�Ͱ� ����� �����Ϸ� �մϴ�.");
			System.out.println("3�� �ȿ� 1~10 ���� �� �ϳ��� ���缭 ���߰� �ؾ� �մϴ�.");
			
			while(yesOrNo) {
				System.out.println("���ڸ� �Է��ϼ���.");
				for (int i = 0; i < 3; i++) {
					
					people = sc.nextInt();
					
					print = (people == com) ? "�¾Ҿ��!!": " Ʋ�Ⱦ��!!";
					System.out.println(print);
					if(print == "�¾Ҿ��!!") {
						break;
					}
				}
				System.out.println("����ҷ�?[Y/N]");
				buttonY = sc.next();
				yesOrNo = (buttonY.equals("Y") || buttonY.equals("y")) ? true : false;
			}
		}
	
	
	public static void scissorsRockPaper(){
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int com, people;
		String buttonY = "";
		boolean yesOrNo = true;
		int[][] judgment =  {{3,2,1},{1,3,2},{2,1,3}};

		Random rd = new Random();


		System.out.println("��ǻ�Ͱ� ����� �����Ϸ� �մϴ�.");
		System.out.println("������������ �̰ܼ� ���߰� �ؾ� �մϴ�.");

		while(yesOrNo) {
			System.out.println("1:����, 2:����, 3:��");
			System.out.print("��ȣ�� �Է��ϼ���.");
			people = sc.nextInt();
			com = rd.nextInt(3) + 1;
			System.out.println("��: "+com);

			if(judgment[people - 1][com - 1] == 3) {
				System.out.println("�����ϴ�.");
			}
			else if(judgment[people - 1][com - 1] == 1) {
				System.out.println("����� �̰���ϴ�.");
			}
			else {
				System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
				System.out.println("����� �׾����ϴ�.");
			}
			System.out.println("�ѹ� ��?[Y/N]");
			buttonY = sc.next();
			yesOrNo = (buttonY.equals("Y") || buttonY.equals("y")) ? true : false;
		}

		
	}



	public static void main(String[] args) {
		boolean exit = true;
		Scanner sc = new Scanner(System.in);
		int inputNumber;

		while(exit) {

			System.out.println("���ϴ� ������ ��ȣ�� �Է��ϼ��� 1~3��(���� 4��)");

			inputNumber = sc.nextInt();

			switch (inputNumber) {
			case 1:
				valueOfMin_Max();
				break;
			case 2:
				threeOutGame();
				break;
			case 3:
				scissorsRockPaper(); 
				break;
			default:
				exit = false;
				break;

			}
		}
	}

}