package com.day6;

import java.util.Random;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args){
        Random rd = new Random();
        
        int[] num = new int[6];
        
        int i, j, temp, n;
        
        n = 0;
        
        while(n<6){
        	num[n] = rd.nextInt(45) + 1;
        	
        	for(int k = 0; k < n; k++) {
        		if(num[k] == num[n]) {
        			n--;
        			break;
        		}
        	}
        	
        	n++;
        }
        
        for (int su : num) {
        	System.out.printf("%4d", su);
		}
    }
}
