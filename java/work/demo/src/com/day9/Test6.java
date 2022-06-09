package com.day9;


class Test{
	public int x = 10;
	public void sub(int a) {
		x += a;
	}
}


public class Test6 {
	
	 static String hi;
	 static String bye;
	
	
	public static void main(String[] args) {
		hi = "hi";
		bye = "bye";
		
		swap();
		
		System.out.println();
	
	}
	
	
	
	static void swap() {
		String temp = hi;
		hi = bye;
		bye = temp;
	}
}
