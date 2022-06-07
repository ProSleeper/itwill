package com.example;

import java.util.Scanner;

public class Bep {

	public static void main(String[] args) {
	
        //A 고정비용
        //B 가변비용
        //C 노트북 가격
        
        Scanner sc = new Scanner(System.in);
        int fixedCost = 0;
        int varCost = 0;
        int price = 0;
        
        fixedCost = sc.nextInt();
        varCost = sc.nextInt();
        price = sc.nextInt();
        
        int product = 0;
        int sales = 0;
        
        int countOfSales = 0;
        
        if(price < varCost || price == 0 || (price - varCost) == 0){
            System.out.print(-1);
            return;
        }
        
        //반복문 사용
//        while(true){
//            if((fixedCost + varCost * countOfSales) < (price * countOfSales)){
//                break;
//            }
//            countOfSales++;
//        }
        
        
        countOfSales = fixedCost / (price - varCost) + 1;
        
        System.out.print(countOfSales);
	}
}
        
        
//        System.out.print(countOfSales);
		
//		
////		A 원금 + 이자
////		G 원금	
////		r 이율	0.05
////		n 기간	2(단위: 년)
//		
//		
//		
////		 A＝G(1＋r×n)
//		 
//		 
//		double deposit = 50;
//		double totalDeposit = 0;
//		double totalInterest = 0;
//		
//		double interestValue = 0.05 / 24;
//		
//		
//		for (int i = 0; i < 24; i++) {
//			totalDeposit += deposit;
//			System.out.println("원금: " + totalDeposit);
//			
//			totalInterest += totalDeposit * interestValue;
//			System.out.println("이자: " + totalInterest);
//		}
//		
//		//System.out.println(totalDeposit + totalInterest);


