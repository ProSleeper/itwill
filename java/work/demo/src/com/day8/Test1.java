package com.day8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Test1 {

	public static void main(String[] args) {
		
		//solution_First();
		solution_Second();
	}
	
	static void solution_First()
	{
		Scanner sc = new Scanner(System.in);
		String[][] kv = new String[8][];
		
		String alphabet = null;
		int iter = 0;
		int count = 0;
		int result = 0;
		
		
		for (int i = 0; i < kv.length; i++) {
			kv[i] = new String[2];
			kv[i][0] = "";
			iter = 3;
			
			if(i == 5 || i == 7) {
				iter = 4;
			}
			
			for (int j = 0; j < iter ; j++) {
				kv[i][0] += String.valueOf((char)(65 + count++));
				
			}
			kv[i][1] = String.valueOf(i + 3);
		}
		
		alphabet = sc.next();
		for (int i = 0; i < alphabet.length(); i++) {
			for (int j = 0; j < kv.length; j++) {
				for (int k = 0; k < kv[j][0].length(); k++) {
					if(kv[j][0].charAt(k) == alphabet.charAt(i)){
						result += Integer.parseInt(kv[j][1]);
					}
				}
			}
		}
		
		System.out.println(result);
	}
	static void solution_Second()
	{
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> si = new HashMap<>();
		
		String alphabet = null;
		int result = 0;
		
		
//		si.put("ABC", 3);
//		si.put("DEF", 4);
//		si.put("GHI", 5);
//		si.put("JKL", 6);
//		si.put("MNO", 7);
//		si.put("PQRS", 8);
//		si.put("TUV", 9);
//		si.put("WXYZ", 10);
//		
//		alphabet = sc.next();
//		for (int i = 0; i < alphabet.length(); i++) {
//			for (String key : si.keySet()) {
//				if(key.contains(String.valueOf(alphabet.charAt(i)))) {
//					result += si.get(key);
//				}
//			}
//		}
//		System.out.println(result);
		
		for (int i = 0; i < 26; i++) {
			si.put(String.valueOf((char)(i + 65)), i / 3 + 3);
		}
		
		si.put("S", 8);
		si.put("V", 9);
		si.put("Y", 10);
		si.put("Z", 10);
		
		for (int i = 0; i < alphabet.length() ; i++) {
			result += si.get(String.valueOf(alphabet.charAt(i)));
		}
		
		System.out.println(result);
	}
	
}
