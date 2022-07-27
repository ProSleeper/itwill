package com.day18;

import java.io.FileInputStream;

//파일 입출력
//FileInputStream
//


public class Test5 {

	public static void main(String[] args) {
		
		try {
			
			FileInputStream fis = new FileInputStream("c:\\doc\\test.txt");
			
			int data;
			
			while ((data = fis.read()) != -1) {
//				System.out.println((char)data);
				System.out.write(data);
				System.out.flush();
				
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
