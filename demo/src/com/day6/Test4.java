package com.day6;

import java.util.Iterator;

public class Test4 {
	public static void main(String[] args) {
		int[] num = {28,20,15,10,8};
		
		int i, j, temp;
		
		System.out.print("Source Data");
		for (int su : num) {
			System.out.printf("%4d", su);
		}
		System.out.println();
		
		for (int k = 1; k < num.length; k++) {
			for (int k2 = 0; k2 < num.length - k; k2++) {
				//System.out.println();
				if(num[k2] > num[k2 + 1]) {
					temp = num[k2];
					num[k2] = num[k2 + 1];
					num[k2 + 1] = temp;
				}
			}
		}
		
		System.out.print("Sorted Data");
		for (int su : num) {
			System.out.printf("%4d", su);
		}
		System.out.println();
		
		
		
		
	}
}
