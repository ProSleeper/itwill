package com.day17;

class MyThread1 extends Thread{

	
	private int num;
	private String name;
	
	public MyThread1(int pNum, String pName) {
		this.num = pNum;
		this.name = pName;
	}
	
	@Override
	public void run() {
		
		
		int i = 0;
		
		
		
		while (i < num) {
			System.out.println(this.getName() + " : " + name + i);
			i++;
			
			
			try {
				sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		
		
		
	}
	
}

public class Test1 {
	public static void main(String[] args) {

		System.out.println("main ����...");
		
		
		MyThread1 t1 = new MyThread1(100, "ù ��°: ");
		MyThread1 t2 = new MyThread1(200, "�� ��°: ");
		MyThread1 t3 = new MyThread1(300, "�� ��°: ");
		MyThread1 t4 = new MyThread1(400, "�� ��°: ");
		MyThread1 t5 = new MyThread1(500, "�ټ� ��°: ");
		MyThread1 t6 = new MyThread1(600, "���� ��°: ");
		MyThread1 t7 = new MyThread1(700, "�ϰ�  ��°: ");
		MyThread1 t8 = new MyThread1(800, "���� ��°: ");
		MyThread1 t9 = new MyThread1(900, "��ȩ ��°: ");
		MyThread1 t10 = new MyThread1(1000, "�� ��°: ");
		MyThread1 t11 = new MyThread1(1100, "���� ��°: ");
		MyThread1 t12 = new MyThread1(1200, "���� ��°: ");
		MyThread1 t13 = new MyThread1(1300, "���� ��°: ");
		MyThread1 t14 = new MyThread1(1400, "���� ��°: ");
		
		 t1.start();
		 t2.start();
		 t3.start();
		 t4.start();
		 t5.start();
		 t6.start();
		 t7.start();
		 t8.start();
		 t9.start(); 
		 t10.start();
		 t11.start();
		 t12.start();
		 t13.start();
		 t14.start();
		
		System.out.println("main ����...");
		
	}
}
