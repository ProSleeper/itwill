package com.day17;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


class Wait implements Runnable{

	@Override
	public void run() {
		try {
			System.out.print("��� ��");
			
			
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
	
	private static String[] name = {"������","�ȼ���","����","�輺��","���ٿ�",
									"������","�̵���","������","��ȫ��","������",
									"������","������","�ڼ���","������","��â��",
									"�����","������","�ڼ���","������","�ɹ���",
									"��ä��","�迵��","�Ƚÿ�","������","�ڼ���",
									"������","������"};

	private static HashMap<String, String> hMap = new HashMap<>();
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Thread t1 = new Thread(new Wait());
		
		System.out.print("��ǥ�ڸ� �Է��ϼ���: ");
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
		
		System.out.println("\n\n�����մϴ�!!. ��ǥ�� �Դϴ�.\n");
		
		int pCount = 1;
		for (String name : hMap.keySet()) {
			System.out.printf("%3d�� ��ǥ�� :  %6s \n", pCount++ , name);
		}
	}
}
