package com.example;

import java.util.Scanner;

public class Bep {

	public static void main(String[] args) {
	
        //A �������
        //B �������
        //C ��Ʈ�� ����
        
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
        
        //�ݺ��� ���
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
////		A ���� + ����
////		G ����	
////		r ����	0.05
////		n �Ⱓ	2(����: ��)
//		
//		
//		
////		 A��G(1��r��n)
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
//			System.out.println("����: " + totalDeposit);
//			
//			totalInterest += totalDeposit * interestValue;
//			System.out.println("����: " + totalInterest);
//		}
//		
//		//System.out.println(totalDeposit + totalInterest);


