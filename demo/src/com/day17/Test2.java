package com.day17;


class MyThread2 implements Runnable{
	private int num;
	private String name;

	public MyThread2(int pNum, String pName) {
		this.num = pNum;
		this.name = pName;

	}

	@Override
	public void run() {

		int i = 0;

		while (i < num) {
			System.out.println(name + " : " + name + i);
			i++;


			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}


		}

	}

}


public class Test2{
	public static void main(String[] args) {
		System.out.println("main ����...");
		
		Thread t1 = new Thread(new MyThread2(100, "ù ��°: "));
		Thread t2 = new Thread(new MyThread2(200, "�� ��°: "));
		Thread t3 = new Thread(new MyThread2(300, "�� ��°: "));
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("main ����...");
		
	}

}







