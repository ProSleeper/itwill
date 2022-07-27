package com.day4;

public class Test3 {
	public static void main(String[] args) {
		
		int sum = 0;
		
		for(int i = 0; i < 100; i++) {
			sum += (i + 1);
		}
		
		sum = 0;
		for(int i = 0; i < 100; i+=2) {
			sum += (i + 1);
		}
		
		
	}

}
