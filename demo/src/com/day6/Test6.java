package com.day6;

public class Test6 {

	public static void main(String[] args) {
		
		int[][] arr = new int[6][6];
		int n = 0;
		
		
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				
				n++;
				arr[i][j] = n;
				
				arr[i][5] += n;
				
				arr[5][j] += n;
				
				arr[5][5] += n;
				
			}
		}
		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr.length; j++) {
//				
//			
//				System.out.printf("%4d", arr[i][j]);
//				
//				
//			}
//			System.out.println();
//		}
		
		
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		
		int[][] b = {{9,8,7},{6,5,4},{3,2,1}};
		
		int[][] sum = new int[3][3];
		
		
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum.length; j++) {
				sum[i][j] = a[i][j] * b[i][j];
				
				System.out.printf("%4d", sum[i][j]);
			}
			System.out.println();
		}
	}
}
