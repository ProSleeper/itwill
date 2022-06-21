package com.day17;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


class Wait implements Runnable{

	@Override
	public void run() {
		try {
			System.out.print("고민 중");
			
			
			for (int i = 0; i < 20; i++) {
				System.out.print(".");
				Thread.sleep(500);
			}
			System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

public class SelectNumber {
	
	private static String[] name = {"오세라","안수언","엄희성","김성현","윤다영",
									"김희진","이동우","최재혁","김홍수","서수현",
									"윤재일","정영진","박선미","전은지","류창주",
									"김수지","이은지","박수정","정성경","심민정",
									"윤채련","김영운","안시연","이정민","박수진",
									"윤서혜","정민정"};

	private static HashMap<String, String> hMap = new HashMap<>();
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Thread t1 = new Thread(new Wait());
		
		System.out.print("발표자를 입력하세요: ");
		int countOfPeople = sc.nextInt();
		Random rd = new Random();
		int randomNumber = 0;
		
		for (int i = 0; i < countOfPeople; i++) {
			randomNumber = rd.nextInt(name.length);
			
			if (hMap.containsKey(name[randomNumber])) {
				i--;
				continue;
			}
			hMap.put(name[randomNumber],(null));
		}
		
		t1.start();
		
		try {
			//Thread.sleep(10000);
			t1.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("\n\n축하합니다!!. 발표자 입니다.\n");
		
		int pCount = 1;
		for (String name : hMap.keySet()) {
			System.out.printf("%3d번 발표자 :  %6s \n", pCount++ , name);
		}
	}
}
