package com.day18;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Hashtable;
import java.util.Iterator;

public class Test14 {

	public static void main(String[] args) throws Exception {

		FileInputStream fis = new FileInputStream("c:\\doc\\out5.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Hashtable<String, String> hTable = (Hashtable<String, String>)ois.readObject();
		
		Iterator<String> it = hTable.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			String value = hTable.get(key);
			
			System.out.println(key + " : " + value);
			
		}
	}
}
