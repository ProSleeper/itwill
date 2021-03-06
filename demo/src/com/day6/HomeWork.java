package com.day6;

import java.util.Scanner;
import java.util.Random;

public class HomeWork {

	public static void valueOfMin_Max(){
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int max, min;

		System.out.println("숫자를 5개 입력하세요.");
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

		System.out.println("가장 큰 수는: " + max + "\n가장 작은 수는: " + min);
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
//		System.out.println("컴퓨터가 당신을 공격하려 합니다.");
//		System.out.println("3번 안에 1~10 숫자 중 하나를 맞춰서 멈추게 해야 합니다.");
//
//		while(yesOrNo) {
//			System.out.println("숫자를 입력하세요.");
//			com = rd.nextInt(10) + 1;
//			yesNo[com - 1] = true;
//			for (int i = 0; i < 3; i++) {
//				
//				people = sc.nextInt();
//				if(yesNo[people - 1]) {
//					System.out.println("맞았어요");
//					break;
//				}
//				System.out.println("틀렸어요");
//				
//			}
//			System.out.println("계속할래?[Y/N]");
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
			
			System.out.println("컴퓨터가 당신을 공격하려 합니다.");
			System.out.println("3번 안에 1~10 숫자 중 하나를 맞춰서 멈추게 해야 합니다.");
			
			while(yesOrNo) {
				System.out.println("숫자를 입력하세요.");
				for (int i = 0; i < 3; i++) {
					
					people = sc.nextInt();
					
					print = (people == com) ? "맞았어요!!": " 틀렸어요!!";
					System.out.println(print);
					if(print == "맞았어요!!") {
						break;
					}
				}
				System.out.println("계속할래?[Y/N]");
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


		System.out.println("컴퓨터가 당신을 공격하려 합니다.");
		System.out.println("가위바위보를 이겨서 멈추게 해야 합니다.");

		while(yesOrNo) {
			System.out.println("1:가위, 2:바위, 3:보");
			System.out.print("번호를 입력하세요.");
			people = sc.nextInt();
			com = rd.nextInt(3) + 1;
			System.out.println("컴: "+com);

			if(judgment[people - 1][com - 1] == 3) {
				System.out.println("비겼습니다.");
			}
			else if(judgment[people - 1][com - 1] == 1) {
				System.out.println("당신이 이겼습니다.");
			}
			else {
				System.out.println("컴퓨터가 이겼습니다.");
				System.out.println("당신은 죽었습니다.");
			}
			System.out.println("한번 더?[Y/N]");
			buttonY = sc.next();
			yesOrNo = (buttonY.equals("Y") || buttonY.equals("y")) ? true : false;
		}

		
	}



	public static void main(String[] args) {
		boolean exit = true;
		Scanner sc = new Scanner(System.in);
		int inputNumber;

		while(exit) {

			System.out.println("원하는 문제의 번호를 입력하세요 1~3번(종료 4번)");

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
