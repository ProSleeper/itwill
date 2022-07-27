package com.day18;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test7 {

	public static void main(String[] args) {

		
		//파일 복사 
		//원본파일? "c:\\doc\\test.txt"
		//대상파일? "c:\\doc\\out1.txt"
		//복사 완료!!
		
		
		try {

			FileInputStream fis = new FileInputStream("c:\\doc\\test.txt");
			FileOutputStream fos = new FileOutputStream("c:\\doc\\out1.txt");
			int data;

			while ((data = fis.read()) != -1) {

				System.out.write(data);
//				fos.write(data);
				//fos.flush();
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
