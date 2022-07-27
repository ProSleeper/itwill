package com.day18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyDataMain {

	public static void main(String[] args) throws Exception {

		FileOutputStream fos = new FileOutputStream("c:\\doc\\out6.txt");

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(new MyData("아이유", 30));
		oos.writeObject(new MyData("유인나", 40));
		oos.writeObject(new MyData("정인선", 30));
		oos.writeObject(new MyData("유아인", 30));
		oos.writeObject(new MyData("공유", 40));
		oos.writeObject(new MyData("배수지", 32));
		
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("c:\\doc\\out6.txt");

		ObjectInputStream ois = new ObjectInputStream(fis);
		
		MyData mydata = null;
		
		try {
			while (true) {	
				mydata = (MyData)ois.readObject();
				System.out.println(mydata.getName() + " : " + mydata.getScore());
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		ois.close();
		fis.close();
		
	}
}
