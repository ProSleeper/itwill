package com.MemberJoin;

import java.util.Scanner;

public class SignUpMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SignUp ob = new SignUpImpl();
			
		int ch;
		while(true) {
			do {
				System.out.print("1.ȸ�� ����   2.�α���   3.���̵� ã��   4.��й�ȣ ã��   5.ȸ�� ���� ����   6.ȸ�� Ż��   7.��ü ���� ���   8.����:");
				ch = sc.nextInt();
			}while(ch<1);
			switch(ch) {
			case 1:
				ob.inputData(); 
//				ob.Join();	//�̰ɷ� ȸ�������� �޾ƾ� ������ �ϴ� ���� �׽�Ʈ�� ���ؼ� �� inputData��~
				break;
			case 2:
				ob.LogIn();
				break;
			case 3:
				ob.findID();
				break;
			case 4:
				ob.findPassword();
				break;
			case 5:
				ob.EditProfile();
				break;
			case 6:
				ob.cancelMember();
				break;
			case 7:
				ob.print();
				break;
			default:
				System.exit(0);			        		
			}
		}
	}
}
