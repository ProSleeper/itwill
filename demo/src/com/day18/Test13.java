package com.day18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

//객체의 직렬화
//메모리에 생성된 클래스의 변수의 현재 상태를 그대로 보존해서
//파일에 저장하거나 네트워크를 통해 전달하는 기능이다.
//데이터의 종류에 상관없이 영속성을 제공할 수 있다.



public class Test13 {

	public static void main(String[] args) throws IOException {

		Hashtable<String, String> hTable = new Hashtable<>();
		
		hTable.put("1", "배수지");
		hTable.put("2", "공유");
		hTable.put("3", "유아인");
		hTable.put("4", "정인선");
		hTable.put("5", "유인나");
		hTable.put("6", "아이유");
		
		
		FileOutputStream fos = new FileOutputStream("c:\\doc\\out5.txt");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(hTable);
		oos.close();
		fos.close();
		
		
	}

}