package com.day18;

import java.io.FileOutputStream;

public class Test6 {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("c:\\doc\\out.txt");
			
			int data;
			
			System.out.print("문자열 입력");
			
			while((data=System.in.read()) != -1) {
				fos.write(data);
				fos.flush();
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
