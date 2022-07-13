package com.guest;

import java.util.Scanner;

import com.db.DBConn;

public class GuestMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int ch;
		Guest ob = new GuestImpl();

		while (true) {
			do {
				System.out.println("1.회원가입 2.방명록 입력 3.검색 4.정보수정 5.방명록 수정 6.삭제 7.전체출력 8.로그아웃 9.종료");
				ch = sc.nextInt();
			} while (ch < 1 || ch > 7);

			switch (ch) {
				case 1:
					ob.writeInfo();
					break;
				case 2:
					ob.writeRecord();
					break;
				case 3:
					ob.search();
					break;
				case 4:
					ob.updateInfo();
					break;
				case 5:
					ob.updateRecord();
					break;
				case 6:
					ob.delete();
					break;
				case 7:
					ob.print();
					break;
				case 8:
					ob.logout();
					break;
				default:
					DBConn.close();
					System.exit(0);
			}
		}
	}
}











