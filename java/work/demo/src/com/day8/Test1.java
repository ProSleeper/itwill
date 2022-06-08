package com.day8;

import java.util.ArrayList;
import java.util.Scanner;


public class Test1 {

	public static void main(String[] args) {
		
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

	static long recursive(long maxValue, long minValue){
		
		if(maxValue == minValue) {
			return minValue;
		}
		
		return maxValue * recursive(maxValue - 1, minValue);
	}	
}
