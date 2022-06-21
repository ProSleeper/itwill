package com.day17;


class MyThread4 extends Thread{
	private String name;

	public MyThread4(String pName) {
		this.name = pName;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(name + " : " + i);
		}
	}

}

public class Test4 {
	public static void main(String[] args) {
		MyThread4 ob1 = new MyThread4("A");
		MyThread4 ob2 = new MyThread4("B");
		MyThread4 ob3 = new MyThread4("C");
	
		
		//스레드 우선순위
		System.out.println("MIN: " + Thread.MIN_PRIORITY);
		System.out.println("NORMAL: " + Thread.NORM_PRIORITY);
		System.out.println("MAX: " + Thread.MAX_PRIORITY);
		
		
		//우선순위 출력
		System.out.println(ob1.getPriority());
		System.out.println(ob2.getPriority());
		System.out.println(ob3.getPriority());
		
		ob1.setPriority(Thread.MIN_PRIORITY);  
		ob2.setPriority(Thread.MIN_PRIORITY);  
		ob3.setPriority(Thread.MAX_PRIORITY);  
		
		
		
		ob1.start();
		ob2.start();
		ob3.start();
		
	}
}
