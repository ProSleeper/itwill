package com.day7;

public class Test1 {
	public static void main(String[] args) {
		Rect ob = new Rect();
		
		ob.input();
		
		int w = ob.area();
		int h = ob.length();
		ob.print(w, h);
		
	}
}
