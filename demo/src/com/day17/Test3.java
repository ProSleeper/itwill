package com.day17;

import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;

class TClock implements Runnable{

	@Override
	public void run() {
		//		Date date;
		//		
		//		try {
		//			while (true) {
		//				date = new Date(System.currentTimeMillis());
		//				
		//				
		//				System.out.println(date);
		//				Thread.sleep(1000);
		//			}
		//		} catch (Exception e) {
		//			// TODO: handle exception
		//		}

		

		try {
			while (true) {
				Calendar cal = Calendar.getInstance();
				Date date = cal.getTime();
				System.out.println(date);
				Thread.sleep(1000);
				Toolkit.getDefaultToolkit().beep();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}


	}

}



public class Test3 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new TClock());

		t1.start();
	}




}
