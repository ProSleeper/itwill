package com.day18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test8 {

	public boolean fileCopy(String str1, String str2) {
		try {
			
			FileInputStream fis = new FileInputStream("c:\\doc\\test.txt");
			FileOutputStream fos = new FileOutputStream("c:\\doc\\tesssssst.txt");
			
			int data;
			byte[] buffer = new byte[1024];
			
			while ((data = fis.read(buffer, 0, 1024)) != -1) {
				//fis.read();
				fos.write(buffer, 0, data);
			}
			
			fos.close();
			fis.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Test8 t8 = new Test8();
		
		String str1, str2;
		
		System.out.println("원본파일?");
		str1 = sc.next();
		
		System.out.println("대상파일?");
		str2 = sc.next();
		
		
		if(t8.fileCopy(str1, str2)) {
			System.out.println("파일 복사 성공!!");
		}
		else {
			System.out.println("파일 복사 실패!!");
		}
		
		
		
		
		
		
	}

}
