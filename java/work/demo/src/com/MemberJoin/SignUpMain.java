package com.MemberJoin;

import java.util.Scanner;

public class SignUpMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SignUp ob = new SignUpImpl();
			
		int ch;
		while(true) {
			do {
				System.out.print("1.회원 가입   2.로그인   3.아이디 찾기   4.비밀번호 찾기   5.회원 정보 수정   6.회원 탈퇴   7.전체 정보 출력   8.종료:");
				ch = sc.nextInt();
			}while(ch<1);
			switch(ch) {
			case 1:
				ob.inputData(); 
//				ob.Join();	//이걸로 회원가입을 받아야 하지만 일단 빠른 테스트를 위해서 위 inputData로~
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
