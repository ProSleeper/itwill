package com.day17;


class MyThread6 extends Thread{

	@Override
	public void run() {
		
		
		try {
			System.out.println("스레드 시작...");
			
			System.out.println("우선순위: " + getPriority());
			
			System.out.println("스레드 이름: " + getName());
			sleep(500);
			
			setPriority(2);
			System.out.println("변경된 우선순위: " + getPriority());
			
			System.out.println("스레드 종료...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

public class Test6 {

	public static void main(String[] args) {
		Thread t1 = Thread.currentThread();
		Thread t2 = new MyThread6();
		
		System.out.println("메인스레드 우선순위: " + t1.getPriority());
		System.out.println("메인스레드 이름: " + t1.getName());
		
		System.out.println("t2.start 메소드 호출전 isAlive: " + t2.isAlive());
		
		t2.start();
		
		System.out.println("t2우선순위: " + t2.getPriority());
		t2.setPriority(1);
		
		
		try {
			Thread.sleep(100);
			System.out.println("t2 살아 있음?" + t2.isAlive());
			
			Thread.sleep(1000);
			System.out.println("1초 쉬고 t2 살아 있음?" + t2.isAlive());
			
			t2.join();
			
			System.out.println("그래도 t2 살아 있음?" + t2.isAlive());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		System.out.println("main 종료");
	}

}
